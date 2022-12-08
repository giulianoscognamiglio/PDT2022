package com.servicios;


import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

import java.util.List;
import com.entities.Funcionalidad;
import com.exceptions.ServiciosException;

/**
 * Session Bean implementation class FuncionalidadBean
 */
@Stateless
public class FuncionalidadBean implements FuncionalidadBeanRemote {

    @PersistenceContext
	private EntityManager em;
	
    public FuncionalidadBean() {
    }
    
    
    @Override
   	public void crearFuncionalidad(Funcionalidad f) throws ServiciosException {
   		
   		try {
   			
   			em.merge(f);
   			em.flush();		
   			
   		}catch(PersistenceException e) {
   			throw new ServiciosException("No se pudo crear el Rol"); 

   		}
   	}
   	
   	
   	
   	@Override
   	public void borrarFuncionalidad(Long id) throws ServiciosException {
   		
   		try {
   			
   			Funcionalidad f= em.find(Funcionalidad.class, id);
   			
   			em.remove(f);
   			em.flush();
   			
   		}catch(PersistenceException e) {
   			throw new ServiciosException("No se pudo BORRAR la funcionalidad"); 
   		}
   	}
   	
   	
   	
   	@Override
   	public void modificarFuncionalidad(Funcionalidad f) throws ServiciosException{
   		
   		try {
   			
   			em.merge(f);
   			
   			em.flush();
   			
   		}catch(PersistenceException e) {
   			throw new ServiciosException("No se pudo MODIFICAR la funcionalidad"); 
   		}
   	}
   	
   	@Override
   	public List<Funcionalidad> obtenerFuncionalidades() throws ServiciosException {
   		
   		try {
   		

   			TypedQuery<Funcionalidad> query = em.createQuery("SELECT DISTINCT f FROM Funcionalidad f",Funcionalidad.class);
   		
   			return query.getResultList();
   		
   		}catch(PersistenceException e) {
   			throw new ServiciosException("No se pudo obtener la lista de roles"); 
   		}
   		
   	}
   	
   	@Override
   	public Funcionalidad buscarFuncionalidadPorId(Long id) throws ServiciosException {
   		
   		try {
   			
   			Funcionalidad f= em.find(Funcionalidad.class, id);
   			
   			return f;
   			
   		}catch(PersistenceException e) {
   			throw new ServiciosException("No se encontro la funcionalidad"); 
   		}
   	}
   	
   	@Override
	public Funcionalidad buscarNombre (String nombre) throws ServiciosException {
		
		try {
			

			TypedQuery<Funcionalidad> query = em.createQuery("SELECT f FROM Funcionalidad f WHERE f.nombre = :nombre",Funcionalidad.class)
					.setParameter("nombre", nombre);
					

		
			return query.getSingleResult();
			
		}catch(PersistenceException e) {

			return null;
			 
		}
	}

}
