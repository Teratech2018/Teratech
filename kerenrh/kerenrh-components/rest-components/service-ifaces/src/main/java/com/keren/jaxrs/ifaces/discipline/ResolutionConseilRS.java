
package com.keren.jaxrs.ifaces.discipline;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.discipline.LigneResolution;
import com.keren.model.discipline.ResolutionConseil;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Fri Feb 16 11:11:48 GMT+01:00 2018
 * 
 */
public interface ResolutionConseilRS
    extends GenericService<ResolutionConseil, Long>
{

	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("demande")
	List<LigneResolution> resolutions(@Context HttpHeaders headers);

}
