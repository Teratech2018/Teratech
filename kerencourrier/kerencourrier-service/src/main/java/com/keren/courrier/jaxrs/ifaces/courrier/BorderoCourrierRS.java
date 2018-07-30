
package com.keren.courrier.jaxrs.ifaces.courrier;

import com.keren.courrier.model.courrier.BorderoCourrier;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Wed Jul 25 20:10:34 GMT+01:00 2018
 * 
 */
public interface BorderoCourrierRS
    extends GenericService<BorderoCourrier, Long>
{

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("distribuer")
    public BorderoCourrier distribuer(@Context HttpHeaders headers,BorderoCourrier entity);

}
