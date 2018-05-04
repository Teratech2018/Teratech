
package com.keren.core.impl.carrieres;

import java.util.ArrayList;
import java.util.HashMap;
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
import com.keren.core.ifaces.carrieres.CessationManagerLocal;
import com.keren.core.ifaces.carrieres.CessationManagerRemote;
import com.keren.dao.ifaces.carrieres.CessationDAOLocal;
import com.keren.dao.ifaces.recrutement.ContratTravailDAOLocal;
import com.keren.model.carrieres.Cessation;
import com.keren.model.employes.Employe;
import com.keren.model.recrutement.ContratTravail;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CessationManager")
public class CessationManagerImpl
    extends AbstractGenericManager<Cessation, Long>
    implements CessationManagerLocal, CessationManagerRemote
{

    @EJB(name = "CessationDAO")
    protected CessationDAOLocal dao;
    
    @EJB(name = "ContratTravailDAO")
    protected ContratTravailDAOLocal contratdao;

    public CessationManagerImpl() {
    }

    @Override
    public GenericDAO<Cessation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Cessation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {

        // TODO Auto-generated method stub
        List<Cessation> datas =  super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Cessation> results = new ArrayList<Cessation>();

        for(Cessation data:datas){
                results.add(new Cessation(data));
        }

        return results;
    }

    @Override
    public Cessation find(String propertyName, Long entityID) {

        // TODO Auto-generated method stub
        Cessation data = super.find(propertyName, entityID);
        Cessation result = new Cessation(data);

        return result;
    }

    @Override
    public List<Cessation> findAll() {

        // TODO Auto-generated method stub		
        List<Cessation> datas = super.findAll();
        List<Cessation> results = new ArrayList<Cessation>();

        for(Cessation data:datas){
                results.add(new Cessation(data));
        }

        return results;
    }

    @Override
    public Cessation delete(Long id) {

        // TODO Auto-generated method stub    	
        Cessation data= super.delete(id);

        return new Cessation(data);
    }

    @Override
    public Cessation valide(Cessation entity) {

        // TODO Auto-generated method stub
        if(entity.getState().equalsIgnoreCase("etabli")){
            entity.setState("valide");
            entity = dao.update(entity.getId(), entity);
            ContratTravail contrat = getValideContrat(entity.getSalarie());
            contrat.setCommentaire(entity.getMotif());
            contrat.setState("cloture");
            contratdao.update(contrat.getId(), contrat);
        }//end if(entity.getState().equalsIgnoreCase("etabli")){

        return new Cessation(entity);
    }
    
	/**
	 * 
	 * @param salarie
	 * @return
	 */
    private ContratTravail getValideContrat(Employe salarie){
    	
    	ContratTravail contrat = null ;
    	RestrictionsContainer container = RestrictionsContainer.newInstance();
    	container.addEq("employe", salarie);
    	container.addEq("state", "confirme");
    	List<ContratTravail> datas = contratdao.filter(container.getPredicats(), new HashMap<String, OrderType>(), null, 0, -1);
    	if(datas!=null&&!datas.isEmpty()){
    		contrat = datas.get(0);
    	}
    	return contrat;
    }

}
