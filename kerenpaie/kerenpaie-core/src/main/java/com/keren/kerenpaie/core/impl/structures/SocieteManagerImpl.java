
package com.keren.kerenpaie.core.impl.structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.structures.SocieteManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.SocieteManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.SocieteDAOLocal;
import com.keren.kerenpaie.model.structures.Planification;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "SocieteManager")
public class SocieteManagerImpl
    extends AbstractGenericManager<Societe, Long>
    implements SocieteManagerLocal, SocieteManagerRemote
{

    @EJB(name = "SocieteDAO")
    protected SocieteDAOLocal dao;

    public SocieteManagerImpl() {
    }

    @Override
    public GenericDAO<Societe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Societe delete(Long id) {

        // TODO Auto-generated method stub    	
        Societe data= super.delete(id);

        return new Societe(data);
    }

    @Override
    public List<Societe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {

        // TODO Auto-generated method stub
        List<Societe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Societe> result = new ArrayList<Societe>();

        for(Societe data:datas){
            result.add(new Societe(data));
        }

        return result;
    }

    @Override
    public Societe find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        Societe data = super.find(propertyName, entityID);
        Societe result = new Societe(data);
        
        /*if(data.getSocieteMere()!=null){
            result.setSocieteMere(new Societe(data.getSocieteMere()));
        }*/
        
        for(Planification plan:data.getPlanifications()){
            result.getPlanifications().add(new Planification(plan));
        }

        return result;
    }

    @Override
    public List<Societe> findAll() {
        
        // TODO Auto-generated method stub
        List<Societe> datas = super.findAll();
        List<Societe> result = new ArrayList<Societe>();

        for(Societe data:datas){
            result.add(new Societe(data));
        }

        return result;
    }

    @Override
    public void processBeforeSave(Societe entity) {
        
        // TODO Auto-generated method stub
        if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){
            
            Planification lundi = new Planification("Lundi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Mardi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Mercredi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Jeudi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Vendredi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Samedi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Dimanche", true, 8.0);
            entity.getPlanifications().add(lundi);
                
        }//end if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){
        
        super.processBeforeSave(entity);
    }

    @Override
    public void processBeforeUpdate(Societe entity) {
        
        // TODO Auto-generated method stub
        if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){

            Planification lundi = new Planification("Lundi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Mardi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Mercredi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Jeudi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Vendredi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Samedi", true, 8.0);
            entity.getPlanifications().add(lundi);
            lundi = new Planification("Dimanche", true, 8.0);
            entity.getPlanifications().add(lundi);

        }//end if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){

        super.processBeforeUpdate(entity);
    }
    
}
/*

    @Override
    public List<Societe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {

        ////On applique les criteres
        ////RestrictionsContainer container = RestrictionsContainer.newInstance();
        ////container.addEq("state", "valide");
        ////predicats.addAll(container.getPredicats());

        //On initialise les les objets
        List<Societe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Societe> results = new ArrayList<Societe>();

        for(Societe data:datas){
            results.add(new Societe(data));
        }
        return results;
    }

    @Override
    public List<Societe> findAll() {
        //List<AffectationCandidat> datas = super.findByUniqueProperty("state", "valide", null);
        List<Societe> datas = super.findAll();
        List<Societe> results = new ArrayList<Societe>();

        for(Societe data:datas){
            results.add(new Societe(data));
        }
        return results;
    }

    @Override
    public Societe find(String propertyName, Long entityID) {
        Societe data = super.find(propertyName, entityID);
        Societe result = new Societe(data);

        for(Planification aas:data.getPlanifications()){
            result.getPlanifications().add(new Planification(aas));
        }


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
    public Societe delete(Long id) {
        
        Societe data = super.find("id", id);
        Societe result = new Societe(data);
        
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
    public void processAfterUpdate(Societe entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Societe entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

    @Override
    public Societe valide(Societe entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }

        Societe data = dao.update(entity.getId(), entity);


        Societe result = new Societe(data);

        for(Planification aas:data.getPlanifications()){
            result.getPlanifications().add(new Planification(aas));
        }

        return result;
    }

    @Override
    public Societe annule(Societe entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        Societe data = dao.update(entity.getId(), entity);
        return new Societe(data);
    }

*/
