package ar.edu.uca.bd.subtes.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Estacion {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="estacionSeq")
	@SequenceGenerator(
				name="estacionSeq",
				sequenceName="SEQ_ESTACION",
				allocationSize=1
			)
	private int id;
	@Column(nullable = false)
	private String nombre;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lineaId",nullable = false)
	private Linea linea;
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			 name = "ESTACION_XREFS",
			 joinColumns = @JoinColumn(name = "estacion1Id"),
			 inverseJoinColumns = @JoinColumn(name = "estacion2Id")	)
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
		return "Estacion [id=" + id + ", nombre=" + nombre + "]";
	}


	
}
