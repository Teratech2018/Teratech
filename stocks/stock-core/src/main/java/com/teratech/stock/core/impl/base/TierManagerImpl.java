
package com.teratech.stock.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.base.TierManagerLocal;
import com.teratech.stock.core.ifaces.base.TierManagerRemote;
import com.teratech.stock.dao.ifaces.base.TierDAOLocal;
import com.teratech.stock.model.banques.CompteBancaire;
import com.teratech.stock.model.base.Contact;
import com.teratech.stock.model.base.Tier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TierManager")
public class TierManagerImpl
    extends AbstractGenericManager<Tier, Long>
    implements TierManagerLocal, TierManagerRemote
{

    @EJB(name = "TierDAO")
    protected TierDAOLocal dao;

    public TierManagerImpl() {
    }

    @Override
    public GenericDAO<Tier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Tier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Tier> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Tier> result = new ArrayList<Tier>();
        for(Tier data:datas){
            result.add(new Tier(data));
        }
        return result;
    }

    @Override
    public List<Tier> findAll() {        
        List<Tier> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Tier> result = new ArrayList<Tier>();
        for(Tier data:datas){
            result.add(new Tier(data));
        }
        return result;
    }

    @Override
    public Tier find(String propertyName, Long entityID) {
        Tier data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Tier result = new Tier(data);
        for(CompteBancaire cb:data.getComptesbancaire()){
            result.getComptesbancaire().add(cb);
        }
        for(Contact co:data.getContacts()){
            result.getContacts().add(co);
        }
        return result;
    }

    @Override
    public Tier delete(Long id) {
        Tier data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Tier(data);
    }
    
    

}
