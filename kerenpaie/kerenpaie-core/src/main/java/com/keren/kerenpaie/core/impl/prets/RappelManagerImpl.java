
package com.keren.kerenpaie.core.impl.prets;

import java.util.ArrayList;
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
import com.keren.kerenpaie.core.ifaces.prets.RappelManagerLocal;
import com.keren.kerenpaie.core.ifaces.prets.RappelManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.prets.RappelDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.keren.kerenpaie.model.prets.LigneRappel;
import com.keren.kerenpaie.model.prets.Rappel;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RappelManager")
public class RappelManagerImpl
    extends AbstractGenericManager<Rappel, Long>
    implements RappelManagerLocal, RappelManagerRemote
{

    @EJB(name = "RappelDAO")
    protected RappelDAOLocal dao; 
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;
    

    public RappelManagerImpl() {
    }

    @Override
    public GenericDAO<Rappel, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public Rappel delete(Long id) {
		// TODO Auto-generated method stub
		Rappel data = super.delete(id);
		return new Rappel(data);
	}

	@Override
	public List<Rappel> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Rappel> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Rappel> result = new ArrayList<Rappel>();
		for(Rappel data:datas){
			result.add(new Rappel(data));
		}
		return result;
	}

	@Override
	public Rappel find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Rappel data = super.find(propertyName, entityID);
		Rappel result = new Rappel(data);
		for(LigneRappel ligne:data.getLignes()){
			result.getLignes().add(new LigneRappel(ligne));
		}
		return result;
	}

	@Override
	public List<Rappel> findAll() {
		// TODO Auto-generated method stub		
		List<Rappel> datas = super.findAll();
		List<Rappel> result = new ArrayList<Rappel>();
		for(Rappel data:datas){
			result.add(new Rappel(data));
		}
		return result;
	}

	@Override
	public Rappel confirme(Rappel entity,PeriodePaie periode) {
		// TODO Auto-generated method stub
		//Traitement des Elements Variables de paie
		ElementVariable element = null ;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("salarie0", entity.getEmploye());
		container.addEq("peiode", periode);
		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
		if(datas!=null && datas.size()>0){
			element = datas.get(0);
		}//end if(datas!=null && datas.size()>0){
		if(element==null){
			element = new ElementVariable();
			element.setSalarie(entity.getEmploye());
			element.setPeiode(periode);	
			variabledao.save(element);
			datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
			if(datas!=null && datas.size()>0){
				element = datas.get(0);
			}//end if(datas!=null && datas.size()>0)
		}//end if(element==null)
		entity.setEltVariable(element);
		entity.setState("engage");
		dao.update(entity.getId(), entity);
		return entity;
	}
    
    

}
