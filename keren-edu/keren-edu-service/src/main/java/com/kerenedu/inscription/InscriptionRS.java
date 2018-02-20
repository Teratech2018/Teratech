
package com.kerenedu.inscription;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS
 * @since Tue Jan 09 20:37:12 WAT 2018
 * 
 */
public interface InscriptionRS
    extends GenericService<Inscription, Long>

{
	@GET
	   @Produces({MediaType.APPLICATION_JSON})
	   @Path("inscrit")
	   public List<Inscription> getEtudiantsInscrits();


}
