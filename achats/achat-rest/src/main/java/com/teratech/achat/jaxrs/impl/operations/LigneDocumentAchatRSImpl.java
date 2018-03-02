
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.teratech.achat.core.ifaces.operations.LigneDocumentAchatManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.LigneDocumentAchatRS;
import com.teratech.achat.model.operations.LigneDocumentAchat;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Mar 02 15:27:18 GMT+01:00 2018
 * 
 */
@Path("/lignedocumentachat")
public class LigneDocumentAchatRSImpl
    extends AbstractGenericService<LigneDocumentAchat, Long>
    implements LigneDocumentAchatRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "LigneDocumentAchatManagerImpl", interf = LigneDocumentAchatManagerRemote.class)
    protected LigneDocumentAchatManagerRemote manager;

    public LigneDocumentAchatRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneDocumentAchat, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

}
