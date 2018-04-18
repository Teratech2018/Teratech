
package com.keren.core.impl.employes;

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
import com.keren.core.ifaces.employes.EmployeManagerLocal;
import com.keren.core.ifaces.employes.EmployeManagerRemote;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.model.comptabilite.CompteBancaire;
import com.keren.model.employes.Employe;
import com.keren.model.employes.Famille;
import com.keren.model.recrutement.ContratTravail;
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
		
		for(CompteBancaire cb: employ.getComptesbancaire()){
			entity.getComptesbancaire().add(new CompteBancaire(cb));
		}//end for(CompteBancaire cb: employ.getComptesbancaire()){
		for(Famille fam:employ.getFamilles()){
			entity.getFamilles().add(new Famille(fam));
		}
		for(ContratTravail contrat:employ.getContrats()){
			entity.getContrats().add(new ContratTravail(contrat));
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
/*
    @EJB(name = "ContratTravailDAO")
    protected ContratTravailDAOLocal contrattravaildao;


    @Override
    public List<Employe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Employe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Employe> results = new ArrayList<Employe>();
        for(Employe data:datas){
            results.add(new Employe(data));
        }
        return results;
    }

    @Override
    public List<Employe> findAll() {
        List<Employe> datas = super.findAll();
        List<Employe> results = new ArrayList<Employe>();

        for(Employe data:datas){
            results.add(new Employe(data));
        }
        return results;
    }

    @Override
    public Employe find(String propertyName, Long entityID) {
        Employe data = super.find(propertyName, entityID);
        Employe result = new Employe(data);

        for(CompteBancaire aas:data.getComptesbancaire()){
            result.getComptesbancaire().add(new CompteBancaire(aas));
        }

        for(ContratTravail aas:data.getContrats()){
            result.getContrats().add(new ContratTravail(aas));
        }

        for(Famille aas:data.getFamilles()){
            result.getFamilles().add(new Famille(aas));
        }


        return result;
    }

    @Override
    public void processAfterUpdate(Employe entity) {

         for(ContratTravail aas:entity.getContrats()){

            aas.setEmploye(entity);

            if(aas.getId()>0){
                contrattravaildao.update(aas.getId(), aas);
            }else {
                contrattravaildao.save(aas);
            }
        }
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Employe entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());


        for(ContratTravail aas:entity.getContrats()){
            aas.setEmploye(entity);

            if(aas.getId()>0){
                contrattravaildao.update(aas.getId(), aas);
            }else {
                contrattravaildao.save(aas);
            }
        }
        super.processAfterSave(entity);
    }

    @Override
    public Employe valide(Employe entity) {

        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
        }

        Employe data = dao.update(entity.getId(), entity);


        for(ContratTravail aas:entity.getContrats()){
            aas.setEmploye(entity);

            if(aas.getId()>0){
                contrattravaildao.update(aas.getId(), aas);
            }else {
                contrattravaildao.save(aas);
            }
        }

        Employe result = new Employe(data);

        for(CompteBancaire aas:data.getComptesbancaire()){
            result.getComptesbancaire().add(new CompteBancaire(aas));
        }

        for(ContratTravail aas:data.getContrats()){
            result.getContrats().add(new ContratTravail(aas));
        }

        for(Famille aas:data.getFamilles()){
            result.getFamilles().add(new Famille(aas));
        }

        return result;

    @Override
    public Employe annule(Employe entity) {

        if(entity.getState().trim().equalsIgnoreCase("valide")){
            entity.setState("annule");
        }

        Employe data = dao.update(entity.getId(), entity);
        return new Employe(data);
    }

*/
