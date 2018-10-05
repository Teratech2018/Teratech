
package com.keren.courrier.core.impl.referentiel;

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
import com.keren.courrier.core.ifaces.referentiel.CompanyManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.CompanyManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.CompanyDAOLocal;
import com.keren.courrier.model.referentiel.Company;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CompanyManager")
public class CompanyManagerImpl
    extends AbstractGenericManager<Company, Long>
    implements CompanyManagerLocal, CompanyManagerRemote
{

    @EJB(name = "CompanyDAO")
    protected CompanyDAOLocal dao;

    public CompanyManagerImpl() {
    }

    @Override
    public GenericDAO<Company, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<Company> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Company> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Company> results = new ArrayList<Company>();        
        for(Company courrier:datas){
        	Company data = new Company(courrier);
            results.add(data);              
        }//end for(ArchiveDocument courrier:datas){        
        return results;
    }

    @Override
    public List<Company> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<Company> datas = super.findAll(); 
        List<Company> results = new ArrayList<Company>();        
        for(Company data:datas){
            results.add(new Company(data));
        }
        
        return results;
    }

    @Override
    public Company find(String propertyName, Long entityID) {        
        //initialisaiton
    	Company data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
    	Company result = new Company(data);            
        return result;
    }
    
    


}
