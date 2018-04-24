
package com.kerenedu.personnel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import javax.ws.rs.Path;
import javax.ws.rs.core.HttpHeaders;

import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.ifaces.GenericManager;
import com.core.tools.EnmHeureCours;
import com.core.tools.EnmJoursCours;
import com.google.gson.Gson;
import com.kerem.core.MetaDataUtil;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.notes.CoefMatiere;
import com.megatimgroup.generic.jax.rs.layer.annot.Manager;
import com.megatimgroup.generic.jax.rs.layer.impl.AbstractGenericService;
import com.megatimgroup.generic.jax.rs.layer.impl.MetaData;


/**
 * Classe d'implementation du Web Service JAX-RS
 * @since Wed Jan 31 17:41:20 CET 2018
 * 
 */
@Path("/planifcours")
public class PlanifCoursRSImpl
    extends AbstractGenericService<PlanifCours, Long>
    implements PlanifCoursRS
{

    /**
     * On injecte un Gestionnaire d'entites
     * 
     */
    @Manager(application = "kereneducation", name = "PlanifCoursManagerImpl", interf = PlanifCoursManagerRemote.class)
    protected PlanifCoursManagerRemote manager;
    
    @Manager(application = "kereneducation", name = "JoursCoursManagerImpl", interf = JoursCoursManagerRemote.class)
    protected JoursCoursManagerRemote managerJours;

    public PlanifCoursRSImpl() {
        super();
    }

    /**
     * Methode permettant de retourner le gestionnaire d'entites
     * 
     */
    @Override
    public GenericManager<PlanifCours, Long> getManager() {
        return manager;
    }

    public String getModuleName() {
        return ("kereneducation");
    }
    
    @Override
  	public MetaData getMetaData(HttpHeaders headers) {
  		// TODO Auto-generated method stub
  		try {
  			return MetaDataUtil.getMetaData(new PlanifCours(), new HashMap<String, MetaData>(),new ArrayList<String>());
  		} catch (InstantiationException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		} catch (IllegalAccessException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
  		return null;
  	}
    
    @Override
    public PlanifCours update(Long id, PlanifCours entity) {
    	CacheMemory.setClasse(entity.getClasse());
        return entity; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PlanifCours save(PlanifCours entity) {
    	System.out.println("PlanifCoursRSImpl.save() je suis 11111111111111111");
        //To change body of generated methods, choose Tools | Templates.
    	CacheMemory.setClasse(entity.getClasse());
    	//todo save jours if is new
    	todoWork(entity);
        return entity; 
    }
    
    private void todoWork(PlanifCours entity){
    	System.out.println("PlanifCoursRSImpl.save() je suis 2222222222");
    	Classe classe = CacheMemory.getClasse();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		 TrancheHoraireCours thc ;
		 List<TrancheHoraireCours>listthc = new ArrayList<TrancheHoraireCours>();
		 List<EnmJoursCours> listjours =EnmJoursCours.getList();
		 List<EnmHeureCours> listheure=EnmHeureCours.getList();
		 List<JoursCours>listjc = new ArrayList<JoursCours>();
		 JoursCours jc ;
		 List<JoursCours> datas= new ArrayList<JoursCours>();
		 List<JoursCours> result = new ArrayList<JoursCours>();
			container.addEq("classe.id", classe.getId());
			System.out.println("PlanifCoursRSImpl.save() je suis 333333333333 classe"+classe.getId());
			 datas = managerJours.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			System.out.println("PlanifCoursRSImpl.save() je suis 44444444444444"+datas.size());
   		if(datas==null||datas.isEmpty()){
   			System.out.println("PlanifCoursRSImpl.todoWork() 55555555555555555");
   			
   			for(EnmJoursCours jour :listjours){
   				listthc = new ArrayList<TrancheHoraireCours>();
   			//	long idx =1;
   				for(EnmHeureCours heure:listheure){
   					 thc = new TrancheHoraireCours(entity,heure);
					 thc.setId(-1);
   					 listthc.add(thc);
//   					idx++;
   				}
   				 jc = new JoursCours(jour,listthc);
   				 listjc.add(jc);
   			}
   			System.out.println("PlanifCoursRSImpl.todoWork() nombre de jours 666666666666666"+listjc.size());
   			for(JoursCours jr : listjc){
   				List<TrancheHoraireCours> newTranche = new ArrayList<TrancheHoraireCours>();
   				newTranche.addAll(jr.getTranchehorairecours());
   				JoursCours newJours = new JoursCours(jr);
   				newJours.setId(-1);
   				newJours.setClasse(entity.getClasse());
   				newJours.setTranchehorairecours(newTranche);
   				managerJours.save(newJours);
   			}
   		}   // fin (datas==null||datas.isEmpty()||datas.size()==0)			
   		
    }

	@Override
	public List<JoursCours> findjourscours(HttpHeaders headers) {
		Gson gson = new Gson();
		long id =gson.fromJson(headers.getRequestHeader("id").get(0), Long.class);
		return manager.findjourscours(id);
	}

}
