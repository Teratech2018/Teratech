
package com.keren.jaxrs.ifaces.formations;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.formations.Formation;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Wed Apr 11 16:28:46 GMT+01:00 2018
 * 
 */
public interface FormationRS
    extends GenericService<Formation, Long>
{

	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("valide")
    public Formation valide(@Context HttpHeaders headers,Formation entity);
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public Formation annule(@Context HttpHeaders headers,Formation entity);


}
