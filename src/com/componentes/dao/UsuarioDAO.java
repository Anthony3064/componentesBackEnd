package com.componentes.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NonUniqueResultException;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import org.hibernate.exception.ConstraintViolationException;

import com.componentes.entidades.Formulario;
import com.componentes.entidades.Usuario;

public class UsuarioDAO extends Servicio{

	
	public void Insert(Usuario t) throws PersistenceException,Exception { 
		try {
			
			this.startEntityManagerFactory();
			this.em.getTransaction().begin();
			this.em.persist((Usuario)t);
			this.em.getTransaction().commit();
			
		}catch(PersistenceException novalidfild) {
			throw novalidfild; 
		}
		catch (Exception e) {
			throw e; 
		}finally{
			
			this.stopEntityManagerFactory();
		}
	}

	
	public void Update(Usuario t)throws Exception {
		
		try {
			this.startEntityManagerFactory();
			em.getTransaction().begin();
			em.merge((Usuario)t);
			em.getTransaction().commit();
		} catch (Exception e) {
			throw e; 
		}finally {
			this.stopEntityManagerFactory();
		}
	}
	

	
	public void Delete(Usuario t) {
		
	}

	
	public Usuario Get(int id) throws Exception {
		
		try {

		this.startEntityManagerFactory();	
		
		return (Usuario)em.createNamedQuery("Usuario.GetById").setParameter("idParam", id).getSingleResult();

		}catch (Exception e) {
			throw e;
		}
		finally {
			this.stopEntityManagerFactory();
		} 
	}
	
	public Usuario login(String nombre, String contrasenna) throws Exception{
		
		try {

		this.startEntityManagerFactory();	
		
		return (Usuario)em.createNamedQuery("Usuario.Logear").setParameter("nombreParam", nombre).setParameter("constraniaParam", contrasenna).getSingleResult();

		}catch (Exception e) {
			throw e;
		}
		finally {
			
			this.stopEntityManagerFactory();
		} 
			
	}
		
	
	public List<Usuario> GetList() throws Exception {
		
		try {
			
			this.startEntityManagerFactory();
			List<Usuario> listaRetorno = new ArrayList<>();
			listaRetorno = (List<Usuario>)em.createNamedQuery("Usuario.GetAll").getResultList();
			this.stopEntityManagerFactory();
			return listaRetorno;
			
		} catch (Exception e) {
			throw e; 
		}
	}
	

	
}