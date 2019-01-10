
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

import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.model.report.EdtBulletinModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface EdtBulletinModalRS extends GenericService<EdtBulletinModal, Long> {
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/pdf")
	public Response buildPdfReportbi(EdtBulletinModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("pdf")
	public Response buildPdfReport(EdtBulletinModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("trim")
	public Response buildPdfReportTrim(EdtBulletinModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/trim")
	public Response buildPdfReportTrimBi(EdtBulletinModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("ann")
	public Response buildPdfReportAnn(EdtBulletinModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/ann")
	public Response buildPdfReportAnnBi(EdtBulletinModal entity, @Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("getidclasse")
	public List<InscriptionChoice> getidclasse(@Context HttpHeaders headers);

}
