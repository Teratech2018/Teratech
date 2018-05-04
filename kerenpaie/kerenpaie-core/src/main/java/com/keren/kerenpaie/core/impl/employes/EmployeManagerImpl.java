
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
import com.kerem.core.KerenExecption;
import com.keren.kerenpaie.core.ifaces.employes.EmployeManagerLocal;
import com.keren.kerenpaie.core.ifaces.employes.EmployeManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.model.employes.ContratTravail;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.employes.Medaille;
import com.keren.kerenpaie.model.structures.Departement;
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
    public Employe delete(Long id) {
        try{
            Employe data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
            return new Employe(data);
        }catch(Exception ex){
            throw new KerenExecption("Employé en cours d'utilisation ");
        }
    }
    

	@Override
	public List<Employe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Employe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Employe> output = new ArrayList<Employe>();
		for(Employe emp:datas){
			Employe data = new Employe(emp);
			if(data.getDepartement()!=null){
				data.setDepartement(new Departement(data.getDepartement()));
			}//end if(data.getDepartement()!=null){
			output.add(data);
		}//end for(Employe emp:datas){
		return output;
	}

	

	@Override
	public Employe find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Employe employ = super.find(propertyName, entityID);		
		Employe entity = new Employe(employ);
		if(employ.getDepartement()!=null){
			entity.setDepartement(new Departement(employ.getDepartement()));
		}//end if(employ.getDepartement()!=null){
		for(ContratTravail contrat: employ.getContrats()){
			entity.getContrats().add(new ContratTravail(contrat));
		}//end for(CompteBancaire cb: employ.getComptesbancaire()){
		for(com.keren.kerenpaie.model.employes.Famille fam:employ.getFamilles()){
			entity.getFamilles().add(new com.keren.kerenpaie.model.employes.Famille(fam));
		}
		for(Medaille medaille:employ.getMedailles()){
			entity.getMedailles().add(new Medaille(medaille));
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
