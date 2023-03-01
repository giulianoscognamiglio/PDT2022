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

@Entity
@Table(name = "ACCIONES_RECLAMOS")
public class AccionReclamo implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@SequenceGenerator(name = "SEQ_ACCION_RECLAMOS", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCION_RECLAMOS")
	Long id;
	
	@Column(nullable =false)
	Date fecha;
	
	@Column(length = 100)
	String detalle;
	

	@Column(nullable= false)
	Long analista_id;
	
	@Column(nullable= false)
	Long reclamo_id;

	public Long getAnalista_id() {
		return analista_id;
	}

	public void setAnalista_id(Long analista_id) {
		this.analista_id = analista_id;
	}

	public Long getReclamo_id() {
		return reclamo_id;
	}

	public void setReclamo_id(Long reclamo_id) {
		this.reclamo_id = reclamo_id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getDetalle() {
		return detalle;
	}

	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}

	public Long getAnalista() {
		return analista_id;
	}

	public void setAnalista(Long analista) {
		this.analista_id = analista;
	}

}
