
package com.kerenedu.jaxrs.ifaces.report;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.kerenedu.model.report.ViewBilanFinancierEcoleModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
public interface ViewBilanFinancierEcoleModalRS
    extends GenericService<ViewBilanFinancierEcoleModal, Long>
{
	@PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(ViewBilanFinancierEcoleModal entity);
	
	@PUT
    @Produces({"application/pdf"})
    @Path("bi/pdf")
    public Response buildPdfReportbi(ViewBilanFinancierEcoleModal entity);


}
