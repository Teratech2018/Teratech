
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
@Stateless(mappedName = "TrancheHoraireCoursManager")
public class TrancheHoraireCoursManagerImpl
    extends AbstractGenericManager<TrancheHoraireCours, Long>
    implements TrancheHoraireCoursManagerLocal, TrancheHoraireCoursManagerRemote
{

    @EJB(name = "TrancheHoraireCoursDAO")
    protected TrancheHoraireCoursDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;    

    public TrancheHoraireCoursManagerImpl() {
    }

    @Override
    public GenericDAO<TrancheHoraireCours, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<TrancheHoraireCours> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<TrancheHoraireCours> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<TrancheHoraireCours> result = new ArrayList<TrancheHoraireCours>();
   		for(TrancheHoraireCours elev:datas){
   			result.add(new TrancheHoraireCours(elev));
   		}
   		return result;
   	}

   	@Override
   	public TrancheHoraireCours find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		TrancheHoraireCours elev = super.find(propertyName, entityID);
   		TrancheHoraireCours inscrip = new TrancheHoraireCours(elev);
   		return inscrip;
   	}

   	@Override
   	public List<TrancheHoraireCours> findAll() {
   		// TODO Auto-generated method stub
   		List<TrancheHoraireCours> datas = super.findAll();
   		List<TrancheHoraireCours> result = new ArrayList<TrancheHoraireCours>();
   		for(TrancheHoraireCours elev:datas){
   			result.add(new TrancheHoraireCours(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public TrancheHoraireCours delete(Long id) {
   		// TODO Auto-generated method stub
   		TrancheHoraireCours elev = super.delete(id);
   		return new TrancheHoraireCours(elev);
   	}

	@Override
	public void processBeforeSave(TrancheHoraireCours entity) {
//		// set annescolaire courante
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
