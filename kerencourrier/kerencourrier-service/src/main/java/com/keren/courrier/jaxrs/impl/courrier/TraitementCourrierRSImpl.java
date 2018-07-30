
package com.keren.courrier.jaxrs.impl.courrier;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.TraitementCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.TraitementCourrierRS;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Jul 19 10:36:25 GMT+01:00 2018
 * 
 */
@Path("/traitementcourrier")
public class TraitementCourrierRSImpl
    extends AbstractGenericService<TraitementCourrier, Long>
    implements TraitementCourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "TraitementCourrierManagerImpl", interf = TraitementCourrierManagerRemote.class)
    protected TraitementCourrierManagerRemote manager;

    public TraitementCourrierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<TraitementCourrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new TraitementCourrier(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Générer La Grille", false, "workflow", null);
            workbtn.setValue("{'model':'kerenpaie','entity':'convension','method':'genere'}");
            workbtn.setStates(new String[]{"etabli","actif"});
            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);  
//            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
//            meta.getHeader().add(stautsbar);	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
