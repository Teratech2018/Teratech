
package com.keren.core.impl.carrieres;

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
import com.keren.core.ifaces.carrieres.ReclassementManagerLocal;
import com.keren.core.ifaces.carrieres.ReclassementManagerRemote;
import com.keren.dao.ifaces.carrieres.ReclassementDAOLocal;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.model.carrieres.Reclassement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ReclassementManager")
public class ReclassementManagerImpl
    extends AbstractGenericManager<Reclassement, Long>
    implements ReclassementManagerLocal, ReclassementManagerRemote
{

    @EJB(name = "ReclassementDAO")
    protected ReclassementDAOLocal dao;


    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;
    
    
    public ReclassementManagerImpl() {
    }

    @Override
    public GenericDAO<Reclassement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Reclassement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
        
        // TODO Auto-generated method stub
        List<Reclassement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Reclassement> results = new ArrayList<Reclassement>();
        
        for(Reclassement data:datas){
                results.add(new Reclassement(data));
        }//end for(Reclassement data:datas){
        
        return results;
    }

    @Override
    public Reclassement find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        Reclassement data = super.find(propertyName, entityID);
        Reclassement result = new Reclassement(data);
            
        return result;
    }

    @Override
    public List<Reclassement> findAll() {
        
        // TODO Auto-generated method stub
        List<Reclassement> datas = super.findAll();
        List<Reclassement> results = new ArrayList<Reclassement>();
        
        for(Reclassement data:datas){
                results.add(new Reclassement(data));
        }//end for(Reclassement data:datas){
        
        return results;		
    }
    
    @Override
    public Reclassement delete(Long id) {
        
        // TODO Auto-generated method stub    	
        Reclassement data= super.delete(id);
        
        return new Reclassement(data);
    }
    
    @Override
    public Reclassement valide(Reclassement entity) {
        
        // TODO Auto-generated method stub
        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            entity.setState("valide");
            entity = dao.update(entity.getId(), entity);
            Employe salarie = entity.getSalarie();
            salarie.setCategorie(entity.getCategorieN());
            employedao.update(salarie.getId(), salarie);
        }
        
        return new Reclassement(entity);
    }
}
