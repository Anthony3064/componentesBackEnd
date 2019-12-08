package com.componentes.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import com.componentes.dao.FormularioDAO;
import com.componentes.entidades.EItem;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Item;
import com.componentes.entidades.Seccion;
import com.componentes.entidades.Usuario;

public class FormularioCL {

	private FormularioDAO _formularioDAO = new FormularioDAO();  
			
//	public List<Formulario> getFormulario(Usuario usuario) throws Exception{
//		if(usuario == null) {
//			throw new Exception("Usuario no valido"); 
//			//return new ArrayList<Formulario>(); 
//		}else
//		return _formularioDAO.GetList(usuario); 
//	}
	
	public void insertFormulario(Formulario formulario) throws Exception {
		_formularioDAO.Insert(formulario);
	}
	
	public Formulario Get(int id) throws Exception {
		Formulario fomulario =_formularioDAO.Get(id); 

		if(fomulario == null) {
			throw new Exception("Formulario no encontrado"); 
		}
		return  fomulario; 
		
	}

	public List<Formulario> GetAll() throws Exception {
		return _formularioDAO.GetAll(); 
	}
	public void Update(Formulario formulario) throws Exception {
		_formularioDAO.Update(formulario);
	}
	

}
