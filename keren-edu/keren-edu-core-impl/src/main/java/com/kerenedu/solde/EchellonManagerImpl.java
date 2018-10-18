
package com.kerenedu.solde;

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
@Stateless(mappedName = "EchellonManager")
public class EchellonManagerImpl
    extends AbstractGenericManager<Echellon, Long>
    implements EchellonManagerLocal, EchellonManagerRemote
{

    @EJB(name = "EchellonDAO")
    protected EchellonDAOLocal dao;

    public EchellonManagerImpl() {
    }

    @Override
    public GenericDAO<Echellon, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Echellon> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<Echellon> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Echellon> result = new ArrayList<Echellon>();
   		for(Echellon elev:datas){
   			result.add(new Echellon(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(Echellon entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public Echellon find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Echellon elev = super.find(propertyName, entityID);
   		Echellon inscrip = new Echellon(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<Echellon> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<Echellon> datas = super.findAll();
   		List<Echellon> result = new ArrayList<Echellon>();
   		for(Echellon elev:datas){
   			result.add(new Echellon(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Echellon delete(Long id) {
   		// TODO Auto-generated method stub
   		Echellon elev = super.delete(id);
   		return new Echellon(elev);
   	}


}
