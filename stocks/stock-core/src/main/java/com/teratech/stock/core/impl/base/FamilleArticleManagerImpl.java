
package com.teratech.stock.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.base.FamilleArticleManagerLocal;
import com.teratech.stock.core.ifaces.base.FamilleArticleManagerRemote;
import com.teratech.stock.dao.ifaces.base.FamilleArticleDAOLocal;
import com.teratech.stock.model.base.FamilleArticle;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "FamilleArticleManager")
public class FamilleArticleManagerImpl
    extends AbstractGenericManager<FamilleArticle, Long>
    implements FamilleArticleManagerLocal, FamilleArticleManagerRemote
{

    @EJB(name = "FamilleArticleDAO")
    protected FamilleArticleDAOLocal dao;

    public FamilleArticleManagerImpl() {
    }

    @Override
    public GenericDAO<FamilleArticle, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<FamilleArticle> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {        
        List<FamilleArticle> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<FamilleArticle> results = new ArrayList<FamilleArticle>();
        for(FamilleArticle data:datas){
            results.add(new FamilleArticle(data));
        }
        return results;
    }

    @Override
    public List<FamilleArticle> findAll() {
        List<FamilleArticle> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<FamilleArticle> results = new ArrayList<FamilleArticle>();
        for(FamilleArticle data:datas){
            results.add(new FamilleArticle(data));
        }
        return results;
    }

    @Override
    public FamilleArticle find(String propertyName, Long entityID) {
        FamilleArticle data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new FamilleArticle(data);
    }

    @Override
    public FamilleArticle delete(Long id) {
        FamilleArticle data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new FamilleArticle(data);
    }
    
    

}
