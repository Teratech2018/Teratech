
package com.kerenedu.reglement;

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
@Stateless(mappedName = "MoratoireManager")
public class MoratoireManagerImpl
    extends AbstractGenericManager<Moratoire, Long>
    implements MoratoireManagerLocal, MoratoireManagerRemote
{

    @EJB(name = "MoratoireDAO")
    protected MoratoireDAOLocal dao;
    
    @EJB(name = "FichePaiementDAO")
    protected FichePaiementDAOLocal fichedao;

    public MoratoireManagerImpl() {
    }

    @Override
    public GenericDAO<Moratoire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Moratoire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<Moratoire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Moratoire> result = new ArrayList<Moratoire>();
   		for(Moratoire elev:datas){
   			result.add(new Moratoire(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(Moratoire entity) {
   		FichePaiement fiche = fichedao.findByPrimaryKey("id", entity.getService().getId());
   		fiche.setDelai(entity.getDateDeb());
   		fichedao.update(fiche.getId(), fiche);
		super.processBeforeSave(entity);
	}

	@Override
   	public Moratoire find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Moratoire elev = super.find(propertyName, entityID);
   		Moratoire inscrip = new Moratoire(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<Moratoire> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<Moratoire> datas = super.findAll();
   		List<Moratoire> result = new ArrayList<Moratoire>();
   		for(Moratoire elev:datas){
   			result.add(new Moratoire(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Moratoire delete(Long id) {
   		// TODO Auto-generated method stub
   		Moratoire elev = super.delete(id);
   		return new Moratoire(elev);
   	}

}
