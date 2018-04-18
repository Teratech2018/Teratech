
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.MissionManagerLocal;
import com.keren.core.ifaces.missions.MissionManagerRemote;
import com.keren.dao.ifaces.missions.MissionDAOLocal;
import com.keren.dao.ifaces.missions.OrdreMissionDAOLocal;
import com.keren.model.missions.ActionMission;
import com.keren.model.missions.Deploiement;
import com.keren.model.missions.Mission;
import com.keren.model.missions.OrdreMission;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "MissionManager")
public class MissionManagerImpl
    extends AbstractGenericManager<Mission, Long>
    implements MissionManagerLocal, MissionManagerRemote
{

    @EJB(name = "MissionDAO")
    protected MissionDAOLocal dao;
    
     @EJB(name = "OrdreMissionDAO")
    protected OrdreMissionDAOLocal ordredao;

    public MissionManagerImpl() {
    }

    @Override
    public GenericDAO<Mission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Mission> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Mission> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Mission> results = new ArrayList<Mission>();
        for(Mission data:datas){
            results.add(new Mission(data));
        }
        return results;
    }

    @Override
    public List<Mission> findAll() {
        //To change body of generated methods, choose Tools | Templates.
         List<Mission> datas = super.findAll(); 
        List<Mission> results = new ArrayList<Mission>();
        
        for(Mission data:datas){
            results.add(new Mission(data));
        }
        return results;
    }

    @Override
    public Mission find(String propertyName, Long entityID) {
        Mission data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Mission result = new Mission(data);
        
        for(OrdreMission ordre:data.getMissions()){
            result.getMissions().add(new OrdreMission(ordre));
        }
        for(Deploiement dep:data.getDepoiements()){
            result.getDepoiements().add(new Deploiement(dep));
        }
        for(ActionMission action:data.getActions()){
            result.getActions().add(new ActionMission(action));
        }
        return result;
    }
    
    

    @Override
	public void processBeforeDelete(Mission entity) {
		// TODO Auto-generated method stub
    	for(OrdreMission ordre:entity.getMissions()){
    		ordredao.delete(ordre.getId());
    	}//end for(OrdreMission ordre:entity.getMissions()){
		super.processBeforeDelete(entity);
	}

	@Override
    public void processBeforeUpdate(Mission entity) {
		 Mission oldentity = dao.findByPrimaryKey("id", entity.getId());
		 HashMap<Long, OrdreMission> map = new HashMap<Long, OrdreMission>();
		 for(OrdreMission ordre:oldentity.getMissions()){
			 map.put(ordre.getId(), ordre);
		 }//end for(OrdreMission ordre:oldentity.getMissions()){
         for(OrdreMission ordre:entity.getMissions()){
            ordre.setMission(entity);
            if(ordre.getId()>0){
            	map.remove(ordre.getId());
                ordredao.update(ordre.getId(), ordre);
            }else {
            	ordre.setState("etabli");
                ordredao.save(ordre);
            }//end  if(ordre.getId()>0){
        }//end for(OrdreMission ordre:entity.getMissions()){
         //Traitement de Ordrre de mission supprimer
         for(Long key : map.keySet()){
        	 OrdreMission ordre = map.get(key);
        	 ordredao.delete(ordre.getId());
         }//end for(Long key : map.keySet()){
        super.processAfterUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processAfterSave(Mission entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());
        //Traitement des ordre de missions
        for(OrdreMission ordre:entity.getMissions()){
            ordre.setMission(entity);
            ordre.setState("etabli");
            if(ordre.getId()>0){
                ordredao.update(ordre.getId(), ordre);
            }else {
                ordredao.save(ordre);
            }
        }
        super.processAfterSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public Mission valide(Mission entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }        
        Mission data = dao.update(entity.getId(), entity);
        //Traitement des ordre de missions
        for(OrdreMission ordre:entity.getMissions()){
            ordre.setMission(entity);
            if(ordre.getId()>0){
                ordredao.update(ordre.getId(), ordre);
            }else {
                ordredao.save(ordre);
            }
        }
        Mission result = new Mission(data);
        for(OrdreMission ordre:data.getMissions()){
            result.getMissions().add(new OrdreMission(ordre));
        }
        for(Deploiement dep:data.getDepoiements()){
            result.getDepoiements().add(new Deploiement(dep));
        }
        for(ActionMission action:data.getActions()){
            result.getActions().add(new ActionMission(action));
        }
        return result;
    }

    @Override
    public Mission annule(Mission entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }
        Mission data = dao.update(entity.getId(), entity);
        return new Mission(data);
    }
    
    

}
