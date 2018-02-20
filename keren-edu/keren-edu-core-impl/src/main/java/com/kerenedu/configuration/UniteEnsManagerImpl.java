
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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "UniteEnsManager")
public class UniteEnsManagerImpl
    extends AbstractGenericManager<UniteEns, Long>
    implements UniteEnsManagerLocal, UniteEnsManagerRemote
{

    @EJB(name = "UniteEnsDAO")
    protected UniteEnsDAOLocal dao;

    public UniteEnsManagerImpl() {
    }

    @Override
    public GenericDAO<UniteEns, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
 	public List<UniteEns> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
 			int firstResult, int maxResult) {
 		// TODO Auto-generated method stub
 		List<UniteEns> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
 		List<UniteEns> result = new ArrayList<UniteEns>();
 		for(UniteEns elev:datas){
 			result.add(new UniteEns(elev));
 		}
 		return result;
 	}

 	@Override
 	public UniteEns find(String propertyName, Long entityID) {
 		// TODO Auto-generated method stub
 		UniteEns elev = super.find(propertyName, entityID);
 		UniteEns inscrip = new UniteEns(elev);
 		return inscrip;
 	}

 	@Override
 	public List<UniteEns> findAll() {
 		// TODO Auto-generated method stub
 		List<UniteEns> datas = super.findAll();
 		List<UniteEns> result = new ArrayList<UniteEns>();
 		for(UniteEns elev:datas){
 			result.add(new UniteEns(elev));
 		}
 		return result;
 	}
 	
 	

 	@Override
 	public UniteEns delete(Long id) {
 		// TODO Auto-generated method stub
 		UniteEns elev = super.delete(id);
 		return new UniteEns(elev);
 	}


}
