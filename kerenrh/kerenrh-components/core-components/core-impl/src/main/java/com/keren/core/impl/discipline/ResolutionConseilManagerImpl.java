
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
import com.keren.core.ifaces.discipline.ResolutionConseilManagerLocal;
import com.keren.core.ifaces.discipline.ResolutionConseilManagerRemote;
import com.keren.dao.ifaces.discipline.ResolutionConseilDAOLocal;
import com.keren.model.discipline.LigneResolution;
import com.keren.model.discipline.ResolutionConseil;
import com.keren.model.discipline.ResolutionConseil;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ResolutionConseilManager")
public class ResolutionConseilManagerImpl
    extends AbstractGenericManager<ResolutionConseil, Long>
    implements ResolutionConseilManagerLocal, ResolutionConseilManagerRemote
{

    @EJB(name = "ResolutionConseilDAO")
    protected ResolutionConseilDAOLocal dao;

    public ResolutionConseilManagerImpl() {
    }

    @Override
    public GenericDAO<ResolutionConseil, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
  	public List<ResolutionConseil> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<ResolutionConseil> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<ResolutionConseil> result = new ArrayList<ResolutionConseil>();
  		for(ResolutionConseil data:datas){
  			result.add(new ResolutionConseil(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public ResolutionConseil find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		ResolutionConseil data = super.find(propertyName, entityID);
  		ResolutionConseil result = new ResolutionConseil(data);	
  		
  		for(LigneResolution lr : data.getLignes()){
  			result.getLignes().add(new LigneResolution(lr));
  		}
  		return result;
  	}

  	@Override
  	public List<ResolutionConseil> findAll() {
  		// TODO Auto-generated method stub
  		List<ResolutionConseil> datas = super.findAll();
  		List<ResolutionConseil> result = new ArrayList<ResolutionConseil>();
  		for(ResolutionConseil data:datas){
  			result.add(new ResolutionConseil(data));
  		}
  		return result;
  	}

}
