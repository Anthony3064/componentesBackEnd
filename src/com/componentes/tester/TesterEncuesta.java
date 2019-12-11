package com.componentes.tester;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import com.componentes.controlador.EncuestaController;
import com.componentes.controlador.UsuarioController;
import com.componentes.entidades.EItem;
import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Item;
import com.componentes.entidades.Seccion;
import com.componentes.entidades.Usuario;

public class TesterEncuesta {
	
	static EncuestaController _encuestaController = new EncuestaController(); 
	static UsuarioController uT = new UsuarioController(); 
	static TesterFormulario formTest = new TesterFormulario(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CrearEncuesta(); 
		//ListarTodasLasEncuestas(); 
		 ListarEncuestaPorUsuario();
		//LlenarEncuesta(); 
		 
		 /*
		 Encuesta encuesta = new Encuesta();
		 
		 encuesta.setUsuarioPadre(uT.Login("Anthony", "123456"));
		 
		 Formulario form = new Formulario();
		 form.setNombre("Formulario de Prueba");
		 form.setFavorito(false);
		 
		 List<Seccion> secciones = new ArrayList<>();
		 
		 for (int i = 0; i < 3; i++) {
			 
			 List<Item> items = new ArrayList<>();
			 
			 Seccion seccion = new Seccion();
			 seccion.setFormularioPadre(form);
			 seccion.setPregunta("Pregunta: " + i);
			 
			 for (int j = 0; j < 4; j++) {
				
				Item item = new Item();
				item.setDefaultName("Item " + j);
				item.setTipoDato(EItem.RadioButton);
				item.setSeccion(seccion);
				items.add(item);
			
			 }
			 
			 seccion.SetItem(items);
			 
			 secciones.add(seccion);
		}
		 
		 
		 form.SetSecciones(secciones);
		 
		 form.setEncuesta(encuesta);
		 
		 encuesta.setFrmScaffolding(form);
		 
		 Usuario u = uT.Login("Anthony", "123456");
		 
		 List<Encuesta>listas = new ArrayList<>();
		 
		 listas.add(encuesta);
		 
		 u.setEncuestas(listas);
		 
		 uT.Update(u);
		 */
		 
		 
		 List<Encuesta> encuestas = _encuestaController.Get(uT.Login("Anthony", "123456"));
		 
		 
		 for (Encuesta encuesta : encuestas) {
			
			 for (Formulario form : encuesta.getRespuestas()) {
				
				 System.out.println(form.getNombre());
				 
				 for (Seccion seccion : form.GetSecciones()) {
					 
					 System.out.println(seccion.getPregunta());
					for (Item it : seccion.getItem()) {
						System.out.println(it.getDefaultName());
					}
				}
				 
			}
			 
		}
		 
		JOptionPane.showMessageDialog(null, _encuestaController.Get(2).getFrmScaffolding());
		 
	}
	
	public static Encuesta CrearEncuesta() {
		//necesitamos una encuesta
			
			//Usuario u = uT.RecuperarUsuario(); 
			
		
			Encuesta encuesta = new Encuesta(); 
			Formulario form =  formTest.GetDummyForms().get(0); 

			System.out.println(form.toString());
		   //Este formulario va a ser el scaffolding
		   
			encuesta.setFrmScaffolding(form);
			//encuesta.setUsuarioPadre(u);
			
			List<Encuesta> enc = new ArrayList<Encuesta>();
			enc.add(encuesta); 
			
			//u.setEncuestas(enc);
			form.setEncuesta(encuesta);
		   
			UsuarioController uC = new UsuarioController(); 
			//uC.Update(u);
			//_encuestaController.Insert(encuesta);
			
			return null; 
	}
	
	public static void ListarTodasLasEncuestas() {
		
		List<Encuesta> lst = _encuestaController.Get(); 
		
		for(Encuesta e: lst) {
			System.out.println(e.getFrmScaffolding().getNombre());
		}
		
	}
	
	public static void ListarEncuestaPorUsuario() {
		
		//List<Encuesta> lst = _encuestaController.Get(uT.RecuperarUsuario()); 
		//for(Encuesta e: lst) {
			//System.out.println(e.getFrmScaffolding().getNombre());
		}
	//}
	
	public static void LlenarEncuesta() {
		
		List<Encuesta> lst = _encuestaController.Get(); 
		
		for(Encuesta encuesta: lst) {
			List<Formulario> listRespuestaToSave = new ArrayList<Formulario>();  
			
			for(int i = 0; i < 5; i++) {
				
				Formulario respueta = formTest.GetDummyForms().get(0); 
				respueta.setEncuesta(encuesta);
				respueta.setIsInterface(false);
				listRespuestaToSave.add(respueta); 
			}
			
			encuesta.setRespuestas(listRespuestaToSave);
			_encuestaController.Update(encuesta);
		}
		
	}
	
	
}
