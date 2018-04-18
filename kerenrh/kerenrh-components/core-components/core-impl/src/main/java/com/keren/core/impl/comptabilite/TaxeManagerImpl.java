
package com.keren.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.comptabilite.TaxeManagerLocal;
import com.keren.core.ifaces.comptabilite.TaxeManagerRemote;
import com.keren.dao.ifaces.comptabilite.TaxeDAOLocal;
import com.keren.model.comptabilite.Compte;
import com.keren.model.comptabilite.Taxe;
import com.megatim.common.annotations.OrderType;
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
        List<Taxe> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Taxe> results = new ArrayList<Taxe>();
        for(Taxe data:datas){
            results.add(new Taxe(data));
        }
        return results;
    }

    @Override
    public List<Taxe> findAll() {
        List<Taxe> datas = super.findAll();
        List<Taxe> results = new ArrayList<Taxe>();

        for(Taxe data:datas){
            results.add(new Taxe(data));
        }
        return results;
    }

    @Override
    public Taxe find(String propertyName, Long entityID) {
        Taxe data = super.find(propertyName, entityID);
        Taxe result = new Taxe(data);

        for(Compte aas:data.getComptes()){
            result.getComptes().add(new Compte(aas));
        }

        return result;
    }

    @Override
    public void processAfterUpdate(Taxe entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Taxe entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }
}
