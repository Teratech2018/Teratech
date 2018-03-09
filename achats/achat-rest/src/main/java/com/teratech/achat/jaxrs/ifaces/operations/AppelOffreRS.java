
package com.teratech.achat.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.achat.model.operations.AppelOffre;
import com.teratech.achat.model.operations.BonCommande;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Tue Feb 27 14:29:40 GMT+01:00 2018
 * 
 */
public interface AppelOffreRS
    extends GenericService<AppelOffre, Long>
{

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public AppelOffre confirmer(@Context HttpHeaders headers,AppelOffre entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("selection")
    public AppelOffre selectionner(@Context HttpHeaders headers,AppelOffre entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public AppelOffre annuler(@Context HttpHeaders headers,AppelOffre entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("termine")
    public AppelOffre termine(@Context HttpHeaders headers,AppelOffre entity);
}
