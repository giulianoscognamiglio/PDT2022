package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ITR;
import com.exceptions.ServiciosException;

@Remote
public interface ItrsBeanRemote {

	void crear(ITR itr) throws ServiciosException;

	void actualizar(ITR itr) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<ITR> obtenerTodos();

	ITR obtenerPorNombre(String filtro);
}
