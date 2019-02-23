
package com.kerenedu.notes;

import java.io.FileNotFoundException;
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
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.jaxrs.impl.report.ReportHelperTrt;
import com.kerenedu.jaxrs.impl.report.ViewBulletinRSImpl;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 10:23:11 CET 2018
 * 
 */
@Path("/matierenote")
public class MatiereNoteRSImpl
    extends AbstractGenericService<MatiereNote, Long>
    implements MatiereNoteRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "MatiereNoteManagerImpl", interf = MatiereNoteManagerRemote.class)
    protected MatiereNoteManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "NoteDetailManagerImpl", interf =NoteDetailManagerRemote.class)
    protected NoteDetailManagerRemote managernote;

    public MatiereNoteRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<MatiereNote, Long> getManager() {
        return manager;
    }

    

	public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			MetaData meta = MetaDataUtil.getMetaData(new MatiereNote(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
  			MetaColumn workbtn = new MetaColumn("button", "work2", "Fiche des notes", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'matierenote','method':'pdf'}");
			workbtn.setStates(new String[] { "crée" });
			
			meta.getHeader().add(workbtn);
			workbtn = new MetaColumn("button", "work1", "Importer les notes ", false, "action", null);
			workbtn.setValue("{'name':'keren_education_importnote',template:{'prof':'object.prof','matiere':'object.matiere','examen':'object.examen','classe':'object.classe','idmat':'object.id'}}");
			workbtn.setStates(new String[] { "etabli" });
			// workbtn.setPattern("btn btn-primary");
			//meta.getHeader().add(workbtn);
  			
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
    
    /**
	 * Methode permettant de retourner les parametres pour le reporting
	 *
	 * @return java.util.Map
	 */
	public Map getReportParameters() {
		Map param = ReportHelperTrt.getReportParameters();

		return param;
	}

	@Override
	public Response ficheNoteReport(MatiereNote entity) {
		try {
			String URL = ReportHelper.templateURL + ReportsName.FICHE_NOTE.getName();
			List<NoteDetail> records = new ArrayList<NoteDetail>();
			records=entity.getNotelisttr();
			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionner un eleve !");
			}
			Map parameters = this.getReportParameters();
			// parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response fichesNoteReport(MatiereNote entity) {
		try {
			String URL = ReportHelper.templateURL + ReportsName.FICHE_NOTE.getName();
			List<NoteDetail> records = new ArrayList<NoteDetail>();
			records=entity.getNotelisttr();
			//records.add(entity);
			if (records.isEmpty() || records.size() == 0) {
				throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionner un eleve !");
			}
			Map parameters = this.getReportParameters();
				// parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}
	
	@Override
	public List<NoteDetail> findeleveclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id = gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		long idclasse = gson.fromJson(headers.getRequestHeader("classe").get(0), Long.class);
		return managernote.findeleve(idclasse);
	}

//	@Override
//	protected void processBeforeSave(MatiereNote entity) {
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
//  		 container.addEq("classe.id", entity.getClasse().getId());
//  		container.addEq("examen.id", entity.getExamen().getId());
//  		container.addEq("matiere.id", entity.getMatiere().getId());
//  		 List<MatiereNote>records = manager.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
//  		 if(records!=null&& records.size()>0){
//  			throw new KerenExecption("Matiere  déjà été Pris en compte pour cet examen verifier la liste  !!!");
//  		 }
//		super.processBeforeSave(entity);
//	}
//
//	@Override
//	protected void processBeforeUpdate(MatiereNote entity) {
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
// 		 container.addEq("classe.id", entity.getClasse().getId());
// 		container.addEq("examen.id", entity.getExamen().getId());
// 		container.addEq("matiere.id", entity.getMatiere().getId());
// 		 List<MatiereNote>records = manager.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
// 		 if(records!=null&& records.size()>0){
// 			throw new KerenExecption("Matiere  déjà été Pris en compte pour cet examen verifier la liste  !!!");
// 		 }
//		super.processBeforeUpdate(entity);
//	}
	
	@Override
	public List<MatiereNote> filter(HttpHeaders arg0, int arg1, int arg2) {
		// TODO Auto-generated method stub
		Gson gson = new Gson();
		long id = gson.fromJson(arg0.getRequestHeader("userid").get(0), Long.class);
		RestrictionsContainer container = filterPredicatesBuilder(arg0,arg1,arg2);
		//PeriodeScolaire periode = (PeriodeScolaire) CacheMemory.getValue(id, TypeCacheMemory.EXAMEN);
		Classe classe = (Classe) CacheMemory.getValue(id, TypeCacheMemory.CLASSE);
		Examen examen = (Examen) CacheMemory.getValue(id, TypeCacheMemory.EXAMEN);
		//Professeur prof = CacheMemory.getProf();
		 container = RestrictionsContainer.newInstance();
		if (examen != null) {
			container.addEq("examen.id", examen.getId());
		} // end if(periode!=null)
		if (classe != null) {
			container.addEq("classe.id", classe.getId());
		} // end if(classe!=null)
//		if (prof != null) {
//			container.addEq("prof.id", prof.getId());
//		} // end if(classe!=null)
		return getManager().filter(container.getPredicats(), null, new HashSet<String>(), arg1, arg2);
	}
	
	
	


}
