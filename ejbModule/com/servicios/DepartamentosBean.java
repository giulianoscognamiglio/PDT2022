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
 * Session Bean implementation class Departamento
 */
@Stateless
@LocalBean
public class DepartamentosBean implements DepartamentosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public DepartamentosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Departamento departamento) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(departamento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el departamento");
		}

	}

	@Override
	public void actualizar(Departamento departamento) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(departamento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el departamento");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Departamento departamento = em.find(Departamento.class, id);
			em.remove(departamento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el departamento");
		}
	}

	@Override
	public List<Departamento> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Departamento> query = em.createQuery("SELECT d FROM Departamento d", Departamento.class);
		return query.getResultList();
	}

	@Override
	public Departamento obtenerPorNombre(String nombre) throws ServiciosException {
		TypedQuery<Departamento> query = em
				.createQuery("SELECT d FROM Departamento d WHERE d.nombre=:nombre", Departamento.class)
				.setParameter("nombre", nombre);
		return query.getSingleResult();
	}

}
