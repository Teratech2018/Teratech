
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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AcompteManager")
public class AcompteManagerImpl
    extends AbstractGenericManager<Acompte, Long>
    implements AcompteManagerLocal, AcompteManagerRemote
{

    @EJB(name = "AcompteDAO")
    protected AcompteDAOLocal dao;
    
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;

    public AcompteManagerImpl() {
    }

    @Override
    public GenericDAO<Acompte, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
	public Acompte delete(Long id) {
		// TODO Auto-generated method stub
		Acompte data = super.delete(id);
		return new Acompte(data);
	}

	@Override
	public List<Acompte> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Acompte> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Acompte> result = new ArrayList<Acompte>();
		for(Acompte data:datas){
			result.add(new Acompte(data));
		}
		return result;
	}

	@Override
	public Acompte find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Acompte data = super.find(propertyName, entityID);
		return new Acompte(data);
	}

	@Override
	public List<Acompte> findAll() {
		// TODO Auto-generated method stub		
		List<Acompte> datas =super.findAll();
		List<Acompte> result = new ArrayList<Acompte>();
		for(Acompte data:datas){
			result.add(new Acompte(data));
		}
		return result;
	}

	@Override
	public Acompte confirme(Acompte entity) {
		// TODO Auto-generated method stub
		entity.setState("confirme");
		dao.update(entity.getId(), entity);
		return new Acompte(entity);
	}
	
    
	@Override
	public Acompte paye(Acompte entity,PeriodePaie periode) {
		// TODO Auto-generated method stub
		//Ajout de l'acompte dans la liste es elements variable
		//Traitement des Elements Variables de paie
		ElementVariable element = null ;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("salarie0", entity.getEmploye());
		container.addEq("peiode", periode);
		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
		if(datas!=null && datas.size()>0){
			element = datas.get(0);
		}
		if(element==null){
			element = new ElementVariable();
			element.setSalarie(entity.getEmploye());
			element.setPeiode(periode);	
			variabledao.save(element);
			datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
			if(datas!=null && datas.size()>0){
				element = datas.get(0);
			}
		}//end if(element==null)		
//		element.getAcomptes().add(entity);
		entity.setEltVariable(element);
		entity.setState("paye");
		entity = dao.update(entity.getId(), entity);		
		return new Acompte(entity);//entity;
	}

	@Override
	public Acompte annule(Acompte entity) {
		// TODO Auto-generated method stub
		entity.setState("annule");
		dao.update(entity.getId(), entity);
		return new Acompte(entity);
	}


}
