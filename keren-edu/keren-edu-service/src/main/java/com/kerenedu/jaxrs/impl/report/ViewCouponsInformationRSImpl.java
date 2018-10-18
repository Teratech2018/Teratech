
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import com.kerenedu.core.ifaces.report.ViewBilanServiceEleveManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewCouponsInformationRS;
import com.kerenedu.model.report.ViewBilanServiceEleve;
import com.kerenedu.model.report.ViewBilanServiceModal;
import com.kerenedu.model.report.ViewCouponsInformation;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.kerenedu.tools.reports.ReportsParameter;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jun 19 09:26:19 WAT 2018
 * 
 */
@Path("/viewcouponsinformation")
public class ViewCouponsInformationRSImpl
    extends AbstractGenericService<ViewCouponsInformation, Long>
    implements ViewCouponsInformationRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewBilanFinancierManagerImpl", interf = ViewBilanFinancierManagerRemote.class)
    protected ViewBilanFinancierManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ViewBilanServiceEleveManagerImpl", interf = ViewBilanServiceEleveManagerRemote.class)
    protected ViewBilanServiceEleveManagerRemote managereleve;

    public ViewCouponsInformationRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewCouponsInformation(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
    public GenericManager<ViewCouponsInformation, Long> getManager() {
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
	public Response buildPdfReport(ViewCouponsInformation entity) {
		try {
		entity.setStatut("1");
      	  List<ViewBilanServiceEleve> records =managereleve.getCriteres(entity);
      	  System.out.println("ViewBilanFinancierModalRSImpl.buildPdfReport() size record is "+records.size());
            String URL = ReportHelper.templateURL+ReportsName.COUPONS_INSOLVABLE.getName();
            Map parameters = this.getReportParameters();
			
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
