
package com.keren.core.impl.presences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.presences.PointageJouranlierManagerLocal;
import com.keren.core.ifaces.presences.PointageJouranlierManagerRemote;
import com.keren.dao.ifaces.presences.LignePointageDAOLocal;
import com.keren.dao.ifaces.presences.PointageJouranlierDAOLocal;
import com.keren.model.presences.LignePointage;
import com.keren.model.presences.PointageJouranlier;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PointageJouranlierManager")
public class PointageJouranlierManagerImpl
    extends AbstractGenericManager<PointageJouranlier, Long>
    implements PointageJouranlierManagerLocal, PointageJouranlierManagerRemote
{

    @EJB(name = "PointageJouranlierDAO")
    protected PointageJouranlierDAOLocal dao;
    
    @EJB(name = "LignePointageDAO")
    protected LignePointageDAOLocal lignedao;

    public PointageJouranlierManagerImpl() {
    }

    @Override
    public GenericDAO<PointageJouranlier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public PointageJouranlier delete(Long id) {
		// TODO Auto-generated method stub
		PointageJouranlier data = super.delete(id);
		return new PointageJouranlier(data);
	}

	@Override
	public List<PointageJouranlier> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<PointageJouranlier> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<PointageJouranlier> results = new ArrayList<PointageJouranlier>();
		for(PointageJouranlier data:datas){
			results.add(new PointageJouranlier(data));
		}
		return results;
	}

	@Override
	public PointageJouranlier find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		PointageJouranlier data = super.find(propertyName, entityID);
		PointageJouranlier result = new PointageJouranlier(data);
		for(LignePointage ligne:data.getLignes()){
			result.getLignes().add(new LignePointage(ligne));
		}//end for(LignePointage ligne:data.getLignes()){
		return result;
	}

	@Override
	public List<PointageJouranlier> findAll() {
		// TODO Auto-generated method stub		
		List<PointageJouranlier> datas = super.findAll();
		List<PointageJouranlier> results = new ArrayList<PointageJouranlier>();
		for(PointageJouranlier data:datas){
			results.add(new PointageJouranlier(data));
		}//end for(PointageJouranlier data:datas){
		return results;
	}

	@Override
	public void processAfterSave(PointageJouranlier entity) {
		// TODO Auto-generated method stub
		entity = dao.findByPrimaryKey("code", entity.getCode());
		for(LignePointage ligne:entity.getLignes()){
			ligne.setPointage(entity);
			ligne.setDatepointage(entity.getDatepointage());
			ligne.setState("etabli");
			lignedao.save(ligne);
		}//end for(LignePointage ligne:entity.getLignes()){
		super.processAfterSave(entity);
	}

	@Override
	public void processBeforeUpdate(PointageJouranlier entity) {
		// TODO Auto-generated method stub
		Map<Long, LignePointage> map = new HashMap<Long, LignePointage>();
		PointageJouranlier oldentity = dao.findByPrimaryKey("id", entity.getId());
		//Construction du cache
		for(LignePointage ligne:oldentity.getLignes()){
			map.put(ligne.getId(), ligne);
		}//end for(LignePointage ligne:oldentity.getLignes()){
		//Traitement des lignes 
		for(LignePointage ligne:entity.getLignes()){
			if(ligne.getId()<=0){
				ligne.setPointage(entity);
				ligne.setDatepointage(entity.getDatepointage());
				ligne.setState("etabli");
				lignedao.save(ligne);
			}else{
				map.remove(ligne.getId());
				ligne.setPointage(entity);
				ligne.setDatepointage(entity.getDatepointage());
				lignedao.update(ligne.getId(), ligne);
			}//end if(ligne.getId()<=0){
		}//end for(LignePointage ligne:entity.getLignes()){
		//Traitement des lignes supprimées
		for(Long key : map.keySet()){
			lignedao.delete(key);
		}//end for(Long key : map.keySet()){
		super.processAfterUpdate(entity);
	}

	@Override
	public void processBeforeDelete(PointageJouranlier entity) {
		// TODO Auto-generated method stub
		for(LignePointage ligne:entity.getLignes()){
			lignedao.delete(ligne.getId());
		}//end for(LignePointage ligne:entity.getLignes()){
		super.processBeforeDelete(entity);
	}

	@Override
	public PointageJouranlier confirmer(PointageJouranlier entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("confirmer");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		PointageJouranlier result = new PointageJouranlier(entity);
		for(LignePointage ligne:entity.getLignes()){
			result.getLignes().add(new LignePointage(ligne));
		}//end for(LignePointage ligne:data.getLignes()){
		return result;
	}
    
    

}
