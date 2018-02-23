
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.SortieManagerLocal;
import com.teratech.stock.core.ifaces.operations.SortieManagerRemote;
import com.teratech.stock.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.dao.ifaces.operations.SortieDAOLocal;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.Lot;
import com.teratech.stock.model.operations.Sortie;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "SortieManager")
public class SortieManagerImpl
    extends AbstractGenericManager<Sortie, Long>
    implements SortieManagerLocal, SortieManagerRemote
{

    @EJB(name = "SortieDAO")
    protected SortieDAOLocal dao;
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    

    public SortieManagerImpl() {
    }

    @Override
    public GenericDAO<Sortie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Sortie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Sortie> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Sortie> result = new ArrayList<Sortie>();
        for(Sortie sor:datas){
            result.add(new Sortie(sor));
        }
        return result;
    }

    @Override
    public List<Sortie> findAll() {        
        List<Sortie> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Sortie> result = new ArrayList<Sortie>();
        for(Sortie sor:datas){
            result.add(new Sortie(sor));
        }
        return result;
    }

    @Override
    public Sortie find(String propertyName, Long entityID) {
        Sortie data= super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Sortie result = new Sortie(data);
        for(LigneDocumentStock lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentStock(lign));
        }
        return result;
    }

    @Override
    public Sortie delete(Long id) {
        Sortie data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Sortie(data);
    }
    
    @Override
    public Sortie confirmer(Sortie object){
        object.setState("valider");
        for(LigneDocumentStock ligne:object.getLignes()){
            computeLigne(ligne, object.getEmplacement());
        }//end for(LigneDocumentStock ligne:object.getLignes())
        //Mise a jour
        dao.update(object.getId(), object);
        return object;
    }
    
    /**
     * 
     * @param ligne
     * @param empl 
     */
    private void computeLigne(LigneDocumentStock ligne , Emplacement empl){
        Article article = articledao.findByPrimaryKey("id", ligne.getArticle().getId());
        for(LienEmplacement lien : article.getStockages()){
            if(lien.getEmplacement().compareTo(empl)==0){
                if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0")){
                    //Nothing to do
                }else if(article.getPolitiquestock().equalsIgnoreCase("1")||article.getPolitiquestock().equalsIgnoreCase("5")){
                    StringBuilder builder = new StringBuilder(ligne.getCode());
                    builder.append(empl.getCode());
                    Lot lot = lotdao.findByPrimaryKey("reference", builder.toString());
                    lot.addSortie(ligne.getQuantite());
                    if(lot.disponible()>=0){
                        lotdao.update(lot.getId(),lot);
                    }else{
                        lotdao.delete(lot.getId());
                    }//end if(lot.disponible()>=0)                        
                }//end if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0"))
                lien.addStock(-ligne.getQuantite());
            }//end if(lien.getEmplacement().compareTo(empl)==0){
        }//end for(LienEmplacement lien : article.getStockages()){
        articledao.update(article.getId(), article);
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){

}
