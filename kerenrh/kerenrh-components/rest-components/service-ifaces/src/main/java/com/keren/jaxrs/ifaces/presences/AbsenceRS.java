
package com.keren.jaxrs.ifaces.presences;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.model.presences.Absence;
import com.keren.model.presences.LignePointage;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Sun Apr 22 11:44:27 GMT+01:00 2018
 * 
 */
public interface AbsenceRS
    extends GenericService<Absence, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("justifier")
    public Absence justifier(@Context HttpHeaders headers,Absence dmde);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("nonjustifier")
    public Absence nonjustifier(@Context HttpHeaders headers,Absence dmde);

}
