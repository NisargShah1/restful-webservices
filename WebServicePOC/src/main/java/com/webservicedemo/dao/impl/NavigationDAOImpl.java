package com.webservicedemo.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.webservicedemo.dao.ifc.NavigationDAO;
import com.webservicedemo.model.Navigation;

/**
 * @author NISARG
 *
 */
@Repository("navigationDao")
public class NavigationDAOImpl implements NavigationDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

    
	/* (non-Javadoc)
	 * @see com.infosys.barclays.bli.dao.ifc.NavigationDAO#save(com.wsdemo.model.Navigation)
	 */
	@Override
	public void saveLocation(Navigation location) {
		Session session = this.sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(location);
		tx.commit();
		session.close();
	}

	/* (non-Javadoc)
	 * @see com.infosys.barclays.bli.dao.ifc.NavigationDAO#getLocations()
	 */
	@Override
	public List<Navigation> getLocations() {
		Session session = this.sessionFactory.openSession();
		List<Navigation> navList = session.createQuery("from Person").list();
		session.close();
		return navList;
	}

}
