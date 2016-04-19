package com.br.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static String PERSISTENCE_UNIT = "projetoPostgres";
	private static  EntityManagerFactory factory = null;
	
	private JPAUtil(){
	}
	
	public static EntityManager getEntityManager(){
		if(factory == null){
			factory = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT);
		}
		return factory.createEntityManager();
	}
}
