package org.arrow.micro.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbsHibernateSession {
	@Autowired
	protected SessionFactory sessionFactory;
  
}
