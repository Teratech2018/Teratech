
package com.keren.jaxrs.ifaces.presences;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.presences.LignePointage;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 14:18:53 GMT+01:00 2018
 * 
 */
public interface LignePointageRS
    extends GenericService<LignePointage, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("justifier")
    public LignePointage justifier(@Context HttpHeaders headers,LignePointage dmde);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("nonjustifier")
    public LignePointage nonjustifier(@Context HttpHeaders headers,LignePointage dmde);
}
