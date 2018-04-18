
package com.keren.core.impl.formations;

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
import com.kerem.commons.DateHelper;
import com.keren.core.ifaces.formations.PlanningFormationManagerLocal;
import com.keren.core.ifaces.formations.PlanningFormationManagerRemote;
import com.keren.dao.ifaces.formations.BesionFormationDAOLocal;
import com.keren.dao.ifaces.formations.LignePlanningFormationDAOLocal;
import com.keren.dao.ifaces.formations.PlanningFormationDAOLocal;
import com.keren.model.formations.BesionFormation;
import com.keren.model.formations.LigneBesionFormation;
import com.keren.model.formations.LignePlanningFormation;
import com.keren.model.formations.PlanningFormation;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PlanningFormationManager")
public class PlanningFormationManagerImpl
    extends AbstractGenericManager<PlanningFormation, Long>
    implements PlanningFormationManagerLocal, PlanningFormationManagerRemote
{

    @EJB(name = "PlanningFormationDAO")
    protected PlanningFormationDAOLocal dao;
    
    @EJB(name = "BesionFormationDAO")
    protected BesionFormationDAOLocal besiondao;
    
    @EJB(name = "LignePlanningFormationDAO")
    protected LignePlanningFormationDAOLocal plandao;
    

    public PlanningFormationManagerImpl() {
    }

    @Override
    public GenericDAO<PlanningFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<PlanningFormation> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<PlanningFormation> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<PlanningFormation> results = new ArrayList<PlanningFormation>();
		for(PlanningFormation plan:datas){
			results.add(new PlanningFormation(plan));
		}
		return results;
	}

	@Override
	public PlanningFormation find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		PlanningFormation data = super.find(propertyName, entityID);
		PlanningFormation result = new PlanningFormation(data);
		for(LignePlanningFormation ligne:data.getLignes()){
			result.getLignes().add(new LignePlanningFormation(ligne));
		}
		return result;
	}

	@Override
	public List<PlanningFormation> findAll() {
		// TODO Auto-generated method stub
		List<PlanningFormation> datas = super.findAll();
		List<PlanningFormation> results = new ArrayList<PlanningFormation>();
		for(PlanningFormation plan:datas){
			results.add(new PlanningFormation(plan));
		}
		return results;
	}

	
	
	@Override
	public void processBeforeSave(PlanningFormation entity) {
		// TODO Auto-generated method stub
		/**
		 * Traitement du nbres de places
		 */		
		short nbreplaces =0;
		BesionFormation besion = besiondao.findByPrimaryKey("id", entity.getBesion().getId());
		for(LigneBesionFormation ligne : besion.getLignes()){
			nbreplaces +=ligne.getPlaces();
		}//end for(LigneBesionFormation ligne : besion.getLignes()){
		entity.setPlaces(nbreplaces);
		super.processBeforeSave(entity);
	}
	
	

	@Override
	public void processAfterSave(PlanningFormation entity) {
		// TODO Auto-generated method stub
		BesionFormation besion = entity.getBesion();
		besion.setState("planifie");
		besiondao.update(besion.getId(),besion);
		entity.setState("etabli");
		//Traitement des LignePlanning
		for(LignePlanningFormation ligne:entity.getLignes()){
			ligne.setState("etabli");
			ligne.setPlanning(entity);
			ligne.setPlaces(Short.parseShort(""+(ligne.getCibles()==null ? 0:ligne.getCibles().size())));
			ligne.setDuree(Short.parseShort(""+DateHelper.numberOfMonth(ligne.getDdebut(), ligne.getDfin())));
			System.out.println(PlanningFormationManagerImpl.class.toString()+" ::::::::::::::::::::::::::::::::::::::::::"+ligne.getFormateur().toString());			
			if(ligne.getId()>0){
				plandao.update(ligne.getId(), ligne);
			}else {
				plandao.save(ligne);
			}//end if(ligne.getId()>0){
		}//end for(LignePlanningFormation ligne:entity.getLignes()){
		super.processAfterSave(entity);
	}

	@Override
	public void processBeforeUpdate(PlanningFormation entity) {
		// TODO Auto-generated method stub
		PlanningFormation oldentity = dao.findByPrimaryKey("id", entity.getId());
		HashMap<Long, LignePlanningFormation> map = new HashMap<Long, LignePlanningFormation>();
		for(LignePlanningFormation ligne:oldentity.getLignes()){
			map.put(ligne.getId(), ligne);
		}//end for(LignePlanningFormation ligne:oldentity.getLignes()){
		//Traitement des LignePlanning
		for(LignePlanningFormation ligne:entity.getLignes()){
			ligne.setState("etabli");
			ligne.setPlanning(entity);
			ligne.setPlaces(Short.parseShort(""+(ligne.getCibles()==null ? 0:ligne.getCibles().size())));
			ligne.setDuree(Short.parseShort(""+DateHelper.numberOfMonth(ligne.getDdebut(), ligne.getDfin())));
//			System.out.println(PlanningFormationManagerImpl.class.toString()+" ::::::::::::::::::::::::::::::::::::::::::"+ligne.getFormateur().toString());			
			if(ligne.getId()>0){
				map.remove(ligne.getId());
				plandao.update(ligne.getId(), ligne);
			}else {
				plandao.save(ligne);
			}//end if(ligne.getId()>0){
		}//end for(LignePlanningFormation ligne:entity.getLignes()){
		for(Long key:map.keySet()){
			plandao.delete(map.get(key).getId());
		}//end for(Long key:map.keySet()){
		super.processBeforeUpdate(entity);
	}

	@Override
	public PlanningFormation valide(PlanningFormation entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("valide");
			entity = dao.update(entity.getId(), entity);			
			for(LignePlanningFormation ligne:entity.getLignes()){
				ligne.setState("valide");
				plandao.update(ligne.getId(), ligne);
			}//end for(LignePlanningFormation ligne:entity.getLignes()){
			//Mise a jour etat du besion
			BesionFormation besion = entity.getBesion();
			besion.setState("planifie");
			besiondao.update(besion.getId(), besion);
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		PlanningFormation result = new PlanningFormation(entity);
		for(LignePlanningFormation ligne:entity.getLignes()){
			result.getLignes().add(new LignePlanningFormation(ligne));
		}
		return result;
		
	}
	
	

	@Override
	public void processBeforeDelete(PlanningFormation entity) {
		// TODO Auto-generated method stub
		//Mise a jour etat du besion
		BesionFormation besion = entity.getBesion();
		besion.setState("valide");
		besiondao.update(besion.getId(), besion);
		//Suppression des lignes
		for(LignePlanningFormation ligne:entity.getLignes()){
			plandao.delete(ligne.getId());
		}//end for(LignePlanningFormation ligne:entity.getLignes()){
		super.processBeforeDelete(entity);
	}

	@Override
	public PlanningFormation delete(Long id) {
		// TODO Auto-generated method stub
		PlanningFormation data = super.delete(id);
		return new PlanningFormation(data);
	}
    
    

}
