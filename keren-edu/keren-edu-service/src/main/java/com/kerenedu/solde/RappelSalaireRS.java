
package com.kerenedu.solde;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Mon Oct 15 16:04:46 WAT 2018
 * 
 */
public interface RappelSalaireRS
    extends GenericService<RappelSalaire, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("engage")
    public RappelSalaire confirme(@Context HttpHeaders headers,RappelSalaire entity);
}
