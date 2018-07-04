
package com.kerenedu.school;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.kerenedu.model.search.EleveSearch;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "EleveManager")
public class EleveManagerImpl
    extends AbstractGenericManager<Eleve, Long>
    implements EleveManagerLocal, EleveManagerRemote
{

    @EJB(name = "EleveDAO")
    protected EleveDAOLocal dao;
    
    @EJB(name = "ResponsableDAO")
    protected ResponsableDAOLocal daoresponsable;

    public EleveManagerImpl() {
    }

    @Override
    public GenericDAO<Eleve, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public List<Eleve> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Eleve> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Eleve> result = new ArrayList<Eleve>();
		for(Eleve elev:datas){
			result.add(new Eleve(elev));
		}
		
		return result;
	}

	@Override
	public Eleve find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Eleve elev = super.find(propertyName, entityID);
		Eleve data = new Eleve(elev);
		
//		for(Contacts contacts: elev.getContact()){
//			data.getContact().add(new Contacts(contacts));
//   		}
		
		return data;
	}

	@Override
	public List<Eleve> findAll() {
		// TODO Auto-generated method stub
		List<Eleve> datas = super.findAll();
		List<Eleve> result = new ArrayList<Eleve>();
		
		for(Eleve elev:datas){
			result.add(new Eleve(elev));
		}
		return result;
	}
	
	   @Override
	    public List<Eleve> getCriteres(EleveSearch critere) {
	         //To change body of generated methods, choose Tools | Templates.
	        RestrictionsContainer container = RestrictionsContainer.newInstance();
	        if(critere!=null){
	            if(critere.getNationalite()!=null){
	                container.addGe("nationalite.code", critere.getNationalite().getCode());
	            }
	            if(critere.getMatricule()!=null){
	                container.addEq("matricule", critere.getMatricule());
	            }
	          
	        }
	        List<Eleve> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
	        List<Eleve>  result = new ArrayList<Eleve>();
	        for(Eleve ecrit:datas){            
	        	Eleve ecriture = new Eleve(ecrit);
	            result.add(ecriture);
	        }
	        return result;
	    }

	@Override
	public void processBeforeSave(Eleve entity) {
		//mis à jour du nombre d'enfant du responsable
		Responsable resp = entity.getResp();
		if(resp.getNe()==null){
			resp.setNe((short)0);
		}
		Short neactuel= (short) (resp.getNe()+1);
		resp.setNe(neactuel);
		daoresponsable.update(resp.getId(), resp);
		super.processBeforeSave(entity);
	}
    

}
