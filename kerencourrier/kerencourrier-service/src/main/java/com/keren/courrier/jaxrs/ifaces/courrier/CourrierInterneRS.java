
package com.keren.courrier.jaxrs.ifaces.courrier;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.courrier.model.courrier.CourrierInterne;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS

 * @since Wed Jul 18 13:37:32 GMT+01:00 2018
 * 
 */
public interface CourrierInterneRS
    extends GenericService<CourrierInterne, Long>
{

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("datelimite")
    public String getDateLimite(@Context HttpHeaders headers);
    
    
  
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("distribuer")
    public CourrierInterne distribuer(@Context HttpHeaders headers,CourrierInterne entity);

}
