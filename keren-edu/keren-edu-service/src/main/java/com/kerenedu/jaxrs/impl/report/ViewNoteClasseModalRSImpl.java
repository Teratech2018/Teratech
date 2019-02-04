package com.kerenedu.jaxrs.impl.report;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseManagerRemote;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.core.ifaces.report.ViewBilanFinancierManagerRemote;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.jaxrs.ifaces.report.ViewNoteClasseModalRS;
import com.kerenedu.model.report.ViewNoteClasseModal;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.notes.BulletinHelperGenerateManagerRemote;
import com.kerenedu.notes.CoefMatiereDetailManagerRemote;
import com.kerenedu.notes.MatiereNoteManagerRemote;
import com.kerenedu.notes.Note;
import com.kerenedu.notes.NoteDetail;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import net.sf.jasperreports.engine.JRException;

@Path("/viewnoteclassemodal")
public class ViewNoteClasseModalRSImpl extends AbstractGenericService<ViewNoteClasseModal, Long>
		implements ViewNoteClasseModalRS {
	@Manager(application = "kereneducation", name = "ViewBilanFinancierManagerImpl", interf = ViewBilanFinancierManagerRemote.class)
	protected ViewBilanFinancierManagerRemote manager;
	@Manager(application = "kereneducation", name = "CoefMatiereDetailManagerImpl", interf = CoefMatiereDetailManagerRemote.class)
	protected CoefMatiereDetailManagerRemote managercoef;
	@Manager(application = "kereneducation", name = "MatiereNoteManagerImpl", interf = MatiereNoteManagerRemote.class)
	protected MatiereNoteManagerRemote managernote;
	@Manager(application = "kereneducation", name = "ViewNoteHelperManagerImpl", interf = ViewNoteHelperManagerRemote.class)
	protected ViewNoteHelperManagerRemote managernotehelper;
	@Manager(application = "kereneducation", name = "BulletinHelperGenerateManagerImpl", interf = BulletinHelperGenerateManagerRemote.class)
	protected BulletinHelperGenerateManagerRemote managernotebulletin;
	@Manager(application = "kereneducation", name = "ClasseManagerImpl", interf = ClasseManagerRemote.class)
	protected ClasseManagerRemote managerClasse;

	public ViewNoteClasseModalRSImpl() {
	}

	public MetaData getMetaData(HttpHeaders headers) {
		try {
			return MetaDataUtil.getMetaData(new ViewNoteClasseModal(), new HashMap(), new ArrayList());
		} catch (Exception e) {
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	public GenericManager<ViewNoteClasseModal, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public Map getReportParameters() {
		return ReportHelperTrt.getReportParameters();
	}

	public Response buildPdfReport(ViewNoteClasseModal entity) {
		try {
			List<NoteDetail> records = new ArrayList<NoteDetail>();
			List<NoteDetail> datas = new ArrayList<NoteDetail>();
			String URL = "";
			if(entity.getEleve()!=null&&!entity.getEleve().isEmpty()&&entity.getEleve().size()!=0){
				URL = ReportHelper.templateURL + ReportsName.RELEVE_NOTE_ELEVE.getName();
			}else{
				URL = ReportHelper.templateURL + ReportsName.FICHE_NOTE_TD.getName();
			
				
			}
			datas = managernotehelper.getCriterenote(entity);
			if ((datas.isEmpty()) || (datas.size() == 0)) {
				throw new KerenExecption("Traitement impossible<br/> Aucunes donnees !");
			}
			Map parameters = getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, datas);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewNoteClasseModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewNoteClasseModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response buildPdfReportbi(ViewNoteClasseModal paramViewNoteClasseModal) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(paramViewNoteClasseModal);
	}

	public List<InscriptionChoice> getidclasse(HttpHeaders headers) {
		Gson gson = new Gson();
		long id = ((Long) gson.fromJson((String) headers.getRequestHeader("id").get(0), Long.class)).longValue();
		long iduser = ((Long) gson.fromJson((String) headers.getRequestHeader("userid").get(0), Long.class))
				.longValue();
		if (id > 0L) {
			Classe cls = (Classe) managerClasse.find("id", Long.valueOf(id));
			CacheMemory.insert(iduser, TypeCacheMemory.CLASSE, cls);
		}
		return new ArrayList<InscriptionChoice>();
	}
}