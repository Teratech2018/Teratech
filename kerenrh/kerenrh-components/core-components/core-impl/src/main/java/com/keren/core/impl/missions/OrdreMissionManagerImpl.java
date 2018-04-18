
package com.keren.core.impl.missions;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.missions.OrdreMissionManagerLocal;
import com.keren.core.ifaces.missions.OrdreMissionManagerRemote;
import com.keren.dao.ifaces.missions.MissionDAOLocal;
import com.keren.dao.ifaces.missions.OrdreMissionDAOLocal;
import com.keren.model.employes.Employe;
import com.keren.model.missions.Escale;
import com.keren.model.missions.FraisMission;
import com.keren.model.missions.Mission;
import com.keren.model.missions.OrdreMission;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "OrdreMissionManager")
public class OrdreMissionManagerImpl
    extends AbstractGenericManager<OrdreMission, Long>
    implements OrdreMissionManagerLocal, OrdreMissionManagerRemote
{

    @EJB(name = "OrdreMissionDAO")
    protected OrdreMissionDAOLocal dao;
    
    @EJB(name = "MissionDAO")
    protected MissionDAOLocal missiondao;

    public OrdreMissionManagerImpl() {
    }

    @Override
    public GenericDAO<OrdreMission, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<OrdreMission> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotEq("mission.state", "etabli");
        container.addNotEq("mission.state", "annule");
        predicats.addAll(container.getPredicats());
    	List<OrdreMission> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<OrdreMission> results = new ArrayList<OrdreMission>();
        for(OrdreMission ordre:datas){
            results.add(new OrdreMission(ordre));
        }
        return results;
    }

    @Override
    public List<OrdreMission> findAll() {
        List<OrdreMission> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<OrdreMission> results = new ArrayList<OrdreMission>();
        for(OrdreMission ordre:datas){
            results.add(new OrdreMission(ordre));
        }
        return results;
    }
    
    @Override
    public OrdreMission find(String propertyName, Long entityID) {
        OrdreMission data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        OrdreMission result = new OrdreMission(data);
        result.setMission(new Mission(data.getMission()));
        for(Escale escale:data.getEscales()){
            result.getEscales().add(new Escale(escale));
        }
        for(FraisMission frais:data.getFrais()){
            result.getFrais().add(new FraisMission(frais));
        }
        for(Employe employe:data.getResources()){
            result.getResources().add(new Employe(employe));
        }
        return result;
        
    }
    
    
    
    @Override
    public OrdreMission valide(OrdreMission entity) {
        if(entity.getState().equalsIgnoreCase("etabli")){
        	entity.setState("valide");
        	entity = dao.update(entity.getId(), entity);
        	Mission mission = entity.getMission();
        	mission.setState("encours");
        	missiondao.update(mission.getId(), mission);
        }//end if(entity.getState().equalsIgnoreCase("etali")){
        OrdreMission result = new OrdreMission(entity);
        for(Escale escale:entity.getEscales()){
            result.getEscales().add(new Escale(escale));
        }
        for(FraisMission frais:entity.getFrais()){
            result.getFrais().add(new FraisMission(frais));
        }
        for(Employe employe:entity.getResources()){
            result.getResources().add(new Employe(employe));
        }
        return result;
    }

    @Override
    public OrdreMission annule(OrdreMission entity) {
    	if(entity.getState().equalsIgnoreCase("valide")){
        	entity.setState("annule");
        	entity = dao.update(entity.getId(), entity);
//        	Mission mission = entity.getMission();
//        	mission.setState("encours");
//        	missiondao.update(mission.getId(), mission);
        }//end if(entity.getState().equalsIgnoreCase("etali")){
        OrdreMission result = new OrdreMission(entity);
        for(Escale escale:entity.getEscales()){
            result.getEscales().add(new Escale(escale));
        }
        for(FraisMission frais:entity.getFrais()){
            result.getFrais().add(new FraisMission(frais));
        }
        for(Employe employe:entity.getResources()){
            result.getResources().add(new Employe(employe));
        }
        return result;
    }

}
