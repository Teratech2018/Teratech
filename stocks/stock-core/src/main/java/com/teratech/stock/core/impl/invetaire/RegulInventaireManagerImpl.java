
package com.teratech.stock.core.impl.invetaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.invetaire.RegulInventaireManagerLocal;
import com.teratech.stock.core.ifaces.invetaire.RegulInventaireManagerRemote;
import com.teratech.stock.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.stock.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.RegulInventaireDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.model.base.LienEmplacement;
import com.teratech.stock.model.invetaire.LigneInventaire;
import com.teratech.stock.model.invetaire.RegulInventaire;
import com.teratech.stock.model.operations.Lot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "RegulInventaireManager")
public class RegulInventaireManagerImpl
    extends AbstractGenericManager<RegulInventaire, Long>
    implements RegulInventaireManagerLocal, RegulInventaireManagerRemote
{

    @EJB(name = "RegulInventaireDAO")
    protected RegulInventaireDAOLocal dao;
    
    @EJB(name = "ArticleDAO")
    protected ArticleDAOLocal articledao;
    
    @EJB(name = "LotDAO")
    protected LotDAOLocal lotedao;
    
    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal liendao;

    public RegulInventaireManagerImpl() {
    }

    @Override
    public GenericDAO<RegulInventaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<RegulInventaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<RegulInventaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<RegulInventaire> result = new ArrayList<RegulInventaire>();
        for(RegulInventaire reg:datas){
            result.add(new RegulInventaire(reg));
        }
        return result;
    }

    @Override
    public List<RegulInventaire> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<RegulInventaire> datas =  super.findAll();
        List<RegulInventaire> result = new ArrayList<RegulInventaire>();
        for(RegulInventaire reg:datas){
            result.add(new RegulInventaire(reg));
        }
        return result;
    }

    @Override
    public RegulInventaire find(String propertyName, Long entityID) {
        RegulInventaire data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        RegulInventaire result = new RegulInventaire(data);
        for(LigneInventaire lign:data.getLignes()){
            result.getLignes().add(new LigneInventaire(lign));
        }//end for(LigneInventaire lign:data.getLignes()){
        return result;
    }

    @Override
    public RegulInventaire delete(Long id) {
        RegulInventaire data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new RegulInventaire(data);
    }

    /**
     * Cloture l'inventaire en mettant a jour le stock
     * @param entity
     * @return 
     */
    public RegulInventaire confirmer(RegulInventaire entity) {
        //To change body of generated methods, choose Tools | Templates.
        for(LigneInventaire ligne:entity.getLignes()){   
               if(ligne.getLot()!=null){
                    Lot lot = ligne.getLot();
                    if(ligne.getStockconstate()!=null){
                        lot.setQuantite(ligne.getStockconstate());
                        lot.setSorties(0.0);
                        lot.setEncours(0.0);
                    } //end if(ligne.getStockconstate()!=null){
                    lotedao.update(lot.getId(), lot);                     
                    //Mise a jour 
                }else{
                    RestrictionsContainer container = RestrictionsContainer.newInstance();
                    if(entity.getFentrepot()!=null){
                        container.addEq("entrpot.id", entity.getFentrepot().getId());
                    }
                    if(entity.getFemplacement()!=null){
                        container.addEq("emplacement.id", entity.getFemplacement().getId());
                    }
                    container.addEq("article.id", ligne.getArticle().getId());
                    List<LienEmplacement> liens = liendao.filter(container.getPredicats(), null, null, 0, -1);
                    LienEmplacement lien = liens.get(0);               
                   lien.setStock(ligne.getStockconstate()!=null? ligne.getStockconstate():lien.getStock());
                   liendao.update(lien.getId(), lien);
                }//end if(ligne.getLot()!=null)                          
                if(ligne.getPuajuste()!=null&&ligne.getPuajuste()>0){
                    ligne.getArticle().setPuachat(ligne.getPuajuste());
                }//end if(ligne.getPuajuste()>0)
                articledao.update(ligne.getArticle().getId(), ligne.getArticle());
        }//end for(LigneInventaire ligne:entity.getLignes())        
        entity.setState("termine");
        dao.update(entity.getId(), entity);
        return entity; 
    }

}
