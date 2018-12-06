
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewBulletinPaieHelperManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.EdtPeriodeModalRS;
import com.kerenedu.model.report.EdtPeriodeModal;
import com.kerenedu.model.report.ViewBulletinPaieHelper;
import com.kerenedu.solde.BulletinPaie;
import com.kerenedu.solde.BulletinPaieManagerRemote;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
@Path("/edtperiodemodal")
public class EdtPeriodeModalRSImpl
    extends AbstractGenericService<EdtPeriodeModal, Long>
    implements EdtPeriodeModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
    protected BulletinPaieManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ViewBulletinPaieHelperManagerImpl", interf = ViewBulletinPaieHelperManagerRemote.class)
    protected ViewBulletinPaieHelperManagerRemote managerview;
    


    public EdtPeriodeModalRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
    	try {
			MetaData meta = MetaDataUtil.getMetaData(new EdtPeriodeModal(), new HashMap<String, MetaData>(),
					new ArrayList<String>());
		
			return meta;
		} catch (InstantiationException ex) {
			Logger.getLogger(EdtPeriodeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			Logger.getLogger(EdtPeriodeModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
   	}

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<EdtPeriodeModal, Long> getManager() {
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
	   
	        return ReportHelperTrt.getReportParametersSolde();
	    }


	@Override
	public Response buildPdfReport(EdtPeriodeModal entity , @Context HttpHeaders headers) {
		 try {
         	
			List<BulletinPaie> records = new ArrayList<BulletinPaie>();
			records = manager.getCriteres(entity);
			String URL = ReportHelper.templatepaieURL + ReportsName.BULLETIN_PAIE.getName();
			Map parameters = this.getReportParameters();
			return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters,
					records);
		} catch (FileNotFoundException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			Response.serverError().build();
		} catch (JRException ex) {
			Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
		}
  
         return Response.noContent().build();
  }

	@Override
	public Response virementsalaire(EdtPeriodeModal entity, HttpHeaders headers) {
		 try {
	         	
				List<ViewBulletinPaieHelper> records = new ArrayList<ViewBulletinPaieHelper>();
				records = managerview.getCriteres(entity);
				String URL = ReportHelper.templatepaieURL + ReportsName.VIREMENT.getName();
				Map parameters = this.getReportParameters();
				return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters,
						records);
			} catch (FileNotFoundException ex) {
				Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
				Response.serverError().build();
			} catch (JRException ex) {
				Logger.getLogger(BulletinPaie.class.getName()).log(Level.SEVERE, null, ex);
			}
	  
	         return Response.noContent().build();
	}

	@Override
	public Response caissesalaire(EdtPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response retenuesSalaires(EdtPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response pieceBancaire(EdtPeriodeModal entity, HttpHeaders headers) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
