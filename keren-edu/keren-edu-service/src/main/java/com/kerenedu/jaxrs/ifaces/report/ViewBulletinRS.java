
package com.kerenedu.jaxrs.ifaces.report;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kerenedu.model.report.ViewBulletin;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Interface du service JAX-RS
 * @since Thu Feb 15 15:02:24 CET 2018
 * 
 */
public interface ViewBulletinRS extends GenericService<ViewBulletin, Long>
{
	@GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("meta")
    public MetaData getMetaData();
    
    /**
     * 
     */
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Path("somethings")
    public List<ViewBulletin> getCriteres(ViewBulletin eleveSearch);
    //List<EcritureComptable> somethings(EcritureSearch param);
    
    @PUT
    @Produces({"application/pdf"})
    @Path("pdf")
    public Response buildPdfReport(ViewBulletin eleveSearch);

}
