
package com.keren.courrier.jaxrs.ifaces.dashbord;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.core.dashboard.DashboardContainer;
import com.keren.courrier.model.dashbord.ArchiveDashboard;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Mon Sep 03 12:16:16 WAT 2018
 * 
 */
public interface ArchiveDashboardRS
    extends GenericService<ArchiveDashboard, Long>
{

	 @GET
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("acceuil/{id}")
	    public DashboardContainer dashboard(@Context HttpHeaders headers ,@PathParam("id")Long templateID);
	    
	    @GET
	    @Produces({MediaType.APPLICATION_JSON})
	    @Path("corbeille")
	    public ArchiveDashboard corbeille(@Context HttpHeaders headers);
}
