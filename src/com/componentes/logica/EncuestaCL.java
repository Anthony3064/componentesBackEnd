package com.componentes.logica;

import java.util.List;
import com.componentes.dao.EncuestaDAO;
import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Usuario;

public class EncuestaCL {

	EncuestaDAO _encuestaDAO = new EncuestaDAO();

	public void Insertar(Encuesta encuesta) throws Exception {
		if (encuesta.getFrmScaffolding() == null) {
			throw new Exception("El formulario Scaffolding no puede ser nulo");
		} else
			_encuestaDAO.Insert(encuesta);
	}

	public List<Encuesta> GetAll() {

		return null;
	}
	
	/**
	 * usar para obtener todas las encuestas por usuario 
	 * */
	public List<Encuesta> GetAll(Usuario usuario) {
		
		
		return null;
	}
}
