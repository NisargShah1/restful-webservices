package com.webservicedemo.aspect;

import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.webservicedemo.exception.RestWSException;
import com.webservicedemo.fault.Fault;


/**
 * @author NISARG
 *
 */
@Component
public class FaultAspect {
	
	/**
	 * @param exception
	 * @return
	 */
	public Response catchingException(Exception exception){
	
		exception.printStackTrace();
	
		int statusCode = Response.Status.BAD_REQUEST.getStatusCode();
		String statusMessage = "Exception Occured in server : "+exception;
		
		if(exception instanceof RestWSException){
			RestWSException rsException = (RestWSException) exception;
			statusMessage = rsException.getCustomMsg();
		}
		
		//Building Fault Object
		Fault fault = new Fault();
		fault.setCode(Integer.toString(statusCode));
		fault.setSuccessFlag(false);
		fault.setMessage(statusMessage);
		
		return Response.status(statusCode).entity(fault).build();
	}
}
