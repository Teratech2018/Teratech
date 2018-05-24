
package com.keren.kerenpaie.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.KerenExecption;
import com.keren.kerenpaie.core.ifaces.structures.SyndicatManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.SyndicatManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.SyndicatDAOLocal;
import com.keren.kerenpaie.model.structures.Syndicat;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "SyndicatManager")
public class SyndicatManagerImpl
    extends AbstractGenericManager<Syndicat, Long>
    implements SyndicatManagerLocal, SyndicatManagerRemote
{

    @EJB(name = "SyndicatDAO")
    protected SyndicatDAOLocal dao;

    public SyndicatManagerImpl() {
    }

    @Override
    public GenericDAO<Syndicat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<Syndicat> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {

        //On initialise les les objets
        List<Syndicat> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Syndicat> results = new ArrayList<Syndicat>();

        for(Syndicat data:datas){
            results.add(new Syndicat(data));
        }
        return results;
    }

    @Override
    public List<Syndicat> findAll() {
        //List<AffectationCandidat> datas = super.findByUniqueProperty("state", "valide", null);
        List<Syndicat> datas = super.findAll();
        List<Syndicat> results = new ArrayList<Syndicat>();

        for(Syndicat data:datas){
            results.add(new Syndicat(data));
        }
        return results;
    }

    @Override
    public Syndicat find(String propertyName, Long entityID) {
        Syndicat data = super.find(propertyName, entityID);
        Syndicat result = new Syndicat(data);

        return result;
    }
    
    @Override
    public Syndicat delete(Long id) {
        
        Syndicat data = super.find("id", id);
        Syndicat result = new Syndicat(data);
        
        try{
            
            //on supprime
            super.delete(id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            throw new KerenExecption("Une erreur est survenue : "+ex.getMessage());
        }
        
        return result;
    }
}
/*

    @Override
    public List<Syndicat> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {

        ////On applique les criteres
        ////RestrictionsContainer container = RestrictionsContainer.newInstance();
        ////container.addEq("state", "valide");
        ////predicats.addAll(container.getPredicats());

        //On initialise les les objets
        List<Syndicat> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Syndicat> results = new ArrayList<Syndicat>();

        for(Syndicat data:datas){
            results.add(new Syndicat(data));
        }
        return results;
    }

    @Override
    public List<Syndicat> findAll() {
        //List<AffectationCandidat> datas = super.findByUniqueProperty("state", "valide", null);
        List<Syndicat> datas = super.findAll();
        List<Syndicat> results = new ArrayList<Syndicat>();

        for(Syndicat data:datas){
            results.add(new Syndicat(data));
        }
        return results;
    }

    @Override
    public Syndicat find(String propertyName, Long entityID) {
        Syndicat data = super.find(propertyName, entityID);
        Syndicat result = new Syndicat(data);


        return result;
    }

    @Override
    public Long count(List<Predicat> predicats) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "valide");
        predicats.addAll(container.getPredicats());
        
        return super.count(predicats);
    }

    @Override
    public Syndicat delete(Long id) {
        
        Syndicat data = super.find("id", id);
        Syndicat result = new Syndicat(data);
        
        try{
            
            //on supprime
            super.delete(id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            throw new KerenExecption("Une erreur est survenue : "+ex.getMessage());
        }
        
        return result;
    }

    @Override
    public void processAfterUpdate(Syndicat entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Syndicat entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

    @Override
    public Syndicat valide(Syndicat entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }

        Syndicat data = dao.update(entity.getId(), entity);


        Syndicat result = new Syndicat(data);

        return result;
    }

    @Override
    public Syndicat annule(Syndicat entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        Syndicat data = dao.update(entity.getId(), entity);
        return new Syndicat(data);
    }

*/
/*

    @Override
    public List<Syndicat> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {

        ////On applique les criteres
        ////RestrictionsContainer container = RestrictionsContainer.newInstance();
        ////container.addEq("state", "valide");
        ////predicats.addAll(container.getPredicats());

        //On initialise les les objets
        List<Syndicat> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Syndicat> results = new ArrayList<Syndicat>();

        for(Syndicat data:datas){
            results.add(new Syndicat(data));
        }
        return results;
    }

    @Override
    public List<Syndicat> findAll() {
        //List<AffectationCandidat> datas = super.findByUniqueProperty("state", "valide", null);
        List<Syndicat> datas = super.findAll();
        List<Syndicat> results = new ArrayList<Syndicat>();

        for(Syndicat data:datas){
            results.add(new Syndicat(data));
        }
        return results;
    }

    @Override
    public Syndicat find(String propertyName, Long entityID) {
        Syndicat data = super.find(propertyName, entityID);
        Syndicat result = new Syndicat(data);


        return result;
    }

    @Override
    public Long count(List<Predicat> predicats) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "valide");
        predicats.addAll(container.getPredicats());
        
        return super.count(predicats);
    }

    @Override
    public Syndicat delete(Long id) {
        
        Syndicat data = super.find("id", id);
        Syndicat result = new Syndicat(data);
        
        try{
            
            //on supprime
            super.delete(id);
            
        }catch(Exception ex){
            ex.printStackTrace();
            throw new KerenExecption("Une erreur est survenue : "+ex.getMessage());
        }
        
        return result;
    }

    @Override
    public void processAfterUpdate(Syndicat entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Syndicat entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

    @Override
    public Syndicat valide(Syndicat entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }

        Syndicat data = dao.update(entity.getId(), entity);


        Syndicat result = new Syndicat(data);

        return result;
    }

    @Override
    public Syndicat annule(Syndicat entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        Syndicat data = dao.update(entity.getId(), entity);
        return new Syndicat(data);
    }

*/
