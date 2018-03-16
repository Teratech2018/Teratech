
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.FactureManagerLocal;
import com.teratech.achat.core.ifaces.operations.FactureManagerRemote;
import com.teratech.achat.dao.ifaces.operations.FactureDAOLocal;
import com.teratech.achat.model.comptabilite.Acompte;
import com.teratech.achat.model.comptabilite.EcheanceReglement;
import com.teratech.achat.model.operations.DocumentAchatState;
import com.teratech.achat.model.operations.Facture;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "FactureManager")
public class FactureManagerImpl
    extends AbstractGenericManager<Facture, Long>
    implements FactureManagerLocal, FactureManagerRemote
{

    @EJB(name = "FactureDAO")
    protected FactureDAOLocal dao;

    public FactureManagerImpl() {
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
        container.addEq("typedocument", DocumentAchatState.FACTURE);
        predicats.addAll(container.getPredicats());
        List<Facture> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Facture> result = new ArrayList<Facture>();
        for(Facture fac:datas){
            result.add(new Facture(fac));
        }
        return result;
    }

    @Override
    public List<Facture> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<Facture> datas =  super.findAll(); 
        List<Facture> result = new ArrayList<Facture>();
        for(Facture fac:datas){
            result.add(new Facture(fac));
        }
        return result;
    }

    @Override
    public Facture find(String propertyName, Long entityID) {
        Facture data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Facture result = new Facture(data);
        for(LigneDocumentAchat ligne:data.getLignes()){
            result.getLignes().add(new LigneDocumentAchat(ligne));
        }//end for(LigneDocumentAchat ligne:data.getLignes()){
        for(Acompte ac:data.getAcomptes()){
            result.getAcomptes().add(new Acompte(ac));
        }//end for(Acompte ac:data.getAcomptes()){
        for(EcheanceReglement ec:data.getEcheances()){
            result.getEcheances().add(ec);
        }//end for(EcheanceReglement ec:data.getEcheances()){
        return result;
    }

    @Override
    public Facture delete(Long id) {
        Facture data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Facture(data);
    }

    @Override
    public Facture confirmer(Facture entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("etabli")){
            entity.setState("confirme");
        }
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public Facture transfert(Facture entity) {
         //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("confirme")){
            entity.setState("transfere");
            entity.setTypedocument(DocumentAchatState.COMPTABILITE);
        }
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public Facture annule(Facture entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(!entity.getState().equalsIgnoreCase("transfere")){
            entity.setState("annule");
        }
        dao.update(entity.getId(), entity);
        return entity;
    }
    
    

}
