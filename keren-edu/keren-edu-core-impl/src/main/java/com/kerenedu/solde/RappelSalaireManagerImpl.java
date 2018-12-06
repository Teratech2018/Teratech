
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
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.DateHelper;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RappelSalaireManager")
public class RappelSalaireManagerImpl
    extends AbstractGenericManager<RappelSalaire, Long>
    implements RappelSalaireManagerLocal, RappelSalaireManagerRemote
{

    @EJB(name = "RappelSalaireDAO")
    protected RappelSalaireDAOLocal dao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;
    

    public RappelSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<RappelSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public RappelSalaire delete(Long id) {
		// TODO Auto-generated method stub
		RappelSalaire data = super.delete(id);
		return new RappelSalaire(data);
	}

	@Override
	public List<RappelSalaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<RappelSalaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<RappelSalaire> result = new ArrayList<RappelSalaire>();
		for(RappelSalaire data:datas){
			result.add(new RappelSalaire(data));
		}
		return result;
	}

	@Override
	public RappelSalaire find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		RappelSalaire data = super.find(propertyName, entityID);
		RappelSalaire result = new RappelSalaire(data);
		for(LigneRappel ligne:data.getLignes()){
			result.getLignes().add(new LigneRappel(ligne));
		}
		return result;
	}

	@Override
	public List<RappelSalaire> findAll() {
		// TODO Auto-generated method stub		
		List<RappelSalaire> datas = super.findAll();
		List<RappelSalaire> result = new ArrayList<RappelSalaire>();
		for(RappelSalaire data:datas){
			result.add(new RappelSalaire(data));
		}
		return result;
	}

	@Override
	public RappelSalaire confirme(RappelSalaire entity,PeriodePaie periode) {
		// TODO Auto-generated method stub
		//Traitement des Elements Variables de paie
		ElementVariable element = null ;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("salarie0", entity.getEmploye());
		container.addGe("ddeb", DateHelper.formatDate(entity.getDebut()));
		container.addLe("dfin", DateHelper.formatDate(entity.getFin()));
		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
		if(datas!=null && datas.size()>0){
			element = datas.get(0);
		}//end if(datas!=null && datas.size()>0){
		if(element==null){
			element = new ElementVariable();
			element.setSalarie(entity.getEmploye());
			element.setPeriode(periode);	
			element.setDdeb(entity.getDebut());
			element.setDfin(entity.getFin());
			variabledao.save(element);
			datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
			if(datas!=null && datas.size()>0){
				element = datas.get(0);
			}//end if(datas!=null && datas.size()>0)
		}//end if(element==null)
		entity.setEltVariable(element);
		entity.setState("engage");
		dao.update(entity.getId(), entity);
		return entity;
	}
    
}
