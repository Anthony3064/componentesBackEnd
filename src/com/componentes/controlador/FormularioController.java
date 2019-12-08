package com.componentes.controlador;

import java.util.ArrayList;
import java.util.List;

import com.componentes.dao.FormularioDAO;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;
import com.componentes.logica.FormularioCL;

public class FormularioController {
	private FormularioCL _formularioCL = new FormularioCL();

	public void Insert(Formulario Formulario) {
		/// Revisar esto
		try {
			_formularioCL.insertFormulario(Formulario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void Update(Formulario formulario) {

		try {
			_formularioCL.Update(formulario);
		} catch (Exception e) {
			/// Redirect to error page
			System.out.println(e.getMessage());
		}

	}

	public void Delete(int id) {
		// TODO Auto-generated method stub

	}

	public Formulario Get(int id) {

		try {
			return _formularioCL.Get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
			return new Formulario();
		}

	}

	public List<Formulario> Get() {

		try {
			return _formularioCL.GetAll();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ArrayList<Formulario>();
		}

	}

	/// mientras implementamos la api se van a usar estos 3
	public List<Formulario> Get(Usuario usuario) {

		try {
			return _formularioCL.getFormulario(usuario);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			return new ArrayList<Formulario>();
		}

	}

}
