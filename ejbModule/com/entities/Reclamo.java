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

	@Column(nullable = false, length = 200)
	private String detalle;

	@Column(nullable = false, length = 50)
	private Date fecha;

	@Column(nullable = false, length = 50)
	private long estudiante_id_usuario;

	@Column(nullable = false, length = 20)
	private String estado;
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Reclamo() {
		super();
	}

	public Reclamo(String detalle, Date fecha, long idEstudiante, String estado) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.estudiante_id_usuario = idEstudiante;
		this.estado = estado;
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

	public long getEstudiante() {
		return estudiante_id_usuario;
	}

	public void setEstudiante(long idEstudiante) {
		this.estudiante_id_usuario = idEstudiante;
	}

	@Override
	public String toString() {
		return "Reclamo [id_reclamo=" + id_reclamo + ", detalle=" + detalle + ", fecha=" + fecha + ", estudiante="
				+ estudiante_id_usuario + "]";
	}

}
