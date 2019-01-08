
package com.teratech.achat.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.achat.model.operations.ReponseFournisseur;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Sat Dec 22 14:01:06 WAT 2018
 * 
 */
public interface ReponseFournisseurRS
    extends GenericService<ReponseFournisseur, Long>
{

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("imprime")
    public ReponseFournisseur imprimer(@Context HttpHeaders headers,ReponseFournisseur dmde);
}
