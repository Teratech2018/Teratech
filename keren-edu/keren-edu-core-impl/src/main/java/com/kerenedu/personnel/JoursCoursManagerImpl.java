
package com.kerenedu.personnel;

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
import com.core.tools.EnmHeureCours;
import com.core.tools.EnmJoursCours;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "JoursCoursManager")
public class JoursCoursManagerImpl
    extends AbstractGenericManager<JoursCours, Long>
    implements JoursCoursManagerLocal, JoursCoursManagerRemote
{

    @EJB(name = "JoursCoursDAO")
    protected JoursCoursDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;   
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal classedao;

    public JoursCoursManagerImpl() {
    }

    @Override
    public GenericDAO<JoursCours, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
   	public List<JoursCours> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	Classe classe = CacheMemory.getClasse();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		 TrancheHoraireCours thc ;
		 List<TrancheHoraireCours>listthc = new ArrayList<TrancheHoraireCours>();
		 List<EnmJoursCours> listjours =EnmJoursCours.getList();
		 List<EnmHeureCours> listheure=EnmHeureCours.getList();
		 List<JoursCours>listjc = new ArrayList<JoursCours>();
		 JoursCours jc ;
		 List<JoursCours> result = new ArrayList<JoursCours>();
		if(classe!=null){
			container.addEq("classe", classe);
		}//end if(classe!=null)
		predicats.addAll(container.getPredicats());
   		List<JoursCours> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
//   		if(datas==null||datas.isEmpty()||datas.size()==0){
//   			System.out.println("JoursCoursManagerImpl.filter() planif not exit ;;;;");
//   			long index =1;
//   			for(EnmJoursCours jour :listjours){
//   				listthc = new ArrayList<TrancheHoraireCours>();
//   				long idx =1;
//   				for(EnmHeureCours heure:listheure){
//   					 thc = new TrancheHoraireCours(heure);
//   					 thc.setId(-idx);
//   					 listthc.add(thc);
//   					idx++;
//   				}
//   				 jc = new JoursCours(jour,listthc);
//   				 jc.setId(-index);
//   				 listjc.add(jc);
//   				index ++;
//   			}
//   			result.addAll(listjc);
//   		}else{
   			System.out.println("JoursCoursManagerImpl.filter() planif  exit ;;;;"+datas.size());
   			for(JoursCours elev:datas){
   	   			result.add(new JoursCours(elev));
   	   		}
//   		}
  		
   		return result;
   	}

   	@Override
   	public JoursCours find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		TrancheHoraireCours thc ;
		 List<TrancheHoraireCours>listthc = new ArrayList<TrancheHoraireCours>();
		 List<EnmJoursCours> listjours =EnmJoursCours.getList();
		 List<EnmHeureCours> listheure=EnmHeureCours.getList();
		 List<JoursCours>listjc = new ArrayList<JoursCours>();
		 JoursCours jc = new JoursCours() ;
		 JoursCours result = new JoursCours();
   			JoursCours jours = super.find(propertyName, entityID);
   			result = new JoursCours(jours);
   	   		for(TrancheHoraireCours jour: jours.getTranchehorairecours()){
   	   		result.getTranchehorairecours().add(new TrancheHoraireCours(jour));
   	   		}

   		return result;
   	}

   	@Override
   	public List<JoursCours> findAll() {
   		// TODO Auto-generated method stub
   		List<JoursCours> datas = super.findAll();
   		List<JoursCours> result = new ArrayList<JoursCours>();
   		for(JoursCours elev:datas){
   			result.add(new JoursCours(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public JoursCours delete(Long id) {
   		// TODO Auto-generated method stub
   		JoursCours elev = super.delete(id);
   		return new JoursCours(elev);
   	}



}
