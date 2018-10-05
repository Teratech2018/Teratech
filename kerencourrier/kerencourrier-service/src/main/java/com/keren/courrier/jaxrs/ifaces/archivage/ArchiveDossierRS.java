
package com.keren.courrier.jaxrs.ifaces.archivage;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.courrier.model.archivage.ArchiveDossier;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Thu Aug 23 09:56:40 WAT 2018
 * 
 */
public interface ArchiveDossierRS
    extends GenericService<ArchiveDossier, Long>
{
	@GET
	@Produces({ MediaType.APPLICATION_JSON })
	@Path("findpiecejointe")
	public List<FichierLie> findpiecejointe(HttpHeaders headers) ;
}
