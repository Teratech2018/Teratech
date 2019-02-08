
package com.kerenedu.solde;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.inscription.Inscription;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Oct 11 16:18:28 WAT 2018
 * 
 */
public interface DemandePretRS
    extends GenericService<DemandePret, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("echeancier")
    public DemandePret generereglements(@Context HttpHeaders headers,DemandePret entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("confirme")
    public DemandePret confirme(@Context HttpHeaders headers,DemandePret entity);

	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public DemandePret annule(@Context HttpHeaders headers,DemandePret entity);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("pdf")
	public Response buildPdfReport(DemandePret entity);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("bi/pdf")
	public Response buildPdfReportbi(DemandePret entity);

}
