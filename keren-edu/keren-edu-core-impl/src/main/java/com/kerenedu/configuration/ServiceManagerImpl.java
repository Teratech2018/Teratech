
package com.kerenedu.configuration;

import java.math.BigDecimal;
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
import com.kerenedu.personnel.JoursCours;
import com.kerenedu.personnel.TrancheHoraireCours;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ServiceManager")
public class ServiceManagerImpl
    extends AbstractGenericManager<Service, Long>
    implements ServiceManagerLocal, ServiceManagerRemote
{

    @EJB(name = "ServiceDAO")
    protected ServiceDAOLocal dao;

    public ServiceManagerImpl() {
    }

    @Override
    public GenericDAO<Service, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Service> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Service> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Service> result = new ArrayList<Service>();
   		for(Service elev:datas){
   			result.add(new Service(elev));
   		}
   		return result;
   	}

   	@Override
   	public Service find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Service elev = super.find(propertyName, entityID);
   		Service inscrip = new Service(elev);
   		for(Filiere frais: elev.getFiliere()){
   			inscrip.getFiliere().add(new Filiere(frais));
   		}
   		return inscrip;
   	}

   	@Override
   	public List<Service> findAll() {
   		// TODO Auto-generated method stub
   		List<Service> datas = super.findAll();
   		List<Service> result = new ArrayList<Service>();
   		for(Service elev:datas){
   			result.add(new Service(elev));
   		}
   		return result;
   	}

	@Override
	public void processBeforeSave(Service entity) {
		super.processBeforeSave(entity);
	}

   	
}
