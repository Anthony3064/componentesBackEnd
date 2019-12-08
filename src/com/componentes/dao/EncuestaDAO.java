package com.componentes.dao;

import java.util.List;
import javax.persistence.TypedQuery;
import java.util.ArrayList;

import com.componentes.entidades.Encuesta;
import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;


public class EncuestaDAO extends Servicio{

	
	public void Insert(Encuesta t) throws Exception {
		
		try {
			
			this.startEntityManagerFactory();
			this.em.getTransaction().begin();
			this.em.persist(t);
			this.em.getTransaction().commit();
			
		} catch (Exception e) {
			throw e; 
		}finally {
			this.stopEntityManagerFactory();
		}
	}
	
	
	public void Update(Encuesta t) throws Exception {
		try {
			this.startEntityManagerFactory();
			em.getTransaction().begin();
			em.merge((Encuesta)t);
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

	
	public Formulario Get(int id) {
		
		this.startEntityManagerFactory();
		Formulario formLeido = em.find(Formulario.class, id);
		this.stopEntityManagerFactory();
		return formLeido;
		
	}

	
	public List<Encuesta> GetList() throws Exception{
		
		try {
			
			this.startEntityManagerFactory();
			this.em.getTransaction().begin();
			TypedQuery<Encuesta> query = em.createNamedQuery("Encuesta.findPK", Encuesta.class);
			return query.getResultList();
			
		} catch (Exception e) {
			throw e; 
		}finally {
			this.stopEntityManagerFactory();
		}
		
	}


	public List<Encuesta> GetList(Usuario usuario) throws Exception {
		try {
			
			this.startEntityManagerFactory();
			this.em.getTransaction().begin();
			return this.findAllSQLWithParam(usuario); 

		} catch (Exception e) {
			throw e; 
		}finally {
			this.stopEntityManagerFactory();
		}
	}
	
	public  List<Encuesta> findAllSQLWithParam(Usuario usuario) throws Exception {
	
	TypedQuery<Usuario> query = em.createNamedQuery("Usuario.findAllSQLWithParam", Usuario.class);
	
	query.setParameter("idParam", usuario.getId());
	if(query.getResultList().size() > 0) {
		
		List<Encuesta> lst = query.getResultList().get(0).GetEncuestas(); 
		return lst;
	}
	else
		return new ArrayList<Encuesta>(); 
}

	
}




















