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
 * Session Bean implementation class Reclamo
 */
@Stateless
@LocalBean
public class ReclamosBean implements ReclamosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ReclamosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Reclamo reclamo) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(reclamo);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el reclamo");
		}

	}

	@Override
	public void actualizar(Reclamo reclamo) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(reclamo);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el reclamo");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Reclamo reclamo = em.find(Reclamo.class, id);
			em.remove(reclamo);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el reclamo");
		}
	}

	@Override
	public List<Reclamo> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Reclamo> query = em.createQuery("SELECT r FROM Reclamo r", Reclamo.class);
		return query.getResultList();
	}

	@Override
	public List<Reclamo> obtenerPorEstado(String estado) {
		// TODO Auto-generated method stub
		TypedQuery<Reclamo> query = em.createQuery("SELECT r FROM Reclamo r WHERE r.estado LIKE :estado", Reclamo.class)
				.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public Reclamo obtenerReclamo(long id_reclamo) {
		TypedQuery<Reclamo> query = em.createQuery("SELECT r FROM Reclamo r WHERE r.id_reclamo LIKE :id_reclamo", Reclamo.class)
				.setParameter("id_reclamo", id_reclamo);
		return query.getResultList().get(0);
	}

}
