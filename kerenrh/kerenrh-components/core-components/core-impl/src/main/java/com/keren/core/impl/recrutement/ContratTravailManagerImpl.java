
package com.keren.core.impl.recrutement;

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
import com.keren.core.ifaces.recrutement.ContratTravailManagerLocal;
import com.keren.core.ifaces.recrutement.ContratTravailManagerRemote;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.dao.ifaces.recrutement.ContratTravailDAOLocal;
import com.keren.model.employes.Employe;
import com.keren.model.recrutement.ContratTravail;
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
//        // TODO Auto-generated method stub
//        Employe employe = entity.getEmploye();
//        employe.setCategorie(entity.getCategorie());
//        employe.setEchelon(entity.getEchelon());
//        employedao.update(employe.getId(),employe);
        // update special
        this.updatedateembaucheemplye();
        System.out.println("ContratTravailManagerImpl.processBeforeSave()");
        super.processAfterUpdate(entity);
    }

    @Override
    public void processBeforeSave(ContratTravail entity) {
        // TODO Auto-generated method stub
        Employe employe = entity.getEmploye();
        employe.setCategorie(entity.getCategorie());
        employe.setEchelon(entity.getEchelon());
        employe.setEmbauche(entity.getDrecurtement());
        employedao.update(employe.getId(),employe);
        
        
      
        super.processBeforeSave(entity);
    }
    
    
    public void updatedateembaucheemplye(){
    	List<ContratTravail> contrat =this.findAll();
    	for(ContratTravail t: contrat){
			Employe employe = t.getEmploye();
			employe.setCategorie(t.getCategorie());
			employe.setEchelon(t.getEchelon());
			employe.setEmbauche(t.getDrecurtement());
			employedao.update(t.getId(), employe);  
    	}
    	System.out.println("ContratTravailManagerImpl.updatedateembaucheemplye() finir...");
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
           
        //Mise a jour du salarie
        Employe salarie = contrat.getEmploye();
        salarie.setCategorie(contrat.getCategorie());
        salarie.setEchelon(contrat.getEchelon());
        employedao.update(salarie.getId(), salarie);
        contrat.setState("confirme");
        dao.update(contrat.getId(), contrat);
        return contrat;
    }
}
