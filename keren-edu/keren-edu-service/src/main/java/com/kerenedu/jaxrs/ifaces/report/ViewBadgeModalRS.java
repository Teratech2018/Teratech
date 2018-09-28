
package com.kerenedu.jaxrs.ifaces.report;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.model.report.ViewBadgeModal;
import com.kerenedu.notes.CoefMatiereDetail;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface ViewBadgeModalRS
    extends GenericService<ViewBadgeModal, Long>
{
	@PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(ViewBadgeModal entity);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("setid")
	public List<CoefMatiereDetail> setid(@Context HttpHeaders headers);




}
