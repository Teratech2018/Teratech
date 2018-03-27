
package com.keren.kerenpaie.core.impl.employes;

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
import com.keren.kerenpaie.core.ifaces.employes.EmployeManagerLocal;
import com.keren.kerenpaie.core.ifaces.employes.EmployeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.model.employes.ContratTravail;
import com.keren.kerenpaie.model.employes.Employe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "EmployeManager")
public class EmployeManagerImpl
    extends AbstractGenericManager<Employe, Long>
    implements EmployeManagerLocal, EmployeManagerRemote
{

    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal dao;

    public EmployeManagerImpl() {
    }

    @Override
    public GenericDAO<Employe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    

	@Override
	public List<Employe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Employe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Employe> output = new ArrayList<Employe>();
		for(Employe emp:datas){
			output.add(new Employe(emp));
		}//end for(Employe emp:datas){
		return output;
	}

	

	@Override
	public Employe find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Employe employ = super.find(propertyName, entityID);		
		Employe entity = new Employe(employ);
		
		for(ContratTravail contrat: employ.getContrats()){
			entity.getContrats().add(new ContratTravail(contrat));
		}//end for(CompteBancaire cb: employ.getComptesbancaire()){
		for(com.keren.kerenpaie.model.employes.Famille fam:employ.getFamilles()){
			entity.getFamilles().add(new com.keren.kerenpaie.model.employes.Famille(fam));
		}
		return  entity;
	}

	@Override
	public List<Employe> findAll() {
		// TODO Auto-generated method stub
		List<Employe> datas = super.findAll();
		List<Employe> output = new ArrayList<Employe>();
		for(Employe emp:datas){
			output.add(new Employe(emp));
		}//end for(Employe emp:datas){
		return output;
	}
    

}
