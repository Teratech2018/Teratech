
package com.keren.courrier.jaxrs.ifaces.courrier;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.courrier.model.courrier.BorderoCourrierR;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS

 * @since Sat Jul 28 11:15:10 GMT+01:00 2018
 * 
 */
public interface BorderoCourrierRRS
    extends GenericService<BorderoCourrierR, Long>
{

     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("accusereception")
    public BorderoCourrierR distribuer(@Context HttpHeaders headers,BorderoCourrierR entity);

}
