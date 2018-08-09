
package com.keren.courrier.jaxrs.impl.traitement;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.traitement.DeclassementActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.traitement.DeclassementActionRS;
import com.keren.courrier.jaxrs.impl.referentiel.ClasseurCourrierRSImpl;
import com.keren.courrier.model.traitement.DeclassementAction;
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

 * @since Wed Aug 01 17:08:49 GMT+01:00 2018
 * 
 */
@Path("/declassementaction")
public class DeclassementActionRSImpl
    extends AbstractGenericService<DeclassementAction, Long>
    implements DeclassementActionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "DeclassementActionManagerImpl", interf = DeclassementActionManagerRemote.class)
    protected DeclassementActionManagerRemote manager;

    public DeclassementActionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<DeclassementAction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta =  MetaDataUtil.getMetaData(new DeclassementAction(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(ClasseurCourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ClasseurCourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta;
    }

    @Override
    protected void processBeforeSave(DeclassementAction entity) {
        if(entity.getDclassement()==null){
            throw new KerenExecption("Le champ Date de Classement est obligatoire");
        }else if(entity.getOrdonateur()==null){
            throw new KerenExecption("Le champ Ordonateur est obligatoire");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
