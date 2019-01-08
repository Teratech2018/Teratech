
package com.teratech.achat.jaxrs.ifaces.tools;

import com.megatimgroup.generic.jax.rs.layer.ifaces.GenericService;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.tools.ReponseToCommande;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


/**
 * Interface du service JAX-RS

 * @since Thu Feb 22 18:51:44 WAT 2018
 * 
 */
public interface ReponseToCommandeRS
    extends GenericService<ReponseToCommande, Long>
{

    /**
     * 
     * @param param
     * @return 
     */
    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    @Path("bi/command")
    public List<BonCommande> somethings(ReponseToCommande param);
}
