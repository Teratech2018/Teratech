
package com.kerenedu.stages;

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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BesionStageVManager")
public class BesionStageVManagerImpl
    extends AbstractGenericManager<BesionStageV, Long>
    implements BesionStageVManagerLocal, BesionStageVManagerRemote
{

    @EJB(name = "BesionStageVDAO")
    protected BesionStageVDAOLocal dao;

    public BesionStageVManagerImpl() {
    }

    @Override
    public GenericDAO<BesionStageV, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
 	public List<BesionStageV> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
 			int firstResult, int maxResult) {
 		// TODO Auto-generated method stub
 		List<BesionStageV> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
 		List<BesionStageV> result = new ArrayList<BesionStageV>();
 		for(BesionStageV elev:datas){
 			result.add(new BesionStageV(elev));
 		}
 		return result;
 	}

 	@Override
 	public BesionStageV find(String propertyName, Long entityID) {
 		// TODO Auto-generated method stub
 		BesionStageV elev = super.find(propertyName, entityID);
 		BesionStageV data = new BesionStageV(elev);
 		return data;
 	}

 	@Override
 	public List<BesionStageV> findAll() {
 		// TODO Auto-generated method stub
 		List<BesionStageV> datas = super.findAll();
 		
 		return datas;
 	}
 	
 	

 	@Override
 	public BesionStageV delete(Long id) {
 		// TODO Auto-generated method stub
 		BesionStageV elev = super.delete(id);
 		return new BesionStageV(elev);
 	}
}
