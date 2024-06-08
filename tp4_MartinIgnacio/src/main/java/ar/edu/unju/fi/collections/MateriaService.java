package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import ar.edu.unju.fi.model.Carrera;
import ar.edu.unju.fi.model.Docente;
import ar.edu.unju.fi.model.Materia;
import ar.edu.unju.fi.model.Modalidad;

public class MateriaService {
private static List<Materia> materias = new ArrayList<Materia>();


public static List <Materia> getMateria(){
	if(materias.isEmpty()) {
		materias.add(new Materia(0, "LSO II", 2, 56,new Docente(0, "Marcelo", "Perez Ibarra", "PerezIb@gmail.com", 388415727),new Carrera(0, "APU", 3, true),Modalidad.VIRTUAL));
		materias.add(new Materia(1, "MATEMATICA DISCRETA", 1, 40,new Docente(1, "Juan Carlos", "Gutierrez", "jc2023@gmail.com", 388423423),new Carrera(1, "INFORMÁTICA", 5, true), Modalidad.VIRTUAL));
		materias.add(new Materia(2, "ROCAS I", 2, 70,new Docente(2, "Maria", "Battezzati", "Mbatt@gmail.com", 388419237), new Carrera(2, "QUÍMICA", 5, false),Modalidad.VIRTUAL));

}
	return materias;
}

public static Docente getDocenteBy(int legajo) {
	for(Docente d: DocenteService.getDocentes()) {
		if(d.getLegajo() == legajo) {
			return d;
		}
	}
	return null;
}

public static Carrera getCarreraBy(int codigo) {
	for(Carrera c: CarrerasService.getCarreras()) {
		if(c.getCodigo() == codigo) {
			return c;
		}
	}
	return null;
}

public static void agregarMateria(Materia materia) {
	materias.add(materia);
}

public static void modificarMateria(Materia materiaModificar) {
	for(Materia m: materias) {
		if(m.getCodigo() == materiaModificar.getCodigo()) {
			m.setCarrera(materiaModificar.getCarrera());
			m.setCurso(materiaModificar.getCurso());
			m.setDocente(materiaModificar.getDocente());
			m.setHoras(materiaModificar.getHoras());
			m.setModalidad(materiaModificar.getModalidad());
			m.setNombre(materiaModificar.getNombre());
		}else {
			System.out.println("no se encontro la materia");
		}
	}
}

public static void eliminarMateria(int codigo) {
	Iterator<Materia> iterator = materias.iterator();
	while(iterator.hasNext()) {
		if(iterator.next().getCodigo()== codigo ) {
			iterator.remove();
		}
	}
}


public static Materia buscarMateria(int codigo) {
	 Predicate<Materia> filterCodigo = c -> c.getCodigo() == codigo;
	 Optional <Materia> materia = materias.stream().filter(filterCodigo).findFirst();
	 if(materia.isPresent()) {
		 return materia.get();
	 }else {
		 return null;
	 }


}



}
