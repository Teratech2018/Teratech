
package com.keren.core.impl.employes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.employes.FonctionManagerLocal;
import com.keren.core.ifaces.employes.FonctionManagerRemote;
import com.keren.dao.ifaces.employes.FonctionDAOLocal;
import com.keren.model.employes.Fonction;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "FonctionManager")
public class FonctionManagerImpl
    extends AbstractGenericManager<Fonction, Long>
    implements FonctionManagerLocal, FonctionManagerRemote
{

    @EJB(name = "FonctionDAO")
    protected FonctionDAOLocal dao;

    public FonctionManagerImpl() {
    }

    @Override
    public GenericDAO<Fonction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<Fonction> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Fonction> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Fonction> results = new ArrayList<Fonction>();
        for(Fonction data:datas){
            results.add(new Fonction(data));
        }
        return results;
    }

    @Override
    public List<Fonction> findAll() {
        List<Fonction> datas = super.findAll();
        List<Fonction> results = new ArrayList<Fonction>();

        for(Fonction data:datas){
            results.add(new Fonction(data));
        }
        return results;
    }

    @Override
    public Fonction find(String propertyName, Long entityID) {
        Fonction data = super.find(propertyName, entityID);
        Fonction result = new Fonction(data);


        return result;
    }

    @Override
    public void processAfterUpdate(Fonction entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Fonction entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }
    
}