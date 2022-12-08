package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Genero
 *
 */
@Entity
@Table(name = "GENEROS")
public class Genero implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_GENERO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_GENERO")
	private long id_genero;

	@Column(nullable = false, length = 50)
	private String nombre;

	public Genero() {
		super();
	}

	public Genero(String nombre) {
		super();
		this.nombre = nombre;
	}

	public long getId_genero() {
		return id_genero;
	}

	public void setId_genero(long id_genero) {
		this.id_genero = id_genero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Genero [id_genero=" + id_genero + ", nombre=" + nombre + "]";
	}

}
