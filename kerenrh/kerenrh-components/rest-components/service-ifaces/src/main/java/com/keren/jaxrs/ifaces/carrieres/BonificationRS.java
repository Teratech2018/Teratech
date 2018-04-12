
package com.keren.jaxrs.ifaces.carrieres;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.carrieres.Bonification;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface BonificationRS
    extends GenericService<Bonification, Long>
{

	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("valide")
    public Bonification valide(@Context HttpHeaders headers,Bonification entity);
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public Bonification annule(@Context HttpHeaders headers,Bonification entity);

}
