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
	private Long id_reclamo;

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(nullable = false, length = 50)
	private String titulo;
	
	@Column(nullable = false, length = 200)
	private String detalle;

	@Column(nullable = false, length = 50)
	private Date fecha;

	@Column(nullable = false, length = 50)
	private Long estudiante_id_usuario;

	@Column(nullable = false, length = 20)
	private String estado;
	
	@Column(nullable = false, length = 10)
	private String tipo;
	
	//opcionales
	//solo vme
	@Column(nullable = true, length = 100)
	private String nombreEventoVME;
	
	//ape u optativa
	@Column(nullable = true, length = 100)
	private String nombreActividadAPE;
	
	//vme, ape u optativa-----------------------------
	@Column(nullable = true, length = 10)
	private Integer creditosReclamados;
	
	@Column(nullable = true, length = 50)
	private Long docente_id;
	
	@Column(nullable = true, length = 50)
	private Date fechaInicioActividad;
	
	@Column(nullable = true, length = 10)
	private Integer semestre;
	//------------------------------------------------
	
	public long getEstudiante_id_usuario() {
		return estudiante_id_usuario;
	}

	public void setEstudiante_id_usuario(Long estudiante_id_usuario) {
		this.estudiante_id_usuario = estudiante_id_usuario;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getNombreEventoVME() {
		return nombreEventoVME;
	}

	public void setNombreEventoVME(String nombreEventoVME) {
		this.nombreEventoVME = nombreEventoVME;
	}

	public String getNombreActividadAPE() {
		return nombreActividadAPE;
	}

	public void setNombreActividadAPE(String nombreActividadAPE) {
		this.nombreActividadAPE = nombreActividadAPE;
	}

	public int getCreditosReclamados() {
		return creditosReclamados;
	}

	public void setCreditosReclamados(Integer creditosReclamados) {
		this.creditosReclamados = creditosReclamados;
	}

	public Long getDocente_id() {
		return docente_id;
	}

	public void setDocente_id(Long docente_id) {
		this.docente_id = docente_id;
	}

	public Date getFechaInicioActividad() {
		return fechaInicioActividad;
	}

	public void setFechaInicioActividad(Date fechaInicioActividad) {
		this.fechaInicioActividad = fechaInicioActividad;
	}

	public int getSemestre() {
		return semestre;
	}

	public void setSemestre(Integer semestre) {
		this.semestre = semestre;
	}

	public Reclamo() {
		super();
	}

//	public Reclamo(String detalle, Date fecha, long idEstudiante, String estado) {
//		super();
//		this.detalle = detalle;
//		this.fecha = fecha;
//		this.estudiante_id_usuario = idEstudiante;
//		this.estado = estado;
//	}

	public long getId_reclamo() {
		return id_reclamo;
	}

	public Reclamo(long id_reclamo, String detalle, Date fecha, long estudiante_id_usuario, String estado, String tipo,
		String nombreEventoVME, String nombreActividadAPE, int creditosReclamados, Long docente_id,
		Date fechaInicioActividad, int semestre) {
	super();
	this.id_reclamo = id_reclamo;
	this.detalle = detalle;
	this.fecha = fecha;
	this.estudiante_id_usuario = estudiante_id_usuario;
	this.estado = estado;
	this.tipo = tipo;
	this.nombreEventoVME = nombreEventoVME;
	this.nombreActividadAPE = nombreActividadAPE;
	this.creditosReclamados = creditosReclamados;
	this.docente_id = docente_id;
	this.fechaInicioActividad = fechaInicioActividad;
	this.semestre = semestre;
}

	public void setId_reclamo(Long id_reclamo) {
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

	public void setEstudiante(Long idEstudiante) {
		this.estudiante_id_usuario = idEstudiante;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	@Override
	public String toString() {
		return "Reclamo [id_reclamo=" + id_reclamo + ", detalle=" + detalle + ", fecha=" + fecha
				+ ", estudiante_id_usuario=" + estudiante_id_usuario + ", estado=" + estado + "]";
	}


}
