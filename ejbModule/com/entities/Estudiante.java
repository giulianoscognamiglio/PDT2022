package com.entities;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Estudiante
 *
 */
@Entity
@Table(name = "ESTUDIANTES")
@PrimaryKeyJoinColumn(referencedColumnName="ID_USUARIO")
public class Estudiante extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	//@Id
	@SequenceGenerator(name = "SEQ_ESTUDIANTE", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ESTUDIANTE")
	private long id_estudiante;

	@Column
	private String generacion;

	public Estudiante(String cedula, String usuario, String contrasena, String apellido1,
			String apellido2, String nombre1, String nombre2, Date fechaNac, Genero genero, Departamento departamento,
			String localidad, String mail, String mailInstitucional, String telefono, String validado, String activo /*long id_estudiante*/) {

		super(cedula, usuario, contrasena, apellido1, apellido2, nombre1, nombre2, fechaNac, genero,
				departamento, localidad, mail, mailInstitucional, telefono, validado, activo);

//		this.id_estudiante = id_estudiante;
	}

	public Estudiante() {
		super();
	}

	public long getId_estudiante() {
		return id_estudiante;
	}

	public void setId_estudiante(long id_estudiante) {
		this.id_estudiante = id_estudiante;
	}

	public String getGeneracion() {
		return generacion;
	}

	public void setGeneracion(String generacion) {
		this.generacion = generacion;
	}

}
