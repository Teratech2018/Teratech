
package com.kerenedu.discipline;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Sat Feb 03 12:30:23 CET 2018
 * 
 */
public interface AbscenceRS
    extends GenericService<Abscence, Long>
{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findeleveclasse")
	public List<LigneAbscence> findeleveclasse(@Context HttpHeaders headers);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("valider")
    public Abscence valider(@Context HttpHeaders headers,Abscence entity);

}
