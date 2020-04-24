package ar.edu.uca.bd.subtes.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Linea {

	@Id
	@Column(length = 8)
	private String id;
	private Double longitudTotal;
	@ManyToOne(fetch = FetchType.LAZY )
	@JoinColumn(name = "ciudadId",nullable = false)
	private Ciudad ciudad;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estacionCabeceraId",nullable = true)
	private Estacion cabecera;
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "estacionFinId",nullable = true)
	private Estacion fin;
	
	public Linea() {
		// TODO Auto-generated constructor stub
	}

	public Double getLongitudTotal() {
		return longitudTotal;
	}

	public void setLongitudTotal(Double longitudTotal) {
		this.longitudTotal = longitudTotal;
	}

	public Ciudad getCiudad() {
		return ciudad;
	}

	public void setCiudad(Ciudad ciudad) {
		this.ciudad = ciudad;
	}

	public Estacion getCabecera() {
		return cabecera;
	}

	public void setCabecera(Estacion cabecera) {
		this.cabecera = cabecera;
	}

	public Estacion getFin() {
		return fin;
	}

	public void setFin(Estacion fin) {
		this.fin = fin;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
		Linea other = (Linea) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Linea [id=" + id + "]";
	}

	public Linea(String id, Double longitudTotal, Ciudad ciudad, Estacion cabecera, Estacion fin) {
		super();
		this.id = id;
		this.longitudTotal = longitudTotal;
		this.ciudad = ciudad;
		this.cabecera = cabecera;
		this.fin = fin;
	}

	
	
}
