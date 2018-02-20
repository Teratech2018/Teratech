
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
import com.kerenedu.school.Contacts;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ProfesseurManager")
public class ProfesseurManagerImpl
    extends AbstractGenericManager<Professeur, Long>
    implements ProfesseurManagerLocal, ProfesseurManagerRemote
{

    @EJB(name = "ProfesseurDAO")
    protected ProfesseurDAOLocal dao;

    public ProfesseurManagerImpl() {
    }

    @Override
    public GenericDAO<Professeur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<Professeur> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Professeur> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Professeur> result = new ArrayList<Professeur>();
   		for(Professeur elev:datas){
   			result.add(new Professeur(elev));
   		}
   		return result;
   	}

   	@Override
   	public Professeur find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Professeur elev = super.find(propertyName, entityID);
   		Professeur inscrip = new Professeur(elev);
		
   		return inscrip;
   	}

   	@Override
   	public List<Professeur> findAll() {
   		// TODO Auto-generated method stub
   		List<Professeur> datas = super.findAll();
   		List<Professeur> result = new ArrayList<Professeur>();
   		for(Professeur elev:datas){
   			result.add(new Professeur(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Professeur delete(Long id) {
   		// TODO Auto-generated method stub
   		Professeur elev = super.delete(id);
   		return new Professeur(elev);
   	}
}
