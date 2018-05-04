
package com.keren.core.impl.structures;

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
import com.keren.core.ifaces.structures.DepartementManagerLocal;
import com.keren.core.ifaces.structures.DepartementManagerRemote;
import com.keren.dao.ifaces.structures.DepartementDAOLocal;
import com.keren.model.structures.Departement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DepartementManager")
public class DepartementManagerImpl
    extends AbstractGenericManager<Departement, Long>
    implements DepartementManagerLocal, DepartementManagerRemote
{

    @EJB(name = "DepartementDAO")
    protected DepartementDAOLocal dao;

    public DepartementManagerImpl() {
    }

    @Override
    public GenericDAO<Departement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Departement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
        
        // TODO Auto-generated method stub
        List<Departement> datas =  super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Departement> result = new ArrayList<Departement>();

        for(Departement dep:datas){
                result.add(new Departement(dep));
        }

        return result;
    }

    @Override
    public Departement find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        Departement data = super.find(propertyName, entityID);
        Departement result = new Departement(data);
        
        return result;
    }

    @Override
    public List<Departement> findAll() {
        
        // TODO Auto-generated method stub
        List<Departement> datas =  super.findAll();
        List<Departement> result = new ArrayList<Departement>();

        for(Departement dep:datas){
                result.add(new Departement(dep));
        }

        return result;
    }

    @Override
    public void processBeforeSave(Departement entity) {
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public Departement delete(Long id) {

        // TODO Auto-generated method stub    	
        Departement data= super.delete(id);

        return new Departement(data);
    }    
       
}
