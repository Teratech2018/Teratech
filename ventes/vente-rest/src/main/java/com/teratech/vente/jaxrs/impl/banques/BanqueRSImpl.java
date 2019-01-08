
package com.teratech.vente.jaxrs.impl.banques;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.banques.BanqueManagerRemote;
import com.teratech.vente.jaxrs.ifaces.banques.BanqueRS;
import com.teratech.vente.model.banques.Banque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Fri Jan 04 08:13:40 WAT 2019
 * 
 */
@Path("/banque")
public class BanqueRSImpl
    extends AbstractGenericService<Banque, Long>
    implements BanqueRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "BanqueManagerImpl", interf = BanqueManagerRemote.class)
    protected BanqueManagerRemote manager;

    public BanqueRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Banque, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new Banque(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(BanqueRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(BanqueRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
