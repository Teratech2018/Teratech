
package com.keren.jaxrs.ifaces.presences;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.presences.LignePointage;
import com.keren.model.presences.PointageJouranlier;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
public interface PointageJouranlierRS
    extends GenericService<PointageJouranlier, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public PointageJouranlier confirmer(@Context HttpHeaders headers,PointageJouranlier dmde);

	 @GET
	 @Produces({MediaType.APPLICATION_JSON})
	 @Path("presence")
	 public List<LignePointage> presences(@Context HttpHeaders headers);
}

