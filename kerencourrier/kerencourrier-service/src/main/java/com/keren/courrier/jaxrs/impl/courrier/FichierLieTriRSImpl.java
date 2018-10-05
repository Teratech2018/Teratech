
package com.keren.courrier.jaxrs.impl.courrier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.FichierLieTriManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.FichierLieTriRS;
import com.keren.courrier.model.courrier.FichierLieTri;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Aug 31 11:17:44 WAT 2018
 * 
 */
@Path("/fichierlietri")
public class FichierLieTriRSImpl
    extends AbstractGenericService<FichierLieTri, Long>
    implements FichierLieTriRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "FichierLieTriManagerImpl", interf = FichierLieTriManagerRemote.class)
    protected FichierLieTriManagerRemote manager;

    public FichierLieTriRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<FichierLieTri, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new FichierLieTri(), new HashMap<String, MetaData>(), new ArrayList<String>());
    
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

}
