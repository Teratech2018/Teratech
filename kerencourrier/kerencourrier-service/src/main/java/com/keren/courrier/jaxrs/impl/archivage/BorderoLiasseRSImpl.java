
package com.keren.courrier.jaxrs.impl.archivage;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.archivage.BorderoLiasseManagerRemote;
import com.keren.courrier.core.ifaces.archivage.LigneBorderoLiasseManagerRemote;
import com.keren.courrier.core.ifaces.courrier.CourrierCloneManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.archivage.BorderoLiasseRS;
import com.keren.courrier.jaxrs.impl.courrier.CourrierRSImpl;
import com.keren.courrier.model.archivage.BorderoLiasse;
import com.keren.courrier.model.archivage.LigneBorderoLiasse;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Aug 28 09:06:50 WAT 2018
 * 
 */
@Path("/borderoliasse")
public class BorderoLiasseRSImpl
    extends AbstractGenericService<BorderoLiasse, Long>
    implements BorderoLiasseRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "BorderoLiasseManagerImpl", interf = BorderoLiasseManagerRemote.class)
    protected BorderoLiasseManagerRemote manager;
    
    @Manager(application = "kerencourrier", name = "LigneBorderoLiasseManagerImpl", interf = LigneBorderoLiasseManagerRemote.class)
    protected LigneBorderoLiasseManagerRemote lingemanager;
    
    @Manager(application = "kerencourrier", name = "CourrierCloneManagerImpl", interf = CourrierCloneManagerRemote.class)
    protected CourrierCloneManagerRemote courriermanager;    
    
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;

    public BorderoLiasseRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<BorderoLiasse, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new BorderoLiasse(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "versement aux archives", false, "workflow", null);
            workbtn.setValue("{'model':'kerencourrier','entity':'borderoliasse','method':'distribuer'}");
            workbtn.setStates(new String[]{"etabli"});
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
    protected void processBeforeUpdate(BorderoLiasse entity) {
    	if(entity.getLignes()==null&&entity.getLignes().size()<=0){
            throw new KerenExecption(" Aucune liasse n'est renseigné");
        }else if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
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
    protected void processBeforeSave(BorderoLiasse entity) {
        if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
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
    protected void processAfterUpdate(BorderoLiasse entity) {        
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BorderoLiasse save(HttpHeaders headers, BorderoLiasse entity) {
        Gson gson =new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0),Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        entity.setSource(user.getService());
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    protected void processAfterSave(BorderoLiasse entity) {
       super.processAfterSave(entity); //To change body of generated methods, choose Tools | Templates.
    }  

    @Override
    public BorderoLiasse delete(HttpHeaders headers, Long id) {
    	BorderoLiasse entity = manager.find("id", id);
        if(entity.getState().trim().equalsIgnoreCase("transmis")){
            throw new KerenExecption("Les liasses de ce  Bordero  "+entity.getDesignation()+" a déjà été verser au archive");
        }else if(entity.getState().trim().equalsIgnoreCase("receptionne")){
            throw new KerenExecption("Les liasses de ce  Bordero"+entity.getDesignation()+" a déjà fait l'objet d'un versement aux archives");
        }//end if(entity.getState().trim().equalsIgnoreCase("transmis")){
        return super.delete(headers, id); //To change body of generated methods, choose Tools | Templates.
    }
    
      @Override
    public List<BorderoLiasse> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
        System.out.println("BorderoLiasseRSImpl.filter() service user "+user.getService().getId());
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
         System.out.println("BorderoLiasseRSImpl.filter() service user "+user.getService().getId());
        container.addEq("source", user.getService());
        container.addNotEq("state", "receptionne");
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    public BorderoLiasse distribuer(HttpHeaders headers, BorderoLiasse entity) {
        //To change body of generated methods, choose Tools | Templates.
       if(entity.getCode()==null||entity.getCode().trim().isEmpty()){
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
    private void validateLink(BorderoLiasse entity){
    	for(LigneBorderoLiasse ligne:entity.getLignes()){
            if(ligne.getId()<=0){
                ligne.setId(-1);
            }//end if(ligne.getId()<=0){
           
        }//end for(LigneBorderoCourrier ligne:entity.getCourriers()){
    }//end private void validateLink(BorderoCourrier entity){


}
