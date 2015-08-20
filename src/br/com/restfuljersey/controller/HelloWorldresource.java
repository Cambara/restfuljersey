package br.com.restfuljersey.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;


@Path("/helloworld")
public class HelloWorldresource {
	@GET@Produces("text/plain")
	public String showHelloWorld(){
		return "Olá mundo";
	}
}
