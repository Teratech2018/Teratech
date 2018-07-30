
package com.keren.courrier.jaxrs.ifaces.dashbord;

import com.core.dashboard.DashboardContainer;
import com.keren.courrier.model.dashbord.CourrierDashboard;
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

 * @since Thu Jul 19 13:57:24 GMT+01:00 2018
 * 
 */
public interface CourrierDashboardRS
    extends GenericService<CourrierDashboard, Long>
{

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("acceuil/{id}")
    public DashboardContainer dashboard(@Context HttpHeaders headers ,@PathParam("id")Long templateID);
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("corbeille")
    public CourrierDashboard corbeille(@Context HttpHeaders headers);

}
