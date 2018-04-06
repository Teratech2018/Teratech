
package com.keren.kerenpaie.core.impl.structures;

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
import com.keren.kerenpaie.core.ifaces.structures.SocieteManagerLocal;
import com.keren.kerenpaie.core.ifaces.structures.SocieteManagerRemote;
import com.keren.kerenpaie.dao.ifaces.structures.SocieteDAOLocal;
import com.keren.kerenpaie.model.structures.Planification;
import com.keren.kerenpaie.model.structures.Societe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "SocieteManager")
public class SocieteManagerImpl
    extends AbstractGenericManager<Societe, Long>
    implements SocieteManagerLocal, SocieteManagerRemote
{

    @EJB(name = "SocieteDAO")
    protected SocieteDAOLocal dao;

    public SocieteManagerImpl() {
    }

    @Override
    public GenericDAO<Societe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public Societe delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<Societe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Societe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Societe> result = new ArrayList<Societe>();
		for(Societe data:datas){
			result.add(new Societe(data));
		}
		return result;
	}

	@Override
	public Societe find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Societe data = super.find(propertyName, entityID);
		Societe result = new Societe(data);
		for(Planification plan:data.getPlanifications()){
			result.getPlanifications().add(new Planification(plan));
		}
		return result;
	}

	@Override
	public List<Societe> findAll() {
		// TODO Auto-generated method stub
		List<Societe> datas = super.findAll();
		List<Societe> result = new ArrayList<Societe>();
		for(Societe data:datas){
			result.add(new Societe(data));
		}
		return result;
	}

	@Override
	public void processBeforeSave(Societe entity) {
		// TODO Auto-generated method stub
		if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){
			Planification lundi = new Planification("Lundi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Mardi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Mercredi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Jeudi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Vendredi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Samedi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Dimanche", true, 8.0);
			entity.getPlanifications().add(lundi);
		}//end if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){
		super.processBeforeSave(entity);
	}

	@Override
	public void processBeforeUpdate(Societe entity) {
		// TODO Auto-generated method stub
		if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){
			Planification lundi = new Planification("Lundi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Mardi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Mercredi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Jeudi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Vendredi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Samedi", true, 8.0);
			entity.getPlanifications().add(lundi);
			lundi = new Planification("Dimanche", true, 8.0);
			entity.getPlanifications().add(lundi);
		}//end if(entity.getPlanifications()==null||entity.getPlanifications().isEmpty()){
		super.processBeforeUpdate(entity);
	}
    
    

}
