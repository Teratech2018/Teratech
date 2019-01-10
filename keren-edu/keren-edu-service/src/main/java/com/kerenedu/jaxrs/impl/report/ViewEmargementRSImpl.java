
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
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewEmargementManagerRemote;
import com.kerenedu.inscription.ChangeClasse;
import com.kerenedu.jaxrs.ifaces.report.ViewEmargementRS;
import com.kerenedu.model.report.EdtBulletinModal;
import com.kerenedu.model.report.ViewEmargement;
import com.kerenedu.notes.Bulletin;
import com.kerenedu.notes.BulletinHelperGenerate;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Mon Jul 23 15:41:27 WAT 2018
 * 
 */
@Path("/viewemargement")
public class ViewEmargementRSImpl
    extends AbstractGenericService<ViewEmargement, Long>
    implements ViewEmargementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewEmargementManagerImpl", interf = ViewEmargementManagerRemote.class)
    protected ViewEmargementManagerRemote manager;

    public ViewEmargementRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewEmargement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    @Override
	public MetaData getMetaData(HttpHeaders headers) {
		// TODO Auto-generated method stub
		try {
			MetaData meta = MetaDataUtil.getMetaData(new ViewEmargement(), new HashMap<String, MetaData>(),
					new ArrayList<String>());

			return meta;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new WebApplicationException(
					Response.serverError().entity(new String("MetaData parse error")).build());
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
    public Response buildPdfReport(ViewEmargement entity) {
        try {
        	
        	  List<ViewEmargement> records =manager.getCriteres(entity);
        	  System.out.println("ViewEmargementRSImpl.buildPdfReport() record is "+records);
              String URL =ReportHelper.templateURL+ReportsName.EMARGEMENT.getName();
              System.out.println("BulletinRSImpl.buildPdfReport() url is "+URL);
              Map parameters = new HashMap();
              parameters= this.getReportParameters();
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
    public Response buildPdfReportplanning(ViewEmargement entity) {
        try {
        	
        	  List<ViewEmargement> records =manager.getCriteres(entity);
        	  System.out.println("ViewEmargementRSImpl.buildPdfReportplanning() record is "+records);
              String URL =ReportHelper.templateURL+ReportsName.PLANNING_COURS.getName();
              System.out.println("ViewEmargementRSImpl.buildPdfReportplanning() url is "+URL);
              Map parameters = new HashMap();
              parameters= this.getReportParameters();
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
	public Response buildPdfReportbi(ViewEmargement entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity);
	}

	@Override
	public Response buildPdfReportplanningbi(ViewEmargement entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReportplanning(entity);
	}


}
