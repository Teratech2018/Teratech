
package com.kerenedu.notes;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Feb 13 10:56:15 CET 2018
 * 
 */
public interface CoefMatiereRS extends GenericService<CoefMatiere, Long> {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findmatierclasse")
	public List<CoefMatiereDetail> findmatierclasse(@Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("setid")
	public List<CoefMatiereDetail> setid(@Context HttpHeaders headers);

}
