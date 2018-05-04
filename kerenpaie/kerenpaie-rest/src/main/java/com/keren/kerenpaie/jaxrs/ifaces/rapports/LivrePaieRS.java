
package com.keren.kerenpaie.jaxrs.ifaces.rapports;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.keren.kerenpaie.model.rapports.LivrePaie;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

/**
 * Interface du service JAX-RS
 * 
 * @since Fri Apr 06 09:41:44 WAT 2018
 * 
 */
public interface LivrePaieRS extends GenericService<LivrePaie, Long> {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("meta")
	public MetaData getMetaData();


	@PUT
	@Produces({ "application/pdf" })
	@Path("buildlivrepaie")
	public Response buildLivrePaie(LivrePaie livre);
}
