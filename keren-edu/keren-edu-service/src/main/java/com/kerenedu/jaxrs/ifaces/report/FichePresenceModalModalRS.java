
package com.kerenedu.jaxrs.ifaces.report;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.model.report.FichePresenceModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface FichePresenceModalModalRS extends GenericService<FichePresenceModal, Long> {
	
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("pdf")
	public Response reportficheprsence(FichePresenceModal entity, @Context HttpHeaders headers);

	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/pdf")
	public Response reportficheprsencebi(FichePresenceModal entity, @Context HttpHeaders headers);
	

	

}
