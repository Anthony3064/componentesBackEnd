package com.componentes.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;


public class FormularioDAO extends Servicio {

	
	
	public void Insert(Formulario formulario) throws Exception  {
		
		try {
			
			this.startEntityManagerFactory();
			this.em.getTransaction().begin();
			this.em.persist(formulario);
			this.em.getTransaction().commit();
			
		} catch (Exception e) {
			throw e; 
		}finally {
			this.stopEntityManagerFactory();
		}
	}
	
	
	public void Update(Formulario t) throws Exception {
		
		try {
			this.startEntityManagerFactory();
			em.getTransaction().begin();
			em.merge((Formulario)t);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e; 
		}finally {
			this.stopEntityManagerFactory();
		}
	}

	
	public void Delete(Object t) {
		// TODO Auto-generated method stub
		
	}

	
	public Formulario Get(int id) throws Exception {
		try {
			
		this.startEntityManagerFactory();
		Formulario formLeido = em.find(Formulario.class, id);
		return formLeido;
		
		} catch (Exception e) {
			throw e; 
		}
		
	}

	
	public List<Formulario> GetAll() throws Exception{
		
		try {
			
		this.startEntityManagerFactory();
		this.em.getTransaction().begin();
		TypedQuery<Formulario> query = em.createNamedQuery("Formulario.findPK", Formulario.class);
		return query.getResultList();

		} catch (Exception e) {
			throw e; 
		}finally {
			this.stopEntityManagerFactory();
		}
		
	}
	
	
//	TypedQuery<DemoPersona> query = em.createNamedQuery("DemoPersona.findAllSQLWithParam", DemoPersona.class);
//	query.setParameter("nombreParam", "%Fde%");
//	return query.getResultList();
	
//	public List<Formulario> GetList(Usuario usuario) throws Exception {
//
//		try {
//			
//			this.startEntityManagerFactory();
//			this.em.getTransaction().begin();
//			return this.findAllSQLWithParam(usuario); 
//
//		} catch (Exception e) {
//			throw e; 
//		}finally {
//			this.stopEntityManagerFactory();
//		} 
//	}
	
	public List<Formulario> buscarFormulariosUsuario(Usuario usuario){
		
		List<Formulario> listaFormularios = null;
		
		try {
			
			//startEntityManagerFactory();
			
			listaFormularios = (List<Formulario>)em.createNamedQuery("Formulario.DeUsuario").setParameter("usuarioParam", usuario).getResultList();
			
			if(listaFormularios.size() > 0) {
				
				return listaFormularios;
				
			}
			
			}catch (Exception e) {
				throw e;
			} 
		
		return listaFormularios;
		
	}
	
//	public  List<Formulario> findAllSQLWithParam(Usuario usuario) throws Exception {
//		
//		TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAllSQLWithParam", Usuario.class);
//		
//		query.setParameter("idParam", usuario.getId());
//		if(query.getResultList().size() > 0) {
//			
//			List<Formulario> lst = query.getResultList().get(0).GetFomurlarios(); 
//			return lst;
//		}
//		else
//			return new ArrayList<Formulario>(); 
//	}
	
}




















