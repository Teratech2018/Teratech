
package com.kerenedu.jaxrs.ifaces.report;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.EdtBulletinModal;
import com.kerenedu.model.report.EleveInscritSearch;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface EleveInscritSearchRS extends GenericService<EleveInscritSearch, Long> {
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("pdf")
	public Response buildPdfReport(EleveInscritSearch entity, @Context HttpHeaders headers);



}
