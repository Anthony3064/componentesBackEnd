package com.componentes.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
 
public abstract class Servicio {

	
	protected static  EntityManagerFactory entityManagerFactory = null;
	protected static  EntityManager em = null;
	
	public static void startEntityManagerFactory() {
		
		if (entityManagerFactory == null) {
			try {
				entityManagerFactory = Persistence
						.createEntityManagerFactory("Componentes");
				em = entityManagerFactory.createEntityManager();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void stopEntityManagerFactory() {
		
		if (entityManagerFactory != null) {
			if (entityManagerFactory.isOpen()) {
				try {
					entityManagerFactory.close();
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			em.close();
			entityManagerFactory = null;
		}
		
	}
	
}
