package com.componentes.tester;
import java.util.ArrayList;
import java.util.List;

import com.componentes.controlador.EncuestaController;
import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Seccion;

public class TesterEncuesta {
	
	static EncuestaController _encuestaController = new EncuestaController(); 
	static UsuarioTester uT = new UsuarioTester(); 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//CrearEncuesta(); 
		ListarTodasLasEncuestas(); 
	}
	
	public static Encuesta CrearEncuesta() {
		//necesitamos una encuesta
		
			TesterFormulario formTest = new TesterFormulario(); 
		   Formulario form =  formTest.GetDummyForms(uT.RecuperarUsuario()).get(0); 
		   System.out.println(form.toString());
		   //Este formulario va a ser el scaffolding
		   
		   Encuesta encuesta = new Encuesta(); 
		   encuesta.setFrmScaffolding(form);
		   form.setEncuesta(encuesta);
		   _encuestaController.Insert(encuesta);
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

	}
	
}
