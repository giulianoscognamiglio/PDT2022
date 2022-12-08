package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Justificado;
import com.exceptions.ServiciosException;

@Remote
public interface JustificadosBeanRemote {
	void crear(Justificado justificado) throws ServiciosException;

	void actualizar(Justificado justificado) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Justificado> obtenerTodos();

	List<Justificado> obtenerTodos(String filtro);

}
