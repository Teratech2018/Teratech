
package com.kerenedu.personnel;

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
 * @since Fri Mar 02 21:06:16 CET 2018
 * 
 */
public interface EmargementProfRS extends GenericService<EmargementProf, Long> {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findprofclasse")
	public List<Professeur> findprofclasse(@Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findmatiereprof")
	public List<EmargementProfDetails> findmatiereprof(@Context HttpHeaders headers);

}
