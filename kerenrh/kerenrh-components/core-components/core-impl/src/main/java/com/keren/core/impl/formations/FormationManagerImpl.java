
package com.keren.core.impl.formations;

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
import com.keren.core.ifaces.formations.FormationManagerLocal;
import com.keren.core.ifaces.formations.FormationManagerRemote;
import com.keren.dao.ifaces.formations.FormationDAOLocal;
import com.keren.dao.ifaces.formations.LignePlanningFormationDAOLocal;
import com.keren.dao.ifaces.formations.SeanceFormationDAOLocal;
import com.keren.model.employes.Employe;
import com.keren.model.formations.Formation;
import com.keren.model.formations.LignePlanningFormation;
import com.keren.model.formations.ParticipantSeance;
import com.keren.model.formations.SeanceFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "FormationManager")
public class FormationManagerImpl
    extends AbstractGenericManager<Formation, Long>
    implements FormationManagerLocal, FormationManagerRemote
{

    @EJB(name = "FormationDAO")
    protected FormationDAOLocal dao;
    
    @EJB(name = "LignePlanningFormationDAO")
    protected LignePlanningFormationDAOLocal plandao;
    
    @EJB(name = "SeanceFormationDAO")
    protected SeanceFormationDAOLocal seancedao;

    public FormationManagerImpl() {
    }

    @Override
    public GenericDAO<Formation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public Formation delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<Formation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Formation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Formation> results = new ArrayList<Formation>();
		for(Formation data:datas){
			results.add(new Formation(data));
		}
		return results;
	}

	@Override
	public Formation find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Formation data = super.find(propertyName, entityID);
		Formation result = new Formation(data);
		for(SeanceFormation seance:data.getSeances()){
			result.getSeances().add(new SeanceFormation(seance));
		}
		return result;
	}

	@Override
	public List<Formation> findAll() {
		// TODO Auto-generated method stub		
		List<Formation> datas = super.findAll();
		List<Formation> results = new ArrayList<Formation>();
		for(Formation data:datas){
			results.add(new Formation(data));
		}
		return results;
	}

	@Override
	public void processAfterSave(Formation entity) {
		// TODO Auto-generated method stub
		super.processAfterSave(entity);
	}

	@Override
	public void processAfterUpdate(Formation entity) {
		// TODO Auto-generated method stub
		LignePlanningFormation plan = plandao.findByPrimaryKey("id",entity.getPlan().getId());
		for(SeanceFormation seance:entity.getSeances()){
			if(seance.getId()<=0){
				for(Employe employ:plan.getCibles()){
					ParticipantSeance part = new ParticipantSeance(employ, Boolean.FALSE);
					seance.getParticipants().add(part);
				}//end for(Employe employ:plan.getCibles()){
				seance.getFormateurs().add(plan.getFormateur());
				seance.setFormation(entity);
				seance.setState("etabli");
				seancedao.save(seance);
			}else{
				seancedao.update(seance.getId(), seance);
			}//end if(seance.getId()<=0){
		}//end for(SeanceFormation seance:entity.getSeances()){
		super.processAfterUpdate(entity);
	}

	@Override
	public Formation valide(Formation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("valide");
			dao.update(entity.getId(), entity);
		}
		Formation result = new Formation(entity);
		for(SeanceFormation seance:entity.getSeances()){
			result.getSeances().add(new SeanceFormation(seance));
		}
		return result;
	}

	@Override
	public Formation annule(Formation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("annule");
			entity = dao.update(entity.getId(), entity);
			for(SeanceFormation seance:entity.getSeances()){
				seance.setState("annule");
				seancedao.update(seance.getId(), seance);
			}//end for(SeanceFormation seance:entity.getSeances()){
		}
		Formation result = new Formation(entity);
		for(SeanceFormation seance:entity.getSeances()){
			result.getSeances().add(new SeanceFormation(seance));
		}
		return result;
	}

	@Override
	public Formation cloture(Formation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("valide")
				||entity.getState().equalsIgnoreCase("encours")){
			entity.setState("termine");
			entity = dao.update(entity.getId(), entity);			
		}//end if(entity.getState().equalsIgnoreCase("valide")
		Formation result = new Formation(entity);
		for(SeanceFormation seance:entity.getSeances()){
			result.getSeances().add(new SeanceFormation(seance));
		}//end for(SeanceFormation seance:entity.getSeances()){
		return result;
	}
    
    

}
