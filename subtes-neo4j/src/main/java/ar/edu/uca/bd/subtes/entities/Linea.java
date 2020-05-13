package ar.edu.uca.bd.subtes.entities;



import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;



@NodeEntity
public class Linea {

	@Id @GeneratedValue 
	private Long id;
	private Double longitudTotal;
	@Relationship(type="CIUDAD", direction = Relationship.OUTGOING)
	private Ciudad ciudad;
	@Relationship(type="CABECERA", direction = Relationship.UNDIRECTED)
	private Estacion cabecera;
	@Relationship(type="FIN", direction = Relationship.UNDIRECTED)
	private Estacion fin;
	private String nombre;
	
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Linea [id=" + id + "]";
	}

	public Linea(Double longitudTotal, Ciudad ciudad, Estacion cabecera, Estacion fin) {
		super();
		this.longitudTotal = longitudTotal;
		this.ciudad = ciudad;
		this.cabecera = cabecera;
		this.fin = fin;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	
	
}
