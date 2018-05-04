
package com.keren.core.impl.presences;

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
import com.keren.core.ifaces.presences.FichePointageManagerLocal;
import com.keren.core.ifaces.presences.FichePointageManagerRemote;
import com.keren.dao.ifaces.presences.FichePointageDAOLocal;
import com.keren.model.presences.FichePointage;
import com.keren.model.presences.LigneFichePointage;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "FichePointageManager")
public class FichePointageManagerImpl
    extends AbstractGenericManager<FichePointage, Long>
    implements FichePointageManagerLocal, FichePointageManagerRemote
{

    @EJB(name = "FichePointageDAO")
    protected FichePointageDAOLocal dao;

    public FichePointageManagerImpl() {
    }

    @Override
    public GenericDAO<FichePointage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public FichePointage delete(Long id) {
        
        FichePointage data = super.delete(id);
        FichePointage result = new FichePointage(data);

        return result;
    }

    @Override
    public List<FichePointage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
                    int firstResult, int maxResult) {
        
        // TODO Auto-generated method stub
        List<FichePointage> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<FichePointage> results = new ArrayList<FichePointage>();

        for(FichePointage data:datas){
            results.add(new FichePointage(data));
        }

        return results;
    }

    @Override
    public FichePointage find(String propertyName, Long entityID) {
        
        // TODO Auto-generated method stub
        FichePointage data = super.find(propertyName, entityID);
        FichePointage result = new FichePointage(data);

        for(LigneFichePointage ligne:data.getLignes()){
            result.getLignes().add(new LigneFichePointage(ligne));
        }
        
        return result;
    }
    
    @Override
    public List<FichePointage> findAll() {
        
        // TODO Auto-generated method stub		
        List<FichePointage> datas =  super.findAll();
        List<FichePointage> results = new ArrayList<FichePointage>();
            
        for(FichePointage data:datas){
            results.add(new FichePointage(data));
        }
            
        return results;
    }
    
}
