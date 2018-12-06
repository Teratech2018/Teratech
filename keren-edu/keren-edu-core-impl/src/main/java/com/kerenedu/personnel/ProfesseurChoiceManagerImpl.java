
package com.kerenedu.personnel;

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
@Stateless(mappedName = "ProfesseurChoiceManager")
public class ProfesseurChoiceManagerImpl
    extends AbstractGenericManager<ProfesseurChoice, Long>
    implements ProfesseurChoiceManagerLocal, ProfesseurChoiceManagerRemote
{

    @EJB(name = "ProfesseurChoiceDAO")
    protected ProfesseurChoiceDAOLocal dao;

    public ProfesseurChoiceManagerImpl() {
    }

    @Override
    public GenericDAO<ProfesseurChoice, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<ProfesseurChoice> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
//    	RestrictionsContainer container = RestrictionsContainer.newInstance();
//    	container.addEq("discriminant","P");   	
//    	predicats.addAll(container.getPredicats());
   		List<ProfesseurChoice> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ProfesseurChoice> result = new ArrayList<ProfesseurChoice>();
   		for(ProfesseurChoice elev:datas){
   			result.add(new ProfesseurChoice(elev));
   		}
   		return result;
   	}

   	@Override
   	public ProfesseurChoice find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ProfesseurChoice elev = super.find(propertyName, entityID);
   		ProfesseurChoice inscrip = new ProfesseurChoice(elev);
		
   		return inscrip;
   	}

   	@Override
   	public List<ProfesseurChoice> findAll() {
   		// TODO Auto-generated method stub
   		List<ProfesseurChoice> datas = super.findAll();
   		List<ProfesseurChoice> result = new ArrayList<ProfesseurChoice>();
   		for(ProfesseurChoice elev:datas){
   			result.add(new ProfesseurChoice(elev));
   		}
   		return result;
   	}
   	
 
	@Override
   	public ProfesseurChoice delete(Long id) {
   		// TODO Auto-generated method stub
		ProfesseurChoice elev = super.delete(id);
   		return new ProfesseurChoice(elev);
   	}
}
