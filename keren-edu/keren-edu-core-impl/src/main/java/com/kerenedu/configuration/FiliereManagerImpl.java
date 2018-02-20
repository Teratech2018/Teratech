
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
@Stateless(mappedName = "FiliereManager")
public class FiliereManagerImpl
    extends AbstractGenericManager<Filiere, Long>
    implements FiliereManagerLocal, FiliereManagerRemote
{

    @EJB(name = "FiliereDAO")
    protected FiliereDAOLocal dao;

    public FiliereManagerImpl() {
    }

    @Override
    public GenericDAO<Filiere, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
  	public List<Filiere> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<Filiere> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<Filiere> result = new ArrayList<Filiere>();
  		for(Filiere elev:datas){
  			result.add(new Filiere(elev));
  		}
  		return result;
  	}

  	@Override
  	public Filiere find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		Filiere annee = super.find(propertyName, entityID);
  		Filiere inscrip = new Filiere(annee);
//  		for(Filiere serv: annee.getPeriodeScoalire()){
//  			inscrip.getPeriodeScoalire().add(new Filiere(serv));
//  		}
  		return inscrip;
  	}

  	@Override
  	public List<Filiere> findAll() {
  		// TODO Auto-generated method stub
  		List<Filiere> datas = super.findAll();
  		List<Filiere> result = new ArrayList<Filiere>();
  		for(Filiere elev:datas){
  			result.add(new Filiere(elev));
  		}
  		return result;
  	}
  	
  	
  	@Override
  	public Filiere delete(Long id) {
  		// TODO Auto-generated method stub
  		Filiere annee = super.delete(id);
  		return new Filiere(annee);
  	}


}
