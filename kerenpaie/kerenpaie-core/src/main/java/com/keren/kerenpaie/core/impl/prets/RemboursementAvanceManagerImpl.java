
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
import com.keren.kerenpaie.core.ifaces.prets.RemboursementAvanceManagerLocal;
import com.keren.kerenpaie.core.ifaces.prets.RemboursementAvanceManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.RemboursementAvanceDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.keren.kerenpaie.model.prets.RemboursementAvance;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RemboursementAvanceManager")
public class RemboursementAvanceManagerImpl
    extends AbstractGenericManager<RemboursementAvance, Long>
    implements RemboursementAvanceManagerLocal, RemboursementAvanceManagerRemote
{

    @EJB(name = "RemboursementAvanceDAO")
    protected RemboursementAvanceDAOLocal dao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;
    
    
    public RemboursementAvanceManagerImpl() {
    }

    @Override
    public GenericDAO<RemboursementAvance, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public RemboursementAvance delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<RemboursementAvance> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<RemboursementAvance> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<RemboursementAvance> result = new ArrayList<RemboursementAvance>();
		for(RemboursementAvance data:datas){
			result.add(new RemboursementAvance(data));
		}
		return result;
	}

	@Override
	public RemboursementAvance find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		RemboursementAvance data= super.find(propertyName, entityID);
		RemboursementAvance result = new RemboursementAvance(data);
		return result;
	}

	@Override
	public List<RemboursementAvance> findAll() {
		// TODO Auto-generated method stub
		List<RemboursementAvance> datas =super.findAll();
		List<RemboursementAvance> result = new ArrayList<RemboursementAvance>();
		for(RemboursementAvance data:datas){
			result.add(new RemboursementAvance(data));
		}
		return result;
	}

	/**
	 * 
	 * @param entity
	 * @param periode
	 * @return
	 */
	@Override
	public RemboursementAvance valider(RemboursementAvance entity,PeriodePaie periode) {
		// TODO Auto-generated method stub
		//Traitement des Elements Variables de paie
		periode = periodedao.findByPrimaryKey("id", periode.getId());
		ElementVariable element = null ;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("salarie0", entity.getAvance().getEmploye());
		container.addEq("peiode", periode);
		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
		if(datas!=null && datas.size()>0){
			element = datas.get(0);
		}//end if(datas!=null && datas.size()>0)
		if(element==null){
			element = new ElementVariable();
			element.setSalarie(entity.getAvance().getEmploye());
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
	public RemboursementAvance refuser(RemboursementAvance entity) {
		// TODO Auto-generated method stub
		entity.setState("refuse");
		dao.update(entity.getId(), entity);
		return entity;
	}
    
    
    

}
