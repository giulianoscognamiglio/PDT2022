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
 * Session Bean implementation class Estudiante
 */
@Stateless
@LocalBean
public class EstudiantesBean implements EstudiantesBeanRemote {// Debe heredar de usuariobean???
	@PersistenceContext
	private EntityManager em;

	/**
	 * @see Usuario#Usuario()
	 */
	public EstudiantesBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Estudiante estudiante) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(estudiante);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta al estudiante");
		}

	}

	@Override
	public void actualizar(Estudiante estudiante) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(estudiante);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar al estudiante");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Estudiante estudiante = em.find(Estudiante.class, id);
			em.remove(estudiante);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja al estudiante");
		}

	}

	@Override
	public List<Estudiante> obtenerTodos() {
		TypedQuery<Estudiante> query = em.createQuery("SELECT r FROM Estudiante r", Estudiante.class);
		return query.getResultList();
	}
	
	// generar otro método que busque por id y otro por ci
	@Override
	public List<Estudiante> obtenerTodos(String filtro) {
		// TODO Auto-generated method stub
		TypedQuery<Estudiante> query = em
				.createQuery("SELECT e FROM Estudiante e WHERE e.nombre LIKE :nombre", Estudiante.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

}
