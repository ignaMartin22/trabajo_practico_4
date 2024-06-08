package ar.edu.unju.fi.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Carrera;

@Component
public class CarrerasService {
	private static List<Carrera> carreras = new ArrayList<Carrera>();



	/*
	 * Devuelve un arrayList de objetos (listar)
	 */
	public static  List <Carrera> getCarreras(){
	if(carreras.isEmpty()) {
		carreras.add(new Carrera(0, "APU", 3, true));
		carreras.add(new Carrera(1, "INFORMÁTICA", 5, true));
		carreras.add(new Carrera(2, "QUÍMICA", 5, false));
	}
		return carreras;
	}

	/*
	 * Agrega un objeto al arraylist
	 */
	public static void agregarCarrera(Carrera carrera) {
		carreras.add(carrera);
	}

	/**
	 * Elimina un objeto del arraylist
	 */
	public static void eliminarCarrera(int codigoAEliminar) {
		Iterator<Carrera> iterator = carreras.iterator();
		while(iterator.hasNext()) {
			if(iterator.next().getCodigo() == codigoAEliminar ) {
				iterator.remove();
			}
		}
	}

	/*
	 * modifica un objeto alumno con nuevos valores
	 */
	public static void modificarCarrera(Carrera carreraModificar) {
		for(Carrera c: carreras) {
			if(c.getCodigo() == carreraModificar.getCodigo()) {
				c.setNombre(carreraModificar.getNombre());
				c.setEstado(carreraModificar.getEstado());
				c.setCantidadAnos(carreraModificar.getCantidadAnos());
			}else {
				System.out.println("no se encontro la carrera");
			}
		}
	}

	/*
	 * Busca un objeto en el arraylist
	 */
	 public static Carrera buscarCarrera(int codigoBuscar) {
		 Predicate<Carrera> filterCodigo = c -> c.getCodigo()   == codigoBuscar;
		 Optional <Carrera> carrera = carreras.stream().filter(filterCodigo).findFirst();
		 if(carrera.isPresent()) {
			 return carrera.get();
		 }else {
			 return null;
		 }
	 }
}
