
package com.keren.kerenpaie.jaxrs.impl.conges;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.keren.kerenpaie.core.ifaces.conges.DemandeCongeManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.conges.DemandeCongeRS;
import com.keren.kerenpaie.model.conges.DemandeConge;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Apr 24 13:58:37 GMT+01:00 2018
 * 
 */
@Path("/demandeconge")
public class DemandeCongeRSImpl
    extends AbstractGenericService<DemandeConge, Long>
    implements DemandeCongeRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "DemandeCongeManagerImpl", interf = DemandeCongeManagerRemote.class)
    protected DemandeCongeManagerRemote manager;

    public DemandeCongeRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DemandeConge, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

}
