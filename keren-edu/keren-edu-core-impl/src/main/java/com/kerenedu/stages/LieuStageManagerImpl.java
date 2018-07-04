
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
@Stateless(mappedName = "LieuStageManager")
public class LieuStageManagerImpl
    extends AbstractGenericManager<LieuStage, Long>
    implements LieuStageManagerLocal, LieuStageManagerRemote
{

    @EJB(name = "LieuStageDAO")
    protected LieuStageDAOLocal dao;

    public LieuStageManagerImpl() {
    }

    @Override
    public GenericDAO<LieuStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
 	public List<LieuStage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
 			int firstResult, int maxResult) {
 		// TODO Auto-generated method stub
 		List<LieuStage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
 		List<LieuStage> result = new ArrayList<LieuStage>();
 		for(LieuStage elev:datas){
 			result.add(new LieuStage(elev));
 		}
 		return result;
 	}

 	@Override
 	public LieuStage find(String propertyName, Long entityID) {
 		// TODO Auto-generated method stub
 		LieuStage elev = super.find(propertyName, entityID);
 		LieuStage data = new LieuStage(elev);
 		
 		for(DivisionStage el : elev.getService()){
 			data.getService().add(new DivisionStage(el));
 		}
 		return data;
 	}

 	@Override
 	public List<LieuStage> findAll() {
 		// TODO Auto-generated method stub
 		List<LieuStage> datas = super.findAll();
 		
 		return datas;
 	}
 	
 	

 	@Override
 	public LieuStage delete(Long id) {
 		// TODO Auto-generated method stub
 		LieuStage elev = super.delete(id);
 		return new LieuStage(elev);
 	}



}
