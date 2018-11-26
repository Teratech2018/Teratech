 package com.kerenedu.jaxrs.impl.report;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.core.ifaces.report.ViewBilanFinancierManagerRemote;
import com.kerenedu.core.ifaces.report.ViewNoteHelperManagerRemote;
import com.kerenedu.jaxrs.ifaces.report.ViewMatiereClasseModalRS;
import com.kerenedu.model.report.ViewMatiereClasseModal;
import com.kerenedu.model.report.ViewNoteHelper;
import com.kerenedu.notes.CoefMatiereDetail;
import com.kerenedu.notes.CoefMatiereDetailManagerRemote;
import com.kerenedu.notes.MatiereNoteManagerRemote;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
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
import javax.ws.rs.core.Response.ResponseBuilder;
import net.sf.jasperreports.engine.JRException;


@Path("/viewmatiereclassemodal")
public class ViewMatiereClasseModalRSImpl
  extends AbstractGenericService<ViewMatiereClasseModal, Long>
  implements ViewMatiereClasseModalRS
{
  @Manager(application="kereneducation", name="ViewBilanFinancierManagerImpl", interf=ViewBilanFinancierManagerRemote.class)
  protected ViewBilanFinancierManagerRemote manager;
  @Manager(application="kereneducation", name="CoefMatiereDetailManagerImpl", interf=CoefMatiereDetailManagerRemote.class)
  protected CoefMatiereDetailManagerRemote managercoef;
  @Manager(application="kereneducation", name="MatiereNoteManagerImpl", interf=MatiereNoteManagerRemote.class)
  protected MatiereNoteManagerRemote managernote;
  @Manager(application="kereneducation", name="ViewNoteHelperManagerImpl", interf=ViewNoteHelperManagerRemote.class)
  protected ViewNoteHelperManagerRemote managernotehelper;
  
  public ViewMatiereClasseModalRSImpl() {}
  
  public MetaData getMetaData(HttpHeaders headers)
  {
    try
    {
      return MetaDataUtil.getMetaData(new ViewMatiereClasseModal(), new HashMap(), new ArrayList());
    }
    catch (Exception e) {
      throw new WebApplicationException(Response.serverError().entity(new String("MetaData parse error")).build());
    }
  }
  




  public GenericManager<ViewMatiereClasseModal, Long> getManager()
  {
    return null;
  }
  
  public String getModuleName() {
    return "kereneducation";
  }
  





  public Map getReportParameters()
  {
    return ReportHelperTrt.getReportParameters();
  }
  


  public Response buildPdfReport(ViewMatiereClasseModal entity)
  {
    try
    {
      List<CoefMatiereDetail> records = managercoef.getCriteres(entity);
      System.out.println("ViewMatiereClasseModal.buildPdfReport() size record is " + records.size());
      String URL = ReportHelper.templateURL + ReportsName.FICHE_MATIERE.getName();
      Map parameters = new HashMap();
      parameters = getReportParameters();
      return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(ViewMatiereClasseModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
      Response.serverError().build();
    } catch (JRException ex) {
      Logger.getLogger(ViewMatiereClasseModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return Response.noContent().build();
  }
  
  public Response fichenotes(ViewMatiereClasseModal entity)
  {
    try {
      String URL = ReportHelper.templateURL + ReportsName.FICHE_NOTE_TD.getName();
      List<ViewNoteHelper> records = new ArrayList();
      records = managernotehelper.getCriteres(entity);
      if ((records.isEmpty()) || (records.size() == 0)) {
        throw new KerenExecption("Traitement impossible<br/>Bien vouloir Selectionner un eleve !");
      }
      Map parameters = getReportParameters();
      
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
 
   
