
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
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ClasseManager")
public class ClasseManagerImpl
    extends AbstractGenericManager<Classe, Long>
    implements ClasseManagerLocal, ClasseManagerRemote
{

    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal dao;

    public ClasseManagerImpl() {
    }

    @Override
    public GenericDAO<Classe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Classe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<Classe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Classe> result = new ArrayList<Classe>();
   		for(Classe elev:datas){
   			result.add(new Classe(elev));
   		}
   		return result;
   	}

   	@Override
   	public Classe find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Classe elev = super.find(propertyName, entityID);
   		Classe inscrip = new Classe(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<Classe> findAll() {
   		// TODO Auto-generated method stub
   		RestrictionsContainer container = RestrictionsContainer.newInstance();
   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<Classe> datas = super.filter(container.getPredicats(), null, null, 0, -1);
   		List<Classe> result = new ArrayList<Classe>();
   		for(Classe elev:datas){
   			result.add(new Classe(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Classe delete(Long id) {
   		// TODO Auto-generated method stub
   		Classe elev = super.delete(id);
   		return new Classe(elev);
   	}


}
