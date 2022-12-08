package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Departamento
 *
 */
@Entity
@Table(name = "DEPARTAMENTOS")
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_DEPARTAMENTO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_DEPARTAMENTO")
	private long id_departamento;

	@Column(nullable = false, length = 50)
	private String nombre;

	public Departamento() {
		super();
	}

	public Departamento(String nombre) {
		super();
		this.nombre = nombre;
	}

	public long getId_departamento() {
		return id_departamento;
	}

	public void setId_departamento(long id) {
		this.id_departamento = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id_departamento + ", nombre=" + nombre + "]";
	}

}
