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
 * Session Bean implementation class Evento
 */
@Stateless
@LocalBean
public class EventosBean implements EventosBeanRemote {
	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public EventosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Evento evento) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(evento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el evento");
		}

	}

	@Override
	public void actualizar(Evento evento) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(evento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la constancia");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Evento evento = em.find(Evento.class, id);
			em.remove(evento);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el evento");
		}

	}

	@Override
	public List<Evento> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Evento> query = em.createNamedQuery("Evento.obtenerTodos", Evento.class);
		return query.getResultList();

	}

	@Override
	public Evento obtenerPorId(Long id_evento) {
		// TODO Auto-generated method stub
		TypedQuery<Evento> query = em.createQuery("SELECT e FROM Evento e WHERE e.id_evento LIKE :id_evento", Evento.class)
				.setParameter("id_evento", id_evento);
		return query.getSingleResult();
	}

}
