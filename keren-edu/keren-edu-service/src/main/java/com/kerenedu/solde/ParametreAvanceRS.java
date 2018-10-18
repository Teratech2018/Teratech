
package com.kerenedu.solde;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Oct 11 12:40:08 WAT 2018
 * 
 */
public interface ParametreAvanceRS
    extends GenericService<ParametreAvance, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("actif")
    public ParametreAvance actif(@Context HttpHeaders headers,ParametreAvance entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("inactif")
    public ParametreAvance inactif(@Context HttpHeaders headers,ParametreAvance entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("genere")
    public ParametreAvance genere(@Context HttpHeaders headers,ParametreAvance entity);
}
