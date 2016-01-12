package br.com.restfuljersey.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

import br.com.restfuljersey.model.bean.Banda;


@Path("/bandas")
public class BandaResource {
	static private Map<Integer,Banda> bandasMap;
	static {
		bandasMap = new HashMap<Integer, Banda>();
		
		Banda b1 = new Banda();
		b1.setId(1);
		b1.setName("Led Zeppelin"); 
		b1.setAnoDeFormacao(1968); 
		
		bandasMap.put(b1.getId(), b1);
		
		Banda b2 = new Banda();
		b2.setId(2);
		b2.setName("Pink Floyd"); 
		b2.setAnoDeFormacao(1965); 
		
		bandasMap.put(b2.getId(), b2);
	}
	@Path("{id}")
	@GET
	@Produces("application/json")
	public Banda getBanda(@PathParam("id")int id){
		Banda banda = bandasMap.get(id);
		if(banda == null){
			ResponseBuilder builder = Response.status(Response.Status.NOT_FOUND);
		    builder.entity("{\"error\":\"not_found\"}");
		    Response response = builder.build();
		    throw new WebApplicationException(response);
		}
		return banda;
		
	}
	@GET
	@Produces("application/json")
	public List<Banda> getBandas(){
		return new ArrayList<Banda>(bandasMap.values());
	}
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public String adicionaBanda(Banda banda){
		banda.setId(bandasMap.size() + 1); 
		bandasMap.put(banda.getId(),banda);
		return banda.getName() + "adicionado";
	}
	@Path("{id}") 
	@PUT 
	@Consumes("application/json") 
	@Produces("application/json") 
	public String atualizaBanda(Banda banda, @PathParam("id") int id) {
		Banda atual = bandasMap.get(id); atual.setName(banda.getName());
		atual.setAnoDeFormacao(banda.getAnoDeFormacao()); 
		return banda.getName() + " atualizada."; 
	}  
	@Path("{id}") 
	@DELETE @Produces("application/json") 
	public String removeBanda(@PathParam("id") int id) { 
		bandasMap.remove(id); 
		return "Banda removida."; 
	}
	
}
