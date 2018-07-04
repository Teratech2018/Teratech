
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
@Stateless(mappedName = "PeriodeScolaireManager")
public class PeriodeScolaireManagerImpl
    extends AbstractGenericManager<PeriodeScolaire, Long>
    implements PeriodeScolaireManagerLocal, PeriodeScolaireManagerRemote
{

    @EJB(name = "PeriodeScolaireDAO")
    protected PeriodeScolaireDAOLocal dao;

    public PeriodeScolaireManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodeScolaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
  	public List<PeriodeScolaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<PeriodeScolaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<PeriodeScolaire> result = new ArrayList<PeriodeScolaire>();
  		for(PeriodeScolaire elev:datas){
  			result.add(new PeriodeScolaire(elev));
  		}
  		return result;
  	}

  	@Override
  	public PeriodeScolaire find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		PeriodeScolaire annee = super.find(propertyName, entityID);
  		PeriodeScolaire inscrip = new PeriodeScolaire(annee);
//  		for(PeriodeScolaire serv: annee.getPeriodeScoalire()){
//  			inscrip.getPeriodeScoalire().add(new PeriodeScolaire(serv));
//  		}
  		return inscrip;
  	}

  	@Override
  	public List<PeriodeScolaire> findAll() {
  		// TODO Auto-generated method stub
  		List<PeriodeScolaire> datas = super.findAll();
  		List<PeriodeScolaire> result = new ArrayList<PeriodeScolaire>();
  		for(PeriodeScolaire elev:datas){
  			result.add(new PeriodeScolaire(elev));
  		}
  		return result;
  	}
  	
  	
  	@Override
  	public PeriodeScolaire delete(Long id) {
  		// TODO Auto-generated method stub
  		PeriodeScolaire annee = super.delete(id);
  		return new PeriodeScolaire(annee);
  	}

}
