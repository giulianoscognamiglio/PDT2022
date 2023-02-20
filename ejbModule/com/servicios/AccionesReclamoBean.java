package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import com.entities.*;
import com.exceptions.ServiciosException;


@Stateless
@LocalBean
public class AccionesReclamoBean implements AccionesReclamoBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public AccionesReclamoBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(AccionReclamo accion) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(accion);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta la accion");
		}

	}

	@Override
	public void actualizar(AccionReclamo accion) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(accion);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la accion");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			AccionReclamo accion = em.find(AccionReclamo.class, id);
			em.remove(accion);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja la accion");
		}

	}

	@Override
	public List<AccionReclamo> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<AccionReclamo> query = em.createNamedQuery("Select a FROM Accion a", AccionReclamo.class);
		return query.getResultList();
	}


}
