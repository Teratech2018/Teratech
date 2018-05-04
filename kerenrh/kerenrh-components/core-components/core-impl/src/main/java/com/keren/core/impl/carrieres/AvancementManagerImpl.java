
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
import com.keren.core.ifaces.carrieres.AvancementManagerLocal;
import com.keren.core.ifaces.carrieres.AvancementManagerRemote;
import com.keren.dao.ifaces.carrieres.AvancementDAOLocal;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.model.carrieres.Avancement;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AvancementManager")
public class AvancementManagerImpl
    extends AbstractGenericManager<Avancement, Long>
    implements AvancementManagerLocal, AvancementManagerRemote
{

    @EJB(name = "AvancementDAO")
    protected AvancementDAOLocal dao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;

    
    public AvancementManagerImpl() {
    	
    }

    @Override
    public GenericDAO<Avancement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<Avancement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
        
        // TODO Auto-generated method stub
        List<Avancement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Avancement> result = new ArrayList<Avancement>();
        
        for(Avancement data:datas){
            result.add(new Avancement(data));
        }
        
        return result;
    }

    @Override
    public Avancement find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        Avancement data = super.find(propertyName, entityID);
        Avancement result = new Avancement(data);
        
        return result;
    }

    @Override
    public List<Avancement> findAll() {
        
        // TODO Auto-generated method stub
        List<Avancement> datas =  super.findAll();
        List<Avancement> result = new ArrayList<Avancement>();
        
        for(Avancement data:datas){
                result.add(new Avancement(data));
        }
        
        return result;
    }
    
    @Override
    public Avancement delete(Long id) {
        
        // TODO Auto-generated method stub    	
        Avancement data= super.delete(id);
        
        return new Avancement(data);
    }

    @Override
    public Avancement valide(Avancement entity) {
        
        // TODO Auto-generated method stub
        if(entity.getState().trim().equalsIgnoreCase("etabli")){
            
            entity.setState("valide");
            entity = dao.update(entity.getId(), entity);
            Employe salarie = entity.getSalarie();
            salarie.setCategorie(entity.getCategorieN());
            salarie.setEchelon(entity.getEchelonN());
            employedao.update(salarie.getId(), salarie);     
        }
        
        return new Avancement(entity);
    }

    @Override
    public Avancement annule(Avancement entity) {
        
        // TODO Auto-generated method stub
        entity.setState("annule");
        dao.update(entity.getId(), entity);
        return entity;
    }

}
