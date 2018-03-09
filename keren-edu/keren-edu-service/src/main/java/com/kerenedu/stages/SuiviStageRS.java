
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
 * @since Fri Mar 09 15:56:31 CET 2018
 * 
 */
public interface SuiviStageRS
    extends GenericService<SuiviStage, Long>
{
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public SuiviStage confirmer(@Context HttpHeaders headers,SuiviStage dmde);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("terminer")
    public SuiviStage terminer(@Context HttpHeaders headers,SuiviStage dmde);

}
