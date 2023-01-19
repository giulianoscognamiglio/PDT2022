package com.servicios;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import com.entities.Usuario;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class Usuario
 */
@Stateless
@LocalBean
public class UsuariosBean implements UsuariosBeanRemote {

	@PersistenceContext
	private EntityManager em;

	/**
	 * Default constructor.
	 */
	public UsuariosBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void crear(Usuario usuario) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException(e.getMessage());
		}
	}

	@Override
	public void actualizar(Usuario usuario) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			em.merge(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo actualizar el usuario");
		}

	}

	@Override
	public void borrar(Long id) throws ServiciosException {
		// TODO Auto-generated method stub
		try {
			Usuario usuario = em.find(Usuario.class, id);
			em.remove(usuario);
			em.flush();
		} catch (PersistenceException e) {
			throw new ServiciosException("No se pudo dar de baja el usuario");
		}

	}

	@Override
	public List<Usuario> obtenerTodos() {
		// TODO Auto-generated method stub
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u", Usuario.class);
		return query.getResultList();
	}

	@Override
	public Usuario obtenerPorDocumento(String cedula) throws ServiciosException {
		try {
		TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.cedula LIKE :cedula", Usuario.class)
				.setParameter("cedula", cedula);
		return query.getSingleResult();
		}catch(PersistenceException e) {
			return null;
		}
		
	}
	
	@Override
	public Usuario verificarUsuario (String usuario, String contrasena) throws ServiciosException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.usuario = :usuario AND u.contrasena=:contrasena",Usuario.class)
					.setParameter("usuario", usuario)
					.setParameter("contrasena", contrasena);
			return query.getSingleResult();
		}catch(PersistenceException e) {
			return null;
		}
	}

	@Override
	public boolean existeDocumento(String cedula) {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.cedula = :cedula",Usuario.class)
					.setParameter("cedula", cedula);
			if(query != null) {
				return true;
			}
			return false;
		}catch(PersistenceException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Usuario obtenerPorId(long id_usuario) throws ServiciosException {
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.id_usuario LIKE :id_usuario", Usuario.class)
					.setParameter("id_usuario", id_usuario);
			return query.getSingleResult();
			}catch(PersistenceException e) {
				return null;
			}
	}
	
	@Override
	public
	List<Usuario> obtenerEstudiantes() throws ServiciosException{
		try {
			TypedQuery<Usuario> query = em.createQuery("SELECT u FROM Usuario u WHERE u.rol_id == 1", Usuario.class);
					
			return query.getResultList();
			}catch(PersistenceException e) {
				return null;
			}
	}


}
