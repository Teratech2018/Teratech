
package com.keren.courrier.jaxrs.impl.courrier;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.CourrierTousManagerRemote;
import com.keren.courrier.core.ifaces.others.ViewCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.CourrierTousRS;
import com.keren.courrier.model.courrier.CourrierRecu;
import com.keren.courrier.model.courrier.CourrierTous;
import com.keren.courrier.model.others.ViewCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Tue Jul 31 15:27:00 GMT+01:00 2018
 * 
 */
@Path("/courriertous")
public class CourrierTousRSImpl
    extends AbstractGenericService<CourrierTous, Long>
    implements CourrierTousRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CourrierTousManagerImpl", interf = CourrierTousManagerRemote.class)
    protected CourrierTousManagerRemote manager;
    
    @Manager(application = "kerencourrier", name = "ViewCourrierManagerImpl", interf = ViewCourrierManagerRemote.class)
    protected ViewCourrierManagerRemote viewmanager;

    public CourrierTousRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CourrierTous, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
       @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new CourrierTous(), new HashMap<String, MetaData>(), new ArrayList<String>());
//            MetaColumn workbtn = new MetaColumn("button", "work1", "Quoter le Courrier", false, "action", null);
//            workbtn.setValue("{'name':'courrier_trait_01_1',template:{'courrier':'object'}}");
//            workbtn.setStates(new String[]{"etabli"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
//            workbtn = new MetaColumn("button", "work1", "Annoter le Courrier", false, "action", null);
//            workbtn.setValue("{'name':'courrier_trait_02_1',template:{'courrier':'object'}}");
//            workbtn.setStates(new String[]{"etabli"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
//            workbtn = new MetaColumn("button", "work1", "Classer le Courrier", false, "action", null);
//            workbtn.setValue("{'name':'courrier_trait_03_1',template:{'courrier':'object'}}");
//            workbtn.setStates(new String[]{"etabli"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
//            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
//            meta.getHeader().add(stautsbar);	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RSNumber count(HttpHeaders headers) {
        String header = null;
        if(headers.getRequestHeader("action_param")!=null){
            header = headers.getRequestHeader("action_param").get(0);
        }
        if(header==null){
              RestrictionsContainer container = RestrictionsContainer.newInstance();
              container.addEq("porte", "0");
              long value = manager.count(container.getPredicats());
              return new RSNumber(value);
        }else{
              RestrictionsContainer container = RestrictionsContainer.newInstance();
              container.addLike("motscles", "%"+header);
              return new RSNumber(viewmanager.count(container.getPredicats()));
        }
       //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourrierTous> filter(HttpHeaders headers, int firstResult, int maxResult) {
        String header = null;
        if(headers.getRequestHeader("action_param")!=null){
            header = headers.getRequestHeader("action_param").get(0);
        }
//        System.out.println(CourrierTousRSImpl.class.toString()+" ==================================== "+header);
        List<CourrierTous> datas = new ArrayList<CourrierTous>();
        List<CourrierTous> results = new ArrayList<CourrierTous>();
         //To change body of generated methods, choose Tools | Templates.
        if(header==null){
              RestrictionsContainer container = RestrictionsContainer.newInstance();
              container.addEq("porte", "0");
              datas = manager.filter(container.getPredicats(), null, null, firstResult, maxResult);             
        }else{
            RestrictionsContainer container = RestrictionsContainer.newInstance();
            container.addLike("motscles", "%"+header);
            List<ViewCourrier> courriers = viewmanager.filter(container.getPredicats(), null, null, firstResult, maxResult);
            for(ViewCourrier view:courriers){
                results.add(new CourrierTous(view.getCourrier()));
            }//end for(ViewCourrier view:courriers){
            return results;
        }//end if(header==null){
       for(CourrierTous data:datas){
            results.add(new CourrierTous(data));
        }//end for(CourrierTous data:datas){
        return results;
    }
    
    

}
