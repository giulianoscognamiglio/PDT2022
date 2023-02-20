package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Analista;
import com.entities.Usuario;
import com.exceptions.ServiciosException;

@Remote
public interface AnalistasBeanRemote {
	void crear(Analista analista) throws ServiciosException;
	 void actualizar(Analista analista) throws ServiciosException;
	 void borrar(Long id) throws ServiciosException;
	 List<Analista> obtenerTodos();
//	 List<Analista> obtenerTodos(String filtro);
	 public Usuario obtenerPorDocumento(String cedula);
	 public Analista obtenerAnalistaDocumento(String cedula);

}
