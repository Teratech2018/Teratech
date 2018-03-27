
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
import com.keren.core.ifaces.discipline.ConvocationConseilManagerLocal;
import com.keren.core.ifaces.discipline.ConvocationConseilManagerRemote;
import com.keren.dao.ifaces.discipline.ConvocationConseilDAOLocal;
import com.keren.model.discipline.ConvocationConseil;
import com.keren.model.discipline.DemandeExplication;
import com.keren.model.discipline.MembreConseil;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ConvocationConseilManager")
public class ConvocationConseilManagerImpl
    extends AbstractGenericManager<ConvocationConseil, Long>
    implements ConvocationConseilManagerLocal, ConvocationConseilManagerRemote
{

    @EJB(name = "ConvocationConseilDAO")
    protected ConvocationConseilDAOLocal dao;

    public ConvocationConseilManagerImpl() {
    }

    @Override
    public GenericDAO<ConvocationConseil, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
	@Override
  	public List<ConvocationConseil> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<ConvocationConseil> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<ConvocationConseil> result = new ArrayList<ConvocationConseil>();
  		for(ConvocationConseil data:datas){
  			result.add(new ConvocationConseil(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public ConvocationConseil find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		ConvocationConseil data = super.find(propertyName, entityID);
  		ConvocationConseil result = new ConvocationConseil(data);	
  		
  		for(DemandeExplication de : data.getDemandes()){
  			result.getDemandes().add(new DemandeExplication(de));
  		}
  		
  		for(MembreConseil mc : data.getMembres()){
  			result.getMembres().add(new MembreConseil(mc));
  		}
  		return result;
  	}

  	@Override
  	public List<ConvocationConseil> findAll() {
  		// TODO Auto-generated method stub
  		List<ConvocationConseil> datas = super.findAll();
  		List<ConvocationConseil> result = new ArrayList<ConvocationConseil>();
  		for(ConvocationConseil data:datas){
  			result.add(new ConvocationConseil(data));
  		}
  		return result;
  	}


}
