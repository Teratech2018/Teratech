
package com.keren.kerenpaie.core.impl.employes;

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
import com.keren.kerenpaie.core.ifaces.employes.CategorieManagerLocal;
import com.keren.kerenpaie.core.ifaces.employes.CategorieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.CategorieDAOLocal;
import com.keren.kerenpaie.model.employes.Categorie;
import com.keren.kerenpaie.model.employes.Echelon;
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
	public Categorie delete(Long id) {
		// TODO Auto-generated method stub
		Categorie data = super.delete(id);
		Categorie result = new Categorie(data);
		return result;
	}

	@Override
	public List<Categorie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Categorie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Categorie> result = new ArrayList<Categorie>();		
		for(Categorie cat:datas){
			result.add(new Categorie(cat));
		}
		return result;
	}

	@Override
	public Categorie find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Categorie data = super.find(propertyName, entityID);
		Categorie result = new Categorie(data);
		for(Echelon eche:data.getEchelons()){
			result.getEchelons().add(new Echelon(eche));
		}
		return result;
	}

	@Override
	public List<Categorie> findAll() {
		// TODO Auto-generated method stub		
		List<Categorie> datas = super.findAll();
		List<Categorie> result = new ArrayList<Categorie>();		
		for(Categorie cat:datas){
			result.add(new Categorie(cat));
		}
		return result;
	}
    
    

}
