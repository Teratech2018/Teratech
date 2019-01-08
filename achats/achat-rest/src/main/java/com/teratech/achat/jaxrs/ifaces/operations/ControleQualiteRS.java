
package com.teratech.achat.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.achat.model.operations.ControleQualite;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Sat Feb 24 14:57:22 WAT 2018
 * 
 */
public interface ControleQualiteRS
    extends GenericService<ControleQualite, Long>
{

     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("traiter")
    public ControleQualite traiter(@Context HttpHeaders headers,ControleQualite entity);

}
