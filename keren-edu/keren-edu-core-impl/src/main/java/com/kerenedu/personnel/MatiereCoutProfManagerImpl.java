
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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "MatiereCoutProfManager")
public class MatiereCoutProfManagerImpl
    extends AbstractGenericManager<MatiereCoutProf, Long>
    implements MatiereCoutProfManagerLocal, MatiereCoutProfManagerRemote
{

    @EJB(name = "MatiereCoutProfDAO")
    protected MatiereCoutProfDAOLocal dao;
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;    

    public MatiereCoutProfManagerImpl() {
    }

    @Override
    public GenericDAO<MatiereCoutProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<MatiereCoutProf> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<MatiereCoutProf> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<MatiereCoutProf> result = new ArrayList<MatiereCoutProf>();
   		for(MatiereCoutProf elev:datas){
   			result.add(new MatiereCoutProf(elev));
   		}
   		return result;
   	}

   	@Override
   	public MatiereCoutProf find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		MatiereCoutProf elev = super.find(propertyName, entityID);
   		MatiereCoutProf inscrip = new MatiereCoutProf(elev);
//   		for(MatiereCoutProf serv: elev.getMatiereEns()){
//   			inscrip.getMatiereEns().add(new MatiereCoutProf(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<MatiereCoutProf> findAll() {
   		// TODO Auto-generated method stub
   		List<MatiereCoutProf> datas = super.findAll();
   		List<MatiereCoutProf> result = new ArrayList<MatiereCoutProf>();
   		for(MatiereCoutProf elev:datas){
   			result.add(new MatiereCoutProf(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public MatiereCoutProf delete(Long id) {
   		// TODO Auto-generated method stub
   		MatiereCoutProf elev = super.delete(id);
   		return new MatiereCoutProf(elev);
   	}

	@Override
	public void processBeforeSave(MatiereCoutProf entity) {
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
