
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.EnmJoursCours;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "EmargementProfManager")
public class EmargementProfManagerImpl
    extends AbstractGenericManager<EmargementProf, Long>
    implements EmargementProfManagerLocal, EmargementProfManagerRemote
{

    @EJB(name = "EmargementProfDAO")
    protected EmargementProfDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao; 
    
    
    @EJB(name = "PlanifCoursDAO")
    protected PlanifCoursDAOLocal planifdao; 
    

    public EmargementProfManagerImpl() {
    }

    @Override
    public GenericDAO<EmargementProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<EmargementProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<EmargementProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<EmargementProf> result = new ArrayList<EmargementProf>();
   		for(EmargementProf elev:datas){
   			result.add(new EmargementProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public EmargementProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		EmargementProf elev = super.find(propertyName, entityID);
   		EmargementProf inscrip = new EmargementProf(elev);
   		if(elev.getEmagementdlt()==null||elev.getEmagementdlt().isEmpty()){
   		List<PlanifCours> listplaning = new ArrayList<PlanifCours>();
   		List<JoursCours> listJour = new ArrayList<JoursCours>();
   		List<TrancheHoraireCours> listTranche = new ArrayList<TrancheHoraireCours>();
   		List<EmargementProfDetails> emargeDlt = new ArrayList<EmargementProfDetails>();
   		 RestrictionsContainer container = RestrictionsContainer.newInstance();
   		 container.addEq("classe", elev.getClasse());
   		 listplaning = planifdao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
   		 System.out.println("EmargementProfManagerImpl.find() je suis ici 0"+listplaning);
	   		if(listplaning!=null||!listplaning.isEmpty()){
	   		 System.out.println("EmargementProfManagerImpl.find() je suis ici 1 "+listplaning.size());
	   			for(PlanifCours planing : listplaning){
	   			
//	   				listJour=planing.getJourscours();
	   			 System.out.println("EmargementProfManagerImpl.find() je suis ici 2 "+listJour.size());
	   				for(JoursCours jour : listJour){
	   					if(jour.getJournne().equals(getDateOfWeek(elev.datemarg).trim())){
	   	   				 System.out.println("EmargementProfManagerImpl.find() je suis journee 3ssq "+jour.getJournne());
		   				 System.out.println("EmargementProfManagerImpl.find() je suis Journee 4ss "+getDateOfWeek(elev.datemarg));
	   						for(TrancheHoraireCours thcours : jour.getTranchehorairecours()){
	   							if(elev.getProf().getId()==thcours.getMatiere().getId()){
	   								System.out.println("EmargementProfManagerImpl.find() je suis Journee 5 "+thcours.getId());
	   								EmargementProfDetails emarge= new EmargementProfDetails(thcours);
	   								emargeDlt.add(emarge);
	   							}
	   						}
	   					}
	   				}
	   			}
	   			inscrip.setEmagementdlt(emargeDlt);
	   		}
   		}else{
	   		for(EmargementProfDetails emdlt: elev.getEmagementdlt()){
	   			inscrip.getEmagementdlt().add(new EmargementProfDetails(emdlt));
	   		}
   		}
   		return inscrip;
   	}

   	@Override
   	public List<EmargementProf> findAll() {
   		// TODO Auto-generated method stub
   		List<EmargementProf> datas = super.findAll();
   		List<EmargementProf> result = new ArrayList<EmargementProf>();
   		for(EmargementProf elev:datas){
   			result.add(new EmargementProf(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public EmargementProf delete(Long id) {
   		// TODO Auto-generated method stub
   		EmargementProf elev = super.delete(id);
   		return new EmargementProf(elev);
   	}

	@Override
	public void processBeforeSave(EmargementProf entity) {
		// set annescolaire courante
		  //Creation des journaux de saisie
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("connected", true);
		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
	    if(annee==null||annee.size()==0){
	        RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
	        throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
	    }
	    entity.setAnneScolaire(annee.get(0).getCode());
	    List<EmargementProfDetails> listdlt = new ArrayList<EmargementProfDetails>();
	    for(EmargementProfDetails emargedlt : entity.getEmagementdlt()){
	    	emargedlt.setId(-1);
	    	listdlt.add(emargedlt);
	    }
	    entity.setEmagementdlt(listdlt);
	    System.out.println("EmargementProfManagerImpl.processBeforeSave() ane is ....."+entity.getAnneScolaire());
		super.processBeforeSave(entity);
	}
	
	private String getDateOfWeek(Date date){
		GregorianCalendar calendar = new GregorianCalendar() ;
		calendar.setTime(date);
        int today = calendar.get(calendar.DAY_OF_WEEK);
        String indexOfToday = "";
        switch (today) {
        case GregorianCalendar.MONDAY:
            indexOfToday = EnmJoursCours.LUNDI+"";
            break;
        case GregorianCalendar.TUESDAY:
            indexOfToday =EnmJoursCours.MARDI+"";
            break;
        case GregorianCalendar.WEDNESDAY:
            indexOfToday = EnmJoursCours.MERCREDI+"";
            break;
        case GregorianCalendar.THURSDAY:
            indexOfToday = EnmJoursCours.JEUDI+"";
            break;
        case GregorianCalendar.FRIDAY:
            indexOfToday = EnmJoursCours.VENDREDI+"";
            break;
        case GregorianCalendar.SATURDAY:
            indexOfToday =EnmJoursCours.SAMEDI+"";
            break;
        }
         
        return indexOfToday;
		
	}
   	

}
