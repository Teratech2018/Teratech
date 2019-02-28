
package com.kerenedu.personnel;

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
 * @since Tue Jan 30 12:13:16 CET 2018
 * 
 */
public interface ProfesseurRS
    extends GenericService<Professeur, Long>
{
	

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("desactiver")
    public Professeur desactiver(@Context HttpHeaders headers,Professeur entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("activer")
    public Professeur activer(@Context HttpHeaders headers,Professeur entity);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("attestation")
	public Response attestationReport(Professeur entity);
	
	@PUT
	@Produces({ "application/pdf" })
	@Path("bi/attestation")
	public Response attestationReportbi(Professeur entity);


}
