
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
import com.keren.core.ifaces.carrieres.BonificationManagerLocal;
import com.keren.core.ifaces.carrieres.BonificationManagerRemote;
import com.keren.dao.ifaces.carrieres.BonificationDAOLocal;
import com.keren.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.model.carrieres.Bonification;
import com.keren.model.employes.Employe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BonificationManager")
public class BonificationManagerImpl
    extends AbstractGenericManager<Bonification, Long>
    implements BonificationManagerLocal, BonificationManagerRemote
{

    @EJB(name = "BonificationDAO")
    protected BonificationDAOLocal dao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;

    public BonificationManagerImpl() {
    }

    @Override
    public GenericDAO<Bonification, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Bonification> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
        
        // TODO Auto-generated method stub
        List<Bonification> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Bonification> results = new ArrayList<Bonification>();

        for(Bonification data:datas){
                results.add(new Bonification(data));
        }
            
        return results;
    }

    @Override
    public Bonification find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        Bonification data = super.find(propertyName, entityID);
        return new Bonification(data);
    }

    @Override
    public List<Bonification> findAll() {
        
        // TODO Auto-generated method stub
        List<Bonification> datas = super.findAll();
        List<Bonification> results = new ArrayList<Bonification>();

        for(Bonification data:datas){
            results.add(new Bonification(data));
        }

        return results;
    }
    
    @Override
    public Bonification delete(Long id) {
        
        // TODO Auto-generated method stub    	
        Bonification data= super.delete(id);
        
        return new Bonification(data);
    }
    
    @Override
    public Bonification valide(Bonification entity) {
        
        // TODO Auto-generated method stub
        if(entity.getState().trim().equalsIgnoreCase("etabli")){
                entity.setState("valide");
        }

        entity = dao.update(entity.getId(), entity);
        //Mise a jour du salarie
        Employe salarie = entity.getSalarie();
        salarie.setEchelon(entity.getEchelonN());
        employedao.update(salarie.getId(), salarie);
        return new Bonification(entity);
    }

    @Override
    public Bonification annule(Bonification entity) {
            // TODO Auto-generated method stub
            return null;
    }
}
