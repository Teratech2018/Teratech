
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
import com.kerenedu.core.ifaces.report.ViewBilanServiceEleveManagerRemote;
import com.kerenedu.core.ifaces.report.ViewRetardPaiementManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewRetardPaiementRS;
import com.kerenedu.model.report.ViewBilanServiceEleve;
import com.kerenedu.model.report.ViewRetardPaiement;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jun 19 11:37:46 WAT 2018
 * 
 */
@Path("/viewretardpaiement")
public class ViewRetardPaiementRSImpl
    extends AbstractGenericService<ViewRetardPaiement, Long>
    implements ViewRetardPaiementRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewRetardPaiementManagerImpl", interf = ViewRetardPaiementManagerRemote.class)
    protected ViewRetardPaiementManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "ViewBilanServiceEleveManagerImpl", interf = ViewBilanServiceEleveManagerRemote.class)
    protected ViewBilanServiceEleveManagerRemote managereleve;

    public ViewRetardPaiementRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewRetardPaiement(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
    public GenericManager<ViewRetardPaiement, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    public Map getReportParameters() {
    	   
        return ReportHelperTrt.getReportParameters();
    }


@Override
public Response buildPdfReport(ViewRetardPaiement entity) {
	try {
  	  List<ViewBilanServiceEleve> records =managereleve.getCriteresRetard(entity);
  	  if(records.size()==0){
  		throw new KerenExecption("Aucune Données Trouvés !!!");
  	  }
        String URL = ReportHelper.templateURL+ReportsName.RETARD_PAIELMENT.getName();
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
public Response buildPdfReportbi(ViewRetardPaiement entity) {
	// TODO Auto-generated method stub
	return this.buildPdfReport(entity);
}

}
