
package com.core.langues;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.google.gson.Gson;
import com.kerem.core.FileHelper;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.SessionContext;
import javax.ejb.TimedObject;
import javax.ejb.Timer;

@TransactionAttribute
@Stateless(mappedName = "LangueManager")
public class LangueManagerImpl
    extends AbstractGenericManager<Langue, Long>
    implements LangueManagerLocal, LangueManagerRemote,TimedObject
{

    @EJB(name = "LangueDAO")
    protected LangueDAOLocal dao;
    
    @EJB(name = "TermeDAO")
    protected TermeDAOLocal termedao;

    @Resource
    SessionContext context ;
    
    public LangueManagerImpl() {
    }

    @Override
    public GenericDAO<Langue, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public void ejbTimeout(Timer timer) {
        //To change body of generated methods, choose Tools | Templates.
        //Chargement des langues disponibles
        Gson gson = new Gson();
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        List<Langue> langues = dao.filter(container.getPredicats(), null, null, 0, -1);
        for(Langue langue : langues){
            if(langue.getVisited()!=null 
                    && langue.getModified()!=null){
                if(langue.getModified().compareTo(langue.getVisited())>0){
                    FileWriter writer = null;
                    try {
                        //Chargement des termes pour la langue
                        Map<String,String> map = new HashMap<String, String>();
                        //Chargement map langue
                        String systemterm = FileHelper.getConfigDirectory()+File.separator+langue.getCodeISO()+"_system.json";
                        map.putAll(FileHelper.getFromJsonFile(systemterm));
                        container = RestrictionsContainer.newInstance();
                        container.addEq("langue", langue);
                        List<Terme> termes = termedao.filter(container.getPredicats(), null, null, 0, -1);
                        for(Terme terme:termes){
                            map.put(terme.getOrign(), terme.getTraduc());
                        }//end for(Terme terme:termes){                        
                        //Lise a jour du fichier de traduction
                        StringBuilder builder = new StringBuilder();
                        builder.append(FileHelper.getConfigDirectory())
                                .append(File.separator)
                                .append(langue.getCodeISO())
                                .append(".json");
                        String tempjson = FileHelper.getTemporalDirectory()+File.separator+langue.getCodeISO()+".json";
                        String traducJson = gson.toJson(map, Map.class);
                        writer = new FileWriter(tempjson);
                        PrintWriter printer = new PrintWriter(writer);
                        printer.print(traducJson);
                        printer.close();
                        //Transfert du fichier vers le repertoire config
                        FileHelper.moveFile(new File(tempjson), new File(builder.toString()));
                    } //end if(langue.getModified().compareTo(langue.getVisited())>0){
                    catch (IOException ex) {
                        Logger.getLogger(LangueManagerImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                }
            }//end if(langue.getVisited()!=null 
            //mise a jour date visite
            langue.setVisited(new Date());
            dao.update(langue.getId(), langue);
        }//end  for(Langue langue : langues){
    }

    @Override
    public void scheduleEventManager(Date initialExpiration, long duration) {
        //To change body of generated methods, choose Tools | Templates.
        context.getTimerService().createTimer(initialExpiration, duration, "Event schulder ...");
    }
    
    

}
