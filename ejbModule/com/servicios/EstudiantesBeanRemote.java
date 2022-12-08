package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Estudiante;
import com.exceptions.ServiciosException;

@Remote
public interface EstudiantesBeanRemote {
	void crear(Estudiante estudiante) throws ServiciosException;

	void actualizar(Estudiante estudiante) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Estudiante> obtenerTodos();

	List<Estudiante> obtenerTodos(String filtro);

}
