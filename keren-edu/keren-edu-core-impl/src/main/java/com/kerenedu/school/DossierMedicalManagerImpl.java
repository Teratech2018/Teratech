
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
@Stateless(mappedName = "DossierMedicalManager")
public class DossierMedicalManagerImpl
    extends AbstractGenericManager<DossierMedical, Long>
    implements DossierMedicalManagerLocal, DossierMedicalManagerRemote
{

    @EJB(name = "DossierMedicalDAO")
    protected DossierMedicalDAOLocal dao;

    public DossierMedicalManagerImpl() {
    }

    @Override
    public GenericDAO<DossierMedical, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<DossierMedical> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<DossierMedical> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<DossierMedical> result = new ArrayList<DossierMedical>();
   		for(DossierMedical elev:datas){
   			result.add(new DossierMedical(elev));
   		}
   		return result;
   	}

   	@Override
   	public DossierMedical find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		DossierMedical elev = super.find(propertyName, entityID);
   		
   		return elev;
   	}

   	@Override
   	public List<DossierMedical> findAll() {
   		// TODO Auto-generated method stub
   		List<DossierMedical> datas = super.findAll();
   		
   		return datas;
   	}
   	
   	

   	@Override
   	public DossierMedical delete(Long id) {
   		// TODO Auto-generated method stub
   		DossierMedical elev = super.delete(id);
   		return new DossierMedical(elev);
   	}
}
