
package com.keren.courrier.jaxrs.impl.traitement;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.traitement.AnnotationActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.traitement.AnnotationActionRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.traitement.AnnotationAction;
import com.keren.courrier.model.traitement.QuotationAction;
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

 * @since Thu Jul 26 18:30:43 GMT+01:00 2018
 * 
 */
@Path("/annotationaction")
public class AnnotationActionRSImpl
    extends AbstractGenericService<AnnotationAction, Long>
    implements AnnotationActionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "AnnotationActionManagerImpl", interf = AnnotationActionManagerRemote.class)
    protected AnnotationActionManagerRemote manager;

    public AnnotationActionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<AnnotationAction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new AnnotationAction(), new HashMap<String, MetaData>(), new ArrayList<String>());
//            MetaColumn workbtn = new MetaColumn("button", "work1", "Distribuer", false, "workflow", null);
//            workbtn.setValue("{'model':'kerencourrier','entity':'courrier','method':'distribuer'}");
//            workbtn.setStates(new String[]{"etabli","valide"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            meta.getHeader().add(stautsbar);	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(AnnotationAction entity) {
        if(entity.getDvisa()==null){
            throw new KerenExecption("La champ Date Annotation est obligatoire");
        }else if(entity.getQuoteur()==null){
            throw new KerenExecption("La champ Le Viseur est obligatoire");
        }else if(entity.getNote()==null||entity.getNote().trim().isEmpty()){
            throw new KerenExecption("La champ Object ou Visa est obligatoire");
        }
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
