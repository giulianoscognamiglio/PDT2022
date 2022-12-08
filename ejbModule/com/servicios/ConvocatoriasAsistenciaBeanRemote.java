package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.ConvocatoriaAsistencia;
import com.exceptions.ServiciosException;

@Remote
public interface ConvocatoriasAsistenciaBeanRemote {
	void crear(ConvocatoriaAsistencia convocatoria) throws ServiciosException;

	void actualizar(ConvocatoriaAsistencia convocatoria) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<ConvocatoriaAsistencia> obtenerTodos();

	List<ConvocatoriaAsistencia> obtenerTodos(String filtro);
}
