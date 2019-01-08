
package com.teratech.vente.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.base.ConditionPaiementManagerRemote;
import com.teratech.vente.jaxrs.ifaces.base.ConditionPaiementRS;
import com.teratech.vente.model.base.CategorieProduit;
import com.teratech.vente.model.base.ConditionPaiement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 08:13:39 WAT 2019
 * 
 */
@Path("/conditionpaiement")
public class ConditionPaiementRSImpl
    extends AbstractGenericService<ConditionPaiement, Long>
    implements ConditionPaiementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "ConditionPaiementManagerImpl", interf = ConditionPaiementManagerRemote.class)
    protected ConditionPaiementManagerRemote manager;

    public ConditionPaiementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ConditionPaiement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new ConditionPaiement(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(CategorieProduitRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CategorieProduitRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

}
