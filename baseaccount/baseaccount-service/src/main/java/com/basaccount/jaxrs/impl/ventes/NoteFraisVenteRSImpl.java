
package com.basaccount.jaxrs.impl.ventes;

import javax.ws.rs.Path;
import com.basaccount.core.ifaces.ventes.NoteFraisVenteManagerRemote;
import com.basaccount.jaxrs.ifaces.ventes.NoteFraisVenteRS;
import com.basaccount.model.ventes.NoteFraisVente;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Jan 15 23:13:06 WAT 2019
 * 
 */
@Path("/notefraisvente")
public class NoteFraisVenteRSImpl
    extends AbstractGenericService<NoteFraisVente, Long>
    implements NoteFraisVenteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "baseaccount", name = "NoteFraisVenteManagerImpl", interf = NoteFraisVenteManagerRemote.class)
    protected NoteFraisVenteManagerRemote manager;

    public NoteFraisVenteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<NoteFraisVente, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("baseaccount");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new NoteFraisVente(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(NoteFraisVenteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NoteFraisVenteRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
