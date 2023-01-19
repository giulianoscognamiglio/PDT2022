package com.servicios;

import java.util.List;

import javax.ejb.Remote;

import com.entities.Usuario;
import com.exceptions.ServiciosException;

@Remote
public interface UsuariosBeanRemote {
	
	void crear(Usuario usuario) throws ServiciosException;

	void actualizar(Usuario usuario) throws ServiciosException;

	void borrar(Long id) throws ServiciosException;

	List<Usuario> obtenerTodos();

	public Usuario obtenerPorDocumento(String cedula) throws ServiciosException;
	
	public Usuario obtenerPorId(long id_usuario) throws ServiciosException;
	
	Usuario verificarUsuario(String usuario, String contrasena) throws ServiciosException;

	public boolean existeDocumento(String documento);

	List<Usuario> obtenerEstudiantes() throws ServiciosException;
	
}
