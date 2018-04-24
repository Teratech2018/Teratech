
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
import com.keren.core.ifaces.conges.DemandeCongeVManagerLocal;
import com.keren.core.ifaces.conges.DemandeCongeVManagerRemote;
import com.keren.dao.ifaces.conges.DemandeCongeVDAOLocal;
import com.keren.model.conges.DemandeCongeV;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandeCongeVManager")
public class DemandeCongeVManagerImpl
    extends AbstractGenericManager<DemandeCongeV, Long>
    implements DemandeCongeVManagerLocal, DemandeCongeVManagerRemote
{

    @EJB(name = "DemandeCongeVDAO")
    protected DemandeCongeVDAOLocal dao;
    
    @EJB(name = "DemandeCongeVDAO")
    protected DemandeCongeVDAOLocal daoddecongec;

    public DemandeCongeVManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeCongeV, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public List<DemandeCongeV> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
    	List<DemandeCongeV> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<DemandeCongeV> result = new ArrayList<DemandeCongeV>();
		for(DemandeCongeV data:datas){
			result.add(new DemandeCongeV(data));
		}
		return result;
	}

	@Override
	public DemandeCongeV find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		DemandeCongeV data = super.find(propertyName, entityID);
		DemandeCongeV result = new DemandeCongeV(data);		
		return result;
	}

	@Override
	public List<DemandeCongeV> findAll() {
		// TODO Auto-generated method stub
		List<DemandeCongeV> datas = super.findAll();
		List<DemandeCongeV> result = new ArrayList<DemandeCongeV>();
		for(DemandeCongeV data:datas){
			result.add(new DemandeCongeV(data));
		}
		return result;
	}
    

}
