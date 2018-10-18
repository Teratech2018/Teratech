
package com.kerenedu.solde;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Oct 11 16:18:28 WAT 2018
 * 
 */
public interface RemboursementPretRS
    extends GenericService<RemboursementPret, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public RemboursementPret confirme(@Context HttpHeaders headers,RemboursementPret entity);

	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("refuse")
    public RemboursementPret annule(@Context HttpHeaders headers,RemboursementPret entity);


}
