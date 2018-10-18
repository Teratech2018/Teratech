
package com.kerenedu.solde;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Oct 11 14:48:37 WAT 2018
 * 
 */
@Path("/traitsalaire")
public class TraitSalaireRSImpl
    extends AbstractGenericService<TraitSalaire, Long>
    implements TraitSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "TraitSalaireManagerImpl", interf = TraitSalaireManagerRemote.class)
    protected TraitSalaireManagerRemote manager;

    public TraitSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }

}
