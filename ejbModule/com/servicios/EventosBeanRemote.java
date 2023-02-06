package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Evento;
import com.exceptions.ServiciosException;

@Remote
public interface EventosBeanRemote {
	void crear(Evento evento) throws ServiciosException;

	void actualizar(Evento evento) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Evento> obtenerTodos();

	Evento obtenerPorId(Long id_evento);
	}
