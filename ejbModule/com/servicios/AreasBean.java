package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Area;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class Area
 */
@Stateless
@LocalBean
public class AreasBean implements AreasBeanRemote {

	@PersistenceContext
	private EntityManager em;

	public AreasBean() {
	}

	@Override
	public void crear(Area area) throws ServiciosException {
		try {
			em.persist(area);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el área");
		}

	}

	@Override
	public void actualizar(Area area) throws ServiciosException {
		try {
			em.merge(area);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el área");
		}
	}

	public void borrar(int id) throws ServiciosException {
		try {
			Area area = em.find(Area.class, id);
			em.remove(area);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el área");
		}

	}

	@Override
	public List<Area> obtenerTodos() {
		TypedQuery<Area> query = em.createQuery("SELECT a FROM Area a", Area.class);
		return query.getResultList();
	}

	@Override
	public List<Area> obtenerTodos(String filtro) {
		TypedQuery<Area> query = em.createQuery("SELECT a FROM Area a WHERE a.nombre LIKE :nombre", Area.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}
	
	
	@Override
	public Area obtenerPorNombre(String nombre) throws ServiciosException{
		TypedQuery<Area> query = em
				.createQuery("SELECT a FROM Area a WHERE a.nombre=:nombre", Area.class)
				.setParameter("nombre", nombre);
				
		return query.getSingleResult();
	}

}
