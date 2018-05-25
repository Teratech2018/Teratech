
package com.keren.kerenpaie.jaxrs.ifaces.rapports;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.keren.kerenpaie.model.rapports.ViewDipePaie;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Interface du service JAX-RS

 * @since Thu Apr 19 10:00:59 WAT 2018
 * 
 */
public interface ViewDipePaieRS
    extends GenericService<ViewDipePaie, Long>
{
	
	@GET
	@Produces({"text/plain" })
	@Path("builddipemagnetique")
	public Response buildDipeMagnetique(@Context HttpHeaders headers);

}
