
package com.kerenedu.notes;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.discipline.LigneAbscence;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 10:23:11 CET 2018
 * 
 */
public interface MatiereNoteRS
    extends GenericService<MatiereNote, Long>
{
	@PUT
	@Produces({ "application/pdf" })
	@Path("pdf")
	public Response ficheNoteReport(MatiereNote entity);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("note")
	public Response fichesNoteReport(MatiereNote entity);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findeleveclasse")
	public List<NoteDetail> findeleveclasse(@Context HttpHeaders headers);

}
