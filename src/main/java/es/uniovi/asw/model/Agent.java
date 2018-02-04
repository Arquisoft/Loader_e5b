package es.uniovi.asw.model;

import javax.persistence.*;

@Entity
@Table(name = "TAGENTS")
public class Agent {

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NOMBRE")
	private String nombre;

	@Column(name = "LOCALIZACION")
	private String localizacion;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "TIPO")
	private String tipo;

	@Column(name = "CONTRASENA")
	private String contrasena;

	// Constructor vacio para JPA
	public Agent() {
	}

	public Agent(String ID, String nombre, String localizacion, String email, String tipo, String contrasena) {
		super();
		this.id = ID;
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.email = email;
		this.tipo = tipo;
		this.contrasena = contrasena;
	}

	public Agent(String ID, String nombre, String localizacion, String email, String tipo) {
		super();
		this.id = ID;
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.email = email;
		this.tipo = tipo;
	}
	
	public void setId(String id){
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
	public String getContrasena() {
		return contrasena;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getEmail() {
		return email;
	}

	public void setLocalizacion(String localizacion) {
		this.localizacion = localizacion;
	}
	
	public String getLocalizacion() {
		return localizacion;
	}
	
	public void setTipo(String tipo){
		this.tipo = tipo;
	}
	
	public String getTipo(){
		return this.tipo;
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
		Agent other = (Agent) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [id=" + id
				+ "nombre=" + nombre
				+ ", localizacion=" + localizacion
				+ ", email=" + email
				+ ", tipo=" + tipo
				+ "]";
	}

}
