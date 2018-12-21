
package com.teratech.stock.core.impl.invetaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.invetaire.FicheInventaireManagerLocal;
import com.teratech.stock.core.ifaces.invetaire.FicheInventaireManagerRemote;
import com.teratech.stock.dao.ifaces.invetaire.FicheInventaireDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.LArticleEmplacementLotDAOLocal;
import com.teratech.stock.dao.ifaces.invetaire.RegulInventaireDAOLocal;
import com.teratech.stock.model.invetaire.FicheInventaire;
import com.teratech.stock.model.invetaire.LArticleEmplacementLot;
import com.teratech.stock.model.invetaire.LigneInventaire;
import com.teratech.stock.model.invetaire.RegulInventaire;
import com.teratech.stock.model.operations.Lot;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "FicheInventaireManager")
public class FicheInventaireManagerImpl
    extends AbstractGenericManager<FicheInventaire, Long>
    implements FicheInventaireManagerLocal, FicheInventaireManagerRemote
{

    @EJB(name = "FicheInventaireDAO")
    protected FicheInventaireDAOLocal dao;
    
    @EJB(name = "LArticleEmplacementLotDAO")
    protected LArticleEmplacementLotDAOLocal laremlodao;
    
     @EJB(name = "RegulInventaireDAO")
    protected RegulInventaireDAOLocal reguldao;
    

    public FicheInventaireManagerImpl() {
    }

    @Override
    public GenericDAO<FicheInventaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<FicheInventaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<FicheInventaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<FicheInventaire> result = new ArrayList<FicheInventaire>();
        for(FicheInventaire fich:datas){
            result.add(new FicheInventaire(fich));
        }
        return result;
    }

    @Override
    public List<FicheInventaire> findAll() {        
         List<FicheInventaire> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<FicheInventaire> result = new ArrayList<FicheInventaire>();
        for(FicheInventaire fich:datas){
            result.add(new FicheInventaire(fich));
        }
        return result;
    }

    @Override
    public FicheInventaire find(String propertyName, Long entityID) {
        FicheInventaire data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        FicheInventaire result = new FicheInventaire(data);        
        return result;
    }

    @Override
    public FicheInventaire delete(Long id) {
        FicheInventaire data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new FicheInventaire(data);
    }

    public RegulInventaire confirmer(FicheInventaire dmde) {
        //To change body of generated methods, choose Tools | Templates.
        RegulInventaire data = new RegulInventaire(dmde);        
        RestrictionsContainer container = RestrictionsContainer.newInstance();        
        if(dmde.getFentrepot()!=null){
            container.addEq("entrepot", data.getFentrepot());
        }//end if(dmde.getFentrepot()!=null){
        if(dmde.getFemplacement()!=null){
            container.addEq("emplacement", data.getFemplacement());
        }//end if(dmde.getFemplacement()!=null){
        //Chargement des lignes
        List<LArticleEmplacementLot> datas = laremlodao.filter(container.getPredicats(), null, null, 0, -1);
        List<LigneInventaire> lignes = new ArrayList<LigneInventaire>();
        for(LArticleEmplacementLot lart:datas){
            if(lart.getLien().getLots()==null||lart.getLien().getLots().isEmpty()){
                LigneInventaire lig = new LigneInventaire(lart);
                lignes.add(lig);
            }else{
                for(Lot lot:lart.getLien().getLots()){
                    LigneInventaire lig = new LigneInventaire(lart);
                    lig.setLot(lot);lig.setStockdispo(lot.disponible());
                    lignes.add(lig);
                }//end for(Lot lot:lart.getLien().getLots())
            }//end if(lart.getLien().getLots()==null||lart.getLien().getLots().isEmpty())
        }//end for(LArticleEmplacementLot lart:datas)
        data.setLignes(lignes);
        dao.delete(dmde.getId());
        reguldao.save(data);
        return new RegulInventaire(data);
    }
    
    

}
