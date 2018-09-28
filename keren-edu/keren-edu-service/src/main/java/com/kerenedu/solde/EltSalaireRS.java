
package com.kerenedu.solde;

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
 * @since Fri Sep 14 16:06:52 WAT 2018
 * 
 */
public interface EltSalaireRS extends GenericService<EltSalaire, Long> {
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findpersonnel")
	public List<EltSalaireLigne> findpersonnel(@Context HttpHeaders headers);

}
