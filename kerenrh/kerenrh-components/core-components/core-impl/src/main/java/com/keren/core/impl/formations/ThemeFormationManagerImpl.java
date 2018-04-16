
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
import com.keren.core.ifaces.formations.ThemeFormationManagerLocal;
import com.keren.core.ifaces.formations.ThemeFormationManagerRemote;
import com.keren.dao.ifaces.formations.ThemeFormationDAOLocal;
import com.keren.model.formations.LigneThemeFormation;
import com.keren.model.formations.ModuleFormation;
import com.keren.model.formations.ThemeFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ThemeFormationManager")
public class ThemeFormationManagerImpl
    extends AbstractGenericManager<ThemeFormation, Long>
    implements ThemeFormationManagerLocal, ThemeFormationManagerRemote
{

    @EJB(name = "ThemeFormationDAO")
    protected ThemeFormationDAOLocal dao;

    public ThemeFormationManagerImpl() {
    }

    @Override
    public GenericDAO<ThemeFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<ThemeFormation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ThemeFormation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ThemeFormation> results = new ArrayList<ThemeFormation>();
		for(ThemeFormation data:datas){
			results.add(new ThemeFormation(data));
		}
		return results;
	}

	@Override
	public ThemeFormation find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ThemeFormation data = super.find(propertyName, entityID);
		ThemeFormation result = new ThemeFormation(data);
		for(LigneThemeFormation mod:data.getLignes()){
			result.getLignes().add(new LigneThemeFormation(mod));
		}
		return result;
	}

	@Override
	public List<ThemeFormation> findAll() {
		// TODO Auto-generated method stub
		List<ThemeFormation> datas = super.findAll();
		List<ThemeFormation> results = new ArrayList<ThemeFormation>();
		for(ThemeFormation data:datas){
			results.add(new ThemeFormation(data));
		}
		return results;
	}
    
    

}
