
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
import com.kerenedu.core.ifaces.report.ViewListeEleveManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewListeEleveModalRS;
import com.kerenedu.model.report.ViewListeEleve;
import com.kerenedu.model.report.ViewListeEleveModal;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jun 19 10:58:41 WAT 2018
 * 
 */
@Path("/viewlisteelevemodal")
public class ViewListeEleveModalRSImpl
    extends AbstractGenericService<ViewListeEleveModal, Long>
    implements ViewListeEleveModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewListeEleveManagerImpl", interf = ViewListeEleveManagerRemote.class)
    protected ViewListeEleveManagerRemote managerli;

    public ViewListeEleveModalRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewListeEleveModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

    
  

	/**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
   

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
	public Response buildPdfReport(ViewListeEleveModal entity) {
		try {
      	  List<ViewListeEleve> records =managerli.getCriteres(new ViewListeEleve(entity));
      	 if(records==null||records.size()==0){
      		throw new KerenExecption("AUCUNE DONNEES TROUVEES !!!!!");
       	  }
            String URL = ReportHelper.templateURL+ReportsName.LISTE_ELEVE.getName();
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
	public GenericManager<ViewListeEleveModal, Long> getManager() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Response buildPdfReportbi(ViewListeEleveModal entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity);
	}

}
