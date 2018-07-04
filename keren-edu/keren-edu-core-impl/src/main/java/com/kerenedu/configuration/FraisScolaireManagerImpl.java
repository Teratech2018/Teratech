
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
@Stateless(mappedName = "FraisScolaireManager")
public class FraisScolaireManagerImpl
    extends AbstractGenericManager<FraisScolaire, Long>
    implements FraisScolaireManagerLocal, FraisScolaireManagerRemote
{

    @EJB(name = "FraisScolaireDAO")
    protected FraisScolaireDAOLocal dao;

    public FraisScolaireManagerImpl() {
    }

    @Override
    public GenericDAO<FraisScolaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
  	public List<FraisScolaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<FraisScolaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<FraisScolaire> result = new ArrayList<FraisScolaire>();
  		for(FraisScolaire elev:datas){
  			result.add(new FraisScolaire(elev));
  		}
  		return result;
  	}

  	@Override
  	public FraisScolaire find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		FraisScolaire annee = super.find(propertyName, entityID);
  		FraisScolaire inscrip = new FraisScolaire(annee);
//  		for(FraisScolaire serv: annee.getPeriodeScoalire()){
//  			inscrip.getPeriodeScoalire().add(new FraisScolaire(serv));
//  		}
  		return inscrip;
  	}

  	@Override
  	public List<FraisScolaire> findAll() {
  		// TODO Auto-generated method stub
  		List<FraisScolaire> datas = super.findAll();
  		List<FraisScolaire> result = new ArrayList<FraisScolaire>();
  		for(FraisScolaire elev:datas){
  			result.add(new FraisScolaire(elev));
  		}
  		return result;
  	}
  	
  	
  	@Override
  	public FraisScolaire delete(Long id) {
  		// TODO Auto-generated method stub
  		FraisScolaire annee = super.delete(id);
  		return new FraisScolaire(annee);
  	}


}
