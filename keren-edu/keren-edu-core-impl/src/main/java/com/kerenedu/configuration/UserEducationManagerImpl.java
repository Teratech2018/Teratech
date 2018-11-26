
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
@Stateless(mappedName = "UserEducationManager")
public class UserEducationManagerImpl
    extends AbstractGenericManager<UserEducation, Long>
    implements UserEducationManagerLocal, UserEducationManagerRemote
{

    @EJB(name = "UserEducationDAO")
    protected UserEducationDAOLocal dao;

    public UserEducationManagerImpl() {
    }

    @Override
    public GenericDAO<UserEducation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
  	public List<UserEducation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<UserEducation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<UserEducation> result = new ArrayList<UserEducation>();
  		for(UserEducation elev:datas){
  			result.add(new UserEducation(elev));
  		}
  		return result;
  	}

  	@Override
  	public UserEducation find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		UserEducation annee = super.find(propertyName, entityID);
  		UserEducation inscrip = new UserEducation(annee);
//  		for(UserEducation serv: annee.getPeriodeScoalire()){
//  			inscrip.getPeriodeScoalire().add(new UserEducation(serv));
//  		}
  		return inscrip;
  	}

  	@Override
  	public List<UserEducation> findAll() {
  		// TODO Auto-generated method stub
  		List<UserEducation> datas = super.findAll();
  		List<UserEducation> result = new ArrayList<UserEducation>();
  		for(UserEducation elev:datas){
  			result.add(new UserEducation(elev));
  		}
  		return result;
  	}
  	
  	
  	@Override
  	public UserEducation delete(Long id) {
  		// TODO Auto-generated method stub
  		UserEducation annee = super.delete(id);
  		return new UserEducation(annee);
  	}


}
