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
 * FK Session Bean implementation class Itr
 */
@Stateless
@LocalBean
public class ItrsBean implements ItrsBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ItrsBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(ITR itr) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(itr);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el itr");
		}

	}

	@Override
	public void actualizar(ITR itr) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(itr);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el itr");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			ITR itr = em.find(ITR.class, id);
			em.remove(itr);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el itr");
		}

	}

	@Override
	public List<ITR> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<ITR> query = em.createQuery("SELECT i FROM ITR i", ITR.class);
		return query.getResultList();
	}

	@Override
	public ITR obtenerPorNombre(String filtro) {
		// TODO Auto-generated method stub
		TypedQuery<ITR> query = em.createQuery("SELECT i FROM ITR i WHERE i.nombre = :nombre", ITR.class)
				.setParameter("nombre", filtro);
		return query.getSingleResult();
	}
	
}
