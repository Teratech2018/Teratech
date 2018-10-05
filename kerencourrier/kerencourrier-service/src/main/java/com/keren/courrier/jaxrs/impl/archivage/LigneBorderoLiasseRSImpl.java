
package com.keren.courrier.jaxrs.impl.archivage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.archivage.LigneBorderoLiasseManagerRemote;
import com.keren.courrier.jaxrs.ifaces.archivage.LigneBorderoLiasseRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.archivage.BorderoLiasseR;
import com.keren.courrier.model.archivage.LigneBorderoLiasse;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Aug 28 09:06:50 WAT 2018
 * 
 */
@Path("/ligneborderoliasse")
public class LigneBorderoLiasseRSImpl
    extends AbstractGenericService<LigneBorderoLiasse, Long>
    implements LigneBorderoLiasseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "LigneBorderoLiasseManagerImpl", interf = LigneBorderoLiasseManagerRemote.class)
    protected LigneBorderoLiasseManagerRemote manager;

    public LigneBorderoLiasseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<LigneBorderoLiasse, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new LigneBorderoLiasse(), new HashMap<String, MetaData>(), new ArrayList<String>());
    
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }




}
