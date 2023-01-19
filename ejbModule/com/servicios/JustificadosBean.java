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
 * Session Bean implementation class Justificados
 */
@Stateless
@LocalBean
public class JustificadosBean implements JustificadosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public JustificadosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Justificado justificado) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(justificado);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el justificado");
		}

	}

	@Override
	public void actualizar(Justificado justificado) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(justificado);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el justificado");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub

		try {
			Justificado justificado = em.find(Justificado.class, id);
			em.remove(justificado);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el justificado");
		}

	}

	@Override
	public List<Justificado> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Justificado> query = em.createQuery("SELECT j FROM Justificado j", Justificado.class);
		return query.getResultList();
	}

	@Override
	public List<Justificado> obtenerPorEstado(String estado) {
		// TODO Auto-generated method stub
		TypedQuery<Justificado> query = em.createQuery("SELECT j FROM Justificado j WHERE j.estado LIKE :estado", Justificado.class)
				.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public Justificado obtenerJustificado(long id_justificado) {
		TypedQuery<Justificado> query = em.createQuery("SELECT j FROM Justificado j WHERE j.id_justificado LIKE :id_justificado", Justificado.class)
				.setParameter("id_justificado", id_justificado);
		return query.getResultList().get(0);
	}

	@Override
	public List<Justificado> obtenerPorEstudiante(long estudiante_id_usuario) {
		TypedQuery<Justificado> query = em.createQuery("SELECT j FROM Justificado j WHERE j.estudiante_id_usuario LIKE :estudiante_id_usuario", Justificado.class)
				.setParameter("estudiante_id_usuario", estudiante_id_usuario);
		return query.getResultList();
	}
}
