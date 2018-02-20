
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.print.attribute.standard.JobOriginatingUserName;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.EnmHeureCours;
import com.core.tools.EnmJoursCours;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PlanifCoursManager")
public class PlanifCoursManagerImpl
    extends AbstractGenericManager<PlanifCours, Long>
    implements PlanifCoursManagerLocal, PlanifCoursManagerRemote
{

    @EJB(name = "PlanifCoursDAO")
    protected PlanifCoursDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;    


    public PlanifCoursManagerImpl() {
    }

    @Override
    public GenericDAO<PlanifCours, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<PlanifCours> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<PlanifCours> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<PlanifCours> result = new ArrayList<PlanifCours>();
   		for(PlanifCours elev:datas){
   			result.add(new PlanifCours(elev));
   		}
   		return result;
   	}

   	@Override
   	public PlanifCours find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		PlanifCours data = super.find(propertyName, entityID);
   		PlanifCours result = new PlanifCours(data);
		 TrancheHoraireCours thc ;
		 List<TrancheHoraireCours>listthc = new ArrayList<TrancheHoraireCours>();
		 List<EnmJoursCours> listjours =EnmJoursCours.getList();
		 List<EnmHeureCours> listheure=EnmHeureCours.getList();
		 List<JoursCours>listjc = new ArrayList<JoursCours>();
		 JoursCours jc ;
   	 if(data.getJourscours()==null||data.getJourscours().isEmpty()){
		for(EnmJoursCours jour :listjours){
			listthc = new ArrayList<TrancheHoraireCours>();
			for(EnmHeureCours heure:listheure){
				 thc = new TrancheHoraireCours(heure);
				 listthc.add(thc);
			}
			 jc = new JoursCours(jour,listthc);
			 listjc.add(jc);
		}
		result.setJourscours(listjc);
	 }else{
		 List<JoursCours> listJC = new ArrayList<JoursCours>();
		 List<TrancheHoraireCours>listtranche = new ArrayList<TrancheHoraireCours>();
		 for(JoursCours serv: data.getJourscours()){
			 JoursCours jci = new JoursCours(serv);
			 listJC = new ArrayList<JoursCours>();
			 listtranche=serv.getTranchehorairecours();
			 jci.getTranchehorairecours().addAll(listtranche);
			 listJC.add(jci);			
	   		}
		 result.setJourscours(listJC);
	   	
	 }
 	return result;
	// en fonction de lenumjour contruire l'objet Jours cours
	// et pour chaque jours cours construire les tranche horaire
   		
   	}

   	@Override
   	public List<PlanifCours> findAll() {
   		// TODO Auto-generated method stub
   		List<PlanifCours> datas = super.findAll();
   		List<PlanifCours> result = new ArrayList<PlanifCours>();
   		for(PlanifCours elev:datas){
   			result.add(new PlanifCours(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public PlanifCours delete(Long id) {
   		// TODO Auto-generated method stub
   		PlanifCours elev = super.delete(id);
   		return new PlanifCours(elev);
   	}

	@Override
	public void processBeforeSave(PlanifCours entity) {
		// recuperer la classe 
		

		super.processBeforeSave(entity);
	}
   	
   	

}
