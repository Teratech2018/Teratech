
package com.keren.courrier.jaxrs.impl.workflow;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.workflow.WorkflowActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.workflow.WorkflowActionRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.referentiel.NatureCourrier;
import com.keren.courrier.model.workflow.WorkflowAction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Jul 18 17:18:15 GMT+01:00 2018
 * 
 */
@Path("/workflowaction")
public class WorkflowActionRSImpl
    extends AbstractGenericService<WorkflowAction, Long>
    implements WorkflowActionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "WorkflowActionManagerImpl", interf = WorkflowActionManagerRemote.class)
    protected WorkflowActionManagerRemote manager;

    public WorkflowActionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<WorkflowAction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    
     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new WorkflowAction(), new HashMap<String, MetaData>(), new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public WorkflowAction delete(@Context HttpHeaders headers ,Long id) {
        
        //Initialisation
        WorkflowAction data = null;
        WorkflowAction result = null;

        try{

            data = super.delete(headers,id);
            result = new WorkflowAction(data);

        }catch(Exception e){

            throw new KerenExecption("Suppression impossible, car cet objet est dejà en cours d'utilisation par d'autres objets !");
        }

        return result; //To change body of generated methods, choose Tools | Templates.
    }
}
