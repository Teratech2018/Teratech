
package com.kerenedu.jaxrs.ifaces.report;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.kerenedu.model.report.ViewEmargement;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Mon Jul 23 15:41:27 WAT 2018
 * 
 */
public interface ViewEmargementRS
    extends GenericService<ViewEmargement, Long>
{

	@PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(ViewEmargement entity);
	

	@PUT
    @Produces({"application/pdf"})
    @Path("planning")
    public Response buildPdfReportplanning(ViewEmargement entity);

}
