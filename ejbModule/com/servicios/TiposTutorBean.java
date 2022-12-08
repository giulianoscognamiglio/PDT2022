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
 * Session Bean implementation class TipoTutor
 */
@Stateless
@LocalBean
public class TiposTutorBean implements TiposTutorBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public TiposTutorBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(TipoTutor tipoTutor) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(tipoTutor);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el tipoTutor");
		}

	}

	@Override
	public void actualizar(TipoTutor tipoTutor) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(tipoTutor);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el tipoTutor");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			TipoTutor tipoTutor = em.find(TipoTutor.class, id);
			em.remove(tipoTutor);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja la tipoTutor");
		}

	}

	@Override
	public List<TipoTutor> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<TipoTutor> query = em.createQuery("SELECT t FROM TipoTutor t", TipoTutor.class);
		return query.getResultList();
	}

	@Override
	public List<TipoTutor> obtenerTodos(String filtro) {
		// TODO Auto-generated method stub
		TypedQuery<TipoTutor> query = em
				.createQuery("SELECT t FROM TipoTutor t WHERE t.nombre LIKE :nombre", TipoTutor.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}
	
	
	@Override
	public TipoTutor obtenerPorNombre(String nombre) throws ServiciosException{
		TypedQuery<TipoTutor> query = em
				.createQuery("SELECT t FROM TipoTutor t WHERE t.nombre=:nombre", TipoTutor.class)
				.setParameter("nombre", nombre);
				
		return query.getSingleResult();
	}


}
