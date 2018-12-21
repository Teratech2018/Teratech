
package com.keren.courrier.jaxrs.impl.traitement;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.core.ifaces.traitement.QuotationActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.traitement.QuotationActionRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.keren.courrier.model.traitement.QuotationAction;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Thu Jul 26 18:00:19 GMT+01:00 2018
 * 
 */
@Path("/quotationaction")
public class QuotationActionRSImpl
    extends AbstractGenericService<QuotationAction, Long>
    implements QuotationActionRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "QuotationActionManagerImpl", interf = QuotationActionManagerRemote.class)
    protected QuotationActionManagerRemote manager;
      
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    

    public QuotationActionRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<QuotationAction, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new QuotationAction(), new HashMap<String, MetaData>(), new ArrayList<String>());
//            MetaColumn workbtn = new MetaColumn("button", "work1", "Distribuer", false, "workflow", null);
//            workbtn.setValue("{'model':'kerencourrier','entity':'courrier','method':'distribuer'}");
//            workbtn.setStates(new String[]{"etabli","valide"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);  
           // MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
            //meta.getHeader().add(stautsbar);	       
        } catch (InstantiationException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CourrierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<QuotationAction> filter(HttpHeaders headers, int firstResult, int maxResult) {
        Gson gson = new Gson();
        Long courrierid = null;
        if(headers.getRequestHeader("courrier")==null){
             return new ArrayList<QuotationAction>();
         }//end if(headers.getRequestHeader("courrier")!=null){
        courrierid = gson.fromJson(headers.getRequestHeader("courrier").get(0), Long.class);
         Long userid  = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        //Type predType = ;
        List contraints = new ArrayList();
        if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
        } //end if(headers.getRequestHeader("predicats")!=null){       
//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("predicats")+" === "+firstResult+" === "+maxResult+" == "+contraints);   
        RestrictionsContainer container = RestrictionsContainer.newInstance();  
        if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                        container = addPredicate(container,filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())
        container.addEq("courrier.id", courrierid);
        container.addEq("quoteur.service", user.getService());
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
//        System.out.println(AbstractGenericService.class.toString()+" === "+headers.getRequestHeader("courrier")+" === "+firstResult+" === "+maxResult+" == ");       
//        return super.filter(headers, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public RSNumber count(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
        //To change body of generated methods, choose Tools | Templates.
         Gson gson =new Gson();
         Long courrierid = null;
         if(headers.getRequestHeader("courrier")==null){
             return new RSNumber(0);
         }//end if(headers.getRequestHeader("courrier")!=null){
         courrierid = gson.fromJson(headers.getRequestHeader("courrier").get(0), Long.class);
         Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);         
         UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
         //Type predType = ;
         List contraints = new ArrayList();
         if(headers.getRequestHeader("predicats")!=null){
            contraints = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
         }//end if(headers.getRequestHeader("predicats")!=null){        
         RestrictionsContainer container = RestrictionsContainer.newInstance();  
         if(contraints!=null&&!contraints.isEmpty()){
            for(Object obj : contraints){
                FilterPredicat filter = (FilterPredicat) obj ;
                if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
                        &&filter.getValue()!=null&&!filter.getValue().isEmpty()){
                      container = addPredicate(container, filter);
                }//end if(filter.getFieldName()!=null&&!filter.getFieldName().trim().isEmpty()
            }//end  for(Object obj : contraints)
        }//end if(contraints!=null&&!contraints.isEmpty())
        container.addEq("courrier.id", courrierid);
        container.addEq("quoteur.service", user.getService());
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    
    
    
}
