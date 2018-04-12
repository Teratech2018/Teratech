
package com.keren.jaxrs.ifaces.missions;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.missions.Mission;
import com.keren.model.missions.OrdreMission;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Apr 10 17:59:57 GMT+01:00 2018
 * 
 */
public interface OrdreMissionRS
    extends GenericService<OrdreMission, Long>
{

	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("valide")
    public OrdreMission valide(@Context HttpHeaders headers,OrdreMission entity);
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public OrdreMission annule(@Context HttpHeaders headers,OrdreMission entity);

}
