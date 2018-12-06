
package com.kerenedu.configuration;

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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ClasseCycleManager")
public class ClasseCycleManagerImpl
    extends AbstractGenericManager<ClasseCycle, Long>
    implements ClasseCycleManagerLocal, ClasseCycleManagerRemote
{

    @EJB(name = "ClasseCycleDAO")
    protected ClasseCycleDAOLocal dao;

    public ClasseCycleManagerImpl() {
    }

    @Override
    public GenericDAO<ClasseCycle, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ClasseCycle> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    
   		List<ClasseCycle> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ClasseCycle> result = new ArrayList<ClasseCycle>();
   		for(ClasseCycle elev:datas){
   			result.add(new ClasseCycle(elev));
   		}
   		return result;
   	}

}
