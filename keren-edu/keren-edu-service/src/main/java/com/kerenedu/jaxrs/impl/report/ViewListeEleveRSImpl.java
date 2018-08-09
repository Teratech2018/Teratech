
package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewListeEleveManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewListeEleveRS;
import com.kerenedu.model.report.ViewAnniversaire;
import com.kerenedu.model.report.ViewListeEleve;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatim.common.annotations.OrderType;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Tue Jun 19 10:58:41 WAT 2018
 * 
 */
@Path("/viewlisteeleve")
public class ViewListeEleveRSImpl
    extends AbstractGenericService<ViewListeEleve, Long>
    implements ViewListeEleveRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "ViewListeEleveManagerImpl", interf = ViewListeEleveManagerRemote.class)
    protected ViewListeEleveManagerRemote manager;

    public ViewListeEleveRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewListeEleve(), new HashMap<String, MetaData>(),new ArrayList<String>());
   		}  catch (Exception e) {
   			// TODO Auto-generated catch block
   			throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
   		} 
   	}

    
    
    @Override
	public List<ViewListeEleve> filter(HttpHeaders headers, List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, Map<String, Object> hints, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
    	List<ViewListeEleve> list = super.filter(headers, predicats, orders, properties, hints, firstResult, maxResult);
    	System.out.println("ViewListeEleveRSImpl.filter() size is "+list.size());
		return list ;
	}

	/**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<ViewListeEleve, Long> getManager() {
        return manager;
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
	public Response buildPdfReport(ViewListeEleve entity) {
		try {
      	  List<ViewListeEleve> records =manager.getCriteres(entity);
      	 if(records.size()==0){
       		throw new KerenExecption("Aucune Données Trouvés !!!");
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


}
