
package com.kerenedu.reglement;

import java.util.ArrayList;
import java.util.Date;
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
import com.kerenedu.configuration.CacheMemory;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "FichePaiementRetardManager")
public class FichePaiementRetardManagerImpl extends AbstractGenericManager<FichePaiementRetard, Long>
		implements FichePaiementRetardManagerLocal, FichePaiementRetardManagerRemote {

	@EJB(name = "FichePaiementRetardDAO")
	protected FichePaiementRetardDAOLocal dao;
	
	@EJB(name = "MoratoireDAO")
    protected  MoratoireDAOLocal moratoiredao;

	public FichePaiementRetardManagerImpl() {
	}

	@Override
	public GenericDAO<FichePaiementRetard, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<FichePaiementRetard> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {

		List<FichePaiementRetard> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<FichePaiementRetard> result = new ArrayList<FichePaiementRetard>();
		for (FichePaiementRetard fiche : datas) {
		//	if (fiche.getDelai().after(new Date()) && fiche.getPayer() == false) {
				result.add(new FichePaiementRetard(fiche));
//				break;
//			}
		}
		return result;
	}

	@Override
	public FichePaiementRetard find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		FichePaiementRetard elev = super.find(propertyName, entityID);
		FichePaiementRetard inscrip = new FichePaiementRetard(elev);
	 	List<Moratoire> moratoires = new ArrayList<Moratoire>();
	   	RestrictionsContainer container = RestrictionsContainer.newInstance();
	   	container.addEq("service.id", elev.getFiche().getId());
	   	moratoires = moratoiredao.filter(container.getPredicats(), null, null, 0, -1);
	   	inscrip.setMoratoires(moratoires);
		return inscrip;
	}

	@Override
	public List<FichePaiementRetard> findAll() {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycleAnnee());
		if (CacheMemory.getClasse() != null) {
			container.addEq("classe.id", CacheMemory.getClasse().getId());
		}
		List<FichePaiementRetard> datas = super.filter(container.getPredicats(), null, null, 0, -1);
		List<FichePaiementRetard> result = new ArrayList<FichePaiementRetard>();
		for (FichePaiementRetard elev : datas) {
			result.add(new FichePaiementRetard(elev));
		}
		return result;
	}

	@Override
	public FichePaiementRetard delete(Long id) {
		// TODO Auto-generated method stub
		FichePaiementRetard elev = super.delete(id);
		return new FichePaiementRetard(elev);
	}

}
