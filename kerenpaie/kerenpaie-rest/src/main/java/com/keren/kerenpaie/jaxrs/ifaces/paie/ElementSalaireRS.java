
package com.keren.kerenpaie.jaxrs.ifaces.paie;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.kerenpaie.model.paie.ElementSalaire;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Fri Mar 23 14:48:54 GMT+01:00 2018
 * 
 */
public interface ElementSalaireRS
    extends GenericService<ElementSalaire, Long>
{
   
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("active")
    public ElementSalaire actif(@Context HttpHeaders headers,ElementSalaire entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("inactive")
    public ElementSalaire inactif(@Context HttpHeaders headers,ElementSalaire entity);

}
