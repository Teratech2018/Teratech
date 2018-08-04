
package com.keren.courrier.jaxrs.impl.courrier;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.commons.DateHelper;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.CourrierManagerRemote;
import com.keren.courrier.core.ifaces.courrier.TraitementCourrierManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.PrioriteManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.StructureCompanyManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.CourrierRS;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.ServiceDiffusion;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.keren.courrier.model.referentiel.Priorite;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
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

 * @since Wed Jul 18 10:58:44 GMT+01:00 2018
 * 
 */
@Path("/courrier")
public class CourrierRSImpl
    extends AbstractGenericService<Courrier, Long>
    implements CourrierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CourrierManagerImpl", interf = CourrierManagerRemote.class)
    protected CourrierManagerRemote manager;
    
    @Manager(application = "kerencourrier", name = "PrioriteManagerImpl", interf = PrioriteManagerRemote.class)
    protected PrioriteManagerRemote prioritemanager;
     
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    
    @Manager(application = "kerencourrier", name = "StructureCompanyManagerImpl", interf = StructureCompanyManagerRemote.class)
    protected StructureCompanyManagerRemote servicemanager;
    
    @Manager(application = "kerencourrier", name = "TraitementCourrierManagerImpl", interf = TraitementCourrierManagerRemote.class)
    protected TraitementCourrierManagerRemote courriermanager;
    

    public CourrierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Courrier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new Courrier(), new HashMap<String, MetaData>(), new ArrayList<String>());
//            MetaColumn workbtn = new MetaColumn("button", "work1", "Distribuer", false, "workflow", null);
//            workbtn.setValue("{'model':'kerencourrier','entity':'courrier','method':'distribuer'}");
//            workbtn.setStates(new String[]{"etabli","valide"});
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
    public String getDateLimite(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
          Gson gson = new Gson();
          Long prioriteid = -1L;
          String data = headers.getRequestHeader("priorite").get(0); 
          try{
              prioriteid = Long.valueOf(data);
          }catch(NumberFormatException ex){
              prioriteid = -1L;
          }//end  try{
          Date limite = new Date();
          if(prioriteid>0){
                Priorite priorite = prioritemanager.find("id", prioriteid);
                if(priorite.getMethode().trim().equalsIgnoreCase("0")){
                    limite = DateHelper.nextJoursOuvrees(limite, priorite.getDelai()!=null?priorite.getDelai():0);
                }else{
                    limite = DateHelper.next(limite, priorite.getDelai()!=null?priorite.getDelai():0);
                }//end if(priorite.getMethode().trim().equalsIgnoreCase("0")){                
          }//end if(prioriteid>0){
          SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
          return format.format(limite);
    }

    @Override
    public List<LigneDiffusion> getdiffusionList(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
//        String data = headers.getRequestHeader("service").get(0);
//        Long serviceid = -1L;
//         try{
//              serviceid = Long.valueOf(data);
//          }catch(NumberFormatException ex){
//              serviceid = -1L;
//          }//end  try{
//         if(serviceid>0){
//             StructureCompany service = servicemanager.find("id", serviceid);             
//             return service.getIntervenants();
//         }else{
//            return new ArrayList<LigneDiffusion>();
//         }
         return new ArrayList<LigneDiffusion>();
    }

    @Override
    public RSNumber count(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         //To change body of generated methods, choose Tools | Templates.
        Gson gson = new Gson();
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
         container.addEq("source", user);
        container.addEq("categorie", "0");
        container.addNotEq("state", "receptionne");
        container.addNotEq("state", "classer");
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    
    
    
    @Override
    public List<Courrier> filter(HttpHeaders headers, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
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
        container.addEq("source", user);
        container.addEq("categorie", "0");
        container.addNotEq("state", "receptionne");
        container.addNotEq("state", "classer");
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }
    

    @Override
    protected void processBeforeUpdate(Courrier entity) {
        if(!entity.getState().trim().equalsIgnoreCase("etabli")){
            throw new KerenExecption("Modification impossible<br/> Le courrier "+entity.getDesignation()+" est déjà en cours de traitement...");
        }
       super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processAfterUpdate(Courrier entity) {
         //To change body of generated methods, choose Tools | Templates.
        for(FichierLie elt:entity.getPiecesjointes()){
            File file = new File(FileHelper.getTemporalDirectory().getPath()+File.separator+elt.getFilename());
            if(file.exists()){
                File destfile = new File(FileHelper.getStaticDirectory().getPath());
                boolean result = true;
                if(!destfile.exists()){
                    result = destfile.mkdir();
                }//end if(!destfile.exists()){
                if(result){
                    try {
                        destfile = new File(destfile.getPath()+File.separator+elt.getFilename());
                        FileHelper.moveFile(file, destfile);
                    } //end if(result){
                    catch (IOException ex) {
                        throw new KerenExecption(ex.getMessage());
                    }
                }
            }//end if(file.exists()){
        }//end for(FichierLie elt:entity.getPiecesjointes()){
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processAfterSave(Courrier entity) {
        //To change body of generated methods, choose Tools | Templates.
        for(FichierLie elt:entity.getPiecesjointes()){
            File file = new File(FileHelper.getTemporalDirectory().getPath()+File.separator+elt.getFilename());
            if(file.exists()){
                File destfile = new File(FileHelper.getStaticDirectory().getPath());
                boolean result = true;
                if(!destfile.exists()){
                    result = destfile.mkdir();
                }//end if(!destfile.exists()){
                if(result){
                    try {
                        destfile = new File(destfile.getPath()+File.separator+elt.getFilename());
                        FileHelper.moveFile(file, destfile);
                    } //end if(result){
                    catch (IOException ex) {
                        throw new KerenExecption(ex.getMessage());
                    }
                }
            }//end if(file.exists()){
        }//end for(FichierLie elt:entity.getPiecesjointes()){
        super.processAfterSave(entity); 
    }

    
    
    @Override
	public Courrier delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
    	Courrier entity = manager.find("id", id);
		try {
			if(!entity.getState().equals("etabli")){
			      throw new KerenExecption("Le courrier "+entity.getDesignation()+" est déjà en cours de traitement...");
			}else{
				// on supprimme l'objet
				super.delete(headers, id);
			}
	

		} catch (Exception ex) {
			throw new KerenExecption("Le courrier "+entity.getDesignation()+" est déjà en cours de traitement...");
		}

		return entity;
	}
    
    

    @Override
    protected void processBeforeSave(Courrier entity) {        
        for(FichierLie fichier:entity.getPiecesjointes()){
             fichier.setId(-1);
        }//end for(FichierLie fichier:entity.getPiecesjointes()){
        entity.setState("etabli");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courrier save(HttpHeaders headers, Courrier entity) {
        Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
        UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        entity.setSource(user);
        entity.setSowner(user.getService());
        entity.setCategorie("0");
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Courrier distribuer(HttpHeaders headers, Courrier entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity =courriermanager.traiterCourrier(entity);
        return new Courrier(entity);
    }

    @Override
    public List<ServiceDiffusion> getdiffusionServices(HttpHeaders headers) {
        //To change body of generated methods, choose Tools | Templates.
         //To change body of generated methods, choose Tools | Templates.
//        String data = headers.getRequestHeader("service").get(0);
//        Long serviceid = -1L;
//         try{
//              serviceid = Long.valueOf(data);
//          }catch(NumberFormatException ex){
//              serviceid = -1L;
//          }//end  try{
//         if(serviceid>0){
//             StructureCompany service = servicemanager.find("id", serviceid);             
//             return service.getServices();
//         }else{
//            return new ArrayList<ServiceDiffusion>();
//         }//end if(serviceid>0){
         return new ArrayList<ServiceDiffusion>();
    }

    

}
