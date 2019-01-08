
package com.teratech.vente.jaxrs.ifaces.operations;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.vente.model.operations.Devis;
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

 * @since Fri Jan 04 10:14:00 WAT 2019
 * 
 */
public interface DevisRS
    extends GenericService<Devis, Long>
{
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("imprime")
    public List<Devis> imprimer(@Context HttpHeaders headers,Devis entity);

     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("accepte")
    public Devis accepte(@Context HttpHeaders headers,Devis entity);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("refuse")
    public Devis refuse(@Context HttpHeaders headers,Devis entity);
    
     @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public Devis annule(@Context HttpHeaders headers,Devis entity);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("termine")
    public Devis termine(@Context HttpHeaders headers,Devis entity);
}
