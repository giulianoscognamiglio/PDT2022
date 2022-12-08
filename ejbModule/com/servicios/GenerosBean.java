package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Departamento;
import com.entities.Genero;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class Genero
 */
@Stateless
@LocalBean
public class GenerosBean implements GenerosBeanRemote {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public GenerosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Genero genero) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(genero);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el género");
		}

	}

	@Override
	public void actualizar(Genero genero) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(genero);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el género");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Genero genero = em.find(Genero.class, id);
			em.remove(genero);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el género");
		}

	}

	@Override
	public List<Genero> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Genero> query = em.createNamedQuery("Genero.obtenerTodos", Genero.class);
		return query.getResultList();
	}

	@Override
	public List<Genero> obtenerTodos(String filtro) {
		// TODO Auto-generated method stub
		TypedQuery<Genero> query = em.createQuery("SELECT g FROM Genero g WHERE g.nombre LIKE :nombre", Genero.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}

	@Override
	public Genero obtenerPorNombre(String nombre) throws ServiciosException {
		TypedQuery<Genero> query = em
				.createQuery("SELECT g FROM Genero g WHERE g.nombre=:nombre", Genero.class)
				.setParameter("nombre", nombre);
		return query.getSingleResult();
	}
	
	



}
