
package com.keren.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.comptabilite.CompteAnalytiqueManagerLocal;
import com.keren.core.ifaces.comptabilite.CompteAnalytiqueManagerRemote;
import com.keren.dao.ifaces.comptabilite.CompteAnalytiqueDAOLocal;
import com.keren.model.comptabilite.CompteAnalytique;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CompteAnalytiqueManager")
public class CompteAnalytiqueManagerImpl
    extends AbstractGenericManager<CompteAnalytique, Long>
    implements CompteAnalytiqueManagerLocal, CompteAnalytiqueManagerRemote
{

    @EJB(name = "CompteAnalytiqueDAO")
    protected CompteAnalytiqueDAOLocal dao;

    public CompteAnalytiqueManagerImpl() {
    }

    @Override
    public GenericDAO<CompteAnalytique, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<CompteAnalytique> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CompteAnalytique> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<CompteAnalytique> results = new ArrayList<CompteAnalytique>();
        for(CompteAnalytique data:datas){
            results.add(new CompteAnalytique(data));
        }
        return results;
    }

    @Override
    public List<CompteAnalytique> findAll() {
        List<CompteAnalytique> datas = super.findAll();
        List<CompteAnalytique> results = new ArrayList<CompteAnalytique>();

        for(CompteAnalytique data:datas){
            results.add(new CompteAnalytique(data));
        }
        return results;
    }

    @Override
    public CompteAnalytique find(String propertyName, Long entityID) {
        CompteAnalytique data = super.find(propertyName, entityID);
        CompteAnalytique result = new CompteAnalytique(data);


        return result;
    }

    @Override
    public void processAfterUpdate(CompteAnalytique entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(CompteAnalytique entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }
    
}