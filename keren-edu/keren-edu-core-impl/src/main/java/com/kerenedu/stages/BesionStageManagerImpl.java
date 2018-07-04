
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
@Stateless(mappedName = "BesionStageManager")
public class BesionStageManagerImpl
    extends AbstractGenericManager<BesionStage, Long>
    implements BesionStageManagerLocal, BesionStageManagerRemote
{

    @EJB(name = "BesionStageDAO")
    protected BesionStageDAOLocal dao;
    
    @EJB(name = "BesionStageVDAO")
    protected BesionStageVDAOLocal daoBCV;

    public BesionStageManagerImpl() {
    }

    @Override
    public GenericDAO<BesionStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public BesionStage valide(BesionStage stage) {
    	BesionStage result = new BesionStage(stage);		
    	result.setState("valider");
    	dao.update(result.getId(), result);
		return result;
	}
    
    @Override
   	public List<BesionStage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<BesionStage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<BesionStage> result = new ArrayList<BesionStage>();
   		for(BesionStage elev:datas){
   			result.add(new BesionStage(elev));
   		}
   		return result;
   	}

   	@Override
   	public BesionStage find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		BesionStage elev = super.find(propertyName, entityID);
   		BesionStage data = new BesionStage(elev);
   		return data;
   	}

   	@Override
   	public List<BesionStage> findAll() {
   		// TODO Auto-generated method stub
   		List<BesionStage> datas = super.findAll();
   		return datas;
   	}
   	
   	

   	@Override
   	public BesionStage delete(Long id) {
   		// TODO Auto-generated method stub
   		BesionStage elev = super.delete(id);
   		return new BesionStage(elev);
   	}


}
