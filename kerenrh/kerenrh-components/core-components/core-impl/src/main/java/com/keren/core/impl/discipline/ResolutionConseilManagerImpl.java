
package com.keren.core.impl.discipline;

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
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.discipline.ResolutionConseilManagerLocal;
import com.keren.core.ifaces.discipline.ResolutionConseilManagerRemote;
import com.keren.dao.ifaces.discipline.ConvocationConseilDAOLocal;
import com.keren.dao.ifaces.discipline.LigneResolutionDAOLocal;
import com.keren.dao.ifaces.discipline.ResolutionConseilDAOLocal;
import com.keren.model.discipline.ConvocationConseil;
import com.keren.model.discipline.DemandeExplication;
import com.keren.model.discipline.LigneResolution;
import com.keren.model.discipline.ResolutionConseil;
import com.keren.model.discipline.Sanction;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ResolutionConseilManager")
public class ResolutionConseilManagerImpl
    extends AbstractGenericManager<ResolutionConseil, Long>
    implements ResolutionConseilManagerLocal, ResolutionConseilManagerRemote
{

    @EJB(name = "ResolutionConseilDAO")
    protected ResolutionConseilDAOLocal dao;
    
    @EJB(name = "LigneResolutionDAO")
    protected LigneResolutionDAOLocal lignedao;
    
    @EJB(name = "ConvocationConseilDAO")
    protected ConvocationConseilDAOLocal convocationdao;
    

    public ResolutionConseilManagerImpl() {
    }

    @Override
    public GenericDAO<ResolutionConseil, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
  	public List<ResolutionConseil> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
  			int firstResult, int maxResult) {
  		// TODO Auto-generated method stub
  		List<ResolutionConseil> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
  		List<ResolutionConseil> result = new ArrayList<ResolutionConseil>();
  		for(ResolutionConseil data:datas){
  			result.add(new ResolutionConseil(data));
  		}
  		return result;
  	}
  	


  	@Override
  	public ResolutionConseil find(String propertyName, Long entityID) {
  		// TODO Auto-generated method stub
  		ResolutionConseil data = super.find(propertyName, entityID);
  		ResolutionConseil result = new ResolutionConseil(data);	 
  		
  		for(LigneResolution lr : data.getLignes()){
  			LigneResolution ligne = new LigneResolution(lr);
  			if(lr.getSanction()!=null){
  				ligne.setSanction(new Sanction(lr.getSanction()));
  			}//end if(lr.getSanction()!=null){
  			ligne.setDemande(new DemandeExplication(lr.getDemande()));
  			result.getLignes().add(ligne);
  		}
  		return result;
  	}

  	@Override
  	public List<ResolutionConseil> findAll() {
  		// TODO Auto-generated method stub
  		List<ResolutionConseil> datas = super.findAll();
  		List<ResolutionConseil> result = new ArrayList<ResolutionConseil>();
  		for(ResolutionConseil data:datas){
  			result.add(new ResolutionConseil(data));
  		}
  		return result;
  	}

	@Override
	public void processAfterDelete(ResolutionConseil entity) {
		// TODO Auto-generated method stub
		super.processAfterDelete(entity);
		ConvocationConseil conseil = entity.getConvocation();
		conseil.setState("convoque");
		convocationdao.update(conseil.getId(), conseil);
		super.processAfterSave(entity);
	}

	@Override
	public void processAfterSave(ResolutionConseil entity) {
		// TODO Auto-generated method stub
		//Mise a jour des ligne Resolution*
		ConvocationConseil conseil = entity.getConvocation();
		conseil = convocationdao.findByPrimaryKey("id", conseil.getId());
		conseil.setState("siege");
		convocationdao.update(conseil.getId(), conseil);
		super.processAfterSave(entity);
	}	
	
	

	@Override
	public void processBeforeUpdate(ResolutionConseil entity) {
		// TODO Auto-generated method stub		
		super.processBeforeUpdate(entity);
	}

	@Override
	public void processBeforeDelete(ResolutionConseil entity) {
		// TODO Auto-generated method stub
		super.processBeforeDelete(entity);
	}

	@Override
	public ResolutionConseil delete(Long id) {
		// TODO Auto-generated method stub
		ResolutionConseil data =  super.delete(id);
		ResolutionConseil result = new ResolutionConseil(data);
		return result;
	}
  	
  	

}
