
package com.kerenedu.solde;

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
import com.kerenedu.model.report.ViewRetenueModal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AcompteManager")
public class AcompteManagerImpl
    extends AbstractGenericManager<Acompte, Long>
    implements AcompteManagerLocal, AcompteManagerRemote
{

    @EJB(name = "AcompteDAO")
    protected AcompteDAOLocal dao;
    
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal variabledao;

    public AcompteManagerImpl() {
    }

    @Override
    public GenericDAO<Acompte, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
	public Acompte delete(Long id) {
		// TODO Auto-generated method stub
		Acompte data = super.delete(id);
		
		// supprimer elt varaible
		variabledao.delete(id);
		return new Acompte(data);
	}

	@Override
	public List<Acompte> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Acompte> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Acompte> result = new ArrayList<Acompte>();
		for(Acompte data:datas){
			result.add(new Acompte(data));
		}
		return result;
	}

	@Override
	public Acompte find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Acompte data = super.find(propertyName, entityID);
		return new Acompte(data);
	}

	@Override
	public List<Acompte> findAll() {
		// TODO Auto-generated method stub		
		List<Acompte> datas =super.findAll();
		List<Acompte> result = new ArrayList<Acompte>();
		for(Acompte data:datas){
			result.add(new Acompte(data));
		}
		return result;
	}

	@Override
	public Acompte confirme(Acompte entity) {
		// TODO Auto-generated method stub
		entity.setState("confirme");
		dao.update(entity.getId(), entity);
		return new Acompte(entity);
	}
	
    
	@Override
	public Acompte paye(Acompte entity,PeriodePaie periode) {
		// TODO Auto-generated method stub
		//Ajout de l'acompte dans la liste es elements variable
		//Traitement des Elements Variables de paie
		ElementVariable element = null ;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("salarie0", entity.getEmploye());
		container.addEq("periode", periode);
		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
		if(datas!=null && datas.size()>0){
			element = datas.get(0);
		}
		if(element==null){
			element = new ElementVariable();
			element.setSalarie(entity.getEmploye());
			element.setPeriode(periode);	
			variabledao.save(element);
			datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
			if(datas!=null && datas.size()>0){
				element = datas.get(0);
			}
		}//end if(element==null)		
//		element.getAcomptes().add(entity);
		//entity.setEltVariable(element);
		entity.setState("paye");
		entity = dao.update(entity.getId(), entity);		
		return new Acompte(entity);//entity;
	}

	@Override
	public Acompte annule(Acompte entity) {
		// TODO Auto-generated method stub
		entity.setState("annule");
		dao.update(entity.getId(), entity);
		///variabledao.delete(entity.getId());
		ElementVariableClone elem = entity.getEltVariable();
		ElementVariable eltvar = variabledao.findByPrimaryKey("id",  elem.getId());
		eltvar.setState("inactif");
    	variabledao.update(eltvar.getId(), eltvar);
		return new Acompte(entity);
	}

	@Override
	public void processAfterSave(Acompte entity) {
			Acompte acompte = dao.findByPrimaryKey("id", entity.getId()); 
          RestrictionsContainer container = RestrictionsContainer.newInstance();
  		container.addEq("elvapid",acompte.getId());
  		List<ElementVariable> datas = variabledao.filter(container.getPredicats(), null, null, 0, -1);
  		if(datas!=null){
  			ElementVariable elt=datas.get(0);
  			acompte.setEltVariable(new ElementVariableClone(elt));
  			dao.update(acompte.getId(), acompte);
  		}
		super.processAfterSave(entity);
	}

	@Override
	public boolean disponible(Acompte entity, PeriodePaie periode) {
		double montantacompte = dao.getMontantAcompte(entity.getEmploye(), periode);
		System.out.println("AcompteManagerImpl.disponible() montant acompte is "+montantacompte);
		boolean result =false ;
		if((montantacompte==entity.getEmploye().getSalaire())){
			result = false;
		}else{
			result=true;
		}
			return result;
	}
	
	@Override
	public List<Acompte> getCriteres(ViewRetenueModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Acompte> datas = new ArrayList<Acompte>();
		List<Acompte> records = new ArrayList<Acompte>();
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
			if (critere.getAnnee() != null) {
				container.addEq("anneeScolaire", critere.getAnnee().getId());
			}
		}
			//daoRem.updateforce("m");
			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			

		return datas;
	}
	
	


}
