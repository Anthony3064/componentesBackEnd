package com.componentes.controlador;

import java.util.List;

import com.componentes.dao.FormularioDAO;
import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;
import com.componentes.logica.EncuestaCL;

public class EncuestaController {
	
	private EncuestaCL _encuestaCL = new EncuestaCL(); 
	
	public void Insert(Encuesta encuesta) {
		
		try {
			_encuestaCL.Insertar(encuesta);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
				
	}
	
	

	
	public void Update(int id) {
		// TODO Auto-generated method stub
		
	}

	
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	public Formulario Get(int id) {
	
		return null; 
		
	}

	
	public List<Formulario> Get() {
		return null; 
		
	}
	///mientras implementamos la api se van a usar estos 3
	public List<Formulario> Get(Usuario usuario) {
		
		
		
		return null; 
		
	}
}
