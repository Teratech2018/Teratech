
package com.kerenedu.personnel;

import java.util.ArrayList;
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
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.school.Contacts;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ProfMatiereEnsManager")
public class ProfMatiereEnsManagerImpl
    extends AbstractGenericManager<ProfMatiereEns, Long>
    implements ProfMatiereEnsManagerLocal, ProfMatiereEnsManagerRemote
{

    @EJB(name = "ProfMatiereEnsDAO")
    protected ProfMatiereEnsDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;    

    public ProfMatiereEnsManagerImpl() {
    }

    @Override
    public GenericDAO<ProfMatiereEns, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ProfMatiereEns> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<ProfMatiereEns> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ProfMatiereEns> result = new ArrayList<ProfMatiereEns>();
   		for(ProfMatiereEns elev:datas){
   			result.add(new ProfMatiereEns(elev));
   		}
   		return result;
   	}

   	@Override
   	public ProfMatiereEns find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ProfMatiereEns elev = super.find(propertyName, entityID);
   		ProfMatiereEns inscrip = new ProfMatiereEns(elev);
		for (MatiereCoutProf serv: elev.getMatiereEns()){
   			inscrip.getMatiereEns().add(new MatiereCoutProf(serv));
   		}
   		return inscrip;
   	}

   	@Override
   	public List<ProfMatiereEns> findAll() {
   		// TODO Auto-generated method stub
		List<ProfMatiereEns> datas = super.findAll();
   		List<ProfMatiereEns> result = new ArrayList<ProfMatiereEns>();
   		for(ProfMatiereEns elev:datas){
   			result.add(new ProfMatiereEns(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public ProfMatiereEns delete(Long id) {
   		// TODO Auto-generated method stub
   		ProfMatiereEns elev = super.delete(id);
   		return new ProfMatiereEns(elev);
   	}

	@Override
	public void processBeforeSave(ProfMatiereEns entity) {
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
