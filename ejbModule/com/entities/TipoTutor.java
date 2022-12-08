package com.entities;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: TipoTutor
 *
 */
@Entity
@Table(name = "TIPOSTUTOR")
public class TipoTutor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_TIPOTUTOR", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_TIPOTUTOR")
	private long id_tipoTutor;

	@Column(nullable = false, length = 50)
	private String nombre;

	public TipoTutor() {
		super();
	}

	public TipoTutor(String nombre) {
		super();
		this.nombre = nombre;
	}

	public long getId_tipoTutor() {
		return id_tipoTutor;
	}

	public void setId_tipoTutor(long id_tipoTutor) {
		this.id_tipoTutor = id_tipoTutor;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "TipoTutor [id_tipoTutor=" + id_tipoTutor + ", nombre=" + nombre + "]";
	}

}
