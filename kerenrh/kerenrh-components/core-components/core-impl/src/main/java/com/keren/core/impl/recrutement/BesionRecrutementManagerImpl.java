
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.KerenExecption;
import com.keren.core.ifaces.recrutement.BesionRecrutementManagerLocal;
import com.keren.core.ifaces.recrutement.BesionRecrutementManagerRemote;
import com.keren.dao.ifaces.recrutement.BesionRecrutementDAOLocal;
import com.keren.model.recrutement.BesionRecrutement;
import com.keren.model.recrutement.Recrutement;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.validation.ConstraintViolationException;

@TransactionAttribute
@Stateless(mappedName = "BesionRecrutementManager")
public class BesionRecrutementManagerImpl
    extends AbstractGenericManager<BesionRecrutement, Long>
    implements BesionRecrutementManagerLocal, BesionRecrutementManagerRemote
{

    @EJB(name = "BesionRecrutementDAO")
    protected BesionRecrutementDAOLocal dao;

    public BesionRecrutementManagerImpl() {
    }

    @Override
    public GenericDAO<BesionRecrutement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<BesionRecrutement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "etabli");
        predicats.addAll(container.getPredicats());
        
        //On initialise les les objets
        List<BesionRecrutement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<BesionRecrutement> results = new ArrayList<BesionRecrutement>();
       
        for(BesionRecrutement data:datas){   
            results.add(new BesionRecrutement(data));            
        }
        return results;
    }

    @Override
    public Long count(List<Predicat> predicats) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "etabli");
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List<BesionRecrutement> findAll() {
        List<BesionRecrutement> datas = super.findByUniqueProperty("state", "etabli", null);
        List<BesionRecrutement> results = new ArrayList<BesionRecrutement>();

        for(BesionRecrutement data:datas){
            results.add(new BesionRecrutement(data));
        }
        
        return results;
    }

    @Override
    public BesionRecrutement find(String propertyName, Long entityID) {
        BesionRecrutement data = super.find(propertyName, entityID);
        BesionRecrutement result = new BesionRecrutement(data);

        return result;
    }

    @Override
    public BesionRecrutement delete(Long id) {
        
        BesionRecrutement data = super.find("id", id);
        BesionRecrutement result = new BesionRecrutement(data);
        
        try{
            super.delete(id);
        }catch(Exception ex){
            throw new KerenExecption("Cet objet est dejà en cours d'utilisation par une autre entite");
        }
        
        return result; //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public BesionRecrutement valide(BesionRecrutement entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }
        
        BesionRecrutement data = dao.update(entity.getId(), entity);
        BesionRecrutement result = new BesionRecrutement(data);

        return result;
    }    
     

    @Override
    public BesionRecrutement annule(BesionRecrutement entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        BesionRecrutement data = dao.update(entity.getId(), entity);
        return new BesionRecrutement(data);
    }

}

