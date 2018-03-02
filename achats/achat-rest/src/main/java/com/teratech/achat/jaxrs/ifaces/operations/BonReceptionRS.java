
package com.teratech.achat.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.BonReception;
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

 * @since Wed Feb 28 21:40:29 GMT+01:00 2018
 * 
 */
public interface BonReceptionRS
    extends GenericService<BonReception, Long>
{

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public BonReception confirmer(@Context HttpHeaders headers,BonReception entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("rejete")
    public BonReception rejeter(@Context HttpHeaders headers,BonReception entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("transfere")
    public BonReception transferer(@Context HttpHeaders headers,BonReception entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public BonReception annuler(@Context HttpHeaders headers,BonReception entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("facture")
    public Facture facture(@Context HttpHeaders headers,BonReception entity);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({"application/pdf"})
    @Path("imprime")
    public Response imprimer(@Context HttpHeaders headers,BonReception dmde);
}
