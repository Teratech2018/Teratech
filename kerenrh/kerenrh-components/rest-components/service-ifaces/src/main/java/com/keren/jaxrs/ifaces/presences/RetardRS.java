
package com.keren.jaxrs.ifaces.presences;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.presences.Absence;
import com.keren.model.presences.Retard;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS

 * @since Mon Apr 23 09:28:01 GMT+01:00 2018
 * 
 */
public interface RetardRS
    extends GenericService<Retard, Long>
{

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("justifier")
    public Retard justifier(@Context HttpHeaders headers,Retard entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("nonjustifier")
    public Retard nonjustifier(@Context HttpHeaders headers,Retard entity);
}
