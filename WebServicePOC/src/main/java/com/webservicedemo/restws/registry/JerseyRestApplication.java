/**
 * @author {Nisarg Shah}
 * 21-Jun-2015
 * com.infosys.barclays.bli.restws.registry JerseyRestApplication.java
 */
package com.webservicedemo.restws.registry;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.spring.scope.RequestContextFilter;

import com.webservicedemo.aspect.FaultAspect;
import com.webservicedemo.restws.ws.NavigationWs;

/**
 * Jersey Restful Services configuration
 * @author NISARG
 *
 */
public class JerseyRestApplication extends ResourceConfig
{
	
	/**
	 * Register JAX-RS application components.
	 */
	public JerseyRestApplication(){
		register(NavigationWs.class);
	}
}
