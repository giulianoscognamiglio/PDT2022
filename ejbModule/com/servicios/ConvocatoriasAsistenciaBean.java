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
 * Session Bean implementation class ConvocatoriaAsistencia
 */

//CREO QUE ESTA CLASE NO VA, ES UNA RELACIÓN ENTRE TABLAS CON ALGUNOS ATRIBUTOS

@Stateless
@LocalBean
public class ConvocatoriasAsistenciaBean implements ConvocatoriasAsistenciaBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public ConvocatoriasAsistenciaBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(ConvocatoriaAsistencia convocatoria) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.persist(convocatoria);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de alta la convocatoria asistencia");
		}

	}

	@Override
	public void actualizar(ConvocatoriaAsistencia convocatoria) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(convocatoria);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar la convocatoria asistencia");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub

		try {
			ConvocatoriaAsistencia convocatoria = em.find(ConvocatoriaAsistencia.class, id);
			em.remove(convocatoria);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja la convocatoria asistencia");
		}

	}

	@Override
	public List<ConvocatoriaAsistencia> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<ConvocatoriaAsistencia> query = em.createNamedQuery("ConvocatoriaAsistencia.obtenerTodos",
				ConvocatoriaAsistencia.class);
		return query.getResultList();
	}

	@Override
	public List<ConvocatoriaAsistencia> obtenerTodos(String filtro) {
		// TODO Auto-generated method stub
		TypedQuery<ConvocatoriaAsistencia> query = em
				.createQuery("SELECT c FROM ConvocatoriaAsistencia c WHERE c.nombre LIKE :nombre",
						ConvocatoriaAsistencia.class)
				.setParameter("nombre", filtro);
		return query.getResultList();
	}
	
	@Override
	public List<ConvocatoriaAsistencia> obtenerPorEstudiante(Long id_estudiante) {
		TypedQuery<ConvocatoriaAsistencia> query = em.createQuery("SELECT c FROM ConvocatoriaAsistencia c WHERE c.id_estudiante LIKE :id_estudiante", ConvocatoriaAsistencia.class)
				.setParameter("id_estudiante", id_estudiante);
		return query.getResultList();
	}

}
