package com.webservicedemo.client;

import java.io.IOException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.springframework.util.Assert;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.webservicedemo.model.Navigation;




public class NavigationWSClient {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(JacksonFeature.class);
 
		Client client = ClientBuilder.newClient(clientConfig);
 
		WebTarget webTarget = client
				.target("http://localhost:8181/WebServicePOC/api/navigate/getLocations");
 
		Builder request = webTarget.request(MediaType.APPLICATION_JSON);
 
		Response response = request.get();
		Assert.assertTrue(response.getStatus() == 200);
 
		Navigation navigation = response.readEntity(Navigation.class);
 
		ObjectMapper mapper = new ObjectMapper();
		System.out
				.print("Received podcast from database *************************** "
						+ mapper.writerWithDefaultPrettyPrinter()
								.writeValueAsString(navigation));
	}

}
