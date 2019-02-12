
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.kerenedu.model.report.ViewAnneeModal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "EmargementDtlPeriodeManager")
public class EmargementDtlPeriodeManagerImpl
    extends AbstractGenericManager<EmargementDtlPeriode, Long>
    implements EmargementDtlPeriodeManagerLocal, EmargementDtlPeriodeManagerRemote
{

    @EJB(name = "EmargementDtlPeriodeDAO")
    protected EmargementDtlPeriodeDAOLocal dao;

    public EmargementDtlPeriodeManagerImpl() {
    }

    @Override
    public GenericDAO<EmargementDtlPeriode, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<EmargementDtlPeriode> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<EmargementDtlPeriode> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<EmargementDtlPeriode> result = new ArrayList<EmargementDtlPeriode>();
   		for(EmargementDtlPeriode elev:datas){
   			result.add(new EmargementDtlPeriode(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(EmargementDtlPeriode entity) {
		//entity.setSection(entity.getFiliere().getSection());
		super.processBeforeSave(entity);
	}

	@Override
   	public EmargementDtlPeriode find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		EmargementDtlPeriode elev = super.find(propertyName, entityID);
   		EmargementDtlPeriode inscrip = new EmargementDtlPeriode(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<EmargementDtlPeriode> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<EmargementDtlPeriode> datas = super.findAll();
   		List<EmargementDtlPeriode> result = new ArrayList<EmargementDtlPeriode>();
   		for(EmargementDtlPeriode elev:datas){
   			result.add(new EmargementDtlPeriode(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public EmargementDtlPeriode delete(Long id) {
   		// TODO Auto-generated method stub
   		EmargementDtlPeriode elev = super.delete(id);
   		return new EmargementDtlPeriode(elev);
   	}

	@Override
	public List<EmargementDtlPeriode> getCriteres(ViewAnneeModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<EmargementDtlPeriode> datas = new ArrayList<EmargementDtlPeriode>();
		container = RestrictionsContainer.newInstance();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
			if (critere.getAnnee() != null) {
				container.addEq("anneScolaire", critere.getAnnee().getCode());
			}
		}
		 datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		return datas;
	}



}
