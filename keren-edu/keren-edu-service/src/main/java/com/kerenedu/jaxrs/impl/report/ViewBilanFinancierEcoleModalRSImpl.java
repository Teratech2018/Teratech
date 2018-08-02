
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
import com.kerenedu.core.ifaces.report.ViewBilanFinancierEcoleManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewBilanFinancierEcoleModalRS;
import com.kerenedu.model.report.ViewBilanFinancierEcole;
import com.kerenedu.model.report.ViewBilanFinancierEcoleModal;
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
@Path("/viewbilanfinancierecolemodal")
public class ViewBilanFinancierEcoleModalRSImpl
    extends AbstractGenericService<ViewBilanFinancierEcoleModal, Long>
    implements ViewBilanFinancierEcoleModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewBilanFinancierEcoleManagerImpl", interf = ViewBilanFinancierEcoleManagerRemote.class)
    protected ViewBilanFinancierEcoleManagerRemote manager;

    public ViewBilanFinancierEcoleModalRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewBilanFinancierEcoleModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewBilanFinancierEcoleModal, Long> getManager() {
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
	public Response buildPdfReport(ViewBilanFinancierEcoleModal entity) {
		try {
      	  List<ViewBilanFinancierEcole> records =manager.getCriteres(entity);
      	  System.out.println("ViewBilanFinancierEcoleModalRSImpl.buildPdfReport() size record is "+records.size());
            String URL = ReportHelper.templateURL+ReportsName.BILANFINANCIER.getName();
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

}
