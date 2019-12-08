package com.componentes.controlador;

import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;

import org.hibernate.exception.ConstraintViolationException;

import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;
import com.componentes.logica.UsuarioLG;

public class UsuarioController {

	private UsuarioLG _usuarioLG = new UsuarioLG(); 
	
	
	public void Insert(Usuario t) {
		try {
			_usuarioLG.Insert(t);
		}catch(PersistenceException MailRepet) {
			//Error causado por llave repetida, si debugeas la excepcion se puede ser el 
			//Mensaje de error pero no lo pude sacar, la idea es poder recuperarlo
			System.out.println(MailRepet.getCause());
		} catch (Exception e) {
			//Redirect to error page
			System.out.println(e.getMessage());
		}
	}
	public Usuario Login(String correo, String pass) {
		
		try {
			Usuario usuario = _usuarioLG.Login(correo, pass);
			if(usuario == null) {
				//Return no user message
				return null; 
			}else {
				return usuario; 
			}
		} catch (NonUniqueResultException nofound) {
			//Redirect to not found user
			return null; 
		}  catch(Exception ex) {
			//redirect to error page
			return null; 
		}
		 
		
	}
	
	
	public void Update(Usuario usuario) {
		
		try {
			_usuarioLG.Update(usuario);
		} catch (Exception e) {
			// Redirect to error page
			e.printStackTrace();
		}
		
	}
	
	
	
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	public Usuario Get(int id) {
		
		try {
			return _usuarioLG.GetBbyId(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		}
		
	}

	
	public List<Usuario> Get() {
	
		return _usuarioLG.GetAll(); 
	}


	
}
