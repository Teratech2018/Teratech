
package com.keren.courrier.jaxrs.impl.courrier;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.BorderoCourrierManagerRemote;
import com.keren.courrier.core.ifaces.courrier.CourrierCloneManagerRemote;
import com.keren.courrier.core.ifaces.courrier.LigneBorderoCourrierManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.BorderoCourrierRS;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.BorderoCourrierR;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.CourrierDepart;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Jul 25 20:10:35 GMT+01:00 2018
 * 
 */
@Path("/borderocourrier")
public class BorderoCourrierRSImpl
    extends AbstractGenericService<BorderoCourrier, Long>
    implements BorderoCourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "BorderoCourrierManagerImpl", interf = BorderoCourrierManagerRemote.class)
    protected BorderoCourrierManagerRemote manager;
    
    @Manager(application = "kerencourrier", name = "LigneBorderoCourrierManagerImpl", interf = LigneBorderoCourrierManagerRemote.class)
    protected LigneBorderoCourrierManagerRemote lingemanager;
    
    @Manager(application = "kerencourrier", name = "CourrierCloneManagerImpl", interf = CourrierCloneManagerRemote.class)
    protected CourrierCloneManagerRemote courriermanager;    
    
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;

    public BorderoCourrierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BorderoCourrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

     @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new BorderoCourrier(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Distribuer le courrier", false, "workflow", null);
            workbtn.setValue("{'model':'kerencourrier','entity':'borderocourrier','method':'distribuer'}");
            workbtn.setStates(new String[]{"etabli"});
//            workbtn.setPattern("btn btn-primary");
            meta.getHeader().add(workbtn);  
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
    protected void processBeforeUpdate(BorderoCourrier entity) {
        if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le champ Bordero est obligatoire");
        }else if(entity.getCible()==null){
            throw new KerenExecption("Le champ Service est obligatoire");
        }else if(entity.getState().trim().equalsIgnoreCase("transmis")){
            throw new KerenExecption("Le courrier est déjà transmis");
        }
         validateLink(entity);
//        entity.setCreation(new Date());
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(BorderoCourrier entity) {
        if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le champ Bordero est obligatoire");
        }else if(entity.getCible()==null){
            throw new KerenExecption("Le champ Service est obligatoire");
        }
         validateLink(entity);
        entity.setCreation(new Date());
        entity.setState("etabli");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processAfterUpdate(BorderoCourrier entity) {        
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BorderoCourrier save(HttpHeaders headers, BorderoCourrier entity) {
        Gson gson =new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0),Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        entity.setSource(user.getService());
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    protected void processAfterSave(BorderoCourrier entity) {
       super.processAfterSave(entity); //To change body of generated methods, choose Tools | Templates.
    }  

    @Override
    public BorderoCourrier delete(HttpHeaders headers, Long id) {
        BorderoCourrier entity = manager.find("id", id);
        if(entity.getState().trim().equalsIgnoreCase("transmis")){
            throw new KerenExecption("Le Bordero de Transmission "+entity.getDesignation()+" a déjà fait l'objet d'une transmission");
        }else if(entity.getState().trim().equalsIgnoreCase("receptionne")){
            throw new KerenExecption("Le Bordero de Transmission "+entity.getDesignation()+" a déjà fait l'objet d'une transmission");
        }//end if(entity.getState().trim().equalsIgnoreCase("transmis")){
        return super.delete(headers, id); //To change body of generated methods, choose Tools | Templates.
    }
    
      @Override
    public List<BorderoCourrier> filter(HttpHeaders headers, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
          //To change body of generated methods, choose Tools | Templates.        
        Gson gson =new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0),Long.class);
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
        container.addEq("source", user.getService());
        container.addNotEq("state", "receptionne");
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }
    
   @Override
    public RSNumber count(@Context HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson =new Gson();
         Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0),Long.class);
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
        container.addEq("source", user.getService());
        container.addNotEq("state", "receptionne");
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    public BorderoCourrier distribuer(HttpHeaders headers, BorderoCourrier entity) {
        //To change body of generated methods, choose Tools | Templates.
       if(entity.getType()==null||entity.getType().trim().isEmpty()){
            throw new KerenExecption("Le champ Bordero est obligatoire");
        }else if(entity.getCible()==null){
            throw new KerenExecption("Le champ Service est obligatoire");
        }else if(entity.getAgentliaison()==null){
            throw new KerenExecption("Le champ Agent de liaison est obligatoire");
        }
        validateLink(entity);
        return manager.distribuer(entity);
    }

    
       /**
     * 
     * @param entity 
     */
    private void validateLink(BorderoCourrier entity){
        for(LigneBorderoCourrier ligne:entity.getCourriers()){
            if(ligne.getId()<=0){
                ligne.setId(-1);
            }//end if(ligne.getId()<=0){
            if(ligne.getNature()==null||ligne.getNature().trim().isEmpty()){
                throw new KerenExecption("Veuillez renseigner la Nature du courrier "+ligne.getCourrier().getDesignation());
                        
            }//end if(ligne.getNature()==null||ligne.getNature().trim().isEmpty()){
            if(lingemanager.originalAllReadyaffect(ligne, entity.getCible())){
                throw new KerenExecption("L'original du courrier "+ligne.getCourrier().getDesignation()+" est déjà affecté au bordero "+ligne.getCourrier().getBordero().getDesignation());
            }//end  if(lingemanager.originalAllReadyaffect(entity.getCible(), ligne.getCourrier())){
        }//end for(LigneBorderoCourrier ligne:entity.getCourriers()){
    }//end private void validateLink(BorderoCourrier entity){

    

}
