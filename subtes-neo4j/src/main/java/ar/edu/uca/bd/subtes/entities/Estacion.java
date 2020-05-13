package ar.edu.uca.bd.subtes.entities;

import java.util.Set;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;


@NodeEntity
public class Estacion {
	
	@Id @GeneratedValue 
	private Long id;
	private String nombre;
	@Relationship(type="PERTENECE_A", direction = Relationship.OUTGOING)	
	private Linea linea;
	@Relationship(type="CONECTA_CON", direction = Relationship.OUTGOING)	
	private Set<Estacion> conectaCon;
	
	public Estacion() {
		// TODO Auto-generated constructor stub
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Estacion [id=" + id + ", nombre=" + nombre + "]";
	}


	public Estacion(String nombre, Linea linea, Set<Estacion> conectaCon) {
		super();
		this.nombre = nombre;
		this.linea = linea;
		this.conectaCon = conectaCon;
	}


	
}
