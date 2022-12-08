package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Analista
 *
 */
@Entity
@Table(name = "ANALISTAS")
@PrimaryKeyJoinColumn(referencedColumnName="ID_USUARIO")
public class Analista extends Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@SequenceGenerator(name = "SEQ_ANALISTA", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ANALISTA")
	private long id_analista;

	public Analista(String cedula, String usuario, String contrasena, String apellido1,
			String apellido2, String nombre1, String nombre2, Date fechaNac, Genero genero, Departamento departamento,
			String localidad, String mail, String mailInstitucional, String telefono, String validado, String activo /*long id_analista*/) {

		super(cedula, usuario, contrasena, apellido1, apellido2, nombre1, nombre2, fechaNac, genero,
				departamento, localidad, mail, mailInstitucional, telefono, validado, activo);

//		this.id_analista = id_analista;
	}

	public Analista() {
		super();
	}

	public long getId_analista() {
		return id_analista;
	}

	public void setId_analista(long id_analista) {
		this.id_analista = id_analista;
	}

}
