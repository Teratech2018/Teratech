
package com.kerenedu.inscription;

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

import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.reglement.FichePaiementOptionel;
import com.kerenedu.reglement.Paiement;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
public interface InscriptionRS extends GenericService<Inscription, Long>

{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("inscrit")
	public List<Inscription> getEtudiantsInscrits(@Context HttpHeaders headers);

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findserviceclasse")
	public List<FichePaiement> findmatierclasse(@Context HttpHeaders headers);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("pdf")
	public Response buildPdfReport(Inscription entity);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("fiche")
	public Response ficheInscriptionReport(Inscription entity);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("pdfins")
	public Response listInscritRepoort(Inscription entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("changer")
    public Inscription changer(@Context HttpHeaders headers,Inscription dmde);


}
