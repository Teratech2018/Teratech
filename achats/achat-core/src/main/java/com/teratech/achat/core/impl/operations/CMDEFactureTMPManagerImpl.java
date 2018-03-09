
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.CMDEFactureTMPManagerLocal;
import com.teratech.achat.core.ifaces.operations.CMDEFactureTMPManagerRemote;
import com.teratech.achat.dao.ifaces.operations.BonCommandeDAOLocal;
import com.teratech.achat.dao.ifaces.operations.FactureDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentAchatDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentStockDAOLocal;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.DocumentAchatState;
import com.teratech.achat.model.operations.Facture;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


@TransactionAttribute
@Stateless(mappedName = "CMDEFactureTMPManager")
public class CMDEFactureTMPManagerImpl
    extends AbstractGenericManager<Facture, Long>
    implements CMDEFactureTMPManagerLocal, CMDEFactureTMPManagerRemote
{

    @EJB(name = "FactureDAO")
    protected FactureDAOLocal dao;
    
    @EJB(name = "BonCommandeDAO")
    protected BonCommandeDAOLocal cmdedao;
    
    @EJB(name = "LigneDocumentAchatDAO")
    protected LigneDocumentAchatDAOLocal lignedao;
    

    public CMDEFactureTMPManagerImpl() {
    }

    @Override
    public GenericDAO<Facture, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    /**
     * 
     * @param data
     * @return 
     */
    private boolean isValideBC(BonCommande data){
//       boolean result = false;
       for(LigneDocumentAchat ligne:data.getLignes()){
           if(ligne.qtenonfacturee()>0){
               return true ;
           }
       }
       return false;
    }
    
    @Override
    public List<Facture> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("typedocument", DocumentAchatState.BONCOMMANDE);
        container.addEq("state", "confirme");
        predicats.addAll(container.getPredicats());
        List<BonCommande> datas = cmdedao.filter(predicats, orders, properties, firstResult, maxResult);
        List<Facture> result = new ArrayList<Facture>();
        for(BonCommande bc:datas){
            if(isValideBC(bc)){
                Facture facture = new Facture(bc);
                facture.setId(bc.getId());
                result.add(facture);
            }//end if(isValideBC(bc))
        }
        return result; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Facture> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Facture find(String propertyName, Long entityID) {
        BonCommande data = cmdedao.findByPrimaryKey(propertyName, entityID);
        Facture result = new Facture(data);
//        result.setId(data.getId());
        for(LigneDocumentAchat ligne:data.getLignes()){
            if(ligne.qtenonfacturee()>0){
                LigneDocumentAchat fac = new LigneDocumentAchat(ligne);
                fac.setLigneachat(new LigneDocumentAchat(ligne));
                fac.setId(ligne.getId());fac.setQuantite(fac.qtenonfacturee());
                fac.setStokdispo(fac.getQuantite());
                result.getLignes().add(fac);
            }//end if(ligne.qtenonfacturee()>0)
        }//end if(ligne.qtenonfacturee()>0)
        return result; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Facture delete(Long id) {
        return null; //To change body of generated methods, choose Tools | Templates.
    }

    

    @Override
    public Facture update(Long id, Facture entity) {
        entity.setId(-1);
        if(entity.getDocachat()!=null){
            BonCommande bon = cmdedao.findByPrimaryKey("id", entity.getDocachat().getId());
            //Construction
           for(LigneDocumentAchat ligne:entity.getLignes()){
                ligne.setId(-1);                        
                for(LigneDocumentAchat lig:bon.getLignes()){
                    if(lig.getArticle().compareTo(ligne.getArticle())==0 && lig.getQuantite()>=ligne.getQuantite()){
                        lig.addQuantitefacturee(ligne.getQuantite());                        
                    }//endif(ligne.getId()==ligne.getLigneachat().getId())
                }//end for(LigneDocumentAchat lig:bon.getLignes())
            }//end for(LigneDocumentAchat ligne:entity.getLignes())
            cmdedao.update(bon.getId(), bon);
        }//end if(entity.getDocachat()!=null)
        return super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
