
package com.teratech.achat.jaxrs.impl.tools;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.DemandePrixManagerRemote;
import com.teratech.achat.core.ifaces.tools.SendDPFormManagerRemote;
import com.teratech.achat.jaxrs.ifaces.tools.SendDPFormRS;
import com.teratech.achat.model.operations.DemandePrix;
import com.teratech.achat.model.tools.SendDPForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Dec 22 07:37:52 WAT 2018
 * 
 */
@Path("/senddpform")
public class SendDPFormRSImpl
    extends AbstractGenericService<SendDPForm, Long>
    implements SendDPFormRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "SendDPFormManagerImpl", interf = SendDPFormManagerRemote.class)
    protected SendDPFormManagerRemote manager;
    
    @Manager(application = "teratechachat", name = "DemandePrixManagerImpl", interf = DemandePrixManagerRemote.class)
    protected DemandePrixManagerRemote dpmanager;

    public SendDPFormRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<SendDPForm, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new SendDPForm(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(SendDPFormRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SendDPFormRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SendDPForm save(HttpHeaders headers, SendDPForm entity) {
        if(entity.getMessage()==null || entity.getMessage().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir votre message");
        }
        /**
         * Envoi des e-mails au fournisseurs
         */
        DemandePrix dp = entity.getDemande();
        dp.setState("transmi");
        dpmanager.update(dp.getId(), dp);
        return entity; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
