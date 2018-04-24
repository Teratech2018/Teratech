
package com.kerenedu.stages;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Mar 08 21:14:59 CET 2018
 * 
 */
public interface StageRS
    extends GenericService<Stage, Long>
{
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirmer")
    public Stage confirmer(@Context HttpHeaders headers,Stage dmde);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("terminer")
    public Stage terminer(@Context HttpHeaders headers,Stage dmde);


}
