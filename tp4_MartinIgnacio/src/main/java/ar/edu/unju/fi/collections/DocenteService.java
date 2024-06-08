package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import ar.edu.unju.fi.model.Docente;

public class DocenteService {
private static List <Docente> docentes = new ArrayList<Docente>(); 


public static List <Docente> getDocentes(){
	if(docentes.isEmpty()) {
		docentes.add(new Docente(0, "Marcelo", "Perez Ibarra", "PerezIb@gmail.com", 388415727));
		docentes.add(new Docente(1, "Juan Carlos", "Gutierrez", "jc2023@gmail.com", 388423423));
		docentes.add(new Docente(2, "Maria", "Battezzati", "Mbatt@gmail.com", 388419237));
}
	return docentes;
}

public static void agregarDocente(Docente docente) {
	docentes.add(docente);
}

public static void modificarDocente(Docente docenteModificar) {
	for(Docente d: docentes) {
		if(d.getLegajo() == docenteModificar.getLegajo()) {
			d.setNombre(docenteModificar.getNombre());
			d.setApellido(docenteModificar.getApellido());
			d.setEmail(docenteModificar.getEmail());
			d.setTelefono(docenteModificar.getTelefono());
		}else {
			System.out.println("no se encontro al docente");
		}
	}
}

public static void eliminarDocente(int legajo) {
	Iterator<Docente> iterator = docentes.iterator();
	while(iterator.hasNext()) {
		if(iterator.next().getLegajo() == legajo ) {
			iterator.remove();
		}
	}
}


public static Docente buscarDocente(int legajo) {
	 Predicate<Docente> filterCodigo = c -> c.getLegajo()   == legajo;
	 Optional <Docente> docente = docentes.stream().filter(filterCodigo).findFirst();
	 if(docente.isPresent()) {
		 return docente.get();
	 }else {
		 return null;
	 }


}
}
