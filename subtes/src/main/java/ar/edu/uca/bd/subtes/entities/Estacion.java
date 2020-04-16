package ar.edu.uca.bd.subtes.entities;

import java.util.Set;

public class Estacion {

	private int id;
	private String nombre;
	private Linea linea;
	private Set<Estacion> conectaCon;
	
	public Estacion() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Linea getLinea() {
		return linea;
	}

	public void setLinea(Linea linea) {
		this.linea = linea;
	}

	public Set<Estacion> getConectaCon() {
		return conectaCon;
	}

	public void setConectaCon(Set<Estacion> conectaCon) {
		this.conectaCon = conectaCon;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Estacion other = (Estacion) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public Estacion(int id, String nombre, Linea linea, Set<Estacion> conectaCon) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.linea = linea;
		this.conectaCon = conectaCon;
	}

	@Override
	public String toString() {
		return "Estacion [id=" + id + ", nombre=" + nombre + ", linea=" + linea + ", conectaCon=" + conectaCon + "]";
	}
	
	
}
