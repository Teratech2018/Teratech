
package com.teratech.gmao.jaxrs.impl.preventif;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.gmao.core.ifaces.preventif.MaintenancePreventiveManagerRemote;
import com.teratech.gmao.jaxrs.ifaces.preventif.MaintenancePreventiveRS;
import com.teratech.gmao.jaxrs.impl.base.ArticleRSImpl;
import com.teratech.gmao.model.preventif.MaintenancePreventive;
import com.teratech.gmao.model.preventif.MiseAJourCompteur;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Mon Jul 16 21:57:16 GMT+01:00 2018
 * 
 */
@Path("/maintenancepreventive")
public class MaintenancePreventiveRSImpl
    extends AbstractGenericService<MaintenancePreventive, Long>
    implements MaintenancePreventiveRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechgmao", name = "MaintenancePreventiveManagerImpl", interf = MaintenancePreventiveManagerRemote.class)
    protected MaintenancePreventiveManagerRemote manager;

    public MaintenancePreventiveRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<MaintenancePreventive, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechgmao");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
             meta = MetaDataUtil.getMetaData(new MaintenancePreventive(), new HashMap<String, MetaData>(), new ArrayList<String>());
           //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArticleRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }
}
