
package com.kerenedu.notes;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Fri Apr 13 22:06:46 WAT 2018
 * 
 */
public interface TraitNoteRS
    extends GenericService<TraitNote, Long>

{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findprofclasse")
	public List<CoefMatiereDetail> findprofclasse(@Context HttpHeaders headers);


}
