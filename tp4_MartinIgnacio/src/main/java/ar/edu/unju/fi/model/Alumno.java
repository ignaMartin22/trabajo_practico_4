package ar.edu.unju.fi.model;

import java.time.LocalDate;


import org.springframework.stereotype.Component;
import java.lang.Long;
@Component
public class Alumno {
private Long dni;
private String nombre;
private String apellido;
private String email;
private Long telefono;
private LocalDate fechaDeNacimiento;
private String domicilio;
private String libretaUniversitaria;



public Alumno() {
	// TODO Auto-generated constructor stub
}

public Alumno(Long dni, String nombre, String apellido, String email, Long telefono, LocalDate fechaDeNacimiento,
		String domicilio, String libretaUniversitaria) {
	super();
	this.dni = dni;
	this.nombre = nombre;
	this.apellido = apellido;
	this.email = email;
	this.telefono = telefono;
	this.fechaDeNacimiento = fechaDeNacimiento;
	this.domicilio = domicilio;
	this.libretaUniversitaria = libretaUniversitaria;
}
public Long getDni() {
	return dni;
}
public void setDni(Long dni) {
	this.dni = dni;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getApellido() {
	return apellido;
}
public void setApellido(String apellido) {
	this.apellido = apellido;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public Long getTelefono() {
	return telefono;
}
public void setTelefono(Long telefono) {
	this.telefono = telefono;
}
public LocalDate getFechaDeNacimiento() {
	return fechaDeNacimiento;
}
public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
	this.fechaDeNacimiento = fechaDeNacimiento;
}
public String getDomicilio() {
	return domicilio;
}
public void setDomicilio(String domicilio) {
	this.domicilio = domicilio;
}
public String getLibretaUniversitaria() {
	return libretaUniversitaria;
}
public void setLibretaUniversitaria(String libretaUniversitaria) {
	this.libretaUniversitaria = libretaUniversitaria;
}


}
