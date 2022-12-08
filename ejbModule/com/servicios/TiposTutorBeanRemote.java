package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.TipoTutor;
import com.exceptions.ServiciosException;

@Remote
public interface TiposTutorBeanRemote {
	
	void crear(TipoTutor tipoTutor) throws ServiciosException;

	void actualizar(TipoTutor tipoTutor) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<TipoTutor> obtenerTodos();

	List<TipoTutor> obtenerTodos(String filtro);
	
	public TipoTutor obtenerPorNombre(String nombre) throws ServiciosException;

}
