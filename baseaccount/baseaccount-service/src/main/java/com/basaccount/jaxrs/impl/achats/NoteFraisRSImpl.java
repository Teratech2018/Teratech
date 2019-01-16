
package com.basaccount.jaxrs.impl.achats;

import javax.ws.rs.Path;
import com.basaccount.core.ifaces.achats.NoteFraisManagerRemote;
import com.basaccount.jaxrs.ifaces.achats.NoteFraisRS;
import com.basaccount.model.achats.NoteFrais;
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

 * @since Fri Mar 16 09:30:48 GMT+01:00 2018
 * 
 */
@Path("/notefrais")
public class NoteFraisRSImpl
    extends AbstractGenericService<NoteFrais, Long>
    implements NoteFraisRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "baseaccount", name = "NoteFraisManagerImpl", interf = NoteFraisManagerRemote.class)
    protected NoteFraisManagerRemote manager;

    public NoteFraisRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<NoteFrais, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("baseaccount");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new NoteFrais(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(NoteFraisRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(NoteFraisRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }
    
    

}
