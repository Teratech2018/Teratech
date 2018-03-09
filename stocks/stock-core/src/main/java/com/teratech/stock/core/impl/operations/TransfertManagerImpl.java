
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.TransfertManagerLocal;
import com.teratech.stock.core.ifaces.operations.TransfertManagerRemote;
import com.teratech.stock.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.dao.ifaces.operations.TransfertDAOLocal;
import com.teratech.stock.model.base.Article;
import com.teratech.stock.model.base.Emplacement;
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.Lot;
import com.teratech.stock.model.operations.Transfert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TransfertManager")
public class TransfertManagerImpl
    extends AbstractGenericManager<Transfert, Long>
    implements TransfertManagerLocal, TransfertManagerRemote
{

    @EJB(name = "TransfertDAO")
    protected TransfertDAOLocal dao;
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    

    public TransfertManagerImpl() {
    }

    @Override
    public GenericDAO<Transfert, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Transfert> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Transfert> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Transfert> result = new ArrayList<Transfert>();
        for(Transfert tra:datas){
            result.add(new Transfert(tra));
        }
        return result;
    }

    @Override
    public List<Transfert> findAll() {
        List<Transfert> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Transfert> result = new ArrayList<Transfert>();
        for(Transfert tra:datas){
            result.add(new Transfert(tra));
        }
        return result;
    }

    @Override
    public Transfert find(String propertyName, Long entityID) {
        Transfert data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Transfert result = new Transfert(data);
        for(LigneDocumentStock lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentStock(lign));
        }
        return result;
    }

    @Override
    public Transfert delete(Long id) {
        Transfert data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Transfert(data);
    }
    
    /**
     * 
     * @param ligne
     * @param empl 
     */
    private void computeLigne(LigneDocumentStock ligne , Emplacement source, Emplacement cible){
        Article article = articledao.findByPrimaryKey("id", ligne.getArticle().getId());
        for(LienEmplacement lien : article.getStockages()){
            if(lien.getEmplacement().compareTo(source)==0){
                if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0")){
                    //Nothing to do
                }else if(article.getPolitiquestock().equalsIgnoreCase("1")||article.getPolitiquestock().equalsIgnoreCase("5")){
                    StringBuilder builder = new StringBuilder(ligne.getCode());
                    builder.append(source.getCode());
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
            //Traitement cible
            if(lien.getEmplacement().compareTo(cible)==0){
                if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0")){
                    //Nothing to do
                }else if(article.getPolitiquestock().equalsIgnoreCase("1")||article.getPolitiquestock().equalsIgnoreCase("5")){
                    StringBuilder builder = new StringBuilder(ligne.getCode());
                    builder.append(cible.getCode());
                    Lot lot = lotdao.findByPrimaryKey("reference", builder.toString());
                    if(lot==null){
                        lot = new Lot(ligne.getCode(), ligne.getQuantite(), ligne.getPeremption(), ligne.getFabrication());
                        lot.setLien(lien);lot.getReference();                    
                    }else{
                        lot.addEntree(ligne.getQuantite());
                    }//end if(lot==null)
                    if(lot.getId()>0){
                        lotdao.update(lot.getId(),lot);
                    }else{
                        lotdao.save(lot);
                    }
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

    public Transfert confirmer(Transfert object) {
        //To change body of generated methods, choose Tools | Templates.
        object.setState("valider");
        for(LigneDocumentStock ligne:object.getLignes()){
            computeLigne(ligne, object.getEmplacement(),object.getEmplcible());
        }//end for(LigneDocumentStock ligne:object.getLignes())
        //Mise a jour
        dao.update(object.getId(), object);
        return object;
    }
    
    

}
