
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.EnmJoursCours;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.notes.CoefMatiereDetailDAOLocal;

@TransactionAttribute
@Stateless(mappedName = "EmargementProfDetailsManager")
public class EmargementProfDetailsManagerImpl
    extends AbstractGenericManager<EmargementProfDetails, Long>
    implements EmargementProfDetailsManagerLocal, EmargementProfDetailsManagerRemote
{

    @EJB(name = "EmargementProfDetailsDAO")
    protected EmargementProfDetailsDAOLocal dao;
    
    @EJB(name = "CoefMatiereDetailDAO")
    protected CoefMatiereDetailDAOLocal daocoefmat;
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal daoclasse;
    
    @EJB(name = "JoursCoursDAO")
    protected JoursCoursDAOLocal joursdao; 
    
    @EJB(name = "ProfesseurDAO")
    protected ProfesseurDAOLocal daoprof;

    public EmargementProfDetailsManagerImpl() {
    }

    @Override
    public GenericDAO<EmargementProfDetails, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	public List<EmargementProfDetails> findmatiereprof(long id,long idclasse, Date date) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<EmargementProfDetails> resuslt = new ArrayList<EmargementProfDetails>();
		List<JoursCours> jours = new ArrayList<JoursCours>();
		List<TrancheHoraireCours> tranches = new ArrayList<TrancheHoraireCours>();
		if(id>0&&idclasse>0){
			container = RestrictionsContainer.newInstance();
			container.addEq("id",id);
			Professeur prof = daoprof.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
			
			container = RestrictionsContainer.newInstance();
			container.addEq("id",idclasse);
			Classe classe = daoclasse.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
			
			container = RestrictionsContainer.newInstance();
			System.out.println("EmargementProfManagerImpl.find() je suis Journee 4ss "+getDateOfWeek(date));
			 container.addEq("journne",getDateOfWeek(date).trim());
			 container.addEq("classe.id", classe.getId());
			 jours = joursdao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			 if(jours!=null||jours.size()!=0){
					for(JoursCours jour : jours){
						int index = 1;
	   						for(TrancheHoraireCours thcours : jour.getTranchehorairecours()){
	   							if(prof.getId()==thcours.getMatiere().getProffesseur().getId()){
	   								EmargementProfDetails emarge= new EmargementProfDetails(thcours);
	   								emarge.setId(-index);
	   								resuslt.add(emarge);
	   							}
	   							index++;
	   					}
	   				}
				 
			 }// fin  if(datas!=null||datas.size()!=0)
		}//fin if(id>0)
		return resuslt;
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
