
package com.keren.jaxrs.ifaces.conges;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.conges.DemandeConge;
import com.keren.model.conges.DemandeCongeC;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 09:30:08 GMT+01:00 2018
 * 
 */
public interface DemandeCongeRS
    extends GenericService<DemandeConge, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public DemandeConge confirmer(@Context HttpHeaders headers,DemandeConge dmde);

}
