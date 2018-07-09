/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.basaccount.jaxrs.impl.search;

import com.basaccount.core.ifaces.comptabilite.CompteManagerRemote;
import com.basaccount.core.ifaces.operations.EcritureComptableManagerRemote;
import com.basaccount.jaxrs.ifaces.search.EcritureSearchRS;
import com.basaccount.model.operations.EcritureComptable;
import com.basaccount.model.search.EcritureSearch;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.core.FileHelper;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.AnnotationsProcessor;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.FilterPredicat;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import net.sf.jasperreports.engine.JRException;

/**
 *
 * @author Commercial_2
 */
@Path("/ecrituresearch")
public class EcritureSearchRSImpl extends AbstractGenericService<EcritureSearch, Long> implements EcritureSearchRS {

    public static final String PLAN_CPLE = "EtatEcritureComptable.jasper";
    
    @Manager(application = "baseaccount", name = "EcritureComptableManagerImpl", interf = EcritureComptableManagerRemote.class)
    protected EcritureComptableManagerRemote ecrituremanager;
    
     @Manager(application = "baseaccount", name = "CompteManagerImpl", interf = CompteManagerRemote.class)
    protected CompteManagerRemote manager;

    public EcritureSearchRSImpl() {
        super();
    }
    
    /**
     *
     * @return
     */
    @Override
    public MetaData getMetaData() {
        try {
            //To change body of generated methods, choose Tools | Templates.
            MetaData meta = MetaDataUtil.getMetaData(new EcritureSearch(), new HashMap<String, MetaData>(),new ArrayList<String>());
            System.out.println(EcritureSearchRSImpl.class.toString()+".getMetaData() ====== "+meta);
            return meta;
        } catch (InstantiationException ex) {
            Logger.getLogger(EcritureSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(EcritureSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public List<EcritureComptable> somethings(EcritureSearch param) {
         //To change body of generated methods, choose Tools | Templates.
        List<EcritureComptable> datas = ecrituremanager.somethings(param);
//        System.out.println(EcritureComptableManagerImpl.class.toString()+" ===================== "+datas);        
        return datas;
    }

    @Override
    public Response somethingspdf(EcritureSearch param,@Context HttpHeaders headers) {
        try {
            Gson gson = new Gson();
            List<FilterPredicat> filter = new ArrayList<FilterPredicat>();
            if(headers.getRequestHeader("predicats")!=null && !headers.getRequestHeader("predicats").isEmpty()){
                filter = gson.fromJson(headers.getRequestHeader("predicats").get(0),new TypeToken<List<FilterPredicat>>(){}.getType());
            }//end if(headers.getRequestHeader("predicats")!=null && !headers.getRequestHeader("predicats").isEmpty()){
            List ids = new ArrayList();
            if(headers.getRequestHeader("values")!=null && !headers.getRequestHeader("values").isEmpty()){
                ids = gson.fromJson(headers.getRequestHeader("values").get(0),new TypeToken<List<Long>>(){}.getType());
            }//end if(headers.getRequestHeader("values")!=null && !headers.getRequestHeader("values").isEmpty()){
            System.out.println(EcritureSearchRSImpl.class.toString()+".somethingspdf(EcritureSearch param,@Context HttpHeaders headers) ==== fileter : "+filter+" === values : "+ids);
            List<EcritureComptable> datas = ecrituremanager.somethings(param);
            String templateURL = FileHelper.getReportsDirectory()+File.separator+PLAN_CPLE;
            String temp_dir = FileHelper.getTemporalDirectory()+File.separator+"plancmpte.pdf";
            Map parameters = new HashMap();
            return buildReportFomTemplate(FileHelper.getTemporalDirectory().toString(), templateURL, parameters, datas);
//            jasperPdfBuilder(new File(templateURL), temp_dir, parameters, datas);
//            //To change body of generated methods, choose Tools | Templates.
//            File file = new File(temp_dir);        
//            return getPdf(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(EcritureSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
            Response.serverError().build();
        } catch (JRException ex) {
            Logger.getLogger(EcritureSearchRSImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.noContent().build();
    }

    @Override
    public GenericManager<EcritureSearch, Long> getManager() {
        return null; //To change body of generated methods, choose Tools | Templates.
    }
    
}
