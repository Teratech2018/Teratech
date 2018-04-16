
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
import com.keren.core.ifaces.formations.ModuleFormationManagerLocal;
import com.keren.core.ifaces.formations.ModuleFormationManagerRemote;
import com.keren.dao.ifaces.formations.ModuleFormationDAOLocal;
import com.keren.model.formations.ModuleFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ModuleFormationManager")
public class ModuleFormationManagerImpl
    extends AbstractGenericManager<ModuleFormation, Long>
    implements ModuleFormationManagerLocal, ModuleFormationManagerRemote
{

    @EJB(name = "ModuleFormationDAO")
    protected ModuleFormationDAOLocal dao;

    public ModuleFormationManagerImpl() {
    }

    @Override
    public GenericDAO<ModuleFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<ModuleFormation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ModuleFormation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ModuleFormation> results =new ArrayList<ModuleFormation>();
		for(ModuleFormation data:datas){
			results.add(new ModuleFormation(data));
		}
		return results;
	}

	@Override
	public ModuleFormation find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ModuleFormation data = super.find(propertyName, entityID);
		ModuleFormation result = new ModuleFormation(data);
		return result;
	}

	@Override
	public List<ModuleFormation> findAll() {
		// TODO Auto-generated method stub		
		List<ModuleFormation> datas = super.findAll();
		List<ModuleFormation> results =new ArrayList<ModuleFormation>();
		for(ModuleFormation data:datas){
			results.add(new ModuleFormation(data));
		}
		return results;
	}
    
    

}
