package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Constancia
 *
 */
@Entity
@Table (name="CONSTANCIAS")
public class Constancia implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Constancia() {
		super();
	} 
	
	public Constancia(String detalle, Date fecha, Estudiante estudiante) {
		super();
		this.detalle = detalle;
		this.fecha = fecha;
		this.estudiante = estudiante;
	}

	@Id
	@SequenceGenerator(name = "SEQ_CONSTANCIA", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CONSTANCIA")
	private long id_constancia;
	
	@Column(nullable=false, length=50)
	private String detalle;
	
	@Column(nullable=false, length=50)
	private Date fecha;
   
	@ManyToOne
	private Estudiante estudiante;
	public long getId_constancia() {
		return id_constancia;
	}

	public void setId_constancia(long id_constancia) {
		this.id_constancia = id_constancia;
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
		return "Constancia [id_constancia=" + id_constancia + ", detalle=" + detalle + ", fecha=" + fecha
				+ ", estudiante=" + estudiante + "]";
	}
	
	
}
