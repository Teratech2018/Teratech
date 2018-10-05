
package com.keren.courrier.jaxrs.ifaces.archivage;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.courrier.model.archivage.LiasseDocument;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;

/**
 * Interface du service JAX-RS
 * 
 * @since Tue Aug 28 09:06:50 WAT 2018
 * 
 */
public interface LiasseDocumentRS extends GenericService<LiasseDocument, Long> {

	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findcourrier")
	public List<CourrierClone> findcourrier(@Context HttpHeaders headers);
	
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findpiece")
	public List<FichierLie> findpiece(@Context HttpHeaders headers);


}
