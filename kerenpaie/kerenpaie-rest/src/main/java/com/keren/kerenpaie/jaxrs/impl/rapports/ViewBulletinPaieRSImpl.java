
package com.keren.kerenpaie.jaxrs.impl.rapports;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.keren.kerenpaie.core.ifaces.paie.BulletinPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.rapports.ViewBulletinPaieManagerRemote;
import com.keren.kerenpaie.jaxrs.ifaces.rapports.ViewBulletinPaieRS;
import com.keren.kerenpaie.jaxrs.impl.paie.ReportHelperTrt;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.rapports.ViewBulletinPaie;
import com.keren.kerenpaie.tools.KerenPaieManagerException;
import com.keren.kerenpaie.tools.report.ReportHelper;
import com.keren.kerenpaie.tools.report.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import javax.ws.rs.core.Context;

import net.sf.jasperreports.engine.JRException;


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
    
    @Manager(application = "kerenpaie", name = "BulletinPaieManagerImpl", interf = BulletinPaieManagerRemote.class)
    protected BulletinPaieManagerRemote managerbulletin;

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
	public ViewBulletinPaie save(@Context HttpHeaders headers , ViewBulletinPaie entity) {
		this.buildPdfReport(entity);
		return super.save(headers , entity);
	}

	public String getModuleName() {
        return ("kerenpaie");
    }

    @Override
    public MetaData getMetaData(HttpHeaders headers) {
        return getMetaData(); //To change body of generated methods, choose Tools | Templates.
    }
        
        
    
//    @Override
    public MetaData getMetaData() {
        try {
        	MetaData meta = MetaDataUtil.getMetaData(new ViewBulletinPaie(), new HashMap<String, MetaData>(),new ArrayList<String>());
//		    MetaColumn workbtn = new MetaColumn("button", "work2", "Imprimer les Bulletin de Paie", false, "report", null);
//            workbtn.setValue("{'model':'kerenpaie','entity':'viewbulletinpaie','method':'printbulletin'}");
//            workbtn.setStates(new String[]{"etabli"});
////            workbtn.setPattern("btn btn-primary");
//            meta.getHeader().add(workbtn);
////            workbtn = new MetaColumn("button", "work3", "Annuler", false, "workflow", null);
////            workbtn.setValue("{'model':'kerenpaie','entity':'acompte','method':'annule'}");
////            workbtn.setStates(new String[]{"etabli"});
////            workbtn.setPattern("btn btn-danger");
////            meta.getHeader().add(workbtn);	           
//            MetaColumn stautsbar = new MetaColumn("workflow", "state", "State", false, "statusbar", null);
//            meta.getHeader().add(stautsbar);
		    return meta;
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

        return ReportHelperTrt.getReportParameters();
    }
    
	@Override
	public Response printbulletin(HttpHeaders headers, ViewBulletinPaie bulletin) {
		// TODO Auto-generated method stub
		if (bulletin.getPeriode()==null) {
			throw new KerenExecption("Bien vouloir saisir les paramètres d'impression <br/> ");
		} // end if(entity.getState().trim().equalsIgnoreCase("valide")){
		try {
			return this.buildPdfReport(bulletin);
		} catch (KerenPaieManagerException ex) {
			throw new KerenExecption(ex.getMessage());
		}
	}


    @Override
    public Response buildPdfReport(ViewBulletinPaie bulletin) {
        try {
        	//BulletinPaie entity = new BulletinPaie(bulletin);
        	 // List<BulletinPaie> records =managerbulletin.getCriteres(entity);
        	List<BulletinPaie> records =managerbulletin.getCriteres(new BulletinPaie());
              String URL = ReportHelper.templateURL+ReportsName.BULLETIN_PAIE.getName();
              Map parameters =this.getReportParameters();
              return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, ReportHelperTrt.getBulletintoprint(records));
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
		// TODO Auto-generated method stub
		return null;
	}



}
