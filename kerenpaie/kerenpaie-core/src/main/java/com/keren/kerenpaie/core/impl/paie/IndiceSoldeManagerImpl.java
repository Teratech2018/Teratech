
package com.keren.kerenpaie.core.impl.paie;

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
import com.keren.kerenpaie.core.ifaces.paie.IndiceSoldeManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.IndiceSoldeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.IndiceSoldeDAOLocal;
import com.keren.kerenpaie.model.paie.IndiceSolde;
import com.keren.kerenpaie.model.paie.LigneConvension;
import com.keren.kerenpaie.model.paie.LigneIndiceSolde;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "IndiceSoldeManager")
public class IndiceSoldeManagerImpl
    extends AbstractGenericManager<IndiceSolde, Long>
    implements IndiceSoldeManagerLocal, IndiceSoldeManagerRemote
{

    @EJB(name = "IndiceSoldeDAO")
    protected IndiceSoldeDAOLocal dao;

    public IndiceSoldeManagerImpl() {
    }

    @Override
    public GenericDAO<IndiceSolde, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public IndiceSolde delete(Long id) {
		// TODO Auto-generated method stub
		IndiceSolde data = super.delete(id);
		return new IndiceSolde(data);
	}

	@Override
	public List<IndiceSolde> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<IndiceSolde> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<IndiceSolde> result = new ArrayList<IndiceSolde>();
		for(IndiceSolde data:datas){
			result.add(new IndiceSolde(data));
		}
		return result;
	}

	@Override
	public IndiceSolde find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		IndiceSolde data = super.find(propertyName, entityID);
		IndiceSolde result = new IndiceSolde(data);		
		for(LigneIndiceSolde ligne:data.getIndicessolde()){
			result.getIndicessolde().add(new LigneIndiceSolde(ligne));
		}//end for(LigneIndiceSolde ligne:data.getIndicessolde()){
		return result;
	}

	@Override
	public List<IndiceSolde> findAll() {
		// TODO Auto-generated method stub		
		List<IndiceSolde> datas = super.findAll();
		List<IndiceSolde> result = new ArrayList<IndiceSolde>();
		for(IndiceSolde data:datas){
			result.add(new IndiceSolde(data));
		}
		return result;
	}

	@Override
	public void processBeforeSave(IndiceSolde entity) {
		// TODO Auto-generated method stub
		for(LigneIndiceSolde ligne:entity.getIndicessolde()){
			if(ligne.getId()<0){
				ligne.setId(-1);
			}
		}
		super.processBeforeSave(entity);
	}

	@Override
	public void processBeforeUpdate(IndiceSolde entity) {
		// TODO Auto-generated method stub
		for(LigneIndiceSolde ligne:entity.getIndicessolde()){
			if(ligne.getId()<0){
				ligne.setId(-1);
			}
		}
		super.processBeforeUpdate(entity);
	}

	@Override
	public IndiceSolde actif(IndiceSolde entity) {
		// TODO Auto-generated method stub
		entity.setState("active");
		dao.update(entity.getId(), entity);
		return entity;
	}

	@Override
	public IndiceSolde inactif(IndiceSolde entity) {
		// TODO Auto-generated method stub
		entity.setState("inactive");
		dao.update(entity.getId(), entity);
		return entity;
	}
    
    

}
