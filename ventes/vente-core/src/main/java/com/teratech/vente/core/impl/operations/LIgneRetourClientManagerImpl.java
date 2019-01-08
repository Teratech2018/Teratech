
package com.teratech.vente.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.vente.core.ifaces.operations.LIgneRetourClientManagerLocal;
import com.teratech.vente.core.ifaces.operations.LIgneRetourClientManagerRemote;
import com.teratech.vente.dao.ifaces.operations.LIgneRetourClientDAOLocal;
import com.teratech.vente.model.operations.LIgneRetourClient;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "LIgneRetourClientManager")
public class LIgneRetourClientManagerImpl
    extends AbstractGenericManager<LIgneRetourClient, Long>
    implements LIgneRetourClientManagerLocal, LIgneRetourClientManagerRemote
{

    @EJB(name = "LIgneRetourClientDAO")
    protected LIgneRetourClientDAOLocal dao;

    public LIgneRetourClientManagerImpl() {
    }

    @Override
    public GenericDAO<LIgneRetourClient, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LIgneRetourClient> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<LIgneRetourClient> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<LIgneRetourClient> retour = new ArrayList<LIgneRetourClient>();
        for(LIgneRetourClient data:datas){
            retour.add(new LIgneRetourClient(data));
        }
        return retour;
    }

    @Override
    public LIgneRetourClient find(String propertyName, Long entityID) {
        LIgneRetourClient data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        LIgneRetourClient result = new LIgneRetourClient(data);
        return result;
    }

    @Override
    public LIgneRetourClient delete(Long id) {
        LIgneRetourClient data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new LIgneRetourClient(data);
    }

    
    
}
