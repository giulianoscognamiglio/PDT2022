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
 * Session Bean implementation class Tutor
 */
@Stateless
@LocalBean
public class TutoresBean implements TutoresBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * @see Usuario#Usuario()
	 */
	public TutoresBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Tutor tutor) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(tutor);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el tutor");
		}

	}

	@Override
	public void actualizar(Tutor tutor) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(tutor);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el tutor");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Tutor tutor = em.find(Tutor.class, id);
			em.remove(tutor);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el tutor");
		}

	}

	@Override
	public List<Tutor> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Tutor> query = em.createNamedQuery("Tutor.obtenerTodos", Tutor.class);
		return query.getResultList();
	}

	@Override
	public List<Tutor> obtenerTodos(String filtro) {
		// TODO Auto-generated method stub
		TypedQuery<Tutor> query = em.createQuery("SELECT t FROM Tutor t WHERE t.nombre LIKE :nombre", Tutor.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

}
