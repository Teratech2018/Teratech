
package com.teratech.vente.jaxrs.impl.base;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.teratech.vente.core.ifaces.base.EntrepotManagerRemote;
import com.teratech.vente.jaxrs.ifaces.base.EntrepotRS;
import com.teratech.vente.model.base.Entrepot;
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
@Path("/entrepot")
public class EntrepotRSImpl
    extends AbstractGenericService<Entrepot, Long>
    implements EntrepotRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "teratechvente", name = "EntrepotManagerImpl", interf = EntrepotManagerRemote.class)
    protected EntrepotManagerRemote manager;

    public EntrepotRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Entrepot, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("teratechvente");
    }

     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new Entrepot(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CiviliteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
