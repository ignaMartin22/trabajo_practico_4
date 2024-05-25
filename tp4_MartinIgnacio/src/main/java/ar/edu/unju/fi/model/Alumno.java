package ar.edu.unju.fi.model;

import java.time.LocalDate;

public class Alumno {
int dni;
String nombre;
String apellido;
String email;
int telefono;
LocalDate fechaDeNacimiento;
String domicilio;
String libretaUniversitaria;
public int getDni() {
	return dni;
}
public void setDni(int dni) {
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
public int getTelefono() {
	return telefono;
}
public void setTelefono(int telefono) {
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
