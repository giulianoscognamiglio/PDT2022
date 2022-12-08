package com.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: ConvocatoriaAsistencia
 *
 */
@Entity
@Table(name = "CONVOCATORIA_ASISTENCIAS")
public class ConvocatoriaAsistencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_CONVOCATORIA", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONVOCATORIA")
	private long id_convocatoria_asistencia;

	@ManyToOne
	private Estudiante estudiante;

	@ManyToOne
	private Evento evento;

	@Column
	private float calificacion;

	// normalizar estado asistencia, o al menos String(?
	@Column
	private float asistencia;

	public ConvocatoriaAsistencia(Estudiante estudiante, Evento evento, float calificacion, float asistencia) {
		this.estudiante = estudiante;
		this.evento = evento;
		this.calificacion = calificacion;
		this.asistencia = asistencia;
	}

	public ConvocatoriaAsistencia() {
		super();
	}

	public long getId_convocatoria_asistencia() {
		return id_convocatoria_asistencia;
	}

	public void setId_convocatoria_asistencia(long id_convocatoria_asistencia) {
		this.id_convocatoria_asistencia = id_convocatoria_asistencia;
	}

	public Estudiante getEstudiante() {
		return estudiante;
	}

	public void setEstudiante(Estudiante estudiante) {
		this.estudiante = estudiante;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public float getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(float calificacion) {
		this.calificacion = calificacion;
	}

	public float getAsistencia() {
		return asistencia;
	}

	public void setAsistencia(float asistencia) {
		this.asistencia = asistencia;
	}

	@Override
	public String toString() {
		return "ConvocatoriaAsistencia [id_convocatoria_asistencia=" + id_convocatoria_asistencia + ", estudiante="
				+ estudiante + ", evento=" + evento + ", calificacion=" + calificacion + ", asistencia=" + asistencia
				+ "]";
	}

}
