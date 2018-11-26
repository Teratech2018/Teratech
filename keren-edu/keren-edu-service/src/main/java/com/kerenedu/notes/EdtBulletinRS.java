
package com.kerenedu.notes;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.kerenedu.inscription.InscriptionChoice;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
public interface EdtBulletinRS
    extends GenericService<EdtBulletin, Long>
{

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("getidclasse")
	public List<InscriptionChoice> getidclasse(@Context HttpHeaders headers);

}
