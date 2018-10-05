
package com.keren.courrier.jaxrs.ifaces.archivage;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.courrier.model.archivage.BorderoLiasse;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Aug 28 09:06:50 WAT 2018
 * 
 */
public interface BorderoLiasseRS
    extends GenericService<BorderoLiasse, Long>
{
	 @PUT
	    @Consumes({MediaType.APPLICATION_JSON})
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("distribuer")
	    public BorderoLiasse distribuer(@Context HttpHeaders headers,BorderoLiasse entity);

}
