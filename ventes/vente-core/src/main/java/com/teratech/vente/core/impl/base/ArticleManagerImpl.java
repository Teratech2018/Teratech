
package com.teratech.vente.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.vente.core.ifaces.base.ArticleManagerLocal;
import com.teratech.vente.core.ifaces.base.ArticleManagerRemote;
import com.teratech.vente.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.vente.model.base.Article;
import com.teratech.vente.model.base.Controle;
import com.teratech.vente.model.base.LienEmplacement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ArticleManager")
public class ArticleManagerImpl
    extends AbstractGenericManager<Article, Long>
    implements ArticleManagerLocal, ArticleManagerRemote
{

    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal dao;

    public ArticleManagerImpl() {
    }

    @Override
    public GenericDAO<Article, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
     @Override
    public List<Article> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("vendu", Boolean.TRUE);
        predicats.addAll(container.getPredicats());
        List<Article> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Article> result = new ArrayList<Article>();
        for(Article art:datas){
            result.add(new Article(art));
        }
        return result;
    }

    @Override
    public Long count(List<Predicat> predicats) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("vendu", Boolean.TRUE);
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List<Article> findAll() {
         //To change body of generated methods, choose Tools | Templates.
        List<Article> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Article> result = new ArrayList<Article>();
        for(Article art:datas){
            result.add(new Article(art));
        }
        return result;
    }

    @Override
    public Article find(String propertyName, Long entityID) {
        Article data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Article result = new Article(data);
        if(data.getStockages()!=null){
            for(LienEmplacement lien:data.getStockages()){
                result.getStockages().add(new LienEmplacement(lien));
            }
        }//end if(data.getStockages()!=null)
        if(data.getControles()!=null){
            for(Controle controle:data.getControles()){
                result.getControles().add(new Controle(controle));
            }//end for(Controle controle:data.getControles()){
        }
        return result;
    }

    @Override
    public Article delete(Long id) {
        Article data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Article(data);
    }

}
