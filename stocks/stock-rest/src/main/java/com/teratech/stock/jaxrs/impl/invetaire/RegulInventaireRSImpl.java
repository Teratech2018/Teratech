
package com.teratech.stock.jaxrs.impl.invetaire;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.stock.core.ifaces.invetaire.RegulInventaireManagerRemote;
import com.teratech.stock.jaxrs.ifaces.invetaire.RegulInventaireRS;
import com.teratech.stock.model.invetaire.FicheInventaire;
import com.teratech.stock.model.invetaire.RegulInventaire;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Feb 20 19:29:55 GMT+01:00 2018
 * 
 */
@Path("/regulinventaire")
public class RegulInventaireRSImpl
    extends AbstractGenericService<RegulInventaire, Long>
    implements RegulInventaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechstock", name = "RegulInventaireManagerImpl", interf = RegulInventaireManagerRemote.class)
    protected RegulInventaireManagerRemote manager;

    public RegulInventaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RegulInventaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechstock");
    }
    
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new RegulInventaire(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(FicheInventaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    

}
