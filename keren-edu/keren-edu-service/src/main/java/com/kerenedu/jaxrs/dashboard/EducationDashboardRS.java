
package com.kerenedu.jaxrs.dashboard;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.core.dashboard.DashboardContainer;
import com.kerenedu.dashboard.EducationDashboard;

/**
 * Interface du service JAX-RS
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
public interface EducationDashboardRS{
	
	
@GET
@Produces({MediaType.APPLICATION_JSON})
@Path("solde/{id}")
public DashboardContainer dashboard(@Context HttpHeaders headers ,@PathParam("id")Long templateID);


@GET
@Produces({MediaType.APPLICATION_JSON})
@Path("liens")
public EducationDashboard liens(@Context HttpHeaders headers) ;

}
