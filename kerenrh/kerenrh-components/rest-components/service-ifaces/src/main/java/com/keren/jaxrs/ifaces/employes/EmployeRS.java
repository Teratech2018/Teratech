
package com.keren.jaxrs.ifaces.employes;

import com.keren.model.employes.Employe;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;


/**
 * Interface du service JAX-RS

 * @since Wed Feb 14 12:53:09 GMT+01:00 2018
 * 
 */
public interface EmployeRS
    extends GenericService<Employe, Long>
{


}
/*
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("valide")
    public Employe valide(@Context HttpHeaders headers,Employe entity);
	
	@POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    @Path("annule")
    public Employe annule(@Context HttpHeaders headers,Employe entity);
*/
