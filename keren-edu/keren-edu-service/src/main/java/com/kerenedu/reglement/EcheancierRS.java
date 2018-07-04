
package com.kerenedu.reglement;

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
 * @since Tue Mar 06 16:43:59 CET 2018
 * 
 */
public interface EcheancierRS
    extends GenericService<Echeancier, Long>
{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("generateecheance")
	public List<EcheancierDlt> generateecheance(@Context HttpHeaders headers);


}
