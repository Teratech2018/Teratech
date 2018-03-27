
package com.keren.core.impl.discipline;

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
import com.keren.core.ifaces.discipline.SanctionManagerLocal;
import com.keren.core.ifaces.discipline.SanctionManagerRemote;
import com.keren.dao.ifaces.discipline.SanctionDAOLocal;
import com.keren.model.discipline.Sanction;
import com.keren.model.discipline.Sanction;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "SanctionManager")
public class SanctionManagerImpl
    extends AbstractGenericManager<Sanction, Long>
    implements SanctionManagerLocal, SanctionManagerRemote
{

    @EJB(name = "SanctionDAO")
    protected SanctionDAOLocal dao;

    public SanctionManagerImpl() {
    }

    @Override
    public GenericDAO<Sanction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
  	public List<Sanction> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<Sanction> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<Sanction> result = new ArrayList<Sanction>();
  		for(Sanction data:datas){
  			result.add(new Sanction(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public Sanction find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		Sanction data = super.find(propertyName, entityID);
  		Sanction result = new Sanction(data);		
  		return result;
  	}

  	@Override
  	public List<Sanction> findAll() {
  		// TODO Auto-generated method stub
  		List<Sanction> datas = super.findAll();
  		List<Sanction> result = new ArrayList<Sanction>();
  		for(Sanction data:datas){
  			result.add(new Sanction(data));
  		}
  		return result;
  	}

}
