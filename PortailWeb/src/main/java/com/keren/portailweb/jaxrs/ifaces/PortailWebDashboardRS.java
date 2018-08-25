
package com.keren.portailweb.jaxrs.ifaces;

import com.core.dashboard.DashboardContainer;
import com.keren.portailweb.model.PortailWebDashboard;
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

 * @since Sat Aug 25 07:54:03 GMT+01:00 2018
 * 
 */
public interface PortailWebDashboardRS
    extends GenericService<PortailWebDashboard, Long>
{

   @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("portailweb/{id}")
    public DashboardContainer dashboard(@Context HttpHeaders headers ,@PathParam("id")Long templateID);
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("website")
    public PortailWebDashboard dashboard(@Context HttpHeaders headers);
}
