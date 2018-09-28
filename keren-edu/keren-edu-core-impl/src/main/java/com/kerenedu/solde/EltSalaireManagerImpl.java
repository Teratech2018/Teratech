
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
@Stateless(mappedName = "EltSalaireManager")
public class EltSalaireManagerImpl
    extends AbstractGenericManager<EltSalaire, Long>
    implements EltSalaireManagerLocal, EltSalaireManagerRemote
{

    @EJB(name = "EltSalaireDAO")
    protected EltSalaireDAOLocal dao;

    public EltSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<EltSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<EltSalaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<EltSalaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<EltSalaire> result = new ArrayList<EltSalaire>();
   		for(EltSalaire elev:datas){
   			result.add(new EltSalaire(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(EltSalaire entity) {
		
		super.processBeforeSave(entity);
	}

	@Override
   	public EltSalaire find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		EltSalaire elev = super.find(propertyName, entityID);
   		EltSalaire inscrip = new EltSalaire(elev);
   		for(EltSalaireLigne ligne: elev.getListemploye()){
   			inscrip.getListemploye().add(new EltSalaireLigne(ligne));
   		}
   		return inscrip;
   	}

   	@Override
   	public List<EltSalaire> findAll() {
   		List<EltSalaire> datas = super.findAll();
   		List<EltSalaire> result = new ArrayList<EltSalaire>();
   		for(EltSalaire elev:datas){
   			result.add(new EltSalaire(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public EltSalaire delete(Long id) {
   		// TODO Auto-generated method stub
   		EltSalaire elev = super.delete(id);
   		return new EltSalaire(elev);
   	}



}
