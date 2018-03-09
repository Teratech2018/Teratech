
package com.teratech.stock.core.impl.invetaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.invetaire.RegulInventaireManagerLocal;
import com.teratech.stock.core.ifaces.invetaire.RegulInventaireManagerRemote;
import com.teratech.stock.dao.ifaces.base.ArticleDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.LArticleEmplacementLotDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.RegulInventaireDAOLocal;
import com.teratech.stock.dao.ifaces.operations.LotDAOLocal;
import com.teratech.stock.model.base.Article;
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
            Article article = articledao.findByPrimaryKey("id", ligne.getArticle().getId());
            for(LienEmplacement lien : article.getStockages()){
                if(lien.getEmplacement().compareTo(entity.getFemplacement())==0){
                    if(ligne.getLot()!=null){
                        Double stock = 0.0;
                        for(Lot lot:lien.getLots()){
                            if(lot.compareTo(ligne.getLot())==0){
                                lot.setQuantite(ligne.getStockconstate());  
                                lotedao.update(lot.getId(), lot);
                            }//end if(lot.compareTo(ligne.getLot())==0){
                            stock+=lot.getQuantite();
                        }//end for(Lot lot:lien.getLots())
                        lien.setStock(stock);
                    }else{
                      lien.setStock(ligne.getStockconstate());
                    }//end if(ligne.getLot()!=null)
                    
                }//end if(lien.getEmplacement().compareTo(entity.getFemplacement())==0)
            }//end for(LienEmplacement lien : article.getStockages())
            if(ligne.getPuajuste()!=null&&ligne.getPuajuste()>0){
                article.setPuachat(ligne.getPuajuste());
            }//end if(ligne.getPuajuste()>0)
            articledao.update(article.getId(), article);
        }//end for(LigneInventaire ligne:entity.getLignes())
        entity.setState("termine");
        dao.update(entity.getId(), entity);
        return entity; 
    }

}
