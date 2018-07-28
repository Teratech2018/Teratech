
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.curative.AffectationBonTravailManagerLocal;
import com.teratech.gmao.core.ifaces.curative.AffectationBonTravailManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.AffectationBonTravailDAOLocal;
import com.teratech.gmao.model.curative.AffectationBonTravail;
import com.teratech.gmao.model.curative.ArticlePrevu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "AffectationBonTravailManager")
public class AffectationBonTravailManagerImpl
    extends AbstractGenericManager<AffectationBonTravail, Long>
    implements AffectationBonTravailManagerLocal, AffectationBonTravailManagerRemote
{

    @EJB(name = "AffectationBonTravailDAO")
    protected AffectationBonTravailDAOLocal dao;

    public AffectationBonTravailManagerImpl() {
    }

    @Override
    public GenericDAO<AffectationBonTravail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<AffectationBonTravail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<AffectationBonTravail> datas =  super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<AffectationBonTravail> results = new ArrayList<AffectationBonTravail>();
        for(AffectationBonTravail data:datas){
            results.add(new AffectationBonTravail(data));
        }
        return results;
    }

    @Override
    public List<AffectationBonTravail> findAll() {
        List<AffectationBonTravail> datas =  super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<AffectationBonTravail> results = new ArrayList<AffectationBonTravail>();
        for(AffectationBonTravail data:datas){
            results.add(new AffectationBonTravail(data));
        }
        return results;
    }

    @Override
    public AffectationBonTravail find(String propertyName, Long entityID) {
        AffectationBonTravail data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        AffectationBonTravail result = new AffectationBonTravail(data);
        for(ArticlePrevu art:data.getArticles()){
            result.getArticles().add(new ArticlePrevu(art));
        }//end for(ArticlePrevu art:data.getArticles()){
        return result;
    }

    @Override
    public AffectationBonTravail delete(Long id) {
        AffectationBonTravail data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new AffectationBonTravail(data);
    }
    
    

}
