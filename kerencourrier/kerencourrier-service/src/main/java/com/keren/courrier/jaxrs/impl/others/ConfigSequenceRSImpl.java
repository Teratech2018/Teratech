
package com.keren.courrier.jaxrs.impl.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.others.ConfigSequenceManagerRemote;
import com.keren.courrier.jaxrs.ifaces.others.ConfigSequenceRS;
import com.keren.courrier.jaxrs.impl.archivage.ArchiveLiasseRSImpl;
import com.keren.courrier.model.others.ConfigSequence;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Sep 24 14:52:56 WAT 2018
 * 
 */
@Path("/configsequence")
public class ConfigSequenceRSImpl
    extends AbstractGenericService<ConfigSequence, Long>
    implements ConfigSequenceRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "ConfigSequenceManagerImpl", interf = ConfigSequenceManagerRemote.class)
    protected ConfigSequenceManagerRemote manager;

    public ConfigSequenceRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ConfigSequence, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new ConfigSequence(), new HashMap<String, MetaData>(), new ArrayList<String>());
    
        } catch (InstantiationException ex) {
            Logger.getLogger(ArchiveLiasseRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArchiveLiasseRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
}
