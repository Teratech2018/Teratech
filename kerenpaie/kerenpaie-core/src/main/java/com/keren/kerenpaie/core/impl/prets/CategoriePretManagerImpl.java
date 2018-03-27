
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
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.prets.CategoriePretManagerLocal;
import com.keren.kerenpaie.core.ifaces.prets.CategoriePretManagerRemote;
import com.keren.kerenpaie.dao.ifaces.prets.CategoriePretDAOLocal;
import com.keren.kerenpaie.model.prets.CategoriePret;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CategoriePretManager")
public class CategoriePretManagerImpl
    extends AbstractGenericManager<CategoriePret, Long>
    implements CategoriePretManagerLocal, CategoriePretManagerRemote
{

    @EJB(name = "CategoriePretDAO")
    protected CategoriePretDAOLocal dao;

    public CategoriePretManagerImpl() {
    }

    @Override
    public GenericDAO<CategoriePret, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public CategoriePret delete(Long id) {
		// TODO Auto-generated method stub
		CategoriePret data =  super.delete(id);
		return new CategoriePret(data);
	}

	@Override
	public List<CategoriePret> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<CategoriePret> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<CategoriePret> result = new ArrayList<CategoriePret>();
		for(CategoriePret data:datas){
			result.add(new CategoriePret(data));
		}
		return result;
	}

	@Override
	public CategoriePret find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		CategoriePret data = super.find(propertyName, entityID);
		CategoriePret result = new CategoriePret(data);
		return result;
	}

	@Override
	public List<CategoriePret> findAll() {
		// TODO Auto-generated method stub		
		List<CategoriePret> datas = super.findAll();
		List<CategoriePret> result = new ArrayList<CategoriePret>();
		for(CategoriePret data:datas){
			result.add(new CategoriePret(data));
		}
		return result;
	}
    
    

}
