
package com.kerenedu.jaxrs.ifaces.report;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.model.report.ViewPeriodeModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface ViewPeriodeModalRS extends GenericService<ViewPeriodeModal, Long> {
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("pdf")
	public Response buildPdfReport(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("vir")
	public Response virementsalaire(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("cai")
	public Response caissesalaire(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("ret")
	public Response retenuesSalaires(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("pie")
	public Response pieceBancaire(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/pdf")
	public Response buildPdfReportbi(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/vir")
	public Response virementsalairebi(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/cai")
	public Response caissesalairebi(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/ret")
	public Response retenuesSalairesbi(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/pie")
	public Response pieceBancairebi(ViewPeriodeModal entity, @Context HttpHeaders headers);
	
	

}
