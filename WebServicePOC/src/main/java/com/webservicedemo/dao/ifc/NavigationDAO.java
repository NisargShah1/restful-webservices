package com.webservicedemo.dao.ifc;

import java.util.List;

import com.webservicedemo.model.Navigation;

/**
 * @author NISARG
 *
 */
public interface NavigationDAO {

	/**
	 * @param location
	 */
	public void saveLocation(Navigation location);
	
	/**
	 * @return
	 */
	public List<Navigation> getLocations();
	
}
