
package com.kerenedu.solde;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Nov 26 15:39:58 WAT 2018
 * 
 */
@Path("/validersalaire")
public class ValiderSalaireRSImpl
    extends AbstractGenericService<ValiderSalaire, Long>
    implements ValiderSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ValiderSalaireManagerImpl", interf = ValiderSalaireManagerRemote.class)
    protected ValiderSalaireManagerRemote manager;

    public ValiderSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ValiderSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
