package com.marcaci.nbrigadistas.Brigada.empresarial.model;

import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("marking")
public class Marcacion {
	@Id
	private Long id;
	private String turno;
	private String entrada;
	private String salida;
	private String planta;

	public Marcacion() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public String getEntrada() {
		return entrada;
	}

	public void setEntrada(String entrada) {
		this.entrada = entrada;
	}

	public String getSalida() {
		return salida;
	}

	public void setSalida(String salida) {
		this.salida = salida;
	}

	public String getPlanta() {
		return planta;
	}

	public void setPlanta(String planta) {
		this.planta = planta;
	}

	@Override
	public int hashCode() {
		return Objects.hash(entrada, id, planta, salida, turno);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Marcacion other = (Marcacion) obj;
		return Objects.equals(entrada, other.entrada) && Objects.equals(id, other.id)
				&& Objects.equals(planta, other.planta) && Objects.equals(salida, other.salida)
				&& Objects.equals(turno, other.turno);
	}

	@Override
	public String toString() {
		return "Marcacion [id=" + id + ", turno=" + turno + ", entrada=" + entrada + ", salida=" + salida + ", planta="
				+ planta + "]";
	}

}
