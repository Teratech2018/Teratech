
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
import com.keren.core.ifaces.discipline.DemandeExplicationManagerLocal;
import com.keren.core.ifaces.discipline.DemandeExplicationManagerRemote;
import com.keren.dao.ifaces.discipline.DemandeExplicationDAOLocal;
import com.keren.model.discipline.DemandeExplication;
import com.keren.model.discipline.ReponseDE;
import com.keren.model.discipline.Sanction;
import com.keren.model.discipline.TraitementDE;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandeExplicationManager")
public class DemandeExplicationManagerImpl
    extends AbstractGenericManager<DemandeExplication, Long>
    implements DemandeExplicationManagerLocal, DemandeExplicationManagerRemote
{

    @EJB(name = "DemandeExplicationDAO")
    protected DemandeExplicationDAOLocal dao;

    public DemandeExplicationManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeExplication, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public DemandeExplication delete(Long id) {
   		// TODO Auto-generated method stub
   		DemandeExplication data= super.delete(id);
   		return new DemandeExplication(data);
   	}

   	@Override
   	public List<DemandeExplication> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<DemandeExplication> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<DemandeExplication> result = new ArrayList<DemandeExplication>();
   		for(DemandeExplication data:datas){
   			result.add(new DemandeExplication(data));
   		}
   		return result;
   	}
   	

   	@Override
   	public DemandeExplication find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		DemandeExplication data = super.find(propertyName, entityID);
   		DemandeExplication result = new DemandeExplication(data);		
   		if(data.getSanction()!=null){
   			result.setSanction(new Sanction(data.getSanction()));
   		}//end if(data.getSanction()!=null){
   		for(ReponseDE reponse:data.getReponses()){
   			result.getReponses().add(new ReponseDE(reponse));
   		}//end for(ReponseDE reponse:data.getReponses()){
   		for(TraitementDE trait:data.getTraitements()){
   			result.getTraitements().add(new TraitementDE(trait));
   		}//end for(TraitementDE trait:data.getTraitements()){
   		return result;
   	}

   	@Override
   	public List<DemandeExplication> findAll() {
   		// TODO Auto-generated method stub
   		List<DemandeExplication> datas = super.findAll();
   		List<DemandeExplication> result = new ArrayList<DemandeExplication>();
   		for(DemandeExplication data:datas){
   			result.add(new DemandeExplication(data));
   		}
   		return result;
   	}

}
