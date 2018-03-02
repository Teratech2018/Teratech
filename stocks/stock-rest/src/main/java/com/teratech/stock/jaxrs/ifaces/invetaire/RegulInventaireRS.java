
package com.teratech.stock.jaxrs.ifaces.invetaire;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.stock.model.invetaire.RegulInventaire;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


/**
 * Interface du service JAX-RS

 * @since Tue Feb 20 19:29:43 GMT+01:00 2018
 * 
 */
public interface RegulInventaireRS
    extends GenericService<RegulInventaire, Long>
{

   @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public RegulInventaire confirmer(@Context HttpHeaders headers,RegulInventaire dmde);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({"application/pdf"})
    @Path("print")
    public Response print(@Context HttpHeaders headers,RegulInventaire dmde);
}
