
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
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
import com.kerenedu.configuration.ClasseManagerRemote;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.jaxrs.ifaces.report.EdtBulletinModalRS;
import com.kerenedu.model.report.EdtBulletinModal;
import com.kerenedu.notes.BulletinHelperGenerate;
import com.kerenedu.notes.BulletinHelperGenerateManagerRemote;
import com.kerenedu.notes.Examen;
import com.kerenedu.notes.ExamenManagerRemote;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
@Path("/edtbulletinmodal")
public class EdtBulletinModalRSImpl
    extends AbstractGenericService<EdtBulletinModal, Long>
    implements EdtBulletinModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BulletinHelperGenerateManagerImpl", interf = BulletinHelperGenerateManagerRemote.class)
    protected BulletinHelperGenerateManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ClasseManagerImpl", interf = ClasseManagerRemote.class)
    protected ClasseManagerRemote managerClasse;
    
    @Manager(application = "kereneducation", name = "ExamenManagerImpl", interf = ExamenManagerRemote.class)
    protected ExamenManagerRemote managerExamen;

    public EdtBulletinModalRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
    	try {
			MetaData meta = MetaDataUtil.getMetaData(new EdtBulletinModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work2", "Imprimer", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'edtbulletinmodal','method':'pdf'}");
			workbtn.setStates(new String[] { "etabli" });
			//// workbtn.setPattern("btn btn-primary");
			// meta.getHeader().add(workbtn);
			//// workbtn = new MetaColumn("button", "work3", "Annuler", false,
			//// "workflow", null);
			//// workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
			//// workbtn.setStates(new String[]{"etabli"});
			//// workbtn.setPattern("btn btn-danger");
			//meta.getHeader().add(workbtn);
			//MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
			//meta.getHeader().add(stautsbar);
			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(EdtBulletinModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(EdtBulletinModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
   	}

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EdtBulletinModal, Long> getManager() {
        return null;
    }

    public String getModuleName() {
        return ("kereneducation");
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
	public Response buildPdfReport(EdtBulletinModal entity , @Context HttpHeaders headers) {
		try {
			System.out.println("EdtBulletinModalRSImpl.buildPdfReport() je suis ici ");
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			String URL = "";
			Map parameters = null ;
			if(entity.getTypebulletin().equals("6")){
				
				container.addEq("typesequence", "0");	
				Examen exam= managerExamen.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0).get(0);
				entity.getExamens().add(exam);
				container = RestrictionsContainer.newInstance();
				container.addEq("typesequence", "1");	
				Examen exam1= managerExamen.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0).get(0);
				entity.getExamens().add(exam1);
				URL = ReportHelper.templateURL+ReportsName.BULLTRIM.getName();
				parameters =this.getReportParameters() ;
				parameters.put(ReportsParameter.TITRE_BULL,"BULLETIN TRIMESTRIEL N°1");
				parameters.put(ReportsParameter.TRIMESTRE,"1");
//				throw new KerenExecption("Edition du Bulletin Trimestriel encours .....!");
			}else if(entity.getTypebulletin().equals("7")){
//				container.addEq("typesequence", "2");	
//				Examen exam= managerExamen.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0).get(0);
//				entity.getExamens().add(exam);
//				container = RestrictionsContainer.newInstance();
//				container.addEq("typesequence", "3");	
//				Examen exam1= managerExamen.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0).get(0);
//				entity.getExamens().add(exam1);
//				URL = ReportHelper.templateURL+ReportsName.BULLTRIM.getName();
//				parameters =this.getReportParameters() ;
//				parameters.put(ReportsParameter.TITRE_BULL,"BULLETIN TRIMESTRIEL N°2");
//				parameters.put(ReportsParameter.TRIMESTRE,"2");
				throw new KerenExecption("Edition du Bulletin Trimestriel encours .....!");
			}else if(entity.getTypebulletin().equals("8")){
//				container.addEq("typesequence", "4");	
//				Examen exam= managerExamen.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0).get(0);
//				entity.getExamens().add(exam);
//				container = RestrictionsContainer.newInstance();
//				container.addEq("typesequence", "5");	
//				Examen exam1= managerExamen.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0).get(0);
//				entity.getExamens().add(exam1);
//				URL = ReportHelper.templateURL+ReportsName.BULLTRIM.getName();
//				parameters =this.getReportParameters() ;
//				parameters.put(ReportsParameter.TITRE_BULL,"BULLETIN TRIMESTRIEL N°3");
//				parameters.put(ReportsParameter.TRIMESTRE,"3");
				throw new KerenExecption("Edition du Bulletin Trimestriel encours .....!");
			}else{
				System.out.println("EdtBulletinModalRSImpl.buildPdfReport()type de bulletin  "+entity.getTypebulletin());
				container.addEq("typesequence", entity.getTypebulletin());	
				List<Examen> examlist= managerExamen.filter(container.getPredicats(), null,new HashSet<String>(), -1, 0);
				if(examlist==null){
					 throw new KerenExecption("Examen inexistant");
				}
				if(examlist!=null){
					entity.getExamens().add(examlist.get(0));
				}
			
				URL = ReportHelper.templateURL+ReportsName.BULLSEQUENTIEL.getName();
				parameters =this.getReportParameters() ;
				System.out.println("EdtBulletinModalRSImpl.buildPdfReport() je suis ici examen trouve etat a imprimé"+URL);
			}
      	  List<BulletinHelperGenerate> records =manager.getCriteres(entity);
      	  System.out.println("EdtBulletinModalRSImpl.buildPdfReport() size records is "+records.size());
            if(records.isEmpty()||records.size()==0){
            	throw new KerenExecption("Note pas encore saisir pour cette séquence !");
            }
          
            return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
      } catch (FileNotFoundException ex) {
          Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
          Response.serverError().build();
      }catch (JRException ex) {
          Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
      }

      return Response.noContent().build();
  }

	@Override
	public List<Inscription> getidclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		if(id>0){
			Classe cls = managerClasse.find("id", id);
			CacheMemory.setClasse(cls);
		}
		return null;
	}

}
