
package com.keren.kerenpaie.jaxrs.impl.rapports;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.core.ifaces.rapports.ViewBulletinPaieManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.rapports.ViewBulletinPaieRS;
import com.keren.kerenpaie.model.rapports.ViewBulletinPaie;
import com.keren.kerenpaie.tools.report.ReportHelper;
import com.keren.kerenpaie.tools.report.ReportsName;
import com.keren.kerenpaie.tools.report.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.base.JRBaseParameter;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Fri Apr 06 09:41:44 WAT 2018
 * 
 */
@Path("/viewbulletinpaie")
public class ViewBulletinPaieRSImpl
    extends AbstractGenericService<ViewBulletinPaie, Long>
    implements ViewBulletinPaieRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerenpaie", name = "ViewBulletinPaieManagerImpl", interf = ViewBulletinPaieManagerRemote.class)
    protected ViewBulletinPaieManagerRemote manager;

    public ViewBulletinPaieRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewBulletinPaie, Long> getManager() {
        return manager;
    }

    @Override
	public ViewBulletinPaie save(ViewBulletinPaie entity) {
		this.buildPdfReport(entity);
		return super.save(entity);
	}

	public String getModuleName() {
        return ("kerenpaie");
    }
    
    @Override
    public MetaData getMetaData() {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new ViewBulletinPaie(), new HashMap<String, MetaData>(),new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(ViewBulletinPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(ViewBulletinPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Methode permettant de retourner les parametres pour le reporting
     *
     * @return java.util.Map
     */
    public Map getReportParameters() {
        Map params = new HashMap();
        params.put(ReportsParameter.ETB,"UCAC");
        params.put(ReportsParameter.ANNEE_SCOLAIRE, "2017");
        params.put(ReportsParameter.REPORT_USER,"BEKO");

        // On positionne la locale
        params.put(JRBaseParameter.REPORT_LOCALE, Locale.FRENCH);
        // Construction du Bundle
        ResourceBundle bundle = ReportHelper.getInstace();
        // Ajout du bundle dans les parametres
        params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);

        return params;
    }


    @Override
    public Response buildPdfReport(ViewBulletinPaie bulletin) {
        try {
        	  bulletin.setPeriode(CacheMemory.getPeriode());
        	  List<ViewBulletinPaie> records =manager.getCriteres(bulletin);
              String URL = ReportHelper.templateURL+ReportsName.BULLETIN_PAIE.getName();
              System.out.println("EleveSearchRSImpl.buildPdfReport() chemin file++++++ "+URL);
              Map parameters = new HashMap();
              return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ViewBulletinPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            Response.serverError().build();
        }catch (JRException ex) {
            Logger.getLogger(ViewBulletinPaieRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return Response.noContent().build();
    }

	@Override
	public List<ViewBulletinPaie> getCriteres(ViewBulletinPaie bulletin) {
		  List<ViewBulletinPaie> datas = manager.getCriteres(bulletin);
    	  return datas;
	}

}
