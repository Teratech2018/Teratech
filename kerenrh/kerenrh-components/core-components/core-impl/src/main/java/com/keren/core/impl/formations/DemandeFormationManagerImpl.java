
package com.keren.core.impl.formations;

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
import com.keren.core.ifaces.formations.DemandeFormationManagerLocal;
import com.keren.core.ifaces.formations.DemandeFormationManagerRemote;
import com.keren.dao.ifaces.formations.DemandeFormationDAOLocal;
import com.keren.model.formations.DemandeFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandeFormationManager")
public class DemandeFormationManagerImpl
    extends AbstractGenericManager<DemandeFormation, Long>
    implements DemandeFormationManagerLocal, DemandeFormationManagerRemote
{

    @EJB(name = "DemandeFormationDAO")
    protected DemandeFormationDAOLocal dao;

    public DemandeFormationManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<DemandeFormation> filter(List<Predicat> predicats, Map<String, OrderType> orders,
                    Set<String> properties, int firstResult, int maxResult) {
            // TODO Auto-generated method stub
            List<DemandeFormation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
            List<DemandeFormation> results = new ArrayList<DemandeFormation>();
            for(DemandeFormation data:datas){
                    results.add(new DemandeFormation(data));
            }
            return results;
    }

    @Override
    public DemandeFormation find(String propertyName, Long entityID) {
            // TODO Auto-generated method stub
            DemandeFormation data = super.find(propertyName, entityID);
            DemandeFormation result = new DemandeFormation(data);
            return result;
    }

    @Override
    public List<DemandeFormation> findAll() {
            // TODO Auto-generated method stub		
            List<DemandeFormation> datas = super.findAll();
            List<DemandeFormation> results = new ArrayList<DemandeFormation>();
            for(DemandeFormation data:datas){
                    results.add(new DemandeFormation(data));
            }
            return results;
    }

    @Override
    public DemandeFormation delete(Long id) {

        // TODO Auto-generated method stub    	
        DemandeFormation data= super.delete(id);

        return new DemandeFormation(data);
    }

    @Override
    public DemandeFormation valide(DemandeFormation entity) {
            // TODO Auto-generated method stub
            if(entity.getState().equalsIgnoreCase("etabli")){
                    entity.setState("valide");
                    entity = dao.update(entity.getId(), entity);
            }
            return new DemandeFormation(entity);
    }

    @Override
    public DemandeFormation rejete(DemandeFormation entity) {
            // TODO Auto-generated method stub
            if(entity.getState().equalsIgnoreCase("etabli")){
                    entity.setState("rejete");
                    entity = dao.update(entity.getId(), entity);
            }
            return new DemandeFormation(entity);
    }
}
