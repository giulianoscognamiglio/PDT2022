package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Analista;
import com.entities.Usuario;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class Analista
 */
@Stateless
@LocalBean
public class AnalistasBean implements AnalistasBeanRemote {//debe heredar de UsuariosBean???

	@PersistenceContext
	private EntityManager em;

	/**
	 * @see Usuario#Usuario()
	 */
	public AnalistasBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Analista analista) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(analista);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta el usuario analista");
		}
	}

	@Override
	public void actualizar(Analista analista) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(analista);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el departamento");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Analista analista = em.find(Analista.class, id);
			em.remove(analista);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el usuario analista");
		}
	}
	
	@Override
	public List<Analista> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Analista> query = em.createNamedQuery("Analista.obtenerTodos", Analista.class);
		return query.getResultList();
	}
	
	@Override
	public Usuario obtenerPorDocumento(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.cedula LIKE :cedula", Usuario.class)
				.setParameter("cedula", cedula);
		return query.getSingleResult();
	}

}
