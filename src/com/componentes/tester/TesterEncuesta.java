package com.componentes.tester;
import java.util.ArrayList;
import java.util.List;

import com.componentes.controlador.EncuestaController;
import com.componentes.controlador.UsuarioController;
import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Seccion;
import com.componentes.entidades.Usuario;

public class TesterEncuesta {
	
	static EncuestaController _encuestaController = new EncuestaController(); 
	static UsuarioTester uT = new UsuarioTester(); 
	static TesterFormulario formTest = new TesterFormulario(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CrearEncuesta(); 
		//ListarTodasLasEncuestas(); 
		 ListarEncuestaPorUsuario();
		//LlenarEncuesta(); 
	}
	
	public static Encuesta CrearEncuesta() {
		//necesitamos una encuesta
			
			Usuario u = uT.RecuperarUsuario(); 
			
		
			Encuesta encuesta = new Encuesta(); 
			Formulario form =  formTest.GetDummyForms().get(0); 

			System.out.println(form.toString());
		   //Este formulario va a ser el scaffolding
		   
			encuesta.setFrmScaffolding(form);
			encuesta.setUsuarioPadre(u);
			
			List<Encuesta> enc = new ArrayList<Encuesta>();
			enc.add(encuesta); 
			
			u.setEncuestas(enc);
			form.setEncuesta(encuesta);
		   
			UsuarioController uC = new UsuarioController(); 
			uC.Update(u);
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
		
		List<Encuesta> lst = _encuestaController.Get(uT.RecuperarUsuario()); 
		for(Encuesta e: lst) {
			System.out.println(e.getFrmScaffolding().getNombre());
		}
	}
	
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
