
package com.keren.posweb.jaxrs.ifaces;

import com.core.dashboard.DashboardContainer;
import com.keren.posweb.model.PosWebDashboard;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Wed Sep 05 10:52:24 GMT+01:00 2018
 * 
 */
public interface PosWebDashboardRS
    extends GenericService<PosWebDashboard, Long>
{

     @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("posweb/{id}")
    public DashboardContainer dashboard(@Context HttpHeaders headers ,@PathParam("id")Long templateID);
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("website")
    public PosWebDashboard dashboard(@Context HttpHeaders headers);
}
