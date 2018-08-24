
package com.core.website;

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

 * @since Wed Aug 22 13:33:15 GMT+01:00 2018
 * 
 */
public interface WebSiteModuleRS
    extends GenericService<WebSiteModule, Long>
{

     @GET
     @Produces({MediaType.APPLICATION_JSON})
     @Path("indexpage/{website}")
     public WebSiteComponent getWebSiteIndex(@Context HttpHeaders headers , @PathParam("website") String website );
     
     @GET
     @Produces({MediaType.APPLICATION_JSON})
     @Path("fragment/{website}/{id}")
     public WebSiteComponent getWebSiteTemplate(@Context HttpHeaders headers , @PathParam("website") String website, @PathParam("id") String fragment );
}
