
package com.keren.courrier.jaxrs.ifaces.archivage;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.courrier.model.archivage.LiasseDocumentTri;
import com.keren.courrier.model.courrier.FichierLieTri;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Aug 28 10:45:52 WAT 2018
 * 
 */
public interface LiasseDocumentTriRS
    extends GenericService<LiasseDocumentTri, Long>
{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findpiece")
	public List<FichierLieTri> findpiece(@Context HttpHeaders headers);

}
