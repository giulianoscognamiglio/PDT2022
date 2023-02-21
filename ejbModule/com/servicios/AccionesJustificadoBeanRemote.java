package com.servicios;


import javax.ejb.Remote;

import com.entities.AccionJustificacion;
import com.exceptions.ServiciosException;

@Remote
public interface AccionesJustificadoBeanRemote {
	void crear(AccionJustificacion Accion) throws ServiciosException;


	void borrar(Long id) throws ServiciosException;



}
