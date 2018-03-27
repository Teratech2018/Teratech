
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
import com.keren.core.ifaces.discipline.MembreConseilManagerLocal;
import com.keren.core.ifaces.discipline.MembreConseilManagerRemote;
import com.keren.dao.ifaces.discipline.MembreConseilDAOLocal;
import com.keren.model.discipline.MembreConseil;
import com.keren.model.discipline.MembreConseil;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "MembreConseilManager")
public class MembreConseilManagerImpl
    extends AbstractGenericManager<MembreConseil, Long>
    implements MembreConseilManagerLocal, MembreConseilManagerRemote
{

    @EJB(name = "MembreConseilDAO")
    protected MembreConseilDAOLocal dao;

    public MembreConseilManagerImpl() {
    }

    @Override
    public GenericDAO<MembreConseil, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
  	public List<MembreConseil> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<MembreConseil> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<MembreConseil> result = new ArrayList<MembreConseil>();
  		for(MembreConseil data:datas){
  			result.add(new MembreConseil(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public MembreConseil find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		MembreConseil data = super.find(propertyName, entityID);
  		MembreConseil result = new MembreConseil(data);		
  		return result;
  	}

  	@Override
  	public List<MembreConseil> findAll() {
  		// TODO Auto-generated method stub
  		List<MembreConseil> datas = super.findAll();
  		List<MembreConseil> result = new ArrayList<MembreConseil>();
  		for(MembreConseil data:datas){
  			result.add(new MembreConseil(data));
  		}
  		return result;
  	}

}
