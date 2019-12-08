package com.componentes.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.componentes.controlador.EncuestaController;
import com.componentes.controlador.FormularioController;
import com.componentes.controlador.UsuarioController;
import com.componentes.dao.EncuestaDAO;
import com.componentes.dao.FormularioDAO;
import com.componentes.dao.IDao;
import com.componentes.dao.ItemDAO;
import com.componentes.dao.SeccionDAO;
import com.componentes.dao.UsuarioDAO;
import com.componentes.entidades.EItem;
import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Item;
import com.componentes.entidades.Seccion;
import com.componentes.entidades.Usuario;
import com.componentes.logica.UsuarioLG;

public class testerInsertarFormulario {

	static FormularioController _fController = new FormularioController();

	public static void main(String[] args) {

		// InsertarFormulario();
		// ListFormularioPorID();
		// ListFormularios();
		// EditarFormulario();
		//ListarFormularioPorUsuario(); 
		
	}

//	public static List<Encuesta> GetEncuestasDummy(Usuario usuario){
//		///Hacemos la encu
//		ArrayList<Encuesta> retorno = new ArrayList<Encuesta>(); 
//		List<Formulario> forms = GetDummyForms(usuario); 
//		
//		for(Formulario frm : forms) {
//			
//			Encuesta _encuesta = new Encuesta(); 
//			_encuesta.setFrmScaffolding(frm);
//			frm.setIsInterface(true);
//			
//			retorno.add(_encuesta); 
//		}
//		
//		return retorno; 
//		
//	} 

	private static void InsertarFormulario() {
		// Traemos un usuario
		UsuarioTester ut = new UsuarioTester();
		Usuario u = ut.RecuperarUsuario();

		List<Formulario> lst = GetDummyForms(u);

		for (Formulario f : lst) {
			f.setUsuarioPadre(u);
			f.setIsInterface(true);
			f.setFavorito(true);
			_fController.Insert(f);

		}
	}

	public static void ListFormularioPorID() {
		for (int i = 0; i < 1000; i++) {
			Formulario fm = _fController.Get(i);
			DibujarFormulario(fm);
		}
	}

	public static List<Formulario> ListFormularios() {

		List<Formulario> lst = _fController.Get();
		for (Formulario f : lst) {
			DibujarFormulario(f);
		}
		return lst; 
	}
	
	public static List<Formulario> ListarFormularioPorUsuario() {
		UsuarioTester ut = new UsuarioTester();
		Usuario u = ut.RecuperarUsuario();
		List<Formulario> lst = _fController.Get(u); 
		
		for(Formulario f: lst) {
			DibujarFormulario(f); 
		}
		return lst; 
	}
	
	public static void EditarFormulario() {
		///Traemos toda la lista 
		
		int i = 0; 
		for(Formulario f : ListarFormularioPorUsuario()) {
			System.out.println("Actualizando nombre a "+f.getNombre());
			f.GetSecciones().clear();
			f.setNombre("Formulario de prueba"+ i++ +" - Editado");
			f.SetSecciones(GetDummySeccion(f));
			_fController.Update(f); 
		}
		///Volvemos a listar
		//ListFormularios();
		ListarFormularioPorUsuario(); 
		
	}

	public static void DibujarFormulario(Formulario formulario) {
		System.out.println("");
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		System.out.println(formulario.toString());
		System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
		for(Seccion s : formulario.GetSecciones()) {
			System.out.println("--------------------");
			System.out.println(s.getPregunta());
			System.out.println("-");
			for(Item i : s.getItem()) {
				System.out.println(i.getDefaultName());
			}
		}
	}

	public static List<Formulario> GetDummyForms(Usuario usurio) {

		List<Formulario> retorno = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			Formulario frm = new Formulario();
			frm.setNombre("formulario de prueba" + i);
			frm.setUsuarioPadre(usurio);
			// por cada formulario creado se agrega una lista de secciones
			// frm.setId(i);
			frm.SetSecciones(GetDummySeccion(frm));
			retorno.add(frm);
		}

		return retorno;
	}

	public static List<Seccion> GetDummySeccion(Formulario frm) {
		List<Seccion> retorno = new ArrayList<>();

		for (int i = 0; i < 3; i++) {

			Seccion sccn = new Seccion();
			sccn.setFormularioPadre(frm);
			sccn.setPregunta("pregunta de prueba" + i);
			sccn.SetItem(GetDummyItems(sccn));
			retorno.add(sccn);
		}

		return retorno;
	}

	public static List<Item> GetDummyItems(Seccion scctn) {
		List<Item> retorno = new ArrayList<>();
		/// Crear aleatoreamente* un tipo de item
		// Este random lo uso para generar el tipo de item
		Random r = new Random();
		int valorDado = r.nextInt(2);

		// si el item = 0 then textobox
		if (valorDado == 0) {
			retorno.add(GetTextox(scctn));
		} else {

			retorno = GetTextoxs(scctn);
		}

		return retorno;
	}

	// va a ser un texbox entonces solo retorna uno
	public static Item GetTextox(Seccion seccion) {

		Item retorno = new Item();
		retorno.setDefaultName("dibujame como un cuadro de texto");
		retorno.setSeccion(seccion);
		retorno.setTipoDato(EItem.TextBox);

		return retorno;
	}

	public static List<Item> GetTextoxs(Seccion seccion) {

		List<Item> retorno = new ArrayList<>();

		for (int i = 0; i < 3; i++) {

			Item item = new Item();
			item.setDefaultName("opcion radioButton " + i);
			item.setSeccion(seccion);
			item.setTipoDato(EItem.RadioButton);
			retorno.add(item);
		}

		return retorno;
	}

}
