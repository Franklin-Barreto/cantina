package com.santander.cantina.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("cantina");

	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}

}
