
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
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "NiveauManager")
public class NiveauManagerImpl
    extends AbstractGenericManager<Niveau, Long>
    implements NiveauManagerLocal, NiveauManagerRemote
{

    @EJB(name = "NiveauDAO")
    protected NiveauDAOLocal dao;

    public NiveauManagerImpl() {
    }

    @Override
    public GenericDAO<Niveau, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
  	public List<Niveau> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<Niveau> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<Niveau> result = new ArrayList<Niveau>();
  		for(Niveau elev:datas){
  			result.add(new Niveau(elev));
  		}
  		return result;
  	}

  	@Override
  	public Niveau find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		Niveau annee = super.find(propertyName, entityID);
  		Niveau inscrip = new Niveau(annee);
//  		for(Niveau serv: annee.getPeriodeScoalire()){
//  			inscrip.getPeriodeScoalire().add(new Niveau(serv));
//  		}
  		return inscrip;
  	}

  	@Override
  	public List<Niveau> findAll() {
  		// TODO Auto-generated method stub
  		List<Niveau> datas = super.findAll();
  		List<Niveau> result = new ArrayList<Niveau>();
  		for(Niveau elev:datas){
  			result.add(new Niveau(elev));
  		}
  		return result;
  	}
  	
  	
  	@Override
  	public Niveau delete(Long id) {
  		// TODO Auto-generated method stub
  		Niveau annee = super.delete(id);
  		return new Niveau(annee);
  	}


}
