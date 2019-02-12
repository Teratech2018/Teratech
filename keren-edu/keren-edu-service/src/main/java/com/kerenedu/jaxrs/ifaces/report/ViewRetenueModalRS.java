
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
import com.kerenedu.model.report.ViewRetenueModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface ViewRetenueModalRS extends GenericService<ViewRetenueModal, Long> {
	
	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("ret")
	public Response retenuesSalaires(ViewRetenueModal entity, @Context HttpHeaders headers);

	
	@PUT
	@Produces({ "application/pdf" })
	@Consumes({MediaType.APPLICATION_JSON})
	@Path("bi/ret")
	public Response retenuesSalairesbi(ViewRetenueModal entity, @Context HttpHeaders headers);
	

	

}
