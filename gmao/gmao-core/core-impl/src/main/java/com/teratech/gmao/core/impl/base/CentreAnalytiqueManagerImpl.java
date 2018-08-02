
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.CentreAnalytiqueManagerLocal;
import com.teratech.gmao.core.ifaces.base.CentreAnalytiqueManagerRemote;
import com.teratech.gmao.dao.ifaces.base.CentreAnalytiqueDAOLocal;
import com.teratech.gmao.model.base.CentreAnalytique;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CentreAnalytiqueManager")
public class CentreAnalytiqueManagerImpl
    extends AbstractGenericManager<CentreAnalytique, Long>
    implements CentreAnalytiqueManagerLocal, CentreAnalytiqueManagerRemote
{

    @EJB(name = "CentreAnalytiqueDAO")
    protected CentreAnalytiqueDAOLocal dao;

    public CentreAnalytiqueManagerImpl() {
    }

    @Override
    public GenericDAO<CentreAnalytique, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<CentreAnalytique> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {        
        List<CentreAnalytique> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CentreAnalytique> results = new ArrayList<CentreAnalytique>();
        for(CentreAnalytique data:datas){
            results.add(new CentreAnalytique(data));
        }
        return results;
    }

    @Override
    public List<CentreAnalytique> findAll() {
        List<CentreAnalytique> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<CentreAnalytique> results = new ArrayList<CentreAnalytique>();
        for(CentreAnalytique data:datas){
            results.add(new CentreAnalytique(data));
        }
        return results;
    }

    @Override
    public CentreAnalytique find(String propertyName, Long entityID) {
        //To change body of generated methods, choose Tools | Templates.
        CentreAnalytique data = super.find(propertyName, entityID); 
        return new CentreAnalytique(data);
    }

    @Override
    public CentreAnalytique delete(Long id) {
        CentreAnalytique data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new CentreAnalytique(data);
    }
    
    

}
