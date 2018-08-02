
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.curative.BonTravailManagerLocal;
import com.teratech.gmao.core.ifaces.curative.BonTravailManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.BonTravailDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.curative.ArticlePrevu;
import com.teratech.gmao.model.curative.BonTravail;
import com.teratech.gmao.model.curative.IntervenantPrevu;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BonTravailManager")
public class BonTravailManagerImpl
    extends AbstractGenericManager<BonTravail, Long>
    implements BonTravailManagerLocal, BonTravailManagerRemote
{

    @EJB(name = "BonTravailDAO")
    protected BonTravailDAOLocal dao;

    public BonTravailManagerImpl() {
    }

    @Override
    public GenericDAO<BonTravail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BonTravail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
       List<BonTravail> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
       List<BonTravail> results = new ArrayList<BonTravail>();
       for(BonTravail data:datas){
           results.add(new BonTravail(data));
       }
       return results;
    }

    @Override
    public List<BonTravail> findAll() {
        //To change body of generated methods, choose Tools | Templates.
       List<BonTravail> datas = super.findAll(); 
       List<BonTravail> results = new ArrayList<BonTravail>();
       for(BonTravail data:datas){
           results.add(new BonTravail(data));
       }
       return results;
    }

    @Override
    public BonTravail find(String propertyName, Long entityID) {
        BonTravail data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        BonTravail entity = new BonTravail(data);
        for(FichierLie fichier:data.getPiecesjointes()){
            entity.getPiecesjointes().add(fichier);
        }//end for(FichierLie fichier:data.getPiecesjointes()){
        for(ArticlePrevu art:data.getArticles()){
            entity.getArticles().add(new ArticlePrevu(art));
        }//end for(ArticlePrevu art:data.getArticles()){
        for(IntervenantPrevu prev:data.getIntervenants()){
            entity.getIntervenants().add(new IntervenantPrevu(prev));
        }//end for(IntervenantPrevu prev:data.getIntervenants()){
        return entity;
    }

    @Override
    public BonTravail delete(Long id) {
        BonTravail data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BonTravail(data);
    }
    
    

}
