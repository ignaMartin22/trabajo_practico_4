package ar.edu.unju.fi.model;

public class Carrera {
int codigo;
String nombre;
int cantidadAños;
boolean estado;
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
public int getCantidadAños() {
	return cantidadAños;
}
public void setCantidadAños(int cantidadAños) {
	this.cantidadAños = cantidadAños;
}
public boolean isEstado() {
	return estado;
}
public void setEstado(boolean estado) {
	this.estado = estado;
}


}
