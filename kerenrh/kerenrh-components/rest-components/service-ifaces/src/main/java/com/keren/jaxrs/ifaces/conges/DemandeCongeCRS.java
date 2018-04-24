
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
import com.keren.model.conges.DemandeCongeR;
import com.keren.model.conges.DemandeCongeV;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 09:30:08 GMT+01:00 2018
 * 
 */
public interface DemandeCongeCRS
    extends GenericService<DemandeCongeC, Long>
{


	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("approuve")
    public DemandeCongeC approuver(@Context HttpHeaders headers,DemandeCongeC dmde);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("rejete")
    public DemandeCongeC rejeter(@Context HttpHeaders headers,DemandeCongeC dmde);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annuler")
    public DemandeCongeC annuler(@Context HttpHeaders headers,DemandeCongeC dmde);
}
