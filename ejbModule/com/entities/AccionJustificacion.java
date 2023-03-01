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
@Table(name = "ACCIONES_JUSTIFICACIONES")
public class AccionJustificacion implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@SequenceGenerator(name = "SEQ_ACCION_JUSTIFICACIONES", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACCION_JUSTIFICACIONES")
	Long id;
	
	@Column(nullable =false)
	Date fecha;
	
	@Column(length = 100)
	String detalle;
	

	@Column(nullable= false)
	Long analista_id;

	@Column(nullable= false)
	Long justificado_id;
	
	public Long getAnalista_id() {
		return analista_id;
	}

	public void setAnalista_id(Long analista_id) {
		this.analista_id = analista_id;
	}

	public Long getJustificado_id() {
		return justificado_id;
	}

	public void setJustificado_id(Long justificado_id) {
		this.justificado_id = justificado_id;
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
