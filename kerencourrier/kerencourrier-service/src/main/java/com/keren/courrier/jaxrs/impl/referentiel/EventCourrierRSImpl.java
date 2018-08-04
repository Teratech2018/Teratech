
package com.keren.courrier.jaxrs.impl.referentiel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.referentiel.EventCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.referentiel.EventCourrierRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.referentiel.EventCourrier;
import com.keren.courrier.model.traitement.RelanceAction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jul 31 12:08:44 WAT 2018
 * 
 */
@Path("/eventcourrier")
public class EventCourrierRSImpl
    extends AbstractGenericService<EventCourrier, Long>
    implements EventCourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "EventCourrierManagerImpl", interf = EventCourrierManagerRemote.class)
    protected EventCourrierManagerRemote manager;

    public EventCourrierRSImpl() {
        super();
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new EventCourrier(), new HashMap<String, MetaData>(), new ArrayList<String>());
	       
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
    public GenericManager<EventCourrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

}
