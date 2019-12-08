package com.componentes.tester;

import java.util.ArrayList;
import java.util.List;

import com.componentes.controlador.FormularioController;
import com.componentes.dao.FormularioDAO;
import com.componentes.dao.UsuarioDAO;
import com.componentes.entidades.EItem;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Item;
import com.componentes.entidades.Seccion;
import com.componentes.entidades.Usuario;

public class testerListarFormulario {

	public static void main(String[] args) throws Exception {
	

		FormularioDAO fDao = new FormularioDAO();
		
		UsuarioDAO uDao = new UsuarioDAO();
		
		Usuario u = (Usuario)uDao.login("ken", "123456");
		
		List<Formulario> lista = new ArrayList<>();
		
		for	(int i = 0 ; i < 3 ; i++) {
			
			Formulario f = new Formulario();
			f.setNombre("AAAAAAAAA" + String.valueOf(i+1));
			f.setFavorito(false);
			f.setUsuarioPadre(u);
			
			List<Item> items = new ArrayList<>();
			Item it = new Item();
			it.setDefaultName("kkkk" + String.valueOf(i+1)) ;
			it.setTipoDato(EItem.RadioButton);
			
			
			List<Seccion> secciones = new ArrayList<>();
			Seccion s = new Seccion();
			s.setPregunta("?????" + String.valueOf(i+1));
			s.setFormularioPadre(f);
			s.SetItem(items);
			secciones.add(s);
			it.setSeccion(s);
			f.SetSecciones(secciones);

			items.add(it);
		}
		
	}
	
	public static void GetAll() {
		
		Usuario user = new Usuario(); 
		
		user.setNombre("Pepe");
		user.setCorreo("pepe@gmail.com");
		user.setConstrania("1234");
		user.setId(1);
		
		FormularioController formController = new FormularioController(); 
		
		List<Formulario> retorno = formController.Get(user); 
		
		for(Formulario form : retorno) {
			
			System.out.println(form.getNombre());
			System.out.println("**************************");
			for(Seccion seccion: form.GetSecciones()) {
				System.out.println(seccion.getPregunta());
				for(Item item : seccion.getItem()) {
					System.out.println(item.getDefaultName());
					
				}
				System.out.println("---------------------------------------");
			}
		}
		
		
	}
	
	public static void GetOne() {
	
		FormularioController formController = new FormularioController(); 
		
		Formulario form = formController.Get(1);
		
		System.out.println(form.getNombre());
		System.out.println("**************************");
		for(Seccion seccion: form.GetSecciones()) {
			System.out.println(seccion.getPregunta());
			for(Item item : seccion.getItem()) {
				System.out.println(item.getDefaultName());
				
			}
			System.out.println("---------------------------------------");
		}
		
		
		
	}
	

}
