
package com.keren.kerenpaie.jaxrs.ifaces.paie;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface BulletinPaieRS
    extends GenericService<BulletinPaie, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("calculer")
    public BulletinPaie calculer(@Context HttpHeaders headers,BulletinPaie entity);

}
