
package com.keren.kerenpaie.jaxrs.ifaces.paie;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.rapports.ViewBulletinPaie;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Mar 08 12:34:28 GMT+01:00 2018
 * 
 */
public interface BulletinPaieRS
    extends GenericService<BulletinPaie, Long>
{

	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("calculer")
    public BulletinPaie calculer(@Context HttpHeaders headers,BulletinPaie entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({"application/pdf"})
    @Path("printbulletin")
    public Response printbulletin(@Context HttpHeaders headers,BulletinPaie bulletin);
	
	@PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(BulletinPaie bulletin);
	

}
