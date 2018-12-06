
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
 * @since Mon Sep 10 15:39:11 WAT 2018
 * 
 */
public interface RubriquePaieRS
    extends GenericService<RubriquePaie, Long>
{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("generatecategorie")
	public List<ForfaitCategorie> generatecategorie(@Context HttpHeaders headers);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("generatecycle")
	public List<ForfaitCycle> generatecycle(@Context HttpHeaders headers);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("generatepersonnel")
	public List<ForfaitPersonnel> generatepersonnel(@Context HttpHeaders headers);


}
