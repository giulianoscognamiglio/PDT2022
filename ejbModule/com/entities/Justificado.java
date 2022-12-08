package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Justificado
 *
 */
@Entity
@Table(name = "JUSTIFICADOS")
public class Justificado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_JUSTIFICADO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_JUSTIFICADO")
	private long id_justificado;

	@Column(nullable = false, length = 50)
	private String detalle;

	@Column(nullable = false, length = 50)
	private Date fecha;

	public Justificado() {
		super();
	}

	public Justificado(String detalle, Date fecha, Estudiante estudiante) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.estudiante = estudiante;
	}

	@ManyToOne
	private Estudiante estudiante;

	public long getId_justificado() {
		return id_justificado;
	}

	public void setId_justificado(long id_justificado) {
		this.id_justificado = id_justificado;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Justificado [id_justificado=" + id_justificado + ", detalle=" + detalle + ", fecha=" + fecha
				+ ", estudiante=" + estudiante + "]";
	}

}
