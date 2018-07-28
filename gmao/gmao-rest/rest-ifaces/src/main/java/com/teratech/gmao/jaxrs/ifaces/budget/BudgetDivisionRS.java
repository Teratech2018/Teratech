
package com.teratech.gmao.jaxrs.ifaces.budget;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.gmao.model.budget.BudgetDivision;
import com.teratech.gmao.model.budget.LigneBudget;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Sat Jul 21 11:07:52 GMT+01:00 2018
 * 
 */
public interface BudgetDivisionRS
    extends GenericService<BudgetDivision, Long>
{

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("budget")
    public List<LigneBudget> getDetails(@Context HttpHeaders headers);

}
