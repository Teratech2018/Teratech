
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.core.tools.EnmHeureCours;
import com.core.tools.EnmJoursCours;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.notes.CoefMatiereDetailDAOLocal;
import com.kerenedu.notes.CoefMatiereManagerImpl;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PlanifCoursManager")
public class PlanifCoursManagerImpl
    extends AbstractGenericManager<PlanifCours, Long>
    implements PlanifCoursManagerLocal, PlanifCoursManagerRemote
{

    @EJB(name = "PlanifCoursDAO")
    protected PlanifCoursDAOLocal dao;
    
    @EJB(name = "CoefMatiereDetailDAO")
    protected CoefMatiereDetailDAOLocal daoCoefMatDlt;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;    
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal classedao;    
    
    @EJB(name = "JoursCoursDAO")
    protected JoursCoursDAOLocal jourCoursdao;


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
//   	 if(data.getJourscours()==null||data.getJourscours().isEmpty()){
//		for(EnmJoursCours jour :listjours){
//			listthc = new ArrayList<TrancheHoraireCours>();
//			for(EnmHeureCours heure:listheure){
//				 thc = new TrancheHoraireCours(heure);
//				 listthc.add(thc);
//			}
//			 jc = new JoursCours(jour,listthc);
//			 listjc.add(jc);
//		}
//		result.setJourscours(listjc);
//	 }else{
//		 List<JoursCours> listJC = new ArrayList<JoursCours>();
//		 List<TrancheHoraireCours>listtranche = new ArrayList<TrancheHoraireCours>();
//		 listJC = new ArrayList<JoursCours>();
//		 for(JoursCours serv: data.getJourscours()){
//			 JoursCours jci = new JoursCours(serv);
//			 listtranche = new ArrayList<TrancheHoraireCours>();
//			 listtranche=serv.getTranchehorairecours();
//			 jci.getTranchehorairecours().addAll(listtranche);
//			 listJC.add(jci);			
//	   		}
//		 result.setJourscours(listJC);
//	   	
//	 }
 	return result;

   		
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
   	
	public List<JoursCours> findjourscours(Long id) {
		System.out.println(CoefMatiereManagerImpl.class.toString()+" ========================================== "+id);
		List<JoursCours> datas = new ArrayList<JoursCours>() ;
		 List<JoursCours> result = new ArrayList<JoursCours>();
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 TrancheHoraireCours thc ;
		 List<TrancheHoraireCours>listthc = new ArrayList<TrancheHoraireCours>();
		 List<EnmJoursCours> listjours =EnmJoursCours.getList();
		 List<EnmHeureCours> listheure=EnmHeureCours.getList();
		 List<JoursCours>listjc = new ArrayList<JoursCours>();
		 JoursCours jc ;
		 
		if(id>0){
			// recherche l'objet classe
			// verifier si existe dejà	
			container = RestrictionsContainer.newInstance();
			 container.addEq("classe.id",id);
			 result = jourCoursdao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			 
			if(result==null||result.isEmpty()||result.size()==0){
				 long index = 1 ;
				for(EnmJoursCours jour :listjours){
	   				listthc = new ArrayList<TrancheHoraireCours>();
	   				long idx =1;
	   				for(EnmHeureCours heure:listheure){
	   					 thc = new TrancheHoraireCours(heure);
	   					 thc.setId(idx);
	   					 listthc.add(thc);
	   					idx++;
	   				}// fin for(EnmHeureCours heure:listheure)
	   				 jc = new JoursCours(jour,listthc);
	   				jc.setId(-index);
	   				 listjc.add(jc);
	   				index++;
	   			} // fin (EnmJoursCours jour :listjours)
				datas.addAll(listjc);
			}else{
				System.out.println("CoefMatiereManagerImpl.findMatiereFiliere() size is "+result.size());
				for(JoursCours elev:result){
					datas.add(new JoursCours(elev));
	   	   		}// fin for(JoursCours elev:result)
			} // end if(result==null||result.isEmpty()||result.size()==0)

		}//end if(id!=-1){
		return datas;
	}


   	

}
