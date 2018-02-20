
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
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
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
   		List<JoursCours> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<JoursCours> result = new ArrayList<JoursCours>();
   		for(JoursCours elev:datas){
   			result.add(new JoursCours(elev));
   		}
   		return result;
   	}

   	@Override
   	public JoursCours find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		JoursCours elev = super.find(propertyName, entityID);
   		JoursCours inscrip = new JoursCours(elev);
   		System.out.println("JoursCoursManagerImpl.find() nombre jours is "+elev.getTranchehorairecours().size());
   		for(TrancheHoraireCours jour: elev.getTranchehorairecours()){
   			inscrip.getTranchehorairecours().add(new TrancheHoraireCours(jour));
   		}
   		return inscrip;
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

	@Override
	public void processBeforeSave(JoursCours entity) {
		// set annescolaire courante
//		  //Creation des journaux de saisie
//		 RestrictionsContainer container = RestrictionsContainer.newInstance();
//		 container.addEq("connected", true);
//		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
//	    if(annee==null||annee.size()==0){
//	        RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
//	        throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
//	    }
//	    entity.setAnneScolaire(annee.get(0));
		super.processBeforeSave(entity);
	}
}
