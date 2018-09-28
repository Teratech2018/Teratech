
package com.core.calendar;

import javax.ws.rs.Path;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.kerem.commons.DateHelper;
import com.kerem.core.KerenExecption;
import com.kerem.core.MetaDataUtil;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javax.persistence.Query;
import javax.persistence.TemporalType;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;


/**
 * Classe d'implementation du Web Service JAX-RS

 * @since Sat Nov 18 09:29:25 WAT 2017
 * 
 */
@Path("/event")
public class EventRSImpl
    extends AbstractGenericService<Event, Long>
    implements EventRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kerencore", name = "EventManagerImpl", interf = EventManagerRemote.class)
    protected EventManagerRemote manager;

    public EventRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<Event, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kerencore");
    }

    @Override
    public MetaData getMetaData(@Context HttpHeaders headers) {
        try {
            //To change body of generated methods, choose Tools | Templates.
            return MetaDataUtil.getMetaData(new Event(),new HashMap<String, MetaData>(),new ArrayList<String>());
        }catch (Exception ex) {          
           throw new WebApplicationException(ex);
        }
    }

    @Override
    protected void processBeforeUpdate(Event entity) {
        if(entity.getTitle()==null||entity.getTitle().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le titre"); 
        }else if(entity.getStart()==null){
            throw new KerenExecption("Veuillez saisir la Date de début"); 
        }else if(entity.getParticipants()==null||entity.getParticipants().isEmpty()){
            throw new KerenExecption("Veuillez saisir sélectionner au moins un participants"); 
        }else if(entity.getDuree()==null||entity.getDuree().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la durée");             
        }else if(entity.getRappel()==null){
            throw new KerenExecption("Veuillez selection la periode de rappel");           
        }        
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void processBeforeSave(Event entity) {
       if(entity.getTitle()==null||entity.getTitle().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir le titre"); 
        }else if(entity.getStart()==null){
            throw new KerenExecption("Veuillez saisir la Date de début"); 
        }else if(entity.getParticipants()==null||entity.getParticipants().isEmpty()){
            throw new KerenExecption("Veuillez saisir sélectionner au moins un participants"); 
        }else if(entity.getDuree()==null||entity.getDuree().trim().isEmpty()){
            throw new KerenExecption("Veuillez saisir la durée");             
        }else if(entity.getRappel()==null){
            throw new KerenExecption("Veuillez selection la periode de rappel");           
        }        
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Event> getevents(HttpHeaders headers, long userid) {
        //To change body of generated methods, choose Tools | Templates.
         Gson gson =new Gson();         
        List ids = new ArrayList();
        Date start = null;
        Date end = null;
        if(headers.getRequestHeader("usersid")!=null){
            ids = gson.fromJson(headers.getRequestHeader("usersid").get(0),new TypeToken<List<Long>>(){}.getType());
        }//end if(headers.getRequestHeader("usersid")!=null){
//        System.out.println(EventRSImpl.class.toString()+" ===========================  ===start date : "+headers.getRequestHeader("startdate"));            
        if(headers.getRequestHeader("startdate")!=null){   
//            System.out.println(EventRSImpl.class.toString()+" ===========================  === "+headers.getRequestHeader("startdate").get(0));     
            start = gson.fromJson(headers.getRequestHeader("startdate").get(0),Date.class);
        }//end if(headers.getRequestHeader("startdate")!=null){
        if(headers.getRequestHeader("enddate")!=null){
            end = gson.fromJson(headers.getRequestHeader("enddate").get(0),Date.class);
        }//end if(headers.getRequestHeader("startdate")!=null){
        if(start==null){
            start = DateHelper.getFirstDayOfMonth(new Date());
            end = DateHelper.getLastDayOfMonth(new Date());
        }//end if(start==null){
        String requete = "SELECT DISTINCT c FROM Event c  WHERE (c.owner.id="+userid;
        StringBuffer subquery = new StringBuffer(" ");
        int index = 0;
        for(Object obj : ids){
            Long id = (Long) obj;
            String quer = "c.owner.id = "+id+" AND (c.confidentialite=0 OR c.confidentialite=2)";
            if(index==0){
                subquery.append(quer);
            }else{
                subquery.append(" OR "+quer);
            }//end if(index==0){
            index++;
        }//end for(Object id : ids){
        subquery.append(" ");// 
        if(subquery.toString().trim().isEmpty()){
            requete+=") AND (c.start >=:start AND c.start<=:end)";
        }else{
            requete+=" OR "+subquery+" ) AND (c.start >=:start AND c.start<=:end)";
        }//end if(subquery.toString().trim().isEmpty()){        
        Query query = manager.getDao().getEntityManager().createQuery(requete);
        query.setParameter("start", start, TemporalType.TIMESTAMP);
        query.setParameter("end", end, TemporalType.TIMESTAMP);
        List<Event> datas = query.getResultList();
        List<Event> output = new ArrayList<Event>();
        for(Event evt:datas){
            output.add(new Event(evt));
        }//end for(Event evt:datas){
        return output;
    }

    @Override
    public List<Event> geteventsforperiod(HttpHeaders headers, long userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
