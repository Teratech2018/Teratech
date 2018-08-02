
package com.kerenedu.configuration;

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
 * @since Tue Jan 09 15:21:43 WAT 2018
 * 
 */
public interface ServiceRS
    extends GenericService<Service, Long>
{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findfiliere")
	public List<ServiceFilliere> findfiliere(@Context HttpHeaders headers);

}
