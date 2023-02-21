package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Itr
 *
 */

@Entity
@Table(name = "ITRS")
public class ITR implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_ITR", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ITR")
	private long id;

	@Column(nullable = false, length = 50)
	private String nombre;

	@ManyToOne
	private Departamento departamento;
	
	@Column(nullable = false, length = 50)
	private String activo;

	public ITR() {
		super();
	}

	public ITR(String nombre, Departamento departamento, String activo) {
		super();
		this.nombre = nombre;
		this.departamento = departamento;
		this.activo = activo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	@Override
	public String toString() {
		return "ITR [id=" + id + ", nombre=" + nombre + ", departamento=" + departamento + ", activo=" + activo + "]";
	}

}
