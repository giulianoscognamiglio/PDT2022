package com.servicios;

import javax.ejb.Remote;

import java.util.List;

import com.entities.Rol;
import com.exceptions.ServiciosException;

@Remote
public interface RolBeanRemote {
	Rol buscarNombre(String nombre) throws ServiciosException;

	Rol buscarUsuarioPorId(Long id) throws ServiciosException;

	List<Rol> obtenerRoles() throws ServiciosException;

	void modificarRol(Rol rol) throws ServiciosException;

	void borrarRol(Long id) throws ServiciosException;

	void crearRol(Rol rol) throws ServiciosException;
}
