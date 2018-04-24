
package com.keren.core.impl.conges;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.conges.InterruptionCongeManagerLocal;
import com.keren.core.ifaces.conges.InterruptionCongeManagerRemote;
import com.keren.dao.ifaces.conges.DemandeCongeDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeVDAOLocal;
import com.keren.dao.ifaces.conges.InterruptionCongeDAOLocal;
import com.keren.model.conges.DemandeConge;
import com.keren.model.conges.InterruptionConge;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "InterruptionCongeManager")
public class InterruptionCongeManagerImpl
    extends AbstractGenericManager<InterruptionConge, Long>
    implements InterruptionCongeManagerLocal, InterruptionCongeManagerRemote
{

    @EJB(name = "InterruptionCongeDAO")
    protected InterruptionCongeDAOLocal dao;
    
    @EJB(name = "DemandeCongeDAO")
    protected DemandeCongeDAOLocal daodcv;

    public InterruptionCongeManagerImpl() {
    }

    @Override
    public GenericDAO<InterruptionConge, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public InterruptionConge delete(Long id) {

        // TODO Auto-generated method stub
        InterruptionConge data= super.delete(id);
        return new InterruptionConge(data);
    }

    @Override
    public List<InterruptionConge> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {

        //On applique les criteres
//        RestrictionsContainer container = RestrictionsContainer.newInstance();
//        container.addEq("state", "etabli");
//        predicats.addAll(container.getPredicats());

        // TODO Auto-generated method stub
        List<InterruptionConge> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<InterruptionConge> result = new ArrayList<InterruptionConge>();

        for(InterruptionConge data:datas){
            result.add(new InterruptionConge(data));
        }
        return result;
    }
   	
    @Override
    public void processAfterSave(InterruptionConge entity) {

        // determine la date de din de congé  en prenant en copte les jours ouvré
        daodcv.update(entity.getConge().getId(), entity.getConge());
        super.processAfterSave(entity);
    }

    @Override
    public void processAfterUpdate(InterruptionConge entity) {

        // TODO Auto-generated method stub
        daodcv.update(entity.getConge().getId(), entity.getConge());
        super.processAfterUpdate(entity);
    }

    @Override
    public InterruptionConge find(String propertyName, Long entityID) {

        // TODO Auto-generated method stub
        InterruptionConge data = super.find(propertyName, entityID);
        InterruptionConge result = new InterruptionConge(data);		
        return result;
    }

    @Override
    public List<InterruptionConge> findAll() {

        // TODO Auto-generated method stub
        List<InterruptionConge> datas = super.findByUniqueProperty("state", "etabli", null);
        List<InterruptionConge> result = new ArrayList<InterruptionConge>();
        
        for(InterruptionConge data:datas){
                result.add(new InterruptionConge(data));
        }
        return result;
    }
        
    @Override
    public Long count(List<Predicat> predicats) {
        //On applique les criteres
//        RestrictionsContainer container = RestrictionsContainer.newInstance();
//        container.addEq("state", "etabli");
//        predicats.addAll(container.getPredicats());
        return super.count(predicats);
    }

    @Override
    public InterruptionConge confirmer(InterruptionConge dmde) {
        //Variables
        InterruptionConge result = null;
        //On teste le l'etat precedent
        if(dmde.getState().equalsIgnoreCase("etabli")){
            dmde.setState("confirmer");
            dmde = dao.update(dmde.getId(), dmde);  	
            //Traitement de la demande lie
            DemandeConge conge = dmde.getConge();
            conge.setState("termine");
            conge.setFinEffetif(dmde.getDate());
            daodcv.update(conge.getId(), conge);
        }
        //On recupre l'objet courant
        result = new InterruptionConge(dmde);
        return result;
    }
}
