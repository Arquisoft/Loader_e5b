/*<<<<<<< HEAD
package es.uniovi.asw.model;

import javax.persistence.*;

import es.uniovi.asw.model.util.Type;
import es.uniovi.asw.parser.reader.CSVReader;

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
	
	private String tipoNombre;

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
		this.tipoNombre = tipo;
		this.contrasena = contrasena;
	}

	public Agent(String ID, String nombre, String localizacion, String email, String tipo) {
		super();
		this.id = ID;
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.email = email;
		this.tipo = tipo;
		this.tipoNombre = tipo;
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
	
	public void setTipoNombre(String tipoNombre){
		this.tipoNombre = tipoNombre;
	}
	
	public String getTipoNombre(String path){
		Type tipo= new Type(path);
		this.tipoNombre=tipo.getNombre(this.tipo);
		return this.tipoNombre;
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
=======
*/
package es.uniovi.asw.model;

import javax.persistence.*;

import es.uniovi.asw.model.util.Type;

@Entity
@Table(name = "TAGENTS")
public class Agent {

	@Id
	@Column(name = "IDENTIFICADOR")
	private String identificador;

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
	
	private String tipoNombre;

	// Constructor vacio para JPA
	public Agent() {
	}

	public Agent(String identificador, String nombre, String localizacion, String email, String tipo, String contrasena) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.email = email;
		this.tipo = tipo;
		this.contrasena = contrasena;
	}

	public Agent(String identificador, String nombre, String localizacion, String email, String tipo) {
		super();
		this.identificador = identificador;
		this.nombre = nombre;
		this.localizacion = localizacion;
		this.email = email;
		this.tipo = tipo;
	}
	
	public void setIdentificador(String identificador){
		this.identificador = identificador;
	}
	
	public String getIdentificador() {
		return identificador;
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
	
	public void setTipoNombre(String tipoNombre){
		this.tipoNombre = tipoNombre;
	}
	
	public String getTipoNombre(String path){
		Type tipo= new Type(path);
		this.tipoNombre=tipo.getNombre(this.tipo);
		return this.tipoNombre;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((identificador == null) ? 0 : identificador.hashCode());
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
		if (identificador == null) {
			if (other.identificador != null)
				return false;
		} else if (!identificador.equals(other.identificador))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Agent [identificador=" + identificador
				+ ", nombre=" + nombre
				+ ", localizacion=" + localizacion
				+ ", email=" + email
				+ ", tipo=" + tipo
				+ "]";
	}

}
//>>>>>>> branch 'master' of https://github.com/Arquisoft/Loader_e5b.git
