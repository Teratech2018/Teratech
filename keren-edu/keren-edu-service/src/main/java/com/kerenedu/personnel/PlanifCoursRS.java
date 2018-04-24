
package com.kerenedu.personnel;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Wed Jan 31 17:41:20 CET 2018
 * 
 */
public interface PlanifCoursRS
    extends GenericService<PlanifCours, Long>
{
  @GET
  @Produces({MediaType.APPLICATION_JSON})
  @Path("findjourscours")
	public List<JoursCours> findjourscours(@Context HttpHeaders headers);


}
