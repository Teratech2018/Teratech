
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
import com.keren.core.ifaces.conges.DemandeCongeRManagerLocal;
import com.keren.core.ifaces.conges.DemandeCongeRManagerRemote;
import com.keren.dao.ifaces.conges.DemandeCongeRDAOLocal;
import com.keren.model.conges.DemandeCongeR;
import com.keren.model.conges.DemandeCongeR;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandeCongeRManager")
public class DemandeCongeRManagerImpl
    extends AbstractGenericManager<DemandeCongeR, Long>
    implements DemandeCongeRManagerLocal, DemandeCongeRManagerRemote
{

    @EJB(name = "DemandeCongeRDAO")
    protected DemandeCongeRDAOLocal dao;

    public DemandeCongeRManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeCongeR, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<DemandeCongeR> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<DemandeCongeR> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<DemandeCongeR> result = new ArrayList<DemandeCongeR>();
   		for(DemandeCongeR data:datas){
   			result.add(new DemandeCongeR(data));
   		}
   		return result;
   	}

   	@Override
   	public DemandeCongeR find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		DemandeCongeR data = super.find(propertyName, entityID);
   		DemandeCongeR result = new DemandeCongeR(data);		
   		return result;
   	}

   	@Override
   	public List<DemandeCongeR> findAll() {
   		// TODO Auto-generated method stub
   		List<DemandeCongeR> datas = super.findAll();
   		List<DemandeCongeR> result = new ArrayList<DemandeCongeR>();
   		for(DemandeCongeR data:datas){
   			result.add(new DemandeCongeR(data));
   		}
   		return result;
   	}

}
