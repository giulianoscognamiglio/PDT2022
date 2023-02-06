package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Tutor
 *
 */
@Entity
@Table(name = "TUTORES")
@PrimaryKeyJoinColumn(referencedColumnName="ID_USUARIO")
public class Tutor extends Usuario implements Serializable {

	
//	@Entity
//	@PrimaryKeyJoinColumn(referencedColumnName="id")
//	public class Tutor extends Usuario implements Serializable {

	public Tutor() {
		super();
	}
	
	private static final long serialVersionUID = 1L;	
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TUTOR")
	@SequenceGenerator(name = "SEQ_TUTOR", initialValue = 1, allocationSize = 1)
	private long id_tutor;

	@Column
	private Area area;

	@Column
	private TipoTutor tipo;

	public Tutor(String cedula, String usuario, String contrasena, String apellido1, String apellido2,
			String nombre1, String nombre2, Date fechaNac, Genero genero, Departamento departamento, String localidad,
			String mail, String mailInstitucional, String telefono, String validado, String activo, TipoTutor tipo, Area area /*long id_tutor*/) {
		super(cedula, usuario, contrasena, apellido1, apellido2, nombre1, nombre2, fechaNac, genero,
				departamento, localidad, mail, mailInstitucional, telefono, validado, activo);
//		this.id_tutor = id_tutor;
		this.tipo = tipo;
		this.area = area;
	}



	public long getId_tutor() {
		return id_tutor;
	}

	public void setId_tutor(long id_tutor) {
		this.id_tutor = id_tutor;
	}

	public Area getArea() {
		return area;
	}

	public void setArea(Area area) {
		this.area = area;
	}

	public TipoTutor getTipo() {
		return tipo;
	}

	public void setTipo(TipoTutor tipo) {
		this.tipo = tipo;
	}
	
   
}
