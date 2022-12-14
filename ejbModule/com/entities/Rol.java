package com.entities;

import java.io.Serializable;
import javax.persistence.*;

import java.util.List;
import java.util.ArrayList;

/**
 * Entity implementation class for Entity: Rol
 *
 */
public class Rol implements Serializable {

	
	private static final long serialVersionUID = 1L;	
	public Rol() {
		super();
	} 
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ROLES" )
	@SequenceGenerator(name = "SEQ_ROLES", initialValue = 1, allocationSize = 1)
	private Long id;
	
	@Column(nullable=false,length=50)
	String nombre;
	
	@Column(nullable=false,length=150)
	String descripcion;
	
	
	@JoinTable(name = "ROL_FUNCION", joinColumns = @JoinColumn(name = "FK_ROL", nullable = false), 
			inverseJoinColumns = @JoinColumn(name = "FK_FUNCION", nullable = false))
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)

	private List<Funcionalidad> funcionalidades;

	public void addFuncionalidad(Funcionalidad funcionalidad) {
		if (this.funcionalidades == null) {
			this.funcionalidades = new ArrayList<>();
		}

		this.funcionalidades.add(funcionalidad);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Rol [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}

	public List<Funcionalidad> getFuncionalidades() {
		return funcionalidades;
	}

	public void setFuncionalidades(List<Funcionalidad> funcionalidades) {
		this.funcionalidades = funcionalidades;
	}
	
	
	
	
   
	
   
}
