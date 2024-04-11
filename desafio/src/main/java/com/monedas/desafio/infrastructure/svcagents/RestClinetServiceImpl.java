package com.monedas.desafio.infrastructure.svcagents;



import javax.ws.rs.core.Response;

import org.jboss.resteasy.client.jaxrs.ResteasyClient;
import org.jboss.resteasy.client.jaxrs.ResteasyClientBuilder;
import org.jboss.resteasy.client.jaxrs.ResteasyWebTarget;
import org.springframework.stereotype.Service;


@Service
public class RestClinetServiceImpl implements RestClientService {

	String baseUri = "https://open.er-api.com/v6/latest/";

	public String ChangeTypeCurrency(String type) {
		String value = null;
		String Url =null;
		try {
			Url = baseUri + type;
			ResteasyClient client = new ResteasyClientBuilder().build();
			ResteasyWebTarget target = client.target(Url);
			Response response = target.request().get();
			value = response.readEntity(String.class);
			System.out.println(value);
			response.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		// Setting URL

		return value;

	}

}
