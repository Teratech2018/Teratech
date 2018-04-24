
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
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.LignePlanningFormationManagerLocal;
import com.keren.core.ifaces.formations.LignePlanningFormationManagerRemote;
import com.keren.dao.ifaces.formations.FormationDAOLocal;
import com.keren.dao.ifaces.formations.LignePlanningFormationDAOLocal;
import com.keren.dao.ifaces.formations.PlanningFormationDAOLocal;
import com.keren.model.employes.Employe;
import com.keren.model.formations.Formation;
import com.keren.model.formations.LignePlanningFormation;
import com.keren.model.formations.PlanningFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "LignePlanningFormationManager")
public class LignePlanningFormationManagerImpl
    extends AbstractGenericManager<LignePlanningFormation, Long>
    implements LignePlanningFormationManagerLocal, LignePlanningFormationManagerRemote
{

    @EJB(name = "LignePlanningFormationDAO")
    protected LignePlanningFormationDAOLocal dao;
    
    @EJB(name = "FormationDAO")
    protected FormationDAOLocal formationdao;
    
    @EJB(name = "PlanningFormationDAO")
    protected PlanningFormationDAOLocal planningdao;

    public LignePlanningFormationManagerImpl() {
    }

    @Override
    public GenericDAO<LignePlanningFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<LignePlanningFormation> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addNotEq("state", "etabli");
		predicats.addAll(container.getPredicats());
		// TODO Auto-generated method stub
		List<LignePlanningFormation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<LignePlanningFormation> results = new ArrayList<LignePlanningFormation>();
		for(LignePlanningFormation data:datas){
			results.add(new LignePlanningFormation(data));
		}
		return results;
	}

	@Override
	public LignePlanningFormation find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		LignePlanningFormation data = super.find(propertyName, entityID);
		LignePlanningFormation result = new LignePlanningFormation(data);
		result.setPlanning(new PlanningFormation(data.getPlanning()));
		for(Employe cible:data.getCibles()){
			result.getCibles().add(new Employe(cible));
		}
		for(Employe cible:data.getInternes()){
			result.getInternes().add(new Employe(cible));
		}
		return result;
	}

	@Override
	public List<LignePlanningFormation> findAll() {
		// TODO Auto-generated method stub		
		List<LignePlanningFormation> datas = super.findAll();
		List<LignePlanningFormation> results = new ArrayList<LignePlanningFormation>();
		for(LignePlanningFormation data:datas){
			results.add(new LignePlanningFormation(data));
		}
		return results;
	}

	@Override
	public LignePlanningFormation demaree(LignePlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("valide")){
			Formation formation = new Formation(entity);
			formation.setState("etabli");
			formationdao.save(formation);
			//Traitement du planning de Formation
			PlanningFormation planning = entity.getPlanning();
			planning.setState("encours");
			planningdao.update(planning.getId(), planning);
			//Traitement de ligne
			entity.setState("demarre");
			entity = dao.update(entity.getId(), entity);
		}//end if(entity.getState().equalsIgnoreCase("valide")){
		LignePlanningFormation result = new LignePlanningFormation(entity);
		result.setPlanning(new PlanningFormation(entity.getPlanning()));
		for(Employe cible:entity.getCibles()){
			result.getCibles().add(new Employe(cible));
		}
		for(Employe cible:entity.getInternes()){
			result.getInternes().add(new Employe(cible));
		}
		return result;		
	}
    
    

}
