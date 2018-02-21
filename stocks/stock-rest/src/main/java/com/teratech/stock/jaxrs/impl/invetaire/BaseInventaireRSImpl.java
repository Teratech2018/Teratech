
package com.teratech.stock.jaxrs.impl.invetaire;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.invetaire.BaseInventaireManagerRemote;
import com.teratech.stock.jaxrs.ifaces.invetaire.BaseInventaireRS;
import com.teratech.stock.model.invetaire.BaseInventaire;
import com.teratech.stock.model.invetaire.FicheInventaire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 19:29:43 GMT+01:00 2018
 * 
 */
@Path("/baseinventaire")
public class BaseInventaireRSImpl
    extends AbstractGenericService<BaseInventaire, Long>
    implements BaseInventaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "BaseInventaireManagerImpl", interf = BaseInventaireManagerRemote.class)
    protected BaseInventaireManagerRemote manager;

    public BaseInventaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BaseInventaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }

    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new BaseInventaire(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
