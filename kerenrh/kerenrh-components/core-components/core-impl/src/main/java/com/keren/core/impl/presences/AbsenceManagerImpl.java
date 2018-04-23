
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
import com.keren.core.ifaces.presences.AbsenceManagerLocal;
import com.keren.core.ifaces.presences.AbsenceManagerRemote;
import com.keren.dao.ifaces.presences.AbsenceDAOLocal;
import com.keren.model.presences.Absence;
import com.keren.model.presences.Retard;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AbsenceManager")
public class AbsenceManagerImpl
    extends AbstractGenericManager<Absence, Long>
    implements AbsenceManagerLocal, AbsenceManagerRemote
{

    @EJB(name = "AbsenceDAO")
    protected AbsenceDAOLocal dao;

    public AbsenceManagerImpl() {
    }

    @Override
    public GenericDAO<Absence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<Absence> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("pointage.state", "confirmer");
		container.addEq("absent", Boolean.TRUE);
		container.addEq("state", "etabli");
		predicats.addAll(container.getPredicats());
		List<Absence> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Absence> results = new ArrayList<Absence>();
		for(Absence data:datas){
			results.add(new Absence(data));
		}//end for(Absence data:datas){
		return results;
	}

	@Override
	public Absence find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Absence data = super.find(propertyName, entityID);
		Absence result = new Absence(data);
		return result;
	}

	@Override
	public List<Absence> findAll() {
		// TODO Auto-generated method stub		
		List<Absence> datas = super.findAll();
		List<Absence> results = new ArrayList<Absence>();
		for(Absence data:datas){
			results.add(new Absence(data));
		}//end for(Absence data:datas){
		return results;
	}

	@Override
	public Absence justifie(Absence entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("justifier");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		Absence result = new Absence(entity);
		return result;
	}

	@Override
	public Absence nonjustifie(Absence entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("nonjustifier");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		Absence result = new Absence(entity);
		return result;
	}
    
    

}
