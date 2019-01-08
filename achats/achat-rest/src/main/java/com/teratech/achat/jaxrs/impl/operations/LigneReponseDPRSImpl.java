
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.operations.LigneReponseDPManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.LigneReponseDPRS;
import com.teratech.achat.model.operations.LigneReponseDP;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Sat Dec 22 14:01:07 WAT 2018
 * 
 */
@Path("/lignereponsedp")
public class LigneReponseDPRSImpl
    extends AbstractGenericService<LigneReponseDP, Long>
    implements LigneReponseDPRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "LigneReponseDPManagerImpl", interf = LigneReponseDPManagerRemote.class)
    protected LigneReponseDPManagerRemote manager;

    public LigneReponseDPRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneReponseDP, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

}
