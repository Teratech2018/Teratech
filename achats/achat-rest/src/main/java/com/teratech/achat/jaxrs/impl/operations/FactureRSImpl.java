
package com.teratech.achat.jaxrs.impl.operations;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.achat.core.ifaces.operations.FactureManagerRemote;
import com.teratech.achat.jaxrs.ifaces.operations.FactureRS;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.Facture;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Mar 02 08:22:57 GMT+01:00 2018
 * 
 */
@Path("/facture")
public class FactureRSImpl
    extends AbstractGenericService<Facture, Long>
    implements FactureRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechachat", name = "FactureManagerImpl", interf = FactureManagerRemote.class)
    protected FactureManagerRemote manager;

    public FactureRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Facture, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechachat");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta= MetaDataUtil.getMetaData(new Facture(), new HashMap<String, MetaData>(), new ArrayList<String>());
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(FactureRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FactureRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    

}
