package com.webservicedemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webservicedemo.dao.ifc.NavigationDAO;
import com.webservicedemo.model.Navigation;
import com.webservicedemo.service.ifc.NavigationService;

/**
 * @author NISARG
 *
 */
@Service("navigationService")
public class NavigationServiceImpl implements NavigationService{
	
	
	/**
	 * 
	 */
	@Autowired
	private NavigationDAO navigationDao;

	/* (non-Javadoc)
	 * @see com.wsdemo.service.ifc.NavigationService#getLocations()
	 */
	@Override
	public List<Navigation> getLocations() {
		return navigationDao.getLocations();
	}

	/* (non-Javadoc)
	 * @see com.wsdemo.service.ifc.NavigationService#saveLocation(com.wsdemo.model.Navigation)
	 */
	@Override
	public String saveLocation(Navigation location) {
		navigationDao.saveLocation(location);
		return "success";
	}

}
