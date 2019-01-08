
package com.teratech.achat.jaxrs.impl.tools;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.BonCommandeManagerRemote;
import com.teratech.achat.core.ifaces.tools.SendCommandFormManagerRemote;
import com.teratech.achat.jaxrs.ifaces.tools.SendCommandFormRS;
import com.teratech.achat.model.tools.SendCommandForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Feb 23 09:56:12 WAT 2018
 * 
 */
@Path("/sendcommandform")
public class SendCommandFormRSImpl
    extends AbstractGenericService<SendCommandForm, Long>
    implements SendCommandFormRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "SendCommandFormManagerImpl", interf = SendCommandFormManagerRemote.class)
    protected SendCommandFormManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "BonCommandeManagerImpl", interf = BonCommandeManagerRemote.class)
    protected BonCommandeManagerRemote cmdemanager;

    public SendCommandFormRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<SendCommandForm, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new SendCommandForm(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(SendCommandFormRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SendCommandFormRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        //To change body of generated methods, choose Tools | Templates.
        return meta;
    }

    @Override
    public SendCommandForm save(HttpHeaders headers, SendCommandForm entity) {
        if(entity.getCommande().getState().equalsIgnoreCase("etabli")){
            entity.getCommande().setState("transmi");
            cmdemanager.update(entity.getCommande().getId(),entity.getCommande());
        }
        return entity; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
