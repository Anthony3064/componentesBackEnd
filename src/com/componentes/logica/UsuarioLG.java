package com.componentes.logica;

import java.util.List;

import com.componentes.dao.UsuarioDAO;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;

public class UsuarioLG {

	UsuarioDAO _usuarioDAO = new UsuarioDAO();
//Verificacion.VerificarString(usuario.getCorreo())
	public void Insert(Usuario usuario) throws Exception {
		/// Verificar los atributos del usuario
		if (!Verificacion.VerificarString(usuario.getNombre())) {

			throw new Exception("Nombre invalido");

		} else if (!Verificacion.VerificarString(usuario.getCorreo())) {

			// Todo verificacion formato correo
			throw new Exception("Correo invalido");

		} else if (!Verificacion.VerificarString(usuario.getConstrania())) {
			
			throw new Exception("Contraseña invalido");

		} else {
			_usuarioDAO.Insert(usuario);
		}
	}

	public Usuario Login(String correo, String pass) throws Exception {
		return _usuarioDAO.login(correo, pass);
	}

	public void Update(Usuario usuario) throws Exception {
		_usuarioDAO.Update(usuario);
	}
	public Usuario GetBbyId(int id) throws Exception {
		return _usuarioDAO.Get(id); 
	}
	public List<Usuario> GetAll() throws Exception{
		return _usuarioDAO.GetList(); 
	}

}
