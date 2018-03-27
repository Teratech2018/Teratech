
package com.keren.core.impl.employes;

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
import com.keren.core.ifaces.employes.PosteManagerLocal;
import com.keren.core.ifaces.employes.PosteManagerRemote;
import com.keren.dao.ifaces.employes.PosteDAOLocal;
import com.keren.model.employes.Poste;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PosteManager")
public class PosteManagerImpl
    extends AbstractGenericManager<Poste, Long>
    implements PosteManagerLocal, PosteManagerRemote
{

    @EJB(name = "PosteDAO")
    protected PosteDAOLocal dao;

    public PosteManagerImpl() {
    }

    @Override
    public GenericDAO<Poste, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
  	public Poste delete(Long id) {
  		// TODO Auto-generated method stub
  		Poste data= super.delete(id);
  		return new Poste(data);
  	}

  	@Override
  	public List<Poste> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<Poste> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<Poste> result = new ArrayList<Poste>();
  		for(Poste data:datas){
  			result.add(new Poste(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public Poste find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		Poste data = super.find(propertyName, entityID);
  		Poste result = new Poste(data);		
  		return result;
  	}

  	@Override
  	public List<Poste> findAll() {
  		// TODO Auto-generated method stub
  		List<Poste> datas = super.findAll();
  		List<Poste> result = new ArrayList<Poste>();
  		for(Poste data:datas){
  			result.add(new Poste(data));
  		}
  		return result;
  	}

}
