package com.kerenedu.jaxrs.impl.report;

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

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewBilanFinancierManagerRemote;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewRecapMoyenneModalRS;
import com.kerenedu.model.report.ViewRecapMoyenneModal;
import com.kerenedu.notes.Bulletin;
import com.kerenedu.notes.BulletinHelperGenerate;
import com.kerenedu.notes.BulletinHelperGenerateManagerRemote;
import com.kerenedu.notes.BulletinManagerRemote;
import com.kerenedu.notes.CoefMatiereDetailManagerRemote;
import com.kerenedu.notes.MatiereNoteManagerRemote;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;

@Path("/viewrecapmoyennemodal")
public class ViewRecapMoyenneModalRSImpl extends AbstractGenericService<ViewRecapMoyenneModal, Long>
		implements ViewRecapMoyenneModalRS {
	
	
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
	
	@Manager(application = "kereneducation", name = "BulletinManagerImpl", interf = BulletinManagerRemote.class)
	protected BulletinManagerRemote managerbulletin;

	public ViewRecapMoyenneModalRSImpl() {
	}

	public MetaData getMetaData(HttpHeaders headers) {
		try {
			return MetaDataUtil.getMetaData(new ViewRecapMoyenneModal(), new HashMap(), new ArrayList());
		} catch (Exception e) {
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
		}
	}

	public GenericManager<ViewRecapMoyenneModal, Long> getManager() {
		return null;
	}

	public String getModuleName() {
		return "kereneducation";
	}

	public Map getReportParameters() {
		return ReportHelperTrt.getReportParameters();
	}

	public Response ficheMoyenneReport(ViewRecapMoyenneModal entity) {
		try {
			String URL = ReportHelper.templateURL + ReportsName.FICHE_MOYENNE_TD.getName();
			List<BulletinHelperGenerate> records = new ArrayList();
			records = managernotebulletin.getCriteres(entity);
			if ((records.isEmpty()) || (records.size() == 0)) {
				throw new KerenExecption("Traitement impossible<br/>Aucunes donnees !");
			}
			Map parameters = getReportParameters();

			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewRecapMoyenneModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewRecapMoyenneModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response ficheMoyenneReportbi(ViewRecapMoyenneModal entity) {
		// TODO Auto-generated method stub
		return this.ficheMoyenneReport(entity);
	}

	@Override
	public Response matrriceMoyenne(ViewRecapMoyenneModal entity) {
		try {
			String URL = ReportHelper.templateURL + ReportsName.FICHE_MOYENNE_TD.getName();
			System.out.println("ViewRecapMoyenneModalRSImpl.matrriceMoyenne() matrice des moyenne "+URL);
			
			List<Bulletin> records = new ArrayList<Bulletin>();
			//List<BulletinHelperGenerate> records = new ArrayList();
			records = managerbulletin.getCriteres(entity);
			if ((records.isEmpty()) || (records.size() == 0)) {
				throw new KerenExecption("Traitement impossible<br/>Aucunes donnees !");
			}
			Map parameters = getReportParameters();

			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(ViewRecapMoyenneModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(ViewRecapMoyenneModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response matrriceMoyennebi(ViewRecapMoyenneModal entity) {
		// TODO Auto-generated method stub
		return this.matrriceMoyenne(entity);
	}
}