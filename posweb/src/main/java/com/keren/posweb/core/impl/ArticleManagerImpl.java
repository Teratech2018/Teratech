
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.ArticleManagerLocal;
import com.keren.posweb.core.ifaces.ArticleManagerRemote;
import com.keren.posweb.dao.ifaces.ArticleDAOLocal;
import com.keren.posweb.model.Article;
import com.keren.posweb.model.Taxe;
import com.megatim.common.annotations.OrderType;
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
        //To change body of generated methods, choose Tools | Templates.
        List<Article> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Article> results = new ArrayList<Article>();
        for(Article data:datas){
            Article art = new Article(data);
            for(Taxe taxe : data.getTaxesventes()){
                art.getTaxesventes().add(new Taxe(taxe));
            }//end for(Taxe taxe : data.getTaxesventes()){
            for(Taxe taxe : data.getTaxesachats()){
                art.getTaxesachats().add(new Taxe(taxe));
            }//end for(Taxe taxe : data.getTaxesventes()){
            results.add(art);
        }
        return results;
    }

    @Override
    public List<Article> findAll() {
        List<Article> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Article> results = new ArrayList<Article>();
        for(Article data:datas){
            Article art = new Article(data);
            for(Taxe taxe : data.getTaxesventes()){
                art.getTaxesventes().add(new Taxe(taxe));
            }//end for(Taxe taxe : data.getTaxesventes()){
            for(Taxe taxe : data.getTaxesachats()){
                art.getTaxesachats().add(new Taxe(taxe));
            }//end for(Taxe taxe : data.getTaxesventes()){
            results.add(art);
        }
        return results;
    }

    @Override
    public Article find(String propertyName, Long entityID) {
        Article article = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Article result = new Article(article);
        for(Taxe taxe : article.getTaxesachats()){
            result.getTaxesachats().add(new Taxe(taxe));
        }
        for(Taxe taxe : article.getTaxesventes()){
            result.getTaxesventes().add(new Taxe(taxe));
        }
        return result;
    }

    @Override
    public Article delete(Long id) {
        Article article =  super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Article(article);
    }

    
}
