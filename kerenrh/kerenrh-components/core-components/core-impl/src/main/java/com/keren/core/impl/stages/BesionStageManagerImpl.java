
package com.keren.core.impl.stages;

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
import com.keren.core.ifaces.stages.BesionStageManagerLocal;
import com.keren.core.ifaces.stages.BesionStageManagerRemote;
import com.keren.dao.ifaces.stages.BesionStageDAOLocal;
import com.keren.model.stages.BesionStage;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BesionStageManager")
public class BesionStageManagerImpl
    extends AbstractGenericManager<BesionStage, Long>
    implements BesionStageManagerLocal, BesionStageManagerRemote
{

    @EJB(name = "BesionStageDAO")
    protected BesionStageDAOLocal dao;

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
	public List<BesionStage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<BesionStage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<BesionStage> results = new ArrayList<BesionStage>();
		for(BesionStage  data:datas){
			results.add(new BesionStage(data));
		}
		return results;
	}

	@Override
	public BesionStage find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		BesionStage data= super.find(propertyName, entityID);
		BesionStage result = new BesionStage(data);
		return result;
	}

	@Override
	public List<BesionStage> findAll() {
		// TODO Auto-generated method stub		
		List<BesionStage> datas = super.findAll();
		List<BesionStage> results = new ArrayList<BesionStage>();
		for(BesionStage  data:datas){
			results.add(new BesionStage(data));
		}
		return results;
	}

	@Override
	public BesionStage valide(BesionStage entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("valide");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		BesionStage result = new BesionStage(entity);
		return result;
	}

	@Override
	public BesionStage annule(BesionStage entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("valide")){
			entity.setState("annule");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		BesionStage result = new BesionStage(entity);
		return result;
	}

}
