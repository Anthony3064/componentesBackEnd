package com.componentes.tester;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import com.componentes.controlador.EncuestaController;
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
		//GetAll();  
		
		
		
		EncuestaController eC = new EncuestaController();
		
		for (Formulario f : eC.Get(19).getRespuestas()) {
			
			if (f.isIsInterface()) {
				
				for (Formulario f2 : eC.Get(19).getRespuestas()) {
					
					if (f2.isIsInterface()) {
						
					}else {
						
						for (Seccion s : f.GetSecciones()) {
							
							if (s.getItem().size() > 1) {
								
								for (Seccion s2 : f2.GetSecciones()) {
									
									if (s.getPregunta().equalsIgnoreCase(s2.getPregunta())) {
										int cont1 = 0;
										int cont2 = 0;
										int cont3 = 0;
										int cont4 = 0;
										System.out.println(s.getPregunta());
										for (Item i2 : s2.getItem()) {
											if (s.getItem().get(0).getDefaultName().equalsIgnoreCase(i2.getDefaultName())) {
												cont1 += 1;
											}else if (s.getItem().get(1).getDefaultName().equalsIgnoreCase(i2.getDefaultName())) {
												cont2 += 1;
											}else if (s.getItem().get(2).getDefaultName().equalsIgnoreCase(i2.getDefaultName())) {
												cont3 += 1;
											}else if (s.getItem().get(3).getDefaultName().equalsIgnoreCase(i2.getDefaultName())) {
												cont4 += 1;
											}
										}
										System.out.println(cont1 + " " + s.getItem().get(0).getDefaultName());
										System.out.println(cont2 + " " + s.getItem().get(1).getDefaultName());
										System.out.println(cont3 + " " + s.getItem().get(2).getDefaultName());
										System.out.println(cont4 + " " + s.getItem().get(3).getDefaultName());
									}

									
									
									
								}
								
							}
							
						}
						
					}
					
				}
				
				
			}
			
			
		}
		
		
		/*
		Usuario u = new Usuario();
		u.setNombre("Anthony");
		u.setCorreo("anthonyestiven3064@gmail.com");
		u.setConstrania("123456");
		_ucontroller.Insert(u);
		
		System.out.println(u.getCorreo());
		*/	

	}
	
	public static void RegistrarPersona() {
		Usuario user = new Usuario(); 
		user.setNombre("kenneth");
		user.setCorreo("kenaguilar.steve@gmail.com");
		user.setConstrania("1234");
		_ucontroller.Insert(user);
	}
	public static Usuario RecuperarUsuario() {
		
		Usuario user = _ucontroller.Get(1); 
		System.out.println(user.getCorreo());
		System.out.println(user.getNombre());
		return user; 
	}
	public static void Login() {
		Usuario user = _ucontroller.Login("kenaguilar.steve@gmail.com", "1234");
		System.out.println(user.getNombre());
		
	}
	public static void Edit() {
		Usuario user = RecuperarUsuario();
		
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

