
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.BonCommandeManagerLocal;
import com.teratech.achat.core.ifaces.operations.BonCommandeManagerRemote;
import com.teratech.achat.dao.ifaces.operations.BonCommandeDAOLocal;
import com.teratech.achat.dao.ifaces.operations.BonReceptionDAOLocal;
import com.teratech.achat.model.operations.BonCommande;
import com.teratech.achat.model.operations.BonReception;
import com.teratech.achat.model.operations.DocumentAchatState;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "BonCommandeManager")
public class BonCommandeManagerImpl
    extends AbstractGenericManager<BonCommande, Long>
    implements BonCommandeManagerLocal, BonCommandeManagerRemote
{

    @EJB(name = "BonCommandeDAO")
    protected BonCommandeDAOLocal dao;
    
    @EJB(name = "BonReceptionDAO")
    protected BonReceptionDAOLocal receptiondao;

    public BonCommandeManagerImpl() {
    }

    @Override
    public GenericDAO<BonCommande, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<BonCommande> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
         RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("typedocument", DocumentAchatState.BONCOMMANDE);
        predicats.addAll(container.getPredicats());
        List<BonCommande> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<BonCommande> result = new ArrayList<BonCommande>();
        for(BonCommande bon:datas){
            result.add(new BonCommande(bon));
        }
        return result;
    }

    @Override
    public List<BonCommande> findAll() {
       //To change body of generated methods, choose Tools | Templates.
        List<BonCommande> datas = super.findAll(); 
        List<BonCommande> result = new ArrayList<BonCommande>();
        for(BonCommande bon:datas){
            result.add(new BonCommande(bon));
        }
        return result;
    }

    @Override
    public BonCommande find(String propertyName, Long entityID) {
        BonCommande data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        BonCommande result = new BonCommande(data);
        for(LigneDocumentAchat lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentAchat(lign));
        }
        return result;
    }

    @Override
    public BonCommande delete(Long id) {
        BonCommande data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new BonCommande(data);
    }

    @Override
    public BonCommande envoyer(BonCommande entity) {
       //To change body of generated methods, choose Tools | Templates.
        return entity;
    }

    @Override
    public BonCommande confirmer(BonCommande entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("etabli")){
            entity.setState("confirme");
        }
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public BonReception reception(BonCommande entity) {
        //To change body of generated methods, choose Tools | Templates.
        BonReception data = new BonReception(entity);
        data.setOrigine(entity.getCode());
        if(entity.getState().equalsIgnoreCase("confirme")){
            data.setState("etabli");
            data.setTypedocument(DocumentAchatState.BONLIVRAISON);
        }
        for(LigneDocumentAchat lign:entity.getLignes()){
            data.getLignes().add(new LigneDocumentAchat(lign));
        }//end for(LigneDocumentAchat lign:entity.getLignes())
        receptiondao.update(data.getId(), data);
        return data;
    }

    @Override
    public BonCommande annuler(BonCommande entity) {
        //To change body of generated methods, choose Tools | Templates.
        entity.setState("annule");
        dao.update(entity.getId(), entity);
        return entity;
    }

   

}
