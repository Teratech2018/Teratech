
package com.kerenedu.configuration;

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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.personnel.Professeur;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "MatiereManager")
public class MatiereManagerImpl
    extends AbstractGenericManager<Matiere, Long>
    implements MatiereManagerLocal, MatiereManagerRemote
{

    @EJB(name = "MatiereDAO")
    protected MatiereDAOLocal dao;

    public MatiereManagerImpl() {
    }

    @Override
    public GenericDAO<Matiere, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Matiere> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Matiere> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Matiere> result = new ArrayList<Matiere>();
   		for(Matiere elev:datas){
   			result.add(new Matiere(elev));
   		}
   		return result;
   	}

   	@Override
   	public Matiere find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Matiere elev = super.find(propertyName, entityID);
   		Matiere data = new Matiere(elev);
   		return data;
   	}

   	@Override
   	public List<Matiere> findAll() {
   		// TODO Auto-generated method stub
   		List<Matiere> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public Matiere delete(Long id) {
   		// TODO Auto-generated method stub
   		Matiere elev = super.delete(id);
   		return new Matiere(elev);
   	}

}
