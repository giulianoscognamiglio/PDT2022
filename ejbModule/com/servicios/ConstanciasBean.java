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

/**
 * Session Bean implementation class Constancia
 */
@Stateless
@LocalBean
public class ConstanciasBean implements ConstanciasBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ConstanciasBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Constancia constancia) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(constancia);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta la constancia");
		}

	}

	@Override
	public void actualizar(Constancia constancia) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(constancia);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la constancia");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Constancia constancia = em.find(Constancia.class, id);
			em.remove(constancia);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja la constancia");
		}

	}

	@Override
	public List<Constancia> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Constancia> query = em.createNamedQuery("Constancia.obtenerTodos", Constancia.class);
		return query.getResultList();
	}

	// modificar esté método y generar otro método más para que liste por tipo de
	// constancia y por fecha
	@Override
	public List<Constancia> obtenerTodos(String filtro) {
		// TODO Auto-generated method stub
		TypedQuery<Constancia> query = em
				.createQuery("SELECT c FROM Constancia c WHERE c.nombre LIKE :nombre", Constancia.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

}
