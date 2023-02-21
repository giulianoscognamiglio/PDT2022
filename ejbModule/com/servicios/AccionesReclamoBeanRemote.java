package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.AccionReclamo;
import com.entities.Analista;
import com.exceptions.ServiciosException;

@Remote
public interface AccionesReclamoBeanRemote {
	void crear(AccionReclamo Accion) throws ServiciosException;

	void actualizar(AccionReclamo accion) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<AccionReclamo> obtenerTodos();

}
