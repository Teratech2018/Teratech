
package com.keren.kerenpaie.jaxrs.ifaces.paie;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.kerenpaie.model.paie.ForfaitCategorie;
import com.keren.kerenpaie.model.paie.ForfaitCategorieProf;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Mar 06 12:50:48 GMT+01:00 2018
 * 
 */
public interface RubriqueRS
    extends GenericService<Rubrique, Long>
{

	@PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("genereforfait")
    public Rubrique genereforfait(@Context HttpHeaders headers,Rubrique entity);
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("evaluer")
    public Rubrique evaluer(@Context HttpHeaders headers,Rubrique entity);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("generatecategorieprof")
	public List<ForfaitCategorieProf> generatecategorieprof(@Context HttpHeaders headers);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("generatecategorie")
	public List<ForfaitCategorie> generatecategorie(@Context HttpHeaders headers);
}
