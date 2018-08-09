
package com.keren.courrier.jaxrs.impl.courrier;

import java.text.SimpleDateFormat;
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
import com.kerem.commons.DateHelper;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.courrier.core.ifaces.courrier.CourrierInterneManagerRemote;
import com.keren.courrier.core.ifaces.courrier.TraitementCourrierManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.PrioriteManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.StructureCompanyManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.jaxrs.ifaces.courrier.CourrierInterneRS;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.CourrierInterne;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.Priorite;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;
import java.io.File;
import java.io.IOException;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Wed Jul 18 13:37:32 GMT+01:00 2018
 * 
 */
@Path("/courrierinterne")
public class CourrierInterneRSImpl
    extends AbstractGenericService<CourrierInterne, Long>
    implements CourrierInterneRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "CourrierInterneManagerImpl", interf = CourrierInterneManagerRemote.class)
    protected CourrierInterneManagerRemote manager;

    @Manager(application = "kerencourrier", name = "PrioriteManagerImpl", interf = PrioriteManagerRemote.class)
    protected PrioriteManagerRemote prioritemanager;
     
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    
    @Manager(application = "kerencourrier", name = "StructureCompanyManagerImpl", interf = StructureCompanyManagerRemote.class)
    protected StructureCompanyManagerRemote servicemanager;
    
    @Manager(application = "kerencourrier", name = "TraitementCourrierManagerImpl", interf = TraitementCourrierManagerRemote.class)
    protected TraitementCourrierManagerRemote courriermanager;
     
    public CourrierInterneRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<CourrierInterne, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new CourrierInterne(), new HashMap<String, MetaData>(), new ArrayList<String>());
            MetaColumn workbtn = new MetaColumn("button", "work1", "Distribuer", false, "workflow", null);
            workbtn.setValue("{'model':'kerencourrier','entity':'courrierinterne','method':'distribuer'}");
            workbtn.setStates(new String[]{"etabli","valide"});
//            workbtn.setPattern("btn btn-primary");
           // meta.getHeader().add(workbtn);  
            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
          //  meta.getHeader().add(stautsbar);	              
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
    protected void processBeforeSave(CourrierInterne entity) {
        // TODO Auto-generated method stub
    	 if(entity.getType().equals("1")&&entity.getCourrier()==null){
    		 throw new KerenExecption("Enregistrement impossible<br/>car le courrier arrivéé pas renseigné  !!!"); 
    	 }       
        for(FichierLie fichier:entity.getPiecesjointes()){
             fichier.setId(-1);
        }//end for(FichierLie fichier:entity.getPiecesjointes()){
        entity.setState("etabli");
        entity.setCategorie("2");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
//    @Override
//    public CourrierInterne confirmer(HttpHeaders headers, CourrierInterne entity) {       
//        return manager.confirmer(entity);
//    }

    @Override
	protected void processBeforeUpdate(CourrierInterne entity) {
    	if(!entity.getState().equals("etabli")){
    		 throw new KerenExecption("Modification impossible<br/> Le courrier "+entity.getDesignation()+" est déjà en cours de traitement...");
		}
		super.processBeforeUpdate(entity);
	}
        
        
    @Override
    protected void processAfterUpdate(CourrierInterne entity) {
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
    protected void processAfterSave(CourrierInterne entity) {
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
    public List<CourrierInterne> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
          container.addEq("categorie", "2");
        container.addEq("state", "etabli");
        
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
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
        container.addEq("categorie", "2");
        container.addEq("state", "etabli");
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }

    @Override
    public CourrierInterne save(HttpHeaders headers, CourrierInterne entity) {
        Gson gson = new Gson();
        Long userid = gson.fromJson(headers.getRequestHeader("userid").get(0), Long.class);
       UtilisateurCourrier user = usermanager.getUserByAcompte(userid);
        entity.setSource(user);
        entity.setSowner(user.getService());
        entity.setCategorie("2");
        entity.setState("etabli");
        return super.save(headers, entity); //To change body of generated methods, choose Tools | Templates.
    }

    
	@Override
	public CourrierInterne delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
		CourrierInterne entity = manager.find("id", id);
		try {
			if(!entity.getState().equals("etabli")){
				 throw new KerenExecption("Suppresion impossible<br/> Le courrier "+entity.getDesignation()+" est déjà en cours de traitement...");
			}else{
				// on supprimme l'objet
				super.delete(headers, id);
			}
	

		} catch (Exception ex) {
			throw new KerenExecption(
					"Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
		}

		return entity;
	}
    @Override
    public CourrierInterne distribuer(HttpHeaders headers, CourrierInterne entity) {
        //To change body of generated methods, choose Tools | Templates.
         entity =courriermanager.traiterCourrier(entity);
         return new CourrierInterne(entity);
    }

    
}
