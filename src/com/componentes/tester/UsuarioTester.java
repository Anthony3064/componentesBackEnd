package com.componentes.tester;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.componentes.controlador.UsuarioController;
import com.componentes.dao.FormularioDAO;
import com.componentes.dao.ItemDAO;
import com.componentes.dao.SeccionDAO;
import com.componentes.dao.UsuarioDAO;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Item;
import com.componentes.entidades.Seccion;
import com.componentes.entidades.Usuario;


public class UsuarioTester {

	static UsuarioController _ucontroller = new  UsuarioController(); 
	public static void main(String[] args) {
			
		//RegistrarPersona(); 
		//RecuperarUsuario(); 
		//Login(); 
		//Edit();
		GetAll();  
	}
	
	public static void RegistrarPersona() {
		Usuario user = new Usuario(); 
		user.setNombre("kenneth");
		user.setCorreo("kenaguilar.steve@gmail.com");
		user.setConstrania("1234");
		_ucontroller.Insert(user);
	}
	public static void RecuperarUsuario() {
		
		Usuario user = _ucontroller.Get(1); 
		System.out.println(user.getCorreo());
		System.out.println(user.getNombre());
	}
	public static void Login() {
		Usuario user = _ucontroller.Login("kenaguilar.steve@gmail.com", "1234");
		System.out.println(user.getNombre());
		
	}
	public static void Edit() {
		Usuario user = _ucontroller.Get(1); 
		System.out.println(user.getCorreo());
		System.out.println(user.getNombre());
		
		System.out.println("Editando....");
		user.setNombre("steve");
		user.setCorreo("steve@gmail.com");
		user.setConstrania("abc"); 
		
		_ucontroller.Update(user);

		RecuperarUsuario(); 
	}
	public static void GetAll() {
		
		List<Usuario> lst = _ucontroller.Get();  
		
		for(Usuario user : lst) {
			System.out.println(user.toString()); 
		}
	}
   
}

