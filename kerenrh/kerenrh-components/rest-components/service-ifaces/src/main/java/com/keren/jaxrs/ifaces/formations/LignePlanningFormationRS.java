
package com.keren.jaxrs.ifaces.formations;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.formations.DemandeFormation;
import com.keren.model.formations.LignePlanningFormation;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Apr 10 13:14:14 GMT+01:00 2018
 * 
 */
public interface LignePlanningFormationRS
    extends GenericService<LignePlanningFormation, Long>
{

	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("demarre")
    public LignePlanningFormation demarrer(@Context HttpHeaders headers,LignePlanningFormation entity);
	

}