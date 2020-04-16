package ar.edu.uca.bd.subtes.entities;

public class Linea {

	private String id;
	private Double longitudTotal;
	private Ciudad ciudad;
	private Estacion cabecera;
	private Estacion fin;
	
	public Linea() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Linea(String id, Double longitudTotal, Ciudad ciudad, Estacion cabecera, Estacion fin) {
		super();
		this.id = id;
		this.longitudTotal = longitudTotal;
		this.ciudad = ciudad;
		this.cabecera = cabecera;
		this.fin = fin;
	}

	@Override
	public String toString() {
		return "Linea [id=" + id + ", longitudTotal=" + longitudTotal + ", ciudad=" + ciudad + ", cabecera=" + cabecera
				+ ", fin=" + fin + "]";
	}
	
	
}
