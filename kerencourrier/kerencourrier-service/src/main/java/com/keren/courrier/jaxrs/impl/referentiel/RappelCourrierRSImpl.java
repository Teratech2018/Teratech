
package com.keren.courrier.jaxrs.impl.referentiel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.referentiel.RappelCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.referentiel.RappelCourrierRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.referentiel.EventCourrier;
import com.keren.courrier.model.referentiel.RappelCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jul 31 12:08:44 WAT 2018
 * 
 */
@Path("/rappelcourrier")
public class RappelCourrierRSImpl
    extends AbstractGenericService<RappelCourrier, Long>
    implements RappelCourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "RappelCourrierManagerImpl", interf = RappelCourrierManagerRemote.class)
    protected RappelCourrierManagerRemote manager;

    public RappelCourrierRSImpl() {
        super();
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new RappelCourrier(), new HashMap<String, MetaData>(), new ArrayList<String>());
	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<RappelCourrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
