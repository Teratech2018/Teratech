
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.LigneDocumentAchatManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.LigneDocumentAchatRS;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


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

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return  MetaDataUtil.getMetaData(new LigneDocumentAchat(), new HashMap<String, MetaData>(), new ArrayList<String>());//To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(LigneDocumentAchatRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(LigneDocumentAchatRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

}
