
package com.keren.kerenpaie.jaxrs.ifaces.employes;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.ValiderSalaire;
import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Interface du service JAX-RS
 * @since Thu Mar 01 10:22:26 GMT+01:00 2018
 * 
 */
public interface EmployeRS
    extends GenericService<Employe, Long>
{

	@GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("salaries/data")
    public List<Employe> getSalaries(@Context HttpHeaders headers,ValiderSalaire entity);
	
	@GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("salaries/count")
    public RSNumber countSalaries(@Context HttpHeaders headers,ValiderSalaire entity);

}
