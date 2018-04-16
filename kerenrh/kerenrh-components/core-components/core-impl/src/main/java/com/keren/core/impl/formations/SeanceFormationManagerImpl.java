
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
import com.keren.core.ifaces.formations.SeanceFormationManagerLocal;
import com.keren.core.ifaces.formations.SeanceFormationManagerRemote;
import com.keren.dao.ifaces.formations.FormationDAOLocal;
import com.keren.dao.ifaces.formations.SeanceFormationDAOLocal;
import com.keren.model.formations.Formateur;
import com.keren.model.formations.Formation;
import com.keren.model.formations.ParticipantSeance;
import com.keren.model.formations.SeanceFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "SeanceFormationManager")
public class SeanceFormationManagerImpl
    extends AbstractGenericManager<SeanceFormation, Long>
    implements SeanceFormationManagerLocal, SeanceFormationManagerRemote
{

    @EJB(name = "SeanceFormationDAO")
    protected SeanceFormationDAOLocal dao;
    
    @EJB(name = "FormationDAO")
    protected FormationDAOLocal formationdao;
    

    public SeanceFormationManagerImpl() {
    }

    @Override
    public GenericDAO<SeanceFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public SeanceFormation delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<SeanceFormation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("state", "etabli");
		predicats.addAll(container.getPredicats());
		List<SeanceFormation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<SeanceFormation> results = new ArrayList<SeanceFormation>();
		for(SeanceFormation data:datas){
			results.add(new SeanceFormation(data));
		}
		return results;
	}

	@Override
	public SeanceFormation find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		SeanceFormation data = super.find(propertyName, entityID);
		SeanceFormation result = new SeanceFormation(data);
		result.setFormation(new Formation(data.getFormation()));
		for(ParticipantSeance part:data.getParticipants()){
			result.getParticipants().add(new ParticipantSeance(part));
		}
		for(Formateur form:data.getFormateurs()){
			result.getFormateurs().add(new Formateur(form));
		}
		return result;
	}

	@Override
	public List<SeanceFormation> findAll() {
		// TODO Auto-generated method stub		
		List<SeanceFormation> datas = super.findAll();
		List<SeanceFormation> results = new ArrayList<SeanceFormation>();
		for(SeanceFormation data:datas){
			results.add(new SeanceFormation(data));
		}
		return results;
	}
	
	

	@Override
	public SeanceFormation valide(SeanceFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("valide");
			dao.update(entity.getId(), entity);
			//Traitement de la formation liée
			Formation formation = entity.getFormation();
			formation.setState("encours");
			formationdao.update(formation.getId(), formation);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		SeanceFormation result = new SeanceFormation(entity);
		result.setFormation(new Formation(entity.getFormation()));
		for(ParticipantSeance part:entity.getParticipants()){
			result.getParticipants().add(new ParticipantSeance(part));
		}
		for(Formateur form:entity.getFormateurs()){
			result.getFormateurs().add(new Formateur(form));
		}
		return result;
	}

	@Override
	public SeanceFormation annule(SeanceFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("annule");
			dao.update(entity.getId(), entity);
			//Traitement de la formation liée
			Formation formation = entity.getFormation();
			formation.setState("encours");
			formationdao.update(formation.getId(), formation);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		SeanceFormation result = new SeanceFormation(entity);
		result.setFormation(new Formation(entity.getFormation()));
		for(ParticipantSeance part:entity.getParticipants()){
			result.getParticipants().add(new ParticipantSeance(part));
		}
		for(Formateur form:entity.getFormateurs()){
			result.getFormateurs().add(new Formateur(form));
		}
		return result;
	}
    
    

}
