
package com.kerenedu.reglement;

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
 * @since Fri Aug 24 09:40:04 WAT 2018
 * 
 */
public interface FichePaiementOptionelRS extends GenericService<FichePaiementOptionel, Long> {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("montant")
	public Long getMontant(@Context HttpHeaders headers);
	


}
