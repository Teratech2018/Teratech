
package com.teratech.vente.jaxrs.impl.others;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.operations.DevisManagerRemote;
import com.teratech.vente.core.ifaces.others.SendDevisFormManagerRemote;
import com.teratech.vente.jaxrs.ifaces.others.SendDevisFormRS;
import com.teratech.vente.model.operations.Devis;
import com.teratech.vente.model.others.SendDevisForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 11:26:19 WAT 2019
 * 
 */
@Path("/senddevisform")
public class SendDevisFormRSImpl
    extends AbstractGenericService<SendDevisForm, Long>
    implements SendDevisFormRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "SendDevisFormManagerImpl", interf = SendDevisFormManagerRemote.class)
    protected SendDevisFormManagerRemote manager;
    
     @Manager(application = "teratechvente", name = "DevisManagerImpl", interf = DevisManagerRemote.class)
    protected DevisManagerRemote devismanager;

    public SendDevisFormRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<SendDevisForm, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new SendDevisForm(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(SendDevisFormRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(SendDevisFormRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SendDevisForm save(HttpHeaders headers, SendDevisForm entity) {
        Devis devis = devismanager.find("id", entity.getDevis().getId());
        devis.setState("transmi");
        devismanager.update(devis.getId(), devis);
        return entity; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
