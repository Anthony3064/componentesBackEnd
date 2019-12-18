package com.componentes.logica;

import java.util.List;
import com.componentes.dao.EncuestaDAO;
import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;

public class EncuestaCL {

	EncuestaDAO _encuestaDAO = new EncuestaDAO();

	public void Insertar(Encuesta encuesta) throws Exception {
		
		if (encuesta.getFrmScaffolding() == null) {
			throw new Exception("El formulario Scaffolding no puede ser nulo");
		} else
			_encuestaDAO.Insert(encuesta);
	}

	public List<Encuesta> GetAll() throws Exception {

		return _encuestaDAO.GetList();
	}
	
	/**
	 * usar para obtener todas las encuestas por usuario 
	 * */
	public List<Encuesta> GetAll(Usuario usuario) throws Exception{
		return _encuestaDAO.GetList(usuario);  
	}
	
	public void Update(Encuesta encuesta) throws Exception {
		_encuestaDAO.Update(encuesta);
	}
	
	public Encuesta encuestaPorId(int idEncuesta) throws Exception{
		return _encuestaDAO.encuestaPorId(idEncuesta);
	}
	
	public Encuesta encuestaPorFrmScaffolding(Formulario frmScaffolding) {
		return _encuestaDAO.encuestaPorFrmScaffolding(frmScaffolding);
		
	}
	
}
