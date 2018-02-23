
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.EntreeManagerLocal;
import com.teratech.stock.core.ifaces.operations.EntreeManagerRemote;
import com.teratech.stock.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.stock.dao.ifaces.operations.EntreeDAOLocal;
import com.teratech.stock.dao.ifaces.operations.EntreeVDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.operations.Entree;
import com.teratech.stock.model.operations.EntreeV;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.Lot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "EntreeManager")
public class EntreeManagerImpl
    extends AbstractGenericManager<Entree, Long>
    implements EntreeManagerLocal, EntreeManagerRemote
{

    @EJB(name = "EntreeDAO")
    protected EntreeDAOLocal dao;
    
    @EJB(name = "EntreeVDAO")
    protected EntreeVDAOLocal dao2;
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;

    public EntreeManagerImpl() {
    }

    @Override
    public GenericDAO<Entree, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Entree> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Entree> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Entree> result = new ArrayList<Entree>();
        for(Entree en:datas){
            result.add(new Entree(en));
        }
        return result ;
    }

    @Override
    public List<Entree> findAll() {        
        List<Entree> datas = super.findAll();//To change body of generated methods, choose Tools | Templates.
        List<Entree> result = new ArrayList<Entree>();
        for(Entree en:datas){
            result.add(new Entree(en));
        }
        return result ;
    }

    @Override
    public Entree find(String propertyName, Long entityID) {
        Entree data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Entree result = new Entree(data);
        for(LigneDocumentStock lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentStock(lign));
        }
        return result;
    }

    @Override
    public Entree delete(Long id) {
        Entree data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Entree(data);
    }

    @Override
    public void processBeforeUpdate(Entree entity) {        
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(Entree entity) {       
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
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
                    Lot lot = new Lot(ligne.getCode(), ligne.getQuantite(), ligne.getPeremption(), ligne.getFabrication());
                    lot.setLien(lien);lot.getReference();
                    lotdao.save(lot);
                }else if(article.getPolitiquestock().equalsIgnoreCase("2")){
                    
                }else if(article.getPolitiquestock().equalsIgnoreCase("3")||article.getPolitiquestock().equalsIgnoreCase("4")){
//                    Date date = new Date();
//                    Lot lot = new Lot(Long.toString(date.getTime()), ligne.getQuantite(), ligne.getPeremption(), ligne.getFabrication());
//                    lot.setLien(lien);
//                    lotdao.save(lot);
                }//end if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0"))
                lien.addStock(ligne.getQuantite());
            }//end if(lien.getEmplacement().compareTo(empl)==0){
        }//end for(LienEmplacement lien : article.getStockages()){
        articledao.update(article.getId(), article);
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){
    
    /**
     * 
     * @param ligne
     * @param empl 
     */
    private void inversecomputeLigne(LigneDocumentStock ligne , Emplacement empl){
        Article article = articledao.findByPrimaryKey("id", ligne.getArticle().getId());
        for(LienEmplacement lien : article.getStockages()){
            if(lien.getEmplacement().compareTo(empl)==0){
                
                lien.addStock(-ligne.getQuantite());
            }//end if(lien.getEmplacement().compareTo(empl)==0){
        }//end for(LienEmplacement lien : article.getStockages()){
        articledao.update(article.getId(), article);
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){

    public EntreeV confirmer(Entree obj) {
        //To change body of generated methods, choose Tools | Templates.
        EntreeV entree = new EntreeV(obj);
        entree.setId(-1);
        //Copie des ligne
        for(LigneDocumentStock lign:obj.getLignes()){
            LigneDocumentStock li = new LigneDocumentStock(lign);
            li.setId(-1);
            entree.getLignes().add(li);
            //Mise a jour du stock en BD
            computeLigne(li, obj.getEmplacement());
        }//end for(LigneDocumentStock lign:obj.getLignes())
        //Suppression 
        dao.delete(obj.getId());
        //Creation de l'entree valide
        dao2.save(entree);
        return entree;
    }
    

}
