package com.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Usuario
 *
 */

@Entity
@Table(name = "USUARIOS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name = "SEQ_USUARIO", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_USUARIO")
	private long id_usuario;

	@ManyToOne
	private ITR itr;

	@Column(nullable = false, length = 50)
	private String cedula;

	@Column(nullable = false, length = 50)
	private String usuario;

	@Column(nullable = false, length = 50)
	private String contrasena;

	@Column(nullable = false, length = 50)
	private String apellido1;

	@Column(nullable = true, length = 50)
	private String apellido2;

	@Column(nullable = false, length = 50)
	private String nombre1;

	@Column(nullable = true, length = 50)
	private String nombre2;

	@Column(nullable = false, length = 50)
	private Date fechaNac;

	@ManyToOne
	private Genero genero;

	@ManyToOne
	private Rol rol;

	@ManyToOne
	private Departamento departamento;

	@Column(nullable = false, length = 50)
	private String localidad;

	@Column(nullable = false, length = 50)
	private String mail;

	@Column(nullable = false, length = 50)
	private String mailInstitucional;

	@Column(nullable = false, length = 50)
	private String telefono;

	@Column(nullable = false, length = 50)
	private String validado; // en la base está como char porque no lo pude poner boolean

	@Column(nullable = false, length = 50)
	private String activo;

	public Usuario() {
		super();
	}

	public Usuario(String cedula, String usuario, String contrasena, String apellido1, String apellido2, String nombre1,
			String nombre2, Date fechaNac, Genero genero, Departamento departamento, String localidad, String mail,
			String mailInstitucional, String telefono, String validado, String activo) {
		super();
		this.cedula = cedula;
		this.usuario = usuario;
		this.contrasena = contrasena;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.nombre1 = nombre1;
		this.nombre2 = nombre2;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.departamento = departamento;
		this.localidad = localidad;
		this.mail = mail;
		this.mailInstitucional = mailInstitucional;
		this.telefono = telefono;
		this.validado = validado;
		this.activo = activo;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getValidado() {
		return validado;
	}

	public void setValidado(String validado) {
		this.validado = validado;
	}

	public String getActivo() {
		return activo;
	}

	public void setActivo(String activo) {
		this.activo = activo;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getMailInstitucional() {
		return mailInstitucional;
	}

	public void setMailInstitucional(String mailInstitucional) {
		this.mailInstitucional = mailInstitucional;
	}

	public ITR getItr() {
		return itr;
	}

	public void setItr(ITR itr) {
		this.itr = itr;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Override
	public String toString() {
		return "Usuario [id_usuario=" + id_usuario + ", itr=" + itr + ", cedula=" + cedula + ", usuario=" + usuario
				+ ", contrasena=" + contrasena + ", apellido1=" + apellido1 + ", apellido2=" + apellido2 + ", nombre1="
				+ nombre1 + ", nombre2=" + nombre2 + ", fechaNac=" + fechaNac + ", genero=" + genero + ", rol=" + rol
				+ ", departamento=" + departamento + ", localidad=" + localidad + ", mail=" + mail
				+ ", mailInstitucional=" + mailInstitucional + ", telefono=" + telefono + ", validado=" + validado
				+ ", activo=" + activo + "]";
	}

}
