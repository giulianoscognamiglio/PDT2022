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

	@Column(nullable = false, length = 50)
	private long estudiante_id_usuario;

	@Column(nullable = false, length = 20)
	private String estado;

	public Justificado() {
		super();
	}

	public Justificado(String detalle, Date fecha, long idEstudiante, String estado) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.estudiante_id_usuario = idEstudiante;
	}

//	@ManyToOne
//	private Estudiante estudiante;

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

	public long getEstudiante() {
		return estudiante_id_usuario;
	}

	public void setEstudiante(long idEstudiante) {
		this.estudiante_id_usuario = idEstudiante;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Justificado [id_justificado=" + id_justificado + ", detalle=" + detalle + ", fecha=" + fecha
				+ ", estudiante_id_usuario=" + estudiante_id_usuario + ", estado=" + estado + "]";
	}

}
