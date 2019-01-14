
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewBulletinManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewBulletinRS;
import com.kerenedu.jaxrs.search.EleveSearchRSImpl;
import com.kerenedu.model.report.ViewBulletin;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Thu Feb 15 15:02:24 CET 2018
 * 
 */
@Path("/viewbulletin")
public class ViewBulletinRSImpl
    extends AbstractGenericService<ViewBulletin, Long>
    implements ViewBulletinRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewBulletinManagerImpl", interf = ViewBulletinManagerRemote.class)
    protected ViewBulletinManagerRemote manager;

    public ViewBulletinRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewBulletin, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
    public MetaData getMetaData() {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new ViewBulletin(), new HashMap<String, MetaData>(),new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<ViewBulletin> getCriteres(ViewBulletin eleveSearch) {
    	  List<ViewBulletin> datas = manager.getCriteres(eleveSearch);
    	  return datas;
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
    public Response buildPdfReport(ViewBulletin eleveSearch) {
        try {
        	  List<ViewBulletin> records =manager.getCriteres(eleveSearch);
              String URL = ReportHelper.templateURL+ReportsName.BULLETIN.getName();
              System.out.println("EleveSearchRSImpl.buildPdfReport() chemin file++++++ "+URL);
              Map parameters =this.getReportParameters();
              return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            Response.serverError().build();
        }catch (JRException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return Response.noContent().build();
    }

	@Override
	public Response buildPdfReportbi(ViewBulletin eleveSearch) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(eleveSearch);
	}

}
