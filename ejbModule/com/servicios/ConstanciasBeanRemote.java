package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Constancia;
import com.exceptions.ServiciosException;

@Remote
public interface ConstanciasBeanRemote {
	void crear(Constancia constancia) throws ServiciosException;

	void actualizar(Constancia constancia) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Constancia> obtenerTodos();

	List<Constancia> obtenerTodos(String filtro);

}
