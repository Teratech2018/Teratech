
package com.kerenedu.jaxrs.ifaces.report;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.kerenedu.model.report.ViewListeEleveModal;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Jun 19 10:58:41 WAT 2018
 * 
 */
public interface ViewListeEleveModalRS
    extends GenericService<ViewListeEleveModal, Long>
{

	@PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(ViewListeEleveModal entity);

}
