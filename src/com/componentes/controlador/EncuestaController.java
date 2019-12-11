package com.componentes.controlador;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;

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
	
	public void Update(Encuesta encuesta) {
		try {
			_encuestaCL.Update(encuesta);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	public void Delete(int id) {
		// TODO Auto-generated method stub
		
	}

	
	public Encuesta Get(int id) {
		
		Encuesta encuesta = null;
		
		try {
			encuesta = _encuestaCL.encuestaPorId(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return encuesta; 
		
	}

	
	public List<Encuesta> Get() {
		try {
			return  _encuestaCL.GetAll();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null; 
		} 
		 
	}




	public List<Encuesta> Get(Usuario usuario) {
		try {
			return _encuestaCL.GetAll(usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null; 
		} 
	}
	

	
}
