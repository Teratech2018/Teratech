
package com.keren.jaxrs.ifaces.recrutement;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.recrutement.AffectationCandidat;
import com.keren.model.recrutement.BesionRecrutement;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Wed Apr 11 11:31:28 GMT+01:00 2018
 * 
 */
public interface AffectationCandidatRS
    extends GenericService<AffectationCandidat, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("valide")
    public AffectationCandidat valide(@Context HttpHeaders headers,AffectationCandidat entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("rejete")
    public AffectationCandidat annule(@Context HttpHeaders headers,AffectationCandidat entity);

}
