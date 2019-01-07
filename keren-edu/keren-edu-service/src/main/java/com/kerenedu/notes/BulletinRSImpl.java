
package com.kerenedu.notes;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.core.ifaces.report.ViewBulletinManagerRemote;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.model.report.EdtBulletinModal;
import com.kerenedu.tools.KerenEduManagerException;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 12:46:28 CET 2018
 * 
 */
@Path("/bulletin")
public class BulletinRSImpl
    extends AbstractGenericService<Bulletin, Long>
    implements BulletinRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BulletinManagerImpl", interf = BulletinManagerRemote.class)
    protected BulletinManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ViewBulletinManagerImpl", interf = ViewBulletinManagerRemote.class)
    protected ViewBulletinManagerRemote viewmanager;
    
    @Manager(application = "kereneducation", name = "BulletinHelperGenerateManagerImpl", interf = BulletinHelperGenerateManagerRemote.class)
    protected BulletinHelperGenerateManagerRemote managerbullview;
    
    @Manager(application = "kereneducation", name = "BulletinHelperGeneratePrimaireManagerImpl", interf = BulletinHelperGeneratePrimaireManagerRemote.class)
    protected BulletinHelperGeneratePrimaireManagerRemote managerbp;

    public BulletinRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Bulletin, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  					
			MetaData meta =  MetaDataUtil.getMetaData(new Bulletin(), new HashMap<String, MetaData>(),new ArrayList<String>());
			  MetaColumn workbtn = new MetaColumn("button", "work1", "Decision Conseil", false, "object", null);
	            workbtn.setValue("{'model':'kereneducation','entity':'bulletin','method':'decision','template':{'this':'object'}}");
	            workbtn.setStates(new String[]{"etabli"});
	            workbtn.setPattern("btn btn-danger");
	           // meta.getHeader().add(workbtn);
	            workbtn = new MetaColumn("button", "work2", "Imprimer le Bulletin ", false, "report", null);
	            workbtn.setValue("{'model':'kereneducation','entity':'bulletin','method':'printbulletin','template':{'this':'object'}}");
	            workbtn.setStates(new String[]{"etabli"});
	        //    workbtn.setPattern("btn btn-primary");
	            meta.getHeader().add(workbtn);
//	            workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
//	            workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
//	            workbtn.setStates(new String[]{"etabli"});
//	            workbtn.setPattern("btn btn-danger");
//	            meta.getHeader().add(workbtn);	           
	            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
	            meta.getHeader().add(stautsbar);
  			return meta;
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}
    
	@Override
	public Bulletin decision(HttpHeaders headers, Bulletin entity) {
		// TODO Auto-generated method stub
		if(entity.getState().trim().equalsIgnoreCase("valide")){
			throw new KerenExecption("Ce bulletin a déjà fait l'objet d'une validation <br/> et par conséquent tout validation est  interdite");
		}//end if(entity.getState().trim().equalsIgnoreCase("valide")){
		try{
		  return new Bulletin();
		}catch(KerenEduManagerException ex){
			throw new KerenExecption(ex.getMessage());
		}
	}
	

	@Override
	public Response printbulletin(HttpHeaders headers, Bulletin bulletin) {
		// TODO Auto-generated method stub
		if (bulletin.getEleve()==null) {
			throw new KerenExecption("Ce bulletin est nulle <br/> ");
		} // end if(entity.getState().trim().equalsIgnoreCase("valide")){
		try {
			return this.buildPdfReport(bulletin);
		} catch (KerenEduManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
	}
	
	@Override
	public Response printbulletinbi(HttpHeaders headers, Bulletin bulletin) {
		// TODO Auto-generated method stub
		if (bulletin.getEleve()==null) {
			throw new KerenExecption("Ce bulletin est nulle <br/> ");
		} // end if(entity.getState().trim().equalsIgnoreCase("valide")){
		try {
			return this.buildPdfReport(bulletin);
		} catch (KerenEduManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
	}
	
	/**
     * Methode permettant de retourner les parametres pour le reporting
     *
     * @return java.util.Map
     */
	 public Map getReportParameters() {
	   

	        return ReportHelperTrt.getReportParameters();
	    }


    @Override
    public Response buildPdfReport(Bulletin bulletin) {
        try {
        	  String URL ="";  Map parameters = new HashMap();
        /*	if(bulletin.getClasse().getTypecycle().equals("1")){
        		System.out.println("BulletinRSImpl.buildPdfReport() BULLETIN PRIMAIRE"+bulletin.getClasse().getTypecycle());
        		 List<BulletinHelperGeneratePrimaire> records =managerbp.getCriteres(bulletin);
           	  System.out.println("BulletinRSImpl.buildPdfReport() record is "+records);
                  URL =ReportHelper.templateURL+ReportsName.BULLSEQUENTIEL_PRIMAIRE.getName();
                 System.out.println("BulletinRSImpl.buildPdfReport() url is "+URL);
               
                 parameters= this.getReportParameters();
                 List<BulletinHelperGeneratePrimaire> datas = new ArrayList<BulletinHelperGeneratePrimaire>();
                 for(BulletinHelperGeneratePrimaire bull:records){
               	  if (bull.getEleve().getImage() != null) {
               		  bull.setPhoto(ReportHelper.getPhotoBytesEleve(bull.getEleve().getImage()));
               	  }
               	  datas.add(bull);
                 }
                 return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, datas);
        	}else if(bulletin.getClasse().getTypecycle().equals("1")){*/
        		System.out.println("BulletinRSImpl.buildPdfReport() BULLETIN Secondaire"+bulletin.getClasse().getTypecycle());
        		 List<BulletinHelperGenerate> records =managerbullview.getCriteres(bulletin);
           	  System.out.println("BulletinRSImpl.buildPdfReport() record is "+records);
                  URL =ReportHelper.templateURL+ReportsName.BULLSEQUENTIEL.getName();
                 System.out.println("BulletinRSImpl.buildPdfReport() url is "+URL);
                 parameters= this.getReportParameters();
                 List<BulletinHelperGenerate> datas = new ArrayList<BulletinHelperGenerate>();
                 for(BulletinHelperGenerate bull:records){
               	  if (bull.getEleve().getImage() != null) {
               		  bull.setPhoto(ReportHelper.getPhotoBytesEleve(bull.getEleve().getImage()));
               	  }
               	  datas.add(bull);
                 }
                 return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, datas);
        	//}
         } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            Response.serverError().build();
        }catch (JRException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
 
        return Response.noContent().build();
    }
    
    @Override
    public Response buildPdfReportbi(Bulletin bulletin) {
        try {
        	  String URL ="";  Map parameters = new HashMap();
        /*	if(bulletin.getClasse().getTypecycle().equals("1")){
        		System.out.println("BulletinRSImpl.buildPdfReport() BULLETIN PRIMAIRE"+bulletin.getClasse().getTypecycle());
        		 List<BulletinHelperGeneratePrimaire> records =managerbp.getCriteres(bulletin);
           	  System.out.println("BulletinRSImpl.buildPdfReport() record is "+records);
                  URL =ReportHelper.templateURL+ReportsName.BULLSEQUENTIEL_PRIMAIRE.getName();
                 System.out.println("BulletinRSImpl.buildPdfReport() url is "+URL);
               
                 parameters= this.getReportParameters();
                 List<BulletinHelperGeneratePrimaire> datas = new ArrayList<BulletinHelperGeneratePrimaire>();
                 for(BulletinHelperGeneratePrimaire bull:records){
               	  if (bull.getEleve().getImage() != null) {
               		  bull.setPhoto(ReportHelper.getPhotoBytesEleve(bull.getEleve().getImage()));
               	  }
               	  datas.add(bull);
                 }
                 return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, datas);
        	}else if(bulletin.getClasse().getTypecycle().equals("1")){*/
        		System.out.println("BulletinRSImpl.buildPdfReport() BULLETIN Secondaire"+bulletin.getClasse().getTypecycle());
        		 List<BulletinHelperGenerate> records =managerbullview.getCriteres(bulletin);
           	  System.out.println("BulletinRSImpl.buildPdfReport() record is "+records);
                  URL =ReportHelper.templateURL+ReportsName.BULLSEQUENTIEL.getName();
                 System.out.println("BulletinRSImpl.buildPdfReport() url is "+URL);
                 parameters= this.getReportParameters();
                 List<BulletinHelperGenerate> datas = new ArrayList<BulletinHelperGenerate>();
                 for(BulletinHelperGenerate bull:records){
               	  if (bull.getEleve().getImage() != null) {
               		  bull.setPhoto(ReportHelper.getPhotoBytesEleve(bull.getEleve().getImage()));
               	  }
               	  datas.add(bull);
                 }
                 return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, datas);
        	//}
         } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            Response.serverError().build();
        }catch (JRException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
 
        return Response.noContent().build();
    }
    

	@Override
	public List<Bulletin> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		Classe classe = (Classe) CacheMemory.getValue(id, TypeCacheMemory.CLASSE);
		Filiere filiere = (Filiere) CacheMemory.getValue(id, TypeCacheMemory.FILLIERE);
		Examen examen = (Examen) CacheMemory.getValue(id, TypeCacheMemory.EXAMEN);

		if (classe != null) {
			container.addEq("classe.id", classe.getId());
		} // end if(classe!=null)

		if (filiere != null) {
			container.addEq("classe.filiere.id", filiere.getId());
		} // end if(mdl!=null)
		
		if (classe != null) {
			container.addEq("model.id", examen.getId());
		} // end if(classe!=null)

		
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}
	

}
