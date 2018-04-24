
package com.keren.core.impl.presences;

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
import com.keren.core.ifaces.presences.RetardManagerLocal;
import com.keren.core.ifaces.presences.RetardManagerRemote;
import com.keren.dao.ifaces.presences.RetardDAOLocal;
import com.keren.model.presences.PointageJouranlier;
import com.keren.model.presences.Retard;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RetardManager")
public class RetardManagerImpl
    extends AbstractGenericManager<Retard, Long>
    implements RetardManagerLocal, RetardManagerRemote
{

    @EJB(name = "RetardDAO")
    protected RetardDAOLocal dao;

    public RetardManagerImpl() {
    }

    @Override
    public GenericDAO<Retard, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public Retard delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<Retard> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("pointage.state", "confirmer");
		container.addEq("retard", Boolean.TRUE);
		container.addEq("state", "etabli");
		predicats.addAll(container.getPredicats());
		List<Retard> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Retard> results = new ArrayList<Retard>();
		for(Retard data:datas){
			results.add(new Retard(data));
		}//end for(Retard data:datas){
		return results;
	}

	@Override
	public Retard find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Retard data = super.find(propertyName, entityID);
		Retard result = new Retard(data);
		result.setPointage(new PointageJouranlier(data.getPointage()));
		return result;
	}

	@Override
	public List<Retard> findAll() {
		// TODO Auto-generated method stub		
		List<Retard> datas = super.findAll();
		List<Retard> results = new ArrayList<Retard>();
		for(Retard data:datas){
			results.add(new Retard(data));
		}//end for(Retard data:datas){
		return results;
	}

	@Override
	public Retard justifie(Retard entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("justifier");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		Retard result = new Retard(entity);
		return result;
	}

	@Override
	public Retard nonjustifie(Retard entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("nonjustifier");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		Retard result = new Retard(entity);
		return result;
	}
    
    

}
