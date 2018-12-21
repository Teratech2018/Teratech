
package com.core.templates;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Thu Dec 06 11:57:28 WAT 2018
 * 
 */
public interface TemplateRS
    extends GenericService<Template, Long>
{

    @GET
     @Produces({MediaType.APPLICATION_JSON})
     @Path("template/{name}")
     public Template getTemplate(@Context HttpHeaders headers , @PathParam("name") String name );
}
