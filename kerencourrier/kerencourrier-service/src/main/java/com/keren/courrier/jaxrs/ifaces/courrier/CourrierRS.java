
package com.keren.courrier.jaxrs.ifaces.courrier;

import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.ServiceDiffusion;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

import java.util.Date;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Wed Jul 18 10:58:43 GMT+01:00 2018
 * 
 */
public interface CourrierRS
    extends GenericService<Courrier, Long>
{

     @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("datelimite")
    public String getDateLimite(@Context HttpHeaders headers);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("diffusionlist")
    public List<LigneDiffusion> getdiffusionList(@Context HttpHeaders headers);

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("diffusionservices")
    public List<ServiceDiffusion> getdiffusionServices(@Context HttpHeaders headers);
    
    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("distribuer")
    public Courrier distribuer(@Context HttpHeaders headers,Courrier entity);
    
    public List<Courrier> findCourrierByDate(Date p$date);
}
