
package com.keren.courrier.jaxrs.impl.archivage;

import java.util.ArrayList;
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
import com.keren.courrier.core.ifaces.archivage.ArchiveDossierManagerRemote;
import com.keren.courrier.core.ifaces.courrier.CourrierCloneManagerRemote;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.core.ifaces.traitement.ClassementActionManagerRemote;
import com.keren.courrier.jaxrs.ifaces.archivage.ArchiveDossierRS;
import com.keren.courrier.model.archivage.ArchiveDossier;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import com.megatimgroup.generic.jax.rs.layer.impl.RSNumber;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Aug 23 09:56:40 WAT 2018
 * 
 */
@Path("/archivedossier")
public class ArchiveDossierRSImpl
    extends AbstractGenericService<ArchiveDossier, Long>
    implements ArchiveDossierRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencourrier", name = "ArchiveDossierManagerImpl", interf = ArchiveDossierManagerRemote.class)
    protected ArchiveDossierManagerRemote manager;
    
    @Manager(application = "kerencourrier", name = "ClassementActionManagerImpl", interf = ClassementActionManagerRemote.class)
    protected ClassementActionManagerRemote managercls;
    
    @Manager(application = "kerencourrier", name = "UtilisateurCourrierManagerImpl", interf = UtilisateurCourrierManagerRemote.class)
    protected UtilisateurCourrierManagerRemote usermanager;
    

    @Manager(application = "kerencourrier", name = "CourrierCloneManagerImpl", interf =CourrierCloneManagerRemote.class)
    protected CourrierCloneManagerRemote courriermanager;



    public ArchiveDossierRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ArchiveDossier, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencourrier");
    }
    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        MetaData meta = null;
        try {
            meta = MetaDataUtil.getMetaData(new ArchiveDossier(), new HashMap<String, MetaData>(), new ArrayList<String>());
               } catch (InstantiationException ex) {
            Logger.getLogger(ArchiveDossierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ArchiveDossierRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return meta; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    protected void processBeforeSave(ArchiveDossier entity) {     
    	entity.setNature("dossier");
        for(FichierLie fichier:entity.getPiecesjointes()){
             fichier.setId(-1);
        }//end for(FichierLie fichier:entity.getPiecesjointes()){
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    
	public ArchiveDossier delete(@Context HttpHeaders headers, Long id) {

		// TODO Auto-generated method stub
    	ArchiveDossier entity = manager.find("id", id);
		try {
			
				// on supprimme l'objet
				super.delete(headers, id);
		} catch (Exception ex) {
			throw new KerenExecption(
					"Suppresion impossible<br/>car cet objet est deja en cours d'utilisation par d'autres objets");
		}

		return entity;
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
         container.addEq("nature", "dossier");
        RSNumber number = new RSNumber(getManager().count(container.getPredicats()));
//        System.out.println(AbstractGenericService.class.toString()+".count === "+" == "+number.getValue());
        return number;
    }
    
    
    
    @Override
    public List<ArchiveDossier> filter(HttpHeaders headers, int firstResult, int maxResult) {
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
        container.addEq("nature", "dossier");
        //List result = new ArrayList();
        return getManager().filter(container.getPredicats(), null , new HashSet<String>(), firstResult, maxResult);
    }
    @Override
	public List<FichierLie> findpiecejointe(HttpHeaders headers) {

		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		return courriermanager.findfichier(id);
	}
	
 
   
//    @Override
//    protected void processAfterUpdate(ArchiveDossier entity) {
//         //To change body of generated methods, choose Tools | Templates.
//        for(FichierLie elt:entity.getPiecesjointes()){
//            File file = new File(FileHelper.getTemporalDirectory().getPath()+File.separator+elt.getFilename());
//            if(file.exists()){
//                File destfile = new File(FileHelper.getStaticDirectory().getPath());
//                boolean result = true;
//                if(!destfile.exists()){
//                    result = destfile.mkdir();
//                }//end if(!destfile.exists()){
//                if(result){
//                    try {
//                        destfile = new File(destfile.getPath()+File.separator+elt.getFilename());
//                        FileHelper.moveFile(file, destfile);
//                    } //end if(result){
//                    catch (IOException ex) {
//                        throw new KerenExecption(ex.getMessage());
//                    }
//                }
//            }//end if(file.exists()){
//        }//end for(FichierLie elt:entity.getPiecesjointes()){
//        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    protected void processAfterSave(ArchiveDossier entity) {
//        //To change body of generated methods, choose Tools | Templates.
//        for(FichierLie elt:entity.getPiecesjointes()){
//            File file = new File(FileHelper.getTemporalDirectory().getPath()+File.separator+elt.getFilename());
//            if(file.exists()){
//                File destfile = new File(FileHelper.getStaticDirectory().getPath());
//                boolean result = true;
//                if(!destfile.exists()){
//                    result = destfile.mkdir();
//                }//end if(!destfile.exists()){
//                if(result){
//                    try {
//                        destfile = new File(destfile.getPath()+File.separator+elt.getFilename());
//                        FileHelper.moveFile(file, destfile);
//                    } //end if(result){
//                    catch (IOException ex) {
//                        throw new KerenExecption(ex.getMessage());
//                    }
//                }
//            }//end if(file.exists()){
//        }//end for(FichierLie elt:entity.getPiecesjointes()){
//        super.processAfterSave(entity); 
//    }


}
