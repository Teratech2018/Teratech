
package com.kerenedu.reglement;

import javax.ws.rs.Consumes;
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
 * @since Tue Mar 06 16:43:59 CET 2018
 * 
 */
public interface PaiementRS
    extends GenericService<Paiement, Long>
{
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annuler")
    public Paiement annuler(@Context HttpHeaders headers,Paiement entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({"application/pdf"})
    @Path("facture")
    public Response facture(@Context HttpHeaders headers,Paiement entity);
	
	@PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(Paiement entity);

}
