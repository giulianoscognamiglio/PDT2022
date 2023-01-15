package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Reclamo;
import com.exceptions.ServiciosException;

@Remote
public interface ReclamosBeanRemote {
	
	void crear(Reclamo reclamo) throws ServiciosException;

	void actualizar(Reclamo reclamo) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Reclamo> obtenerTodos();

	List<Reclamo> obtenerPorEstado(String estado);
	
	List<Reclamo> obtenerPorEstudiante(long estudiante_id_reclamo);

	Reclamo obtenerReclamo(long id);

}
