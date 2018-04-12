
package com.keren.jaxrs.ifaces.recrutement;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.recrutement.ContratTravail;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
public interface ContratTravailRS
    extends GenericService<ContratTravail, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("cloture")
    public ContratTravail cloture(@Context HttpHeaders headers,ContratTravail entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("demarrer")
    public ContratTravail demarrer(@Context HttpHeaders headers,ContratTravail entity);

}
