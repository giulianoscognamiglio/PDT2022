package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Reclamo
 *
 */
@Entity
@Table(name = "RECLAMOS")
public class Reclamo implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_RECLAMO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RECLAMO")
	private long id_reclamo;

	@Column(nullable = false, length = 50)
	private String detalle;

	@Column(nullable = false, length = 50)
	private Date fecha;

	@ManyToOne
	private Estudiante estudiante;

	public Reclamo() {
		super();
	}

	public Reclamo(String detalle, Date fecha, Estudiante estudiante) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.estudiante = estudiante;
	}

	public long getId_reclamo() {
		return id_reclamo;
	}

	public void setId_reclamo(long id_reclamo) {
		this.id_reclamo = id_reclamo;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	@Override
	public String toString() {
		return "Reclamo [id_reclamo=" + id_reclamo + ", detalle=" + detalle + ", fecha=" + fecha + ", estudiante="
				+ estudiante + "]";
	}

}
