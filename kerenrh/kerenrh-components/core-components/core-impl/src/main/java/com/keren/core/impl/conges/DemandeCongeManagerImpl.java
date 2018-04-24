
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
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.core.KerenExecption;
import com.keren.core.ifaces.conges.DemandeCongeManagerLocal;
import com.keren.core.ifaces.conges.DemandeCongeManagerRemote;
import com.keren.dao.ifaces.conges.DemandeCongeCDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeDAOLocal;
import com.keren.model.conges.DemandeConge;
import com.keren.model.conges.DemandeCongeC;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandeCongeManager")
public class DemandeCongeManagerImpl
    extends AbstractGenericManager<DemandeConge, Long>
    implements DemandeCongeManagerLocal, DemandeCongeManagerRemote
{

    @EJB(name = "DemandeCongeDAO")
    protected DemandeCongeDAOLocal dao;
    
    @EJB(name = "DemandeCongeCDAO")
    protected DemandeCongeCDAOLocal daodcc;

    public DemandeCongeManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeConge, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<DemandeConge> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
        // TODO Auto-generated method stub
        List<DemandeConge> datas =  super.filter(predicats, orders, properties, firstResult, maxResult);
        List<DemandeConge> output = new ArrayList<DemandeConge>();

        for(DemandeConge dc:datas){
                output.add(new DemandeConge(dc));
        }

        return output;
    }

    @Override
    public DemandeConge find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        DemandeConge dmde = super.find(propertyName, entityID);
        return new DemandeConge(dmde);
    }

    @Override
    public List<DemandeConge> findAll() {
        
        // TODO Auto-generated method stub
        List<DemandeConge> datas =  super.findAll();
        List<DemandeConge> output = new ArrayList<DemandeConge>();
        
        for(DemandeConge dc:datas){
                output.add(new DemandeConge(dc));
        }
        
        return output;
    }

    @Override
    public void processAfterSave(DemandeConge entity) {
        super.processAfterSave(entity);
    }

    @Override
    public void processAfterUpdate(DemandeConge entity) {           
        super.processAfterUpdate(entity);
    }

    @Override
    public DemandeConge confirmer(DemandeConge dmde) {
        if(dmde.getState().equals("etabli")){
        	dmde.setState("confirmer");
        	dmde = dao.update(dmde.getId(), dmde);
        }
        return new DemandeConge(dmde);
    }
	
    @Override
    public DemandeConge delete(Long id) {        
        DemandeConge data = super.delete(id);
        DemandeConge result = new DemandeConge(data);        
        return result;
    }
	
}
