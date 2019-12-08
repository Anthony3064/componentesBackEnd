package com.componentes.tester;

import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;

public class TesterEncuesta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrearEncuesta(); 
	}
	
	public static Encuesta CrearEncuesta() {
		//necesitamos una encuesta
		
		TesterFormulario formTest = new TesterFormulario(); 
		
		   Formulario form =  formTest.ListFormularioPorID(1);
		   formTest.DibujarFormulario(form);
		
		
		
		return null; 
	}
	
}
