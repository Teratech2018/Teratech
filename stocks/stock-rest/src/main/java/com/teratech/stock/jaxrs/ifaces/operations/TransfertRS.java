
package com.teratech.stock.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.stock.model.operations.Sortie;
import com.teratech.stock.model.operations.Transfert;
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

 * @since Tue Feb 20 15:00:50 GMT+01:00 2018
 * 
 */
public interface TransfertRS
    extends GenericService<Transfert, Long>
{

   @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("imprime")
    public List<Transfert> imprime(@Context HttpHeaders headers,Transfert object);
}
