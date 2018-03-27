
package com.keren.kerenpaie.jaxrs.impl.paie;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.paie.LignePonderationSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.LignePonderationSalaireRS;
import com.keren.kerenpaie.model.paie.LignePonderationSalaire;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 23 14:48:54 GMT+01:00 2018
 * 
 */
@Path("/ligneponderationsalaire")
public class LignePonderationSalaireRSImpl
    extends AbstractGenericService<LignePonderationSalaire, Long>
    implements LignePonderationSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "LignePonderationSalaireManagerImpl", interf = LignePonderationSalaireManagerRemote.class)
    protected LignePonderationSalaireManagerRemote manager;

    public LignePonderationSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LignePonderationSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

}
