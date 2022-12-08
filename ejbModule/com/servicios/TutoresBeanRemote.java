package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Tutor;
import com.exceptions.ServiciosException;

@Remote
public interface TutoresBeanRemote {
	void crear(Tutor tutor) throws ServiciosException;

	void actualizar(Tutor tutor) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Tutor> obtenerTodos();

	List<Tutor> obtenerTodos(String filtro);

}
