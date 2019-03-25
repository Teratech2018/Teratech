
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
import com.google.gson.Gson;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewBadgeModalRS;
import com.kerenedu.model.report.ViewBadgeModal;
import com.kerenedu.notes.CoefMatiereDetail;
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
@Path("/viewbadgemodal")
public class ViewBadgeModalRSImpl
    extends AbstractGenericService<ViewBadgeModal, Long>
    implements ViewBadgeModalRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf = InscriptionManagerRemote.class)
    protected InscriptionManagerRemote manager;

    public ViewBadgeModalRSImpl() {
        super();
    }
    
    @Override
   	public MetaData getMetaData(HttpHeaders headers) {
   		// TODO Auto-generated method stub
   		try {
   			return MetaDataUtil.getMetaData(new ViewBadgeModal(), new HashMap<String, MetaData>(),new ArrayList<String>());
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
    public GenericManager<ViewBadgeModal, Long> getManager() {
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
	public Response buildPdfReport(ViewBadgeModal entity) {
		try {
      	  List<Inscription> records =manager.getCriteres(new Inscription(entity));
      	 List<Inscription> datas = new ArrayList<Inscription>();
      	if(datas==null||datas.size()==0){
      		throw new KerenExecption("AUCUNES DONNEES TROUVEES !!");
      	}
            String URL = ReportHelper.templateURL+ReportsName.BADGE.getName();
        	Map parameters = this.getReportParameters();
            for(Inscription i : records){
            	System.out.println("ViewBadgeModalRSImpl.buildPdfReport() section type "+i.getClasse().getSection().getTypesection());
    			if (i.getEleve().getImage() != null) {
    				try {
    					//i.setPhoto(ReportHelper.getPhotoBytes(i.getEleve().getImage()));
//    					String m= i.getEleve().getMatricule();
//    					String matricule= m.substring(0, m.length()-5);
//    					if(i.getEleve().getImage()==null){
    					i.setPhoto(ReportHelper.getPhotoBytesEleve(i.getEleve().getImage()));
//    					}else{
//    						i.setPhoto(ReportHelper.getPhotoBytes(i.getEleve().getImage()));
//    					}
//    				//	i.setPhotostream(ReportHelper.getPhotoBytesstream(matricule+".png"));;
//    					parameters.put(ReportsParameter.BG_IMAGE_REPOSITORY,ReportHelper.getBytes("default.png"));
//    					parameters.put(ReportsParameter.PHOTO_IMAGE_REPOSITORY,ReportHelper.getBytes("default.png"));
    				} catch (IOException e) {
    					// TODO Auto-generated catch block
    					e.printStackTrace();
    				

    			}
            }
    			 System.out.println("ViewBadgeModalRSImpl.buildPdfReport() je suis ici ====="+i.getId());
    			datas.add(i);
            }
			
            System.out.println("ViewBadgeModalRSImpl.buildPdfReport() je suis ici =====");
            return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, datas);
      } catch (FileNotFoundException ex) {
          Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
          Response.serverError().build();
      }catch (JRException ex) {
          Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
      }

      return Response.noContent().build();
  }
	
	@Override
	public List<CoefMatiereDetail> setid(HttpHeaders headers) {
		System.out.println("ViewBadgeModalRSImpl.setid() je suis ici ...");
		List<CoefMatiereDetail>  list = new ArrayList<CoefMatiereDetail>();
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		System.out.println("ClasseCycleRSImpl.setid() je suis ici id select is "+id);
		CacheMemory.setCurentcycle(id);
		return list;
	}

	@Override
	public Response certificatsReport(ViewBadgeModal entity) {
		try {
	      	  List<Inscription> records =manager.getCriteres(new Inscription(entity));
	      	
	      	  System.out.println("ViewAnniversaireModalRSImpl.buildPdfReport() size record is "+records.size());
	            String URL = ReportHelper.templateURL+ReportsName.CERTIFICAT_SCOLAIRE.getName();
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

	@Override
	public Response buildPdfReportbi(ViewBadgeModal entity) {
		// TODO Auto-generated method stub
		return this.buildPdfReport(entity);
	}

	@Override
	public Response certificatsReportbi(ViewBadgeModal entity) {
		// TODO Auto-generated method stub
		return this.certificatsReport(entity);
	}

}
