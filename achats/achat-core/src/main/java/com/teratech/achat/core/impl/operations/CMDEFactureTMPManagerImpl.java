
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

    @Override
    public List<Facture> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("typedocument", DocumentAchatState.BONCOMMANDE);
        container.addEq("state", "confirme");
        predicats.addAll(container.getPredicats());
        List<BonCommande> datas = cmdedao.filter(predicats, orders, properties, firstResult, maxResult);
        List<Facture> result = new ArrayList<Facture>();
        for(BonCommande bc:datas){
            Facture facture = new Facture(bc);
            facture.setId(bc.getId());
            result.add(facture);
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
        for(LigneDocumentAchat ligne:entity.getLignes()){
            ligne.setId(-1);
            if(ligne.getLigneachat()!=null){
                ligne.getLigneachat().addQuantitefacturee(ligne.getQuantite());
            }
            lignedao.update(ligne.getLigneachat().getId(), ligne.getLigneachat());
        }//end for(LigneDocumentAchat ligne:entity.getLignes())
        return super.save(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
