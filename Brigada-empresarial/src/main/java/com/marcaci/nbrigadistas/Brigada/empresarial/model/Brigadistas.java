package com.marcaci.nbrigadistas.Brigada.empresarial.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("fireman")
public class Brigadistas {

	@Id
	private Long id;
	private String nombre;
	private String apellido;
	private String direccion;
	private String planta;
	private String años_brigadista;

	public Brigadistas() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	public String getAños_brigadista() {
		return años_brigadista;
	}

	public void setAños_brigadista(String años_brigadista) {
		this.años_brigadista = años_brigadista;
	}

	@Override
	public int hashCode() {
		return Objects.hash(apellido, años_brigadista, direccion, id, nombre, planta);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Brigadistas other = (Brigadistas) obj;
		return Objects.equals(apellido, other.apellido) && Objects.equals(años_brigadista, other.años_brigadista)
				&& Objects.equals(direccion, other.direccion) && Objects.equals(id, other.id)
				&& Objects.equals(nombre, other.nombre) && Objects.equals(planta, other.planta);
	}

	@Override
	public String toString() {
		return "Brigadistas [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", direccion=" + direccion
				+ ", planta=" + planta + ", años_brigadista=" + años_brigadista + "]";
	}

}
