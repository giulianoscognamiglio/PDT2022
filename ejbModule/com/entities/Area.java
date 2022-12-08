package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Area
 *
 */
@Entity
@Table(name = "AREAS")
public class Area implements Serializable {

	private static final long serialVersionUID = 1L;

	public Area() {
		super();
	}

	public Area(String nombre) {
		super();
		this.nombre = nombre;
	}

	@Id
	@SequenceGenerator(name = "SEQ_AREA", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_AREA")
	private long id_area;

	@Column(nullable = false, length = 50)
	private String nombre;

	public long getId_area() {
		return id_area;
	}

	public void setId_area(long id_area) {
		this.id_area = id_area;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Area [id_area=" + id_area + ", nombre=" + nombre + "]";
	}

}
