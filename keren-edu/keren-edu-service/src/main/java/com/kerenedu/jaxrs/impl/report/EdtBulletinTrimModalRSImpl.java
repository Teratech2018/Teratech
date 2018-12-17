package com.kerenedu.jaxrs.impl.report;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.kerem.core.FileHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseManagerRemote;
import com.kerenedu.configuration.TypeCacheMemory;
import com.kerenedu.inscription.InscriptionChoice;
import com.kerenedu.jaxrs.ifaces.report.EdtBulletinTrimModalRS;
import com.kerenedu.model.report.EdtBulletinTrimModal;
import com.kerenedu.notes.BulletinHelperGenerate;
import com.kerenedu.notes.BulletinHelperGenerateManagerRemote;
import com.kerenedu.notes.Examen;
import com.kerenedu.notes.ExamenManagerRemote;
import com.kerenedu.tools.reports.ReportHelper;
import com.kerenedu.tools.reports.ReportsName;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaColumn;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;





















@Path("/edtbulletintrimmodal")
public class EdtBulletinTrimModalRSImpl
  extends AbstractGenericService<EdtBulletinTrimModal, Long>
  implements EdtBulletinTrimModalRS
{
  @Manager(application="kereneducation", name="BulletinHelperGenerateManagerImpl", interf=BulletinHelperGenerateManagerRemote.class)
  protected BulletinHelperGenerateManagerRemote manager;
  @Manager(application="kereneducation", name="ClasseManagerImpl", interf=ClasseManagerRemote.class)
  protected ClasseManagerRemote managerClasse;
  @Manager(application="kereneducation", name="ExamenManagerImpl", interf=ExamenManagerRemote.class)
  protected ExamenManagerRemote managerExamen;
//  @Manager(application="kereneducation", name="ExamenPManagerImpl", interf=ExamenPManagerRemote.class)
//  protected ExamenPManagerRemote managerExamenp;
//  @Manager(application="kereneducation", name="ExamenSManagerImpl", interf=ExamenSManagerRemote.class)
//  protected ExamenSManagerRemote managerExamenS;
//  
  public EdtBulletinTrimModalRSImpl() {}
  
  public MetaData getMetaData(HttpHeaders headers)
  {
    try
    {
      MetaData meta = MetaDataUtil.getMetaData(new EdtBulletinTrimModal(), new HashMap<String, MetaData>(), new ArrayList<String>());
      
      MetaColumn workbtn = new MetaColumn("button", "work2", "Imprimer", false, "report", null);
      workbtn.setValue("{'model':'kereneducation','entity':'edtbulletinmodal','method':'pdf'}");
      workbtn.setStates(new String[] { "etabli" });
      









      return meta;
    } catch (InstantiationException ex) {
      Logger.getLogger(EdtBulletinTrimModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      Logger.getLogger(EdtBulletinTrimModalRSImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }
  




  public GenericManager<EdtBulletinTrimModal, Long> getManager()
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
  

  public Response buildPdfReportTrim(EdtBulletinTrimModal entity, @Context HttpHeaders headers)
  {
    try
    {
      System.out.println("EdtBulletinModalRSImpl.buildPdfReport() je suis ici ");
      RestrictionsContainer container = RestrictionsContainer.newInstance();
      String URL = "";
      Map parameters = null;
      
      if (entity.getTypebulletin().equals("0")) {
        System.out.println("EdtBulletinTrimModalRSImpl.buildPdfReportTrim() ==EDITION BULLETIN TRIMESTRE I========");
        
        container = RestrictionsContainer.newInstance();
        container.addEq("typesequence", "0");
        List<Examen> datas = managerExamen.filter(container.getPredicats(), null, new HashSet(), -1, 0);
        if ((datas == null) || (datas.isEmpty())) {
          throw new KerenExecption("ERREUR::: Bienvouloir se Rassurer que toutes les notes du premier Trimestre sont Saisies");
        }
        Examen exam = (Examen)datas.get(0);
        entity.getExamen().add(exam);

        URL = ReportHelper.templateURL + ReportsName.BULLTRIM.getName();
        parameters = getReportParameters();
        parameters.put("TITRE", "BULLETIN TRIMESTRIEL N°1");
        parameters.put("TRIMESTRE", entity.getTypebulletin());
      } else if (entity.getTypebulletin().equals("1"))
      {
        System.out.println("EdtBulletinTrimModalRSImpl.buildPdfReportTrim() ==EDITION BULLETIN TRIMESTRE II========");
        container.addEq("typesequence", "2");
        List<Examen> datas = managerExamen.filter(container.getPredicats(), null, new HashSet(), -1, 0);
        if ((datas == null) || (datas.isEmpty())) {
          throw new KerenExecption("ERREUR::: Bienvouloir se Rassurer que toutes les notes du dexieme Trimestre sont Saisies");
        }
        Examen exam = (Examen)datas.get(0);
        entity.getExamen().add(exam);
        
        URL = ReportHelper.templateURL + ReportsName.BULLTRIM.getName();
        parameters = getReportParameters();
        parameters.put("TITRE", "BULLETIN TRIMESTRIEL N°2");
        parameters.put("TRIMESTRE", entity.getTypebulletin());
      }
      else {
        System.out.println("EdtBulletinTrimModalRSImpl.buildPdfReportTrim() ==EDITION BULLETIN TRIMESTRE III========");
        container.addEq("typesequence", "4");
        List<Examen> datas = managerExamen.filter(container.getPredicats(), null, new HashSet(), -1, 0);
        if ((datas == null) || (datas.isEmpty())) {
          throw new KerenExecption("ERREUR::: Bienvouloir se Rassurer que toutes les notes du Troisieme Trimestre sont Saisies");
        }
        Examen exam = (Examen)datas.get(0);
        entity.getExamen().add(exam);
        
        URL = ReportHelper.templateURL + ReportsName.BULLTRIM.getName();
        parameters = getReportParameters();
        parameters.put("TITRE", "BULLETIN TRIMESTRIEL N°3");
        parameters.put("TRIMESTRE", entity.getTypebulletin());
      }
      List<BulletinHelperGenerate> records = manager.getCriteres(entity);
      List<BulletinHelperGenerate> datas = new ArrayList();
      if ((records.isEmpty()) || (records.size() == 0)) {
        throw new KerenExecption("Note pas encore saisir pour cette séquence !");
      }
      for (BulletinHelperGenerate bull : records) {
        if (bull.getEleve().getImage() != null) {
          try
          {
            bull.setPhoto(ReportHelper.getPhotoBytesEleve(bull.getEleve().getImage()));
          }
          catch (IOException e) {
            e.printStackTrace();
          }
        }
        

        datas.add(bull);
      }
      return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, datas);
    } catch (FileNotFoundException ex) {
      Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
      Response.serverError().build();
    } catch (JRException ex) {
      Logger.getLogger(ViewBulletinRSImpl.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    return Response.noContent().build();
  }
  
  public List<InscriptionChoice> getidclasse(HttpHeaders headers)
  {
    Gson gson = new Gson();
    long id = ((Long)gson.fromJson((String)headers.getRequestHeader("id").get(0), Long.class)).longValue();
    long iduser = ((Long)gson.fromJson((String)headers.getRequestHeader("userid").get(0), Long.class)).longValue();
    if (id > 0L) {
      Classe cls = (Classe)managerClasse.find("id", Long.valueOf(id));
      CacheMemory.insert(iduser, TypeCacheMemory.CLASSE, cls);
    }
    return new ArrayList<InscriptionChoice>();
  }
}
