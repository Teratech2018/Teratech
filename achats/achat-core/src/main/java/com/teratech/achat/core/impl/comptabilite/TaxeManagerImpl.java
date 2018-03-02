
package com.teratech.achat.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.comptabilite.TaxeManagerLocal;
import com.teratech.achat.core.ifaces.comptabilite.TaxeManagerRemote;
import com.teratech.achat.dao.ifaces.comptabilite.TaxeDAOLocal;
import com.teratech.achat.model.comptabilite.Taxe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TaxeManager")
public class TaxeManagerImpl
    extends AbstractGenericManager<Taxe, Long>
    implements TaxeManagerLocal, TaxeManagerRemote
{

    @EJB(name = "TaxeDAO")
    protected TaxeDAOLocal dao;

    public TaxeManagerImpl() {
    }

    @Override
    public GenericDAO<Taxe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
    @Override
    public List<Taxe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Taxe> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Taxe> result = new ArrayList<Taxe>();
        for(Taxe te:datas){
            result.add(new Taxe(te));
        }
        return result;
    }

    @Override
    public List<Taxe> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Taxe find(String propertyName, Long entityID) {
        Taxe data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Taxe result = new Taxe(data);
        
        return result;
    }

    @Override
    public Taxe delete(Long id) {
        return super.delete(id); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Taxe save(Taxe entity) {
        Taxe data = super.save(entity); //To change body of generated methods, choose Tools | Templates.
        return new Taxe(data);
    }
    

}
