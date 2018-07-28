
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.OrganeManagerLocal;
import com.teratech.gmao.core.ifaces.base.OrganeManagerRemote;
import com.teratech.gmao.dao.ifaces.base.OrganeDAOLocal;
import com.teratech.gmao.model.base.Article;
import com.teratech.gmao.model.base.Organe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "OrganeManager")
public class OrganeManagerImpl
    extends AbstractGenericManager<Organe, Long>
    implements OrganeManagerLocal, OrganeManagerRemote
{

    @EJB(name = "OrganeDAO")
    protected OrganeDAOLocal dao;

    public OrganeManagerImpl() {
    }

    @Override
    public GenericDAO<Organe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Organe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Organe> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Organe> results = new ArrayList<Organe>();
        for(Organe data:datas){
            results.add(new Organe(data));
        }
        return results;
    }

    @Override
    public List<Organe> findAll() {
        List<Organe> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Organe> results = new ArrayList<Organe>();
        for(Organe data:datas){
            results.add(new Organe(data));
        }
        return results;
    }

    @Override
    public Organe find(String propertyName, Long entityID) {
        Organe data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Organe result = new Organe(data);
        for(Article art:data.getArticles()){
            result.getArticles().add(new Article(art));
        }//end for(Article art:data.getArticles()){
        return result;
    }

    @Override
    public Organe delete(Long id) {
        Organe data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Organe(data);
    }
    
    

}
