
package com.teratech.achat.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.Facture;
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

 * @since Fri Mar 02 08:22:57 GMT+01:00 2018
 * 
 */
public interface FactureRS
    extends GenericService<Facture, Long>
{

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public Facture confirmer(@Context HttpHeaders headers,Facture entity);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("transfert")
    public Facture transfert(@Context HttpHeaders headers,Facture entity);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public Facture annule(@Context HttpHeaders headers,Facture entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({"application/pdf"})
    @Path("imprime")
    public Response imprimer(@Context HttpHeaders headers,Facture entity);
}
