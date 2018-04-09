
package com.keren.kerenpaie.core.impl.employes;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.print.attribute.standard.RequestingUserName;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.employes.ContratTravailManagerLocal;
import com.keren.kerenpaie.core.ifaces.employes.ContratTravailManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.ContratTravailDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.model.employes.ContratTravail;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ContratTravailManager")
public class ContratTravailManagerImpl
    extends AbstractGenericManager<ContratTravail, Long>
    implements ContratTravailManagerLocal, ContratTravailManagerRemote
{

    @EJB(name = "ContratTravailDAO")
    protected ContratTravailDAOLocal dao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;

    public ContratTravailManagerImpl() {
    }

    @Override
    public GenericDAO<ContratTravail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    

	@Override
	public void processAfterUpdate(ContratTravail entity) {
		// TODO Auto-generated method stub
		Employe employe = entity.getEmploye();
		employe.setCategorie(entity.getCategorie());
		employe.setEchelon(entity.getEchelon());
		employedao.update(employe.getId(),employe);
		super.processAfterUpdate(entity);
	}

	@Override
	public void processBeforeSave(ContratTravail entity) {
		// TODO Auto-generated method stub
		Employe employe = entity.getEmploye();
		employe.setCategorie(entity.getCategorie());
		employe.setEchelon(entity.getEchelon());
		employedao.update(employe.getId(),employe);
		super.processBeforeSave(entity);
	}

	@Override
	public ContratTravail delete(Long id) {
		// TODO Auto-generated method stub
		ContratTravail data = super.delete(id);
		return new ContratTravail(data);
	}

	@Override
	public List<ContratTravail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ContratTravail> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ContratTravail> result = new ArrayList<ContratTravail>();
		for(ContratTravail contr:datas){
			result.add(new ContratTravail(contr));
		}
		return result;
	}

	@Override
	public ContratTravail find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ContratTravail data = super.find(propertyName, entityID);
		ContratTravail result = new ContratTravail(data);
		return result;
	}

	@Override
	public List<ContratTravail> findAll() {
		// TODO Auto-generated method stub
//		return
		List<ContratTravail> datas = super.findAll();
		List<ContratTravail> result = new ArrayList<ContratTravail>();
		for(ContratTravail contr:datas){
			result.add(new ContratTravail(contr));
		}
		return result;
	}
	
	

	@Override
	public ContratTravail cloture(ContratTravail contrat) {
		// TODO Auto-generated method stub
		contrat.setState("cloture");
		dao.update(contrat.getId(), contrat);
		return contrat;
	}

	@Override
	public ContratTravail demarrer(ContratTravail contrat) {
		// TODO Auto-generated method stub	
		//Mise a jour du salarie
		Employe salarie = contrat.getEmploye();
		salarie.setCategorie(contrat.getCategorie());
		salarie.setEchelon(contrat.getEchelon());
		employedao.update("id", salarie);
		contrat.setState("confirme");
		dao.update(contrat.getId(), contrat);
		return contrat;
	}
    
    

}
