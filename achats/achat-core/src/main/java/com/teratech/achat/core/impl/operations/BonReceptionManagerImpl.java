
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerLocal;
import com.teratech.achat.core.ifaces.operations.BonReceptionManagerRemote;
import com.teratech.achat.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.achat.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonReceptionDAOLocal;
import com.teratech.achat.dao.ifaces.operations.ControleQualiteDAOLocal;
import com.teratech.achat.dao.ifaces.operations.EntreeDAOLocal;
import com.teratech.achat.dao.ifaces.operations.FactureDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LotDAOLocal;
import com.teratech.achat.model.base.Article;
import com.teratech.achat.model.base.Emplacement;
import com.teratech.achat.model.base.LienEmplacement;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.ControleQualite;
import com.teratech.achat.model.operations.Entree;
import com.teratech.achat.model.operations.Facture;
import com.teratech.achat.model.operations.LigneDocumentStock;
import com.teratech.achat.model.operations.LigneEntree;
import com.teratech.achat.model.operations.Lot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BonReceptionManager")
public class BonReceptionManagerImpl
    extends AbstractGenericManager<BonReception, Long>
    implements BonReceptionManagerLocal, BonReceptionManagerRemote
{

    @EJB(name = "BonReceptionDAO")
    protected BonReceptionDAOLocal dao;
    
    @EJB(name = "EntreeDAO")
    protected EntreeDAOLocal entreedao;  
     
    @EJB(name = "FactureDAO")
    protected FactureDAOLocal facturedao;  
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotdao;
    
    @EJB(name = "ControleQualiteDAO")
    protected ControleQualiteDAOLocal controledao;
    
    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal liendao;
    
 
    public BonReceptionManagerImpl() {
    }

    @Override
    public GenericDAO<BonReception, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BonReception> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("nature", "0");
        predicats.addAll(container.getPredicats());
        List<BonReception> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<BonReception> result = new ArrayList<BonReception>();
        for(BonReception bon:datas){
            result.add(new BonReception(bon));
        }
        return result;
    }

    @Override
    public Long count(List<Predicat> predicats) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("nature", "0");
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    @Override
    public List<BonReception> findAll() {
        List<BonReception> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates
        List<BonReception> result = new ArrayList<BonReception>();
        for(BonReception bon:datas){
            result.add(new BonReception(bon));
        }
        return result;
    }

    @Override
    public BonReception find(String propertyName, Long entityID) {
        BonReception data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        BonReception result = new BonReception(data);
        for(LigneEntree lign:data.getLignes()){
            result.getLignes().add(new LigneEntree(lign));
        }
//        for(Facture fac:data.getFactures()){
//            result.getFactures().add(new Facture(fac));
//        }
        return result;
    }

    @Override
    public void processBeforeUpdate(BonReception entity) {        
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processAfterSave(BonReception entity) {
        entity = dao.findByPrimaryKey("compareid", entity.getCompareid());
        boolean tocontrole = false ;
        for(LigneDocumentStock ligne:entity.getLignes()){
            Article article = articledao.findByPrimaryKey("id", ligne.getArticle().getId());
            if(!article.getControles().isEmpty()){
                ControleQualite controle = new ControleQualite(article, entity, ligne);
                controledao.save(controle);
                tocontrole = true;
            }//end if(!article.getControles().isEmpty()){
        }//end for(LigneDocumentStock ligne:entity.getLignes()){
        if(tocontrole){
            entity.setState("qualite");
            dao.update(entity.getId(), entity);
        }//end if(tocontrole){
        super.processAfterSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(BonReception entity) {
//        Date today = new Date();
//        entity.setCompareid(today.getTime());
        entity.setState("transfere");
        entity.setNature("0");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    

    @Override
    public BonReception delete(Long id) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("bonlivraison.id", id);
        List<ControleQualite> controles = controledao.filter(container.getPredicats(), null, null, 0, -1);
        if(controles!=null && !controles.isEmpty()){
            for(ControleQualite controle:controles){
                controledao.delete(controle.getId());
            }//end for(ControleQualite controle:controles){
        }//end if(controles!=null && !controles.isEmpty()){
        BonReception data= super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BonReception(data);
    }

    /**
     * 
     * @param entity
     * @return 
     */
    @Override
    public BonReception confirmer(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        /*if(entity.getState().equalsIgnoreCase("etabli"))*/{
            entity.setState("confirme");
        }//end if(entity.getState().equalsIgnoreCase("etabli"))
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public BonReception rejeter(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("rejete");
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public BonReception transferer(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("disponible");
        dao.update(entity.getId(), entity);
        //Traitement des lignes de BR
        compute(entity);
//        for(LigneDocumentStock ligne:entity.getLignes()){
//            LienEmplacement lien = ligne.getEmplacement();            
//            lien.addStock(entity.getTypebon().equalsIgnoreCase("0")? ligne.getQuantite(): ligne.getQuantite()*-1);
//            liendao.update(lien.getId(), lien);
//        }//end for(LigneDocumentStock ligne:entity.getLignes()){
        return entity;
    }

    @Override
    public BonReception annuler(BonReception entity) {
        //To change body of generated methods, choose Tools | Templates.
         entity.setState("annule");
        dao.update(entity.getId(), entity);
        return entity;
    }
    
    /**
     * 
     * @param ligne
     * @param empl 
     */
    private void compute(BonReception entity){
       for(LigneEntree ligne:entity.getLignes()){
                LienEmplacement lien = ligne.getEmplacement();
                if(ligne.getArticle().getPolitiquestock()==null
                        ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("0")){
                    //Nothing to do
                }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("1")
                        ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("5")){
                    Lot lot = new Lot(ligne.getCode(), ligne.getQuantite(), ligne.getPeremption(), ligne.getFabrication());
                    lot.setLien(lien);lot.getReference();
                    lotdao.save(lot);
                }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("2")){
                    
                }else if(ligne.getArticle().getPolitiquestock().equalsIgnoreCase("3")
                        ||ligne.getArticle().getPolitiquestock().equalsIgnoreCase("4")){
//                    Date date = new Date();
//                    Lot lot = new Lot(Long.toString(date.getTime()), ligne.getQuantite(), ligne.getPeremption(), ligne.getFabrication());
//                    lot.setLien(lien);
//                    lotdao.save(lot);
                }//end if(article.getPolitiquestock()==null||article.getPolitiquestock().equalsIgnoreCase("0"))
                lien.addStock(ligne.getQuantite());     
                liendao.update(lien.getId(), lien);
       }//end for(LigneDocumentStock ligne:entity.getLignes()){
    }//end private void computeLigne(LigneDocumentStock ligne , Emplacement empl){
    
   
    /**
     * 
     * @param obj
     * @return 
     */
    public Entree confirmer(Entree obj) {
        //To change body of generated methods, choose Tools | Templates.
       //        EntreeV entree = new EntreeV(obj);
//  
        obj.setState("valider");
        entreedao.update(obj.getId(), obj);
        return obj;
    }

    @Override
    public BonReception facturer(BonReception entity) {
       //To change body of generated methods, choose Tools | Templates.
        Facture facture = new Facture(entity);
        facture.setId(-1);
//        for(LigneDocumentAchat lign:entity.getLignes()){
//            LigneDocumentAchat lignefacture = new LigneDocumentAchat(lign);
//            lignefacture.setId(-1);
//            lign.setQtefacturee(lign.getQuantite());
//            facture.getLignes().add(lignefacture);
//        }//end for(LigneDocumentAchat lign:entity.getLignes())
        dao.update(entity.getId(), entity);
        //Sauvegarde de la facture
        facturedao.save(facture);
        return entity;
    }

}
