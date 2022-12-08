package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Departamento;
import com.entities.Genero;
import com.exceptions.ServiciosException;

@Remote
public interface GenerosBeanRemote {
	void crear(Genero genero) throws ServiciosException;

	void actualizar(Genero genero) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Genero> obtenerTodos();

	List<Genero> obtenerTodos(String filtro);
	
	Genero obtenerPorNombre(String nombre) throws ServiciosException;

}
