
package com.teratech.gmao.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.base.CalendrierEquipementManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.base.CalendrierEquipementRS;
import com.teratech.gmao.model.base.CalendrierEquipement;
import com.teratech.gmao.model.base.CauseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Jul 14 14:27:59 GMT+01:00 2018
 * 
 */
@Path("/calendrierequipement")
public class CalendrierEquipementRSImpl
    extends AbstractGenericService<CalendrierEquipement, Long>
    implements CalendrierEquipementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "CalendrierEquipementManagerImpl", interf = CalendrierEquipementManagerRemote.class)
    protected CalendrierEquipementManagerRemote manager;

    public CalendrierEquipementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CalendrierEquipement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new CalendrierEquipement(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

}
