
package com.keren.core.impl.employes;

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
import com.keren.core.ifaces.employes.CategorieManagerLocal;
import com.keren.core.ifaces.employes.CategorieManagerRemote;
import com.keren.dao.ifaces.employes.CategorieDAOLocal;
import com.keren.model.employes.Categorie;
import com.keren.model.employes.Echelon;
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
		List<Categorie> results = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Categorie> curentdata = new ArrayList<Categorie>();
		for(Categorie elev:results){
			curentdata.add(new Categorie(elev));
		}
		
		return curentdata;
	}

	@Override
	public Categorie find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Categorie results = super.find(propertyName, entityID);
		Categorie curentdata = new Categorie(results);
		
		for(Echelon ech: results.getEchelons()){
			curentdata.getEchelons().add(new Echelon(ech));
   		}
		
		return curentdata;
	}

	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub
		List<Categorie> results = super.findAll();
		List<Categorie> curentdata = new ArrayList<Categorie>();
		
		for(Categorie elev:curentdata){
			results.add(new Categorie(elev));
		}
		return results;
	}
	
    

}
