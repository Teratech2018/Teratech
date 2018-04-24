
package com.keren.jaxrs.ifaces.presences;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.presences.FichePointage;
import com.keren.model.presences.LigneFichePointage;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 13:18:47 GMT+01:00 2018
 * 
 */
public interface FichePointageRS
    extends GenericService<FichePointage, Long>
{

	  @GET
	  @Produces({MediaType.APPLICATION_JSON})
	  @Path("presence")
	  public List<LigneFichePointage> presences(@Context HttpHeaders headers);

}
