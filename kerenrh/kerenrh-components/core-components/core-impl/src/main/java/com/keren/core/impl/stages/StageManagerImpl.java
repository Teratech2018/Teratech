
package com.keren.core.impl.stages;

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
import com.keren.core.ifaces.stages.StageManagerLocal;
import com.keren.core.ifaces.stages.StageManagerRemote;
import com.keren.dao.ifaces.stages.BesionStageDAOLocal;
import com.keren.dao.ifaces.stages.StageDAOLocal;
import com.keren.model.stages.BesionStage;
import com.keren.model.stages.Stage;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "StageManager")
public class StageManagerImpl
    extends AbstractGenericManager<Stage, Long>
    implements StageManagerLocal, StageManagerRemote
{

    @EJB(name = "StageDAO")
    protected StageDAOLocal dao;
    
    @EJB(name = "BesionStageDAO")
    protected BesionStageDAOLocal besiondao;

    public StageManagerImpl() {
    }

    @Override
    public GenericDAO<Stage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<Stage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Stage> datas =  super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Stage> results = new ArrayList<Stage>();
		for(Stage data:datas){
			results.add(new Stage(data));
		}
		return results;
	}

	@Override
	public Stage find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Stage data =  super.find(propertyName, entityID);
		Stage result = new Stage(data);
		return result;
	}

	@Override
	public List<Stage> findAll() {
		// TODO Auto-generated method stub		
		List<Stage> datas = super.findAll();
		List<Stage> results = new ArrayList<Stage>();
		for(Stage data:datas){
			results.add(new Stage(data));
		}
		return results;
	}
	
	

	@Override
	public void processAfterSave(Stage entity) {
		// TODO Auto-generated method stub
		//Traitement Besion lie
		BesionStage besion = entity.getBesion();
		if(besion!=null){
			besion.setState("encours");
			besiondao.update(besion.getId(), besion);
		}
		super.processAfterSave(entity);
	}

	@Override
	public void processAfterUpdate(Stage entity) {
		// TODO Auto-generated method stub
		BesionStage besion = entity.getBesion();
		if(besion!=null){
			if(besion.getState().trim().equalsIgnoreCase("valide")){
				besion.setState("encours");
				besiondao.update(besion.getId(), besion);
			}//end if(besion.getState().trim().equalsIgnoreCase("valide")){			
		}//end if(besion!=null){
		super.processAfterUpdate(entity);
	}

	@Override
	public Stage valide(Stage entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("etabli")){
			entity.setState("valide");
			dao.update(entity.getId(), entity);
			//Traitement Besion lie
			BesionStage besion = entity.getBesion();
			if(besion!=null){
				besion.setState("traite");
				besiondao.update(besion.getId(), besion);
			}
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		Stage result = new Stage(entity);
		return result;
	}

	@Override
	public Stage annule(Stage entity) {
		// TODO Auto-generated method stub
		if(entity.getState().equalsIgnoreCase("valide")){
			entity.setState("annule");
			dao.update(entity.getId(), entity);
			//Traitement Besion lie
			BesionStage besion = entity.getBesion();
			if(besion!=null){
				besion.setState("valide");
				besiondao.update(besion.getId(), besion);
			}
		}//end if(entity.getState().equalsIgnoreCase("etabli")){
		Stage result = new Stage(entity);
		return result;
	}
    
    

}
