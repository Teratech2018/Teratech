
package com.core.langues;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import java.util.Map;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Tue May 08 12:34:37 GMT+01:00 2018
 * 
 */
public interface TermeRS
    extends GenericService<Terme, Long>
{
   @GET
   @Produces({MediaType.APPLICATION_JSON})
   @Path("traduction")
   public Map<String,String> loadTraduction(@Context HttpHeaders headers);

}
