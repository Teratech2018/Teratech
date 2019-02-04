
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
@Stateless(mappedName = "CategorieManager")
public class CategorieManagerImpl
    extends AbstractGenericManager<Categorie, Long>
    implements CategorieManagerLocal, CategorieManagerRemote
{

    @EJB(name = "CategorieDAO")
    protected CategorieDAOLocal dao;

    public CategorieManagerImpl() {
    }

    @Override
    public GenericDAO<Categorie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Categorie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	//predicats.addAll(CacheMemory.defaultPredicatsCycle());
   		List<Categorie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Categorie> result = new ArrayList<Categorie>();
   		for(Categorie elev:datas){
   			result.add(new Categorie(elev));
   		}
   		return result;
   	}

   	@Override
	public void processBeforeSave(Categorie entity) {
	
		super.processBeforeSave(entity);
	}

	@Override
   	public Categorie find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Categorie elev = super.find(propertyName, entityID);
   		Categorie inscrip = new Categorie(elev);
//   		for(Echellon serv: elev.getEchelons()){
//   			inscrip.getEchelons().add(new Echellon(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<Categorie> findAll() {
   		// TODO Auto-generated method stub
//   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
   		List<Categorie> datas = super.findAll();
   		List<Categorie> result = new ArrayList<Categorie>();
   		for(Categorie elev:datas){
   			result.add(new Categorie(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Categorie delete(Long id) {
   		// TODO Auto-generated method stub
   		Categorie elev = super.delete(id);
   		return new Categorie(elev);
   	}


}
