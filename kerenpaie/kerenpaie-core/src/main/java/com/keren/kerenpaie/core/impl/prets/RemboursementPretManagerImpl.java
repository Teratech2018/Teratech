
package com.keren.kerenpaie.core.impl.prets;

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
import com.keren.kerenpaie.core.ifaces.prets.RemboursementPretManagerLocal;
import com.keren.kerenpaie.core.ifaces.prets.RemboursementPretManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.RemboursementPretDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.keren.kerenpaie.model.prets.RemboursementPret;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RemboursementPretManager")
public class RemboursementPretManagerImpl
    extends AbstractGenericManager<RemboursementPret, Long>
    implements RemboursementPretManagerLocal, RemboursementPretManagerRemote
{

    @EJB(name = "RemboursementPretDAO")
    protected RemboursementPretDAOLocal dao;

    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;
    

    public RemboursementPretManagerImpl() {
    }

    @Override
    public GenericDAO<RemboursementPret, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public RemboursementPret delete(Long id) {
		// TODO Auto-generated method stub
		RemboursementPret data = dao.findByPrimaryKey("id", id);
		return new RemboursementPret(data);
	}

	@Override
	public List<RemboursementPret> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<RemboursementPret> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<RemboursementPret> result = new ArrayList<RemboursementPret>();
		for(RemboursementPret data:datas){
			result.add(new RemboursementPret(data));
		}
		return result;
	}

	@Override
	public RemboursementPret find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		RemboursementPret data = super.find(propertyName, entityID);
		return new RemboursementPret(data);
	}

	@Override
	public List<RemboursementPret> findAll() {
		// TODO Auto-generated method stub		
		List<RemboursementPret> datas = super.findAll();
		List<RemboursementPret> result = new ArrayList<RemboursementPret>();
		for(RemboursementPret data:datas){
			result.add(new RemboursementPret(data));
		}
		return result;
	}

	@Override
	public RemboursementPret confirme(RemboursementPret entity,PeriodePaie periode) {
		// TODO Auto-generated method stub
		//Traitement des Elements Variables de paie
		ElementVariable element = null ;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("salarie0", entity.getDemande().getEmploye());
		container.addEq("peiode", periode);
		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
		if(datas!=null && datas.size()>0){
			element = datas.get(0);
		}//end if(datas!=null && datas.size()>0)
		if(element==null){
			element = new ElementVariable();
			element.setSalarie(entity.getDemande().getEmploye());
			element.setPeiode(periode);		
			variabledao.save(element);
			datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
			if(datas!=null && datas.size()>0){
				element = datas.get(0);
			}
		}//end if(element==null)
		entity.setEltVariable(element);
		entity.setState("confirme");
		dao.update(entity.getId(), entity);
		return entity;
	}

	@Override
	public RemboursementPret annule(RemboursementPret entity) {
		// TODO Auto-generated method stub
		entity.setState("refuse");
		dao.update(entity.getId(), entity);
		return entity;
	}
    
    

}
