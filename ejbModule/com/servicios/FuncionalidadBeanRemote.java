package com.servicios;

import javax.ejb.Remote;

import java.util.List;

import com.entities.Funcionalidad;
import com.exceptions.ServiciosException;
@Remote
public interface FuncionalidadBeanRemote {
	Funcionalidad buscarNombre(String nombre) throws ServiciosException;

	Funcionalidad buscarFuncionalidadPorId(Long id) throws ServiciosException;

	List<Funcionalidad> obtenerFuncionalidades() throws ServiciosException;

	void modificarFuncionalidad(Funcionalidad f) throws ServiciosException;

	void borrarFuncionalidad(Long id) throws ServiciosException;

	void crearFuncionalidad(Funcionalidad f) throws ServiciosException;
}
