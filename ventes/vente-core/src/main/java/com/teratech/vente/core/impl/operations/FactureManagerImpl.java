
package com.teratech.vente.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.vente.core.ifaces.operations.FactureManagerLocal;
import com.teratech.vente.core.ifaces.operations.FactureManagerRemote;
import com.teratech.vente.dao.ifaces.operations.FactureDAOLocal;
import com.teratech.vente.model.comptabilite.Acompte;
import com.teratech.vente.model.comptabilite.EcheanceReglement;
import com.teratech.vente.model.operations.Facture;
import com.teratech.vente.model.operations.LigneFacture;
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
    public void processBeforeUpdate(Facture entity) {
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void processBeforeSave(Facture entity) {
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Facture> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Facture> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Facture> result = new ArrayList<Facture>();
        for(Facture data:datas){
            result.add(new Facture(data));
        }
        return result;
    }

    @Override
    public Facture find(String propertyName, Long entityID) {
        Facture data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Facture entity = new Facture(data);
        for(LigneFacture ligne:data.getLignes()){
            entity.getLignes().add(new LigneFacture(ligne));
        }//end for(LigneFacture ligne:data.getLignes()){
        for(EcheanceReglement echea:data.getEcheances()){
            entity.getEcheances().add(echea);
        }
        for(Acompte acom:data.getAcomptes()){
            entity.getAcomptes().add(new Acompte(acom));
        }
        return entity;
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
//            entity.setTypedocument(DocumentAchatState.COMPTABILITE);
        }
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public Facture annule(Facture entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("confirme")){
            entity.setState("etabli");
        }else if(entity.getState().equalsIgnoreCase("transfere")){
            entity.setState("confirme");
        }
        dao.update(entity.getId(), entity);
        return entity;
    }
}
