
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.DemandePrixManagerLocal;
import com.teratech.achat.core.ifaces.operations.DemandePrixManagerRemote;
import com.teratech.achat.dao.ifaces.operations.AppelOffreDAOLocal;
import com.teratech.achat.dao.ifaces.operations.DemandePrixDAOLocal;
import com.teratech.achat.model.operations.AppelOffre;
import com.teratech.achat.model.operations.DemandePrix;
import com.teratech.achat.model.operations.DocumentAchatState;
import com.teratech.achat.model.operations.LigneDocumentAchat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "DemandePrixManager")
public class DemandePrixManagerImpl
    extends AbstractGenericManager<DemandePrix, Long>
    implements DemandePrixManagerLocal, DemandePrixManagerRemote
{

    @EJB(name = "DemandePrixDAO")
    protected DemandePrixDAOLocal dao;
    
    @EJB(name = "AppelOffreDAO")
    protected AppelOffreDAOLocal offredao;

    public DemandePrixManagerImpl() {
    }

    @Override
    public GenericDAO<DemandePrix, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<DemandePrix> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("typedocument", DocumentAchatState.DEMANDE_PRIX);
        predicats.addAll(container.getPredicats());
        List<DemandePrix> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<DemandePrix> result = new ArrayList<DemandePrix>();
        for(DemandePrix dmde:datas){
            result.add(new DemandePrix(dmde));
        }
        return result;
    }

    @Override
    public List<DemandePrix> findAll() {
        List<DemandePrix> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.         
        List<DemandePrix> result = new ArrayList<DemandePrix>();
        for(DemandePrix dmde:datas){
            result.add(new DemandePrix(dmde));
        }
        return result;
    }

    @Override
    public DemandePrix find(String propertyName, Long entityID) {
        DemandePrix data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        DemandePrix result = new DemandePrix(data);
        for(LigneDocumentAchat lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentAchat(lign));
        }
        return result;
    }

    @Override
    public DemandePrix delete(Long id) {
        DemandePrix data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new DemandePrix(data);
    }

    @Override
    public DemandePrix confirmer(DemandePrix entity) {
       //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("etabli")){
            entity.setState("confirme");
        }
        dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public DemandePrix envoyer(DemandePrix entity) {
        //To change body of generated methods, choose Tools | Templates.
        return entity;
    }

    @Override
    public DemandePrix engage(DemandePrix entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("confirme")){
            entity.setState("etabli");
            entity.setTypedocument(DocumentAchatState.BONCOMMANDE);
            if(entity.getAppeloffre()!=null){
                AppelOffre offre = entity.getAppeloffre();
                offre = offredao.findByPrimaryKey("id", offre.getId());
                offre.setState("boncommande");
                offredao.update(offre.getId(), offre);
            }//end if(entity.getAppeloffre()!=null)
        }
         dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public DemandePrix annule(DemandePrix entity) {
        //To change body of generated methods, choose Tools | Templates.
        if(entity.getState().equalsIgnoreCase("etabli")||entity.getState().equalsIgnoreCase("confirme")){
            entity.setState("annule");
        }
         dao.update(entity.getId(), entity);
        return entity;
    }

    @Override
    public void processBeforeSave(DemandePrix entity) {
        entity.setTypedocument(DocumentAchatState.DEMANDE_PRIX);
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
