
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
@Stateless(mappedName = "ElementVariableManager")
public class ElementVariableManagerImpl
    extends AbstractGenericManager<ElementVariable, Long>
    implements ElementVariableManagerLocal, ElementVariableManagerRemote
{

    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal dao;

    public ElementVariableManagerImpl() {
    }

    @Override
    public GenericDAO<ElementVariable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
	public ElementVariable delete(Long id) {
		// TODO Auto-generated method stub
		ElementVariable data = super.delete(id);
		return new ElementVariable(data);
	}

	@Override
	public List<ElementVariable> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ElementVariable> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ElementVariable> result = new ArrayList<ElementVariable>();
		for(ElementVariable data:datas){
			result.add(new ElementVariable(data));
		}
		return result;
	}

	@Override
	public ElementVariable find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ElementVariable data = super.find(propertyName, entityID);
		ElementVariable result = new ElementVariable(data);
		for(RemboursementAvance lign:data.getAvances()){
			result.getAvances().add(new RemboursementAvance(lign));
		}
		for(RemboursementPret lign:data.getPrets()){
			result.getPrets().add(new RemboursementPret(lign));
		}
		for(Acompte lign:data.getAcomptes()){
			result.getAcomptes().add(new Acompte(lign));
		}
		for(RappelSalaire lign:data.getRappels()){
			result.getRappels().add(new RappelSalaire(lign));
		}
//		for(LigneElementVariable lign:data.getLignes()){
//			result.getLignes().add(new LigneElementVariable(lign));
//		}
		return result;
	}

	@Override
	public List<ElementVariable> findAll() {
		// TODO Auto-generated method stub		
		List<ElementVariable> datas = super.findAll();
		List<ElementVariable> result = new ArrayList<ElementVariable>();
		for(ElementVariable data:datas){
			result.add(new ElementVariable(data));
		}
		return result;
	}

	@Override
	public void processBeforeSave(ElementVariable entity) {
		// TODO Auto-generated method stub		
		super.processBeforeSave(entity);
	}
    
    

}
