
package com.kerenedu.discipline;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.school.Eleve;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PresenceManager")
public class PresenceManagerImpl
    extends AbstractGenericManager<Presence, Long>
    implements PresenceManagerLocal, PresenceManagerRemote
{

    @EJB(name = "PresenceDAO")
    protected PresenceDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;  

    public PresenceManagerImpl() {
    }

    @Override
    public GenericDAO<Presence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<Presence> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<Presence> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<Presence> result = new ArrayList<Presence>();
   		for(Presence elev:datas){
   			result.add(new Presence(elev));
   		}
   		return result;
   	}

   	@Override
   	public Presence find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		Presence elev = super.find(propertyName, entityID);
   		Presence inscrip = new Presence(elev);
   		for(Eleve eleve: elev.getEleveList()){
   			inscrip.getEleveList().add(new Eleve(eleve));
   		}
   		return inscrip;
   	}

   	@Override
   	public List<Presence> findAll() {
   		// TODO Auto-generated method stub
   		List<Presence> datas = super.findAll();
   		List<Presence> result = new ArrayList<Presence>();
   		for(Presence elev:datas){
   			result.add(new Presence(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public Presence delete(Long id) {
   		// TODO Auto-generated method stub
   		Presence elev = super.delete(id);
   		return new Presence(elev);
   	}

	@Override
	public void processBeforeSave(Presence entity) {
		// set annescolaire courante
		  //Creation des journaux de saisie
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("connected", true);
		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
	    if(annee==null||annee.size()==0){
	        RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
	        throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
	    }
	    entity.setAnneScolaire(annee.get(0));
		super.processBeforeSave(entity);
	}

}
