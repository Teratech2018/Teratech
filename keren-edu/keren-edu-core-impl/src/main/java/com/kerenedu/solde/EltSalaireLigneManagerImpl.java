
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
@Stateless(mappedName = "EltSalaireLigneManager")
public class EltSalaireLigneManagerImpl
    extends AbstractGenericManager<EltSalaireLigne, Long>
    implements EltSalaireLigneManagerLocal, EltSalaireLigneManagerRemote
{

    @EJB(name = "EltSalaireLigneDAO")
    protected EltSalaireLigneDAOLocal dao;

    public EltSalaireLigneManagerImpl() {
    }

    @Override
    public GenericDAO<EltSalaireLigne, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<EltSalaireLigne> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<EltSalaireLigne> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<EltSalaireLigne> result = new ArrayList<EltSalaireLigne>();
   		for(EltSalaireLigne elev:datas){
   			result.add(new EltSalaireLigne(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(EltSalaireLigne entity) {
		
		super.processBeforeSave(entity);
	}

	@Override
   	public EltSalaireLigne find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		EltSalaireLigne elev = super.find(propertyName, entityID);
   		EltSalaireLigne inscrip = new EltSalaireLigne(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<EltSalaireLigne> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<EltSalaireLigne> datas = super.findAll();
   		List<EltSalaireLigne> result = new ArrayList<EltSalaireLigne>();
   		for(EltSalaireLigne elev:datas){
   			result.add(new EltSalaireLigne(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public EltSalaireLigne delete(Long id) {
   		// TODO Auto-generated method stub
   		EltSalaireLigne elev = super.delete(id);
   		return new EltSalaireLigne(elev);
   	}



}
