
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.KerenExecption;
import com.keren.core.ifaces.recrutement.RecrutementManagerLocal;
import com.keren.core.ifaces.recrutement.RecrutementManagerRemote;
import com.keren.dao.ifaces.recrutement.RecrutementDAOLocal;
import com.keren.model.recrutement.DetailRecrutement;
import com.keren.model.recrutement.Recrutement;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "RecrutementManager")
public class RecrutementManagerImpl
    extends AbstractGenericManager<Recrutement, Long>
    implements RecrutementManagerLocal, RecrutementManagerRemote
{

    @EJB(name = "RecrutementDAO")
    protected RecrutementDAOLocal dao;

    public RecrutementManagerImpl() {
    }

    @Override
    public GenericDAO<Recrutement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<Recrutement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "etabli");
        predicats.addAll(container.getPredicats());
        
        //On initialise les les objets
        List<Recrutement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Recrutement> results = new ArrayList<Recrutement>();
        
        for(Recrutement data:datas){          
            results.add(new Recrutement(data));
        }
        return results;
    }

    @Override
    public List<Recrutement> findAll() {
        List<Recrutement> datas =  super.findByUniqueProperty("state", "etabli", null);
        List<Recrutement> results = new ArrayList<Recrutement>();

        for(Recrutement data:datas){
            results.add(new Recrutement(data));
        }
        return results;
    }

    @Override
    public Recrutement find(String propertyName, Long entityID) {
        Recrutement data = super.find(propertyName, entityID);
        Recrutement result = new Recrutement(data);

        for(DetailRecrutement aas:data.getDetails()){
            result.getDetails().add(new DetailRecrutement(aas));
        }
        
        return result;
    }
    
    @Override
    public Long count(List<Predicat> predicats) {
        
        //On applique les criteres
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "etabli");
        predicats.addAll(container.getPredicats());
        
        return super.count(predicats); 
    }
    
    @Override
    public Recrutement delete(Long id) {
        
        Recrutement data = super.find("id", id);
        Recrutement result = new Recrutement(data);
        
        try{
            
            //on supprime
            super.delete(id);
            
        }catch(Exception ex){
            
            //On affiche les traces
            ex.printStackTrace();
            
            //On leve l'exception
            throw new KerenExecption("Une erreur est survenue : "+ex.getMessage());
        }
       
        return result; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Recrutement valide(Recrutement entity) {
        
        //Initialisation
        Recrutement data = null;
        Recrutement result = null;
        
        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("termine");
        }
        
        //affectation
        data = dao.update(entity.getId(), entity);
        result = new Recrutement(data);

        for(DetailRecrutement aas:data.getDetails()){
            result.getDetails().add(new DetailRecrutement(aas));
        }

        return result;
    }

    @Override
    public Recrutement annule(Recrutement entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        Recrutement data = dao.update(entity.getId(), entity);
        return new Recrutement(data);
    }
}
