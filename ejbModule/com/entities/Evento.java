package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Evento
 *
 */
@Entity
@Table(name = "EVENTOS")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_EVENTO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_EVENTO")
	private long id_evento;

	@Column(nullable = false, length = 50)
	private String titulo;

	@Column(nullable = false, length = 50)
	private Date fecha_inicio;

	@Column(nullable = false, length = 50)
	private Date fecha_fin;

	@ManyToOne
	private Tutor tutor;

	public Evento() {
		super();
	}

	public Evento(String titulo, Date fecha_inicio, Date fecha_fin, Tutor tutor) {
		super();
		this.titulo = titulo;
		this.fecha_inicio = fecha_inicio;
		this.fecha_fin = fecha_fin;
		this.tutor = tutor;
	}

	public long getId_evento() {
		return id_evento;
	}

	public void setId_evento(long id_evento) {
		this.id_evento = id_evento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Date getFecha_inicio() {
		return fecha_inicio;
	}

	public void setFecha_inicio(Date fecha_inicio) {
		this.fecha_inicio = fecha_inicio;
	}

	public Date getFecha_fin() {
		return fecha_fin;
	}

	public void setFecha_fin(Date fecha_fin) {
		this.fecha_fin = fecha_fin;
	}

	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Evento [id_evento=" + id_evento + ", titulo=" + titulo + ", fecha_inicio=" + fecha_inicio
				+ ", fecha_fin=" + fecha_fin + ", tutor=" + tutor + "]";
	}

}
