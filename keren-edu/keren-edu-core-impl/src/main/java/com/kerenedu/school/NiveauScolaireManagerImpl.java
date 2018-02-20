
package com.kerenedu.school;

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
@Stateless(mappedName = "NiveauScolaireManager")
public class NiveauScolaireManagerImpl
    extends AbstractGenericManager<NiveauScolaire, Long>
    implements NiveauScolaireManagerLocal, NiveauScolaireManagerRemote
{

    @EJB(name = "NiveauScolaireDAO")
    protected NiveauScolaireDAOLocal dao;

    public NiveauScolaireManagerImpl() {
    }

    @Override
    public GenericDAO<NiveauScolaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<NiveauScolaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<NiveauScolaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<NiveauScolaire> result = new ArrayList<NiveauScolaire>();
   		for(NiveauScolaire elev:datas){
   			result.add(new NiveauScolaire(elev));
   		}
   		return result;
   	}

   	@Override
   	public NiveauScolaire find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		NiveauScolaire elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<NiveauScolaire> findAll() {
   		// TODO Auto-generated method stub
   		List<NiveauScolaire> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public NiveauScolaire delete(Long id) {
   		// TODO Auto-generated method stub
   		NiveauScolaire elev = super.delete(id);
   		return new NiveauScolaire(elev);
   	}

}
