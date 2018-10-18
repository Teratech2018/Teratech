
package com.kerenedu.solde;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Oct 11 15:46:58 WAT 2018
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
	
//	@PUT
//    @Consumes({MediaType.APPLICATION_JSON})
//    @Produces({"application/pdf"})
//    @Path("printbulletin")
//    public Response printbulletin(@Context HttpHeaders headers,BulletinPaie bulletin);
//	
//	@PUT
//    @Produces({"application/pdf"})
//    @Path("pdf")
//    public Response buildPdfReportLot(BulletinPaie bulletin);
//	
//	@PUT
//    @Produces({"application/pdf"})
//    @Path("pdf")
//    public Response livrepaie(BulletinPaie bulletin);
}
