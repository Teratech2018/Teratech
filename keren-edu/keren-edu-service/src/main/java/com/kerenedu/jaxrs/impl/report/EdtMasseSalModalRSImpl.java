
package com.kerenedu.jaxrs.impl.report;

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
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.core.ifaces.report.ViewMasseSalarialeManagerRemote;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.jaxrs.ifaces.report.EdtMasseSalModalRS;
import com.kerenedu.model.report.EdtBulletinModal;
import com.kerenedu.model.report.EdtMasseSalModal;
import com.kerenedu.model.report.ViewMasseSalariale;
import com.kerenedu.notes.BulletinHelperGenerate;
import com.kerenedu.notes.BulletinHelperGenerateManagerRemote;
import com.kerenedu.notes.Examen;
import com.kerenedu.notes.ExamenManagerRemote;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.BulletinPaieManagerRemote;
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
@Path("/edtmassesalmodal")
public class EdtMasseSalModalRSImpl
    extends AbstractGenericService<EdtMasseSalModal, Long>
    implements EdtMasseSalModalRS
{

	  @Manager(application = "kereneducation", name = "ViewMasseSalarialeManagerImpl", interf = ViewMasseSalarialeManagerRemote.class)
	    protected ViewMasseSalarialeManagerRemote manager;
	  
	    @Manager(application = "kereneducation", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
	    protected BulletinPaieManagerRemote managerbull;

    public EdtMasseSalModalRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
    	try {
			MetaData meta = MetaDataUtil.getMetaData(new EdtMasseSalModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
			MetaColumn workbtn = new MetaColumn("button", "work2", "Imprimer", false, "report", null);
			workbtn.setValue("{'model':'kereneducation','entity':'edtbulletinmodal','method':'pdf'}");
			workbtn.setStates(new String[] { "etabli" });
			
			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(EdtMasseSalModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(EdtMasseSalModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
   	}

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EdtMasseSalModal, Long> getManager() {
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
	public Response buildPdfReport(EdtMasseSalModal entity, HttpHeaders headers) {
		try {

			List<ViewMasseSalariale> records = new ArrayList<ViewMasseSalariale>();
			
			records = manager.getCriteres(entity);
			String URL = ReportHelper.templatepaieURL + ReportsName.MASSE_SAL_GLOBAL.getName();
			Map parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response buildPdfReportbi(EdtMasseSalModal entity, HttpHeaders headers) {
		return this.buildPdfReport(entity, headers);
	}

	@Override
	public Response buildPdfReportDlt(EdtMasseSalModal entity, HttpHeaders headers) {
		try {

			List<BulletinPaie> records = new ArrayList<BulletinPaie>();
			records = managerbull.getCriteres(entity);
			String URL = ReportHelper.templatepaieURL + ReportsName.MASSE_SAL.getName();
			Map parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
		}

		return Response.noContent().build();
	}

	@Override
	public Response buildPdfReportDltbi(EdtMasseSalModal entity, HttpHeaders headers) {
		return this.buildPdfReportDlt(entity, headers);
	}



}
