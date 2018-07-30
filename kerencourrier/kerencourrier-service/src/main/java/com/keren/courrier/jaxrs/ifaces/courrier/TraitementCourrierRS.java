
package com.keren.courrier.jaxrs.ifaces.courrier;

import com.keren.courrier.model.courrier.TraitementCourrier;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Thu Jul 19 10:36:25 GMT+01:00 2018
 * 
 */
public interface TraitementCourrierRS
    extends GenericService<TraitementCourrier, Long>
{

   
}
