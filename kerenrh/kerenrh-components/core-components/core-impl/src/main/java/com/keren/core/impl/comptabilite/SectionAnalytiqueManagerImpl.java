
package com.keren.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.comptabilite.SectionAnalytiqueManagerLocal;
import com.keren.core.ifaces.comptabilite.SectionAnalytiqueManagerRemote;
import com.keren.dao.ifaces.comptabilite.SectionAnalytiqueDAOLocal;
import com.keren.model.comptabilite.SectionAnalytique;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "SectionAnalytiqueManager")
public class SectionAnalytiqueManagerImpl
    extends AbstractGenericManager<SectionAnalytique, Long>
    implements SectionAnalytiqueManagerLocal, SectionAnalytiqueManagerRemote
{

    @EJB(name = "SectionAnalytiqueDAO")
    protected SectionAnalytiqueDAOLocal dao;

    public SectionAnalytiqueManagerImpl() {
    }

    @Override
    public GenericDAO<SectionAnalytique, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<SectionAnalytique> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<SectionAnalytique> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<SectionAnalytique> results = new ArrayList<SectionAnalytique>();
        for(SectionAnalytique data:datas){
            results.add(new SectionAnalytique(data));
        }
        return results;
    }

    @Override
    public List<SectionAnalytique> findAll() {
        List<SectionAnalytique> datas = super.findAll();
        List<SectionAnalytique> results = new ArrayList<SectionAnalytique>();

        for(SectionAnalytique data:datas){
            results.add(new SectionAnalytique(data));
        }
        return results;
    }

    @Override
    public SectionAnalytique find(String propertyName, Long entityID) {
        SectionAnalytique data = super.find(propertyName, entityID);
        SectionAnalytique result = new SectionAnalytique(data);


        return result;
    }

    @Override
    public void processAfterUpdate(SectionAnalytique entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(SectionAnalytique entity) {
         entity = dao.findByPrimaryKey("compte", entity.getCompte());

        super.processAfterSave(entity);
    }

}