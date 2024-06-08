package ar.edu.unju.fi.collections;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Alumno;

@Component
public class AlumnoService {
private static List<Alumno> alumnos = new ArrayList<Alumno>();



/*
 * Devuelve un arrayList de objetos (listar)
 */
public static  List <Alumno> getAlumnos(){
if(alumnos.isEmpty()) {
	alumnos.add(new Alumno(00001L, "Ignacio", "Martin", "fibias2004@gmail.com",388415727L, LocalDate.now(),"El Rosedal 116", "APU005457"));
	alumnos.add(new Alumno(00002L, "Eduardo", "Belliboni", "poloObrero@gmail.com",38816271L, LocalDate.now(), "Israel 235", "INF001625"));
	alumnos.add(new Alumno(00003L, "Javier", "Milei", "vllc@gmail.com",  38816273L, LocalDate.now(), "Brandsen 805", "APU001829"));
}
	return alumnos;
}

/*
 * Agrega un objeto al arraylist
 */
public static void agregarAlumno(Alumno alumno) {
	alumnos.add(alumno);
}

/**
 * Elimina un objeto del arraylist
 */
public static void eliminarAlumno(long dniEliminar) {
	Iterator<Alumno> iterator = alumnos.iterator();
	while(iterator.hasNext()) {
		if(iterator.next().getDni()==  dniEliminar) {
			iterator.remove();
		}
	}
}

/*
 * modifica un objeto alumno con nuevos valores
 */
public static void modificarAlumno(Alumno alumno) {
	for(Alumno a: alumnos) {
		if(a.getDni() == alumno.getDni()) {
			a.setNombre(alumno.getNombre());
			a.setApellido(alumno.getApellido());
			a.setDomicilio(alumno.getDomicilio());
			a.setEmail(alumno.getEmail());
			a.setFechaDeNacimiento(alumno.getFechaDeNacimiento());
			a.setLibretaUniversitaria(alumno.getLibretaUniversitaria());
			a.setTelefono(alumno.getTelefono());
		}else {
			System.out.println("no se encontro el dni");
		}
	}
}

/*
 * Busca un objeto en el arraylist
 */
 public static Alumno buscarAlumno(long dniBuscar) {
	 Predicate<Alumno> filterDni = c -> c.getDni()   == dniBuscar;
	 Optional <Alumno> alumno = alumnos.stream().filter(filterDni).findFirst();
	 if(alumno.isPresent()) {
		 return alumno.get();
	 }else {
		 return null;
	 }
 }
}
