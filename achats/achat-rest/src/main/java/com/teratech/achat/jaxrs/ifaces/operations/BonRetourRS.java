
package com.teratech.achat.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.BonRetour;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Thu Jan 03 09:08:05 WAT 2019
 * 
 */
public interface BonRetourRS
    extends GenericService<BonRetour, Long>
{

   @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("imprime")
    public List<BonRetour> imprimer(@Context HttpHeaders headers,BonRetour entity);
}
