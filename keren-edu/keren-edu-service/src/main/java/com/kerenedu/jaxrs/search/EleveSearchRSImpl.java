/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kerenedu.jaxrs.search;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.NamingException;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionManagerRemote;
import com.kerenedu.jaxrs.reports.tools.ReportHelper;
import com.kerenedu.jaxrs.reports.tools.ReportsName;
import com.kerenedu.jaxrs.reports.tools.ReportsParameter;
import com.kerenedu.model.search.EleveSearch;
import com.kerenedu.school.Eleve;
import com.kerenedu.school.EleveManagerRemote;
import com.megatimgroup.generic.jax.rs.layer.annot.AnnotationsProcessor;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.base.JRBaseParameter;

/**
 *
 * @author Commercial_2
 */
@Path("/elevesearch")
public class EleveSearchRSImpl extends AbstractGenericService<EleveSearch, Long> implements EleveSearchRS {

    @Manager(application = "kereneducation", name = "EleveManagerImpl", interf = EleveManagerRemote.class)
    protected EleveManagerRemote elevemanager;
    
    
    @Manager(application = "kereneducation", name = "InscriptionManagerImpl", interf =InscriptionManagerRemote.class)
    protected InscriptionManagerRemote inscriptionmanager;

    public EleveSearchRSImpl() {
        try {
            AnnotationsProcessor processor  = new AnnotationsProcessor();
            processor.process(this);
        } catch (NamingException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    @Override
    public MetaData getMetaData() {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new EleveSearch(), new HashMap<String, MetaData>(),new ArrayList<String>());
        } catch (InstantiationException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<Eleve> getCriteres(EleveSearch eleveSearch) {
    	  List<Eleve> datas = elevemanager.getCriteres(eleveSearch);
    	  return datas;
    }
    
    /**
     * Methode permettant de retourner les parametres pour le reporting
     *
     * @return java.util.Map
     */
    public Map getReportParameters() {
        Map params = new HashMap();
        params.put(ReportsParameter.ETB,"UCAC");
        params.put(ReportsParameter.ANNEE_SCOLAIRE, "");
        params.put(ReportsParameter.REPORT_USER,"BEKO");

        // On positionne la locale
        params.put(JRBaseParameter.REPORT_LOCALE, Locale.FRENCH);
        // Construction du Bundle
        ResourceBundle bundle = ReportHelper.getInstace();
        // Ajout du bundle dans les parametres
        params.put(JRBaseParameter.REPORT_RESOURCE_BUNDLE, bundle);

        return params;
    }


    @Override
    public Response buildPdfReport(EleveSearch eleveSearch) {
        try {
        	  //List<Eleve> datas = elevemanager.getCriteres(eleveSearch);
        	  List<Inscription> records =inscriptionmanager.getCriteres(eleveSearch);
              String URL = ReportHelper.templateURL+ReportsName.CERTIFICAT_SCOLAIRE.getName();
              System.out.println("EleveSearchRSImpl.buildPdfReport() chemin file++++++ "+URL);
              Map parameters = new HashMap();
              return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), URL, parameters, records);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            Response.serverError().build();
        }catch (JRException ex) {
            Logger.getLogger(EleveSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
 
        return Response.noContent().build();
    }

    @Override
    public GenericManager<EleveSearch, Long> getManager() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }



    
}
