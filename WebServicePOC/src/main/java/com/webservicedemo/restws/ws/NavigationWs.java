package com.webservicedemo.restws.ws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webservicedemo.aspect.FaultAspect;
import com.webservicedemo.model.Navigation;
import com.webservicedemo.service.ifc.NavigationService;

/**
 * @author NISARG
 *
 */
@Component
@Path("/navigation")
public class NavigationWs{

	/**
	 * 
	 */
	@Autowired
	private NavigationService navigationService;

	/**
	 * 
	 */
	@Autowired
	private FaultAspect faultAspect;

	/**
	 * @return
	 */
	@GET
	@Path("getLocations")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLocations(){
		Response response;
		try{
			List<Navigation> locations = navigationService.getLocations();
			response = Response.ok(locations).build();
		}catch(Exception ex){
			response = faultAspect.catchingException(ex);
		}
		return response;
	}

	/**
	 * @param location
	 */
	@POST
	@Path("/saveLocations")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response saveLocation(Navigation location) {
		Response response;
		try{
			String status = navigationService.saveLocation(location);
			return Response.ok(status).build();
		}catch(Exception ex){
			response = faultAspect.catchingException(ex);
		}
		return response;
	}
}
