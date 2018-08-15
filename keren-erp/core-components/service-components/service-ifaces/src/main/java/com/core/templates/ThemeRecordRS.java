
package com.core.templates;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Mon Aug 06 16:38:13 GMT+01:00 2018
 * 
 */
public interface ThemeRecordRS
    extends GenericService<ThemeRecord, Long>
{

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("theme")
    public ThemeRecord getApplicationTheme();

}
