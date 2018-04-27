
package com.kerenedu.notes;

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
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
public interface BulletinRS
    extends GenericService<Bulletin, Long>
{
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("decision")
    public Bulletin decision(@Context HttpHeaders headers,Bulletin entity);
	
	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({"application/pdf"})
    @Path("printbulletin")
    public Response printbulletin(@Context HttpHeaders headers,Bulletin bulletin);
	
	@PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(Bulletin bulletin);

}
