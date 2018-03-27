
package com.keren.kerenpaie.jaxrs.impl.paie;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.core.ifaces.paie.TraitSalaireManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.paie.TraitSalaireRS;
import com.keren.kerenpaie.model.paie.TraitSalaire;
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

 * @since Mon Mar 12 16:23:11 GMT+01:00 2018
 * 
 */
@Path("/traitsalaire")
public class TraitSalaireRSImpl
    extends AbstractGenericService<TraitSalaire, Long>
    implements TraitSalaireRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "TraitSalaireManagerImpl", interf = TraitSalaireManagerRemote.class)
    protected TraitSalaireManagerRemote manager;

    public TraitSalaireRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitSalaire, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        try {
            return MetaDataUtil.getMetaData(new TraitSalaire(), new HashMap<String, MetaData>(), new ArrayList<String>()); //To change body of generated methods, choose Tools | Templates.
        } catch (InstantiationException ex) {
            Logger.getLogger(TraitSalaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TraitSalaireRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public TraitSalaire update(Long id, TraitSalaire entity) {
    	CacheMemory.setPeriode(entity.getPeriode());
        return entity; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TraitSalaire save(TraitSalaire entity) {
        //To change body of generated methods, choose Tools | Templates.
    	CacheMemory.setPeriode(entity.getPeriode());
        return entity; 
    }
    
    

}
