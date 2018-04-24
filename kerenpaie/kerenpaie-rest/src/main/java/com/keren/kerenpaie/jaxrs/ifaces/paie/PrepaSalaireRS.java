
package com.keren.kerenpaie.jaxrs.ifaces.paie;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.PrepaSalaire;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Mar 08 16:41:23 GMT+01:00 2018
 * 
 */
public interface PrepaSalaireRS
    extends GenericService<PrepaSalaire, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({"application/pdf"})
    @Path("brouillard")
    public Response imprimer(@Context HttpHeaders headers,PrepaSalaire dmde);

}
