package ar.edu.unju.fi.model;

public class Materia {
int codigo;
String nombre;
int curso;
int horas;
Docente docente;
String carrera;
Modalidad modalidad;
public int getCodigo() {
	return codigo;
}
public void setCodigo(int codigo) {
	this.codigo = codigo;
}
public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public int getCurso() {
	return curso;
}
public void setCurso(int curso) {
	this.curso = curso;
}
public int getHoras() {
	return horas;
}
public void setHoras(int horas) {
	this.horas = horas;
}
public Docente getDocente() {
	return docente;
}
public void setDocente(Docente docente) {
	this.docente = docente;
}
public String getCarrera() {
	return carrera;
}
public void setCarrera(String carrera) {
	this.carrera = carrera;
}
public Modalidad getModalidad() {
	return modalidad;
}
public void setModalidad(Modalidad modalidad) {
	this.modalidad = modalidad;
}


}
