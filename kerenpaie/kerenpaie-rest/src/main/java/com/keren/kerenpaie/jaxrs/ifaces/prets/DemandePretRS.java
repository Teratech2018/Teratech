
package com.keren.kerenpaie.jaxrs.ifaces.prets;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.kerenpaie.model.prets.AvanceSalaire;
import com.keren.kerenpaie.model.prets.DemandePret;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Mar 13 13:15:47 GMT+01:00 2018
 * 
 */
public interface DemandePretRS
    extends GenericService<DemandePret, Long>
{

	  
		@PUT
	    @Consumes({MediaType.APPLICATION_JSON})
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("echeancier")
	    public DemandePret generereglements(@Context HttpHeaders headers,DemandePret entity);
		
		@PUT
	    @Consumes({MediaType.APPLICATION_JSON})
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("confirme")
	    public DemandePret confirme(@Context HttpHeaders headers,DemandePret entity);

		
		@PUT
	    @Consumes({MediaType.APPLICATION_JSON})
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("annule")
	    public DemandePret annule(@Context HttpHeaders headers,DemandePret entity);


}
