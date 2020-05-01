package ar.edu.uca.bd.subtes.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Ciudad {

	@Id
	private String id;
	private String nombre;
	private Double latitud;
	private Double longitud;
	
	public Ciudad() {
		// TODO Auto-generated constructor stub
	}



	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Double getLatitud() {
		return latitud;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}





	@Override
	public String toString() {
		return "Ciudad [id=" + id + ", nombre=" + nombre + "]";
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
		Ciudad other = (Ciudad) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}



	public Ciudad(String nombre, Double latitud, Double longitud) {
		super();
		this.nombre = nombre;
		this.latitud = latitud;
		this.longitud = longitud;
	}


	
	
	
}
