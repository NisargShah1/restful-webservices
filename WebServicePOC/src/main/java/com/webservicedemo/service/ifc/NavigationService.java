package com.webservicedemo.service.ifc;

import java.util.List;

import com.webservicedemo.model.Navigation;

/**
 * @author NISARG
 *
 */
public interface NavigationService {

	/**
	 * @return
	 */
	public List<Navigation> getLocations();

	/**
	 * @param location
	 * @return
	 */
	public String saveLocation(Navigation location);

}
