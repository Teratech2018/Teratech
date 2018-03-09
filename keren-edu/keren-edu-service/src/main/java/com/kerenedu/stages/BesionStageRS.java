
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
 * @since Thu Mar 08 15:07:05 CET 2018
 * 
 */
public interface BesionStageRS
    extends GenericService<BesionStage, Long>
{
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("valide")
    public BesionStage valide(@Context HttpHeaders headers,BesionStage dmde);

}
