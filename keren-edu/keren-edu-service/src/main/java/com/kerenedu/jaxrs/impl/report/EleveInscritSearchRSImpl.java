
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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.EleveInscritSearchRS;
import com.kerenedu.model.report.EleveInscritSearch;
import com.kerenedu.model.report.ViewBadgeModal;
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
@Path("/eleveinscritsearch")
public class EleveInscritSearchRSImpl
    extends AbstractGenericService<EleveInscritSearch, Long>
    implements EleveInscritSearchRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
    protected InscriptionManagerRemote manager;

    public EleveInscritSearchRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new EleveInscritSearch(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
    public GenericManager<EleveInscritSearch, Long> getManager() {
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
	public Response buildPdfReport(EleveInscritSearch entity, HttpHeaders headers) {
		try {
			Inscription data = new Inscription();
			String URL = ReportHelper.templateURL + ReportsName.LISTE_INSCRIT.getName();
			data.setCycle(entity.getCycle().getId());
			data.setClasse(entity.getClasse());
			data.setAnneScolaire(CacheMemory.getCurrentannee());
      	  List<Inscription> records =manager.getCriteres(data);
      	if (records.isEmpty() || records.size() == 0) {
			throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionné un eleve !!!");
		}
		Map parameters = this.getReportParameters();
		try {
			if(entity.getCycle().getTypecycle().equals("2")){
				parameters.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytesC());
			}else{
				parameters.put(ReportsParameter.REPORT_IMAGE_REPOSITORY, ReportHelper.getBytes());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
	} catch (FileNotFoundException ex) {
		Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
		Response.serverError().build();
	} catch (JRException ex) {
		Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
	}

	return Response.noContent().build();
  }

	
}
