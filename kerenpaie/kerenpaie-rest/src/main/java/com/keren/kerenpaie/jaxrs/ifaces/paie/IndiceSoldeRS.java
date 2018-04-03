
package com.keren.kerenpaie.jaxrs.ifaces.paie;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.kerenpaie.model.paie.IndiceSolde;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Fri Mar 30 15:55:03 GMT+01:00 2018
 * 
 */
public interface IndiceSoldeRS
    extends GenericService<IndiceSolde, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("actif")
    public IndiceSolde actif(@Context HttpHeaders headers,IndiceSolde entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("inactif")
    public IndiceSolde inactif(@Context HttpHeaders headers,IndiceSolde entity);	
	

}
