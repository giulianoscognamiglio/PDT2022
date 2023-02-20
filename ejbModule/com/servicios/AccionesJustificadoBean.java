package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import com.entities.*;
import com.exceptions.ServiciosException;

@Stateless
@LocalBean
public class AccionesJustificadoBean implements AccionesJustificadoBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public AccionesJustificadoBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(AccionJustificacion accion) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(accion);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta la accion");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			AccionJustificacion accion = em.find(AccionJustificacion.class, id);
			em.remove(accion);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja la accion");
		}

	}

}
