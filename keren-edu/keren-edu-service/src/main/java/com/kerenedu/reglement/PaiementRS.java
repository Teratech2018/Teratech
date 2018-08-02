
package com.kerenedu.reglement;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Mar 06 16:43:59 CET 2018
 * 
 */
public interface PaiementRS extends GenericService<Paiement, Long> {
	// @POST
	// @Consumes({MediaType.APPLICATION_JSON})
	// @Produces({MediaType.APPLICATION_JSON})
	// @Path("annuler")
	// public Paiement annuler(@Context HttpHeaders headers,Paiement entity);

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("annuler")
	public Paiement annuler(@Context HttpHeaders headers, Paiement dmde);

	@PUT
	@Consumes({ MediaType.APPLICATION_JSON })
	@Produces({ "application/pdf" })
	@Path("facture")
	public Response facture(@Context HttpHeaders headers, Paiement entity);

	@PUT
	@Produces({ "application/pdf" })
	@Path("pdf")
	public Response buildPdfReport(Paiement entity);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("getideleve")
	public List<FichePaiement> getideleve(@Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findfichefraiseleve")
	public List<FichePaiement> findfichefraiseleve(@Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("getremise")
	public List<Remise> getremise(@Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("reduction")
	public Long getReduction(@Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("versement")
	public Long getVersement(@Context HttpHeaders headers);

}
