
package com.keren.core.impl.discipline;

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
import com.keren.core.ifaces.discipline.SanctionManagerLocal;
import com.keren.core.ifaces.discipline.SanctionManagerRemote;
import com.keren.dao.ifaces.discipline.DemandeExplicationDAOLocal;
import com.keren.dao.ifaces.discipline.SanctionDAOLocal;
import com.keren.model.discipline.DemandeExplication;
import com.keren.model.discipline.LigneResolution;
import com.keren.model.discipline.Sanction;
import com.keren.model.discipline.Sanction;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "SanctionManager")
public class SanctionManagerImpl
    extends AbstractGenericManager<Sanction, Long>
    implements SanctionManagerLocal, SanctionManagerRemote
{

    @EJB(name = "SanctionDAO")
    protected SanctionDAOLocal dao;
    
    @EJB(name = "DemandeExplicationDAO")
    protected DemandeExplicationDAOLocal dedao;
    

    public SanctionManagerImpl() {
    }

    @Override
    public GenericDAO<Sanction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
  	public List<Sanction> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<Sanction> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<Sanction> result = new ArrayList<Sanction>();
  		for(Sanction data:datas){
  			Sanction sanction =new Sanction(data);
  			sanction.setDemande(new DemandeExplication(data.getDemande()));
  			sanction.setResolution(null);
  			result.add(sanction);
  		}
  		return result;
  	}
  	


  	@Override
  	public Sanction find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		Sanction data = super.find(propertyName, entityID);
  		Sanction result = new Sanction(data);	
  		result.setDemande(new DemandeExplication(data.getDemande()));
  		if(data.getResolution()!=null){
  			result.setResolution(new LigneResolution(data.getResolution()));
  		}//end if(data.getResolution()!=null){
  		return result;
  	}

  	@Override
  	public List<Sanction> findAll() {
  		// TODO Auto-generated method stub
  		List<Sanction> datas = super.findAll();
  		List<Sanction> result = new ArrayList<Sanction>();
  		for(Sanction data:datas){
  			result.add(new Sanction(data));
  		}
  		return result;
  	}
        
        @Override
	public Sanction delete(Long id) {
            
            Sanction data = super.find("id", id);
            Sanction result = new Sanction(data);
            
            //on supprime
            super.delete(id);
            
            return result;
	}
        
	@Override
	public void processAfterDelete(Sanction entity) {
		// TODO Auto-generated method stub
		DemandeExplication demande = entity.getDemande();
		demande.setState("encours");
		dedao.update(demande.getId(), demande);
		super.processAfterDelete(entity);
	}
	
	

	@Override
	public void processBeforeSave(Sanction entity) {
		// TODO Auto-generated method stub
		DemandeExplication demande = dedao.findByPrimaryKey("id", entity.getDemande().getId());
		entity.setResolution(new LigneResolution(demande.getResolution()));
		super.processBeforeSave(entity);
	}

	@Override
	public void processAfterSave(Sanction entity) {
		// TODO Auto-generated method stub
		DemandeExplication demande = entity.getDemande();
		demande.setState("traite");
		dedao.update(demande.getId(), demande);
		super.processAfterSave(entity);
	}
  	
  	

}
