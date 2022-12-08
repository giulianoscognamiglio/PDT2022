package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Area;
import com.exceptions.ServiciosException;

@Remote
public interface AreasBeanRemote {
	void crear(Area area) throws ServiciosException;

	void actualizar(Area area) throws ServiciosException;

	void borrar(int id) throws ServiciosException;

	List<Area> obtenerTodos();

	List<Area> obtenerTodos(String filtro);


	public Area obtenerPorNombre(String nombre) throws ServiciosException;

}
