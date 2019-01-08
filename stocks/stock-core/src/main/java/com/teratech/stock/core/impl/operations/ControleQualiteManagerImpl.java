
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.ControleQualiteManagerLocal;
import com.teratech.stock.core.ifaces.operations.ControleQualiteManagerRemote;
import com.teratech.stock.dao.ifaces.operations.ControleQualiteDAOLocal;
import com.teratech.stock.dao.ifaces.operations.EntreeDAOLocal;
import com.teratech.stock.model.operations.ControleQualite;
import com.teratech.stock.model.operations.Entree;
import com.teratech.stock.model.operations.LigneControleQualite;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ControleQualiteManager")
public class ControleQualiteManagerImpl
    extends AbstractGenericManager<ControleQualite, Long>
    implements ControleQualiteManagerLocal, ControleQualiteManagerRemote
{

    @EJB(name = "ControleQualiteDAO")
    protected ControleQualiteDAOLocal dao;
    
    @EJB(name = "EntreeDAO")
    protected EntreeDAOLocal indao;

    public ControleQualiteManagerImpl() {
    }

    @Override
    public GenericDAO<ControleQualite, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<ControleQualite> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ControleQualite> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ControleQualite> result = new ArrayList<ControleQualite>();
        for(ControleQualite data:datas){
            result.add(new ControleQualite(data));
        }
        return result;
    }

    @Override
    public ControleQualite find(String propertyName, Long entityID) {
        ControleQualite entity = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ControleQualite result = new ControleQualite(entity);
        for(LigneControleQualite ligne:entity.getLignes()){
            result.getLignes().add(new LigneControleQualite(ligne));
        }
        return result;
    }

    @Override
    public ControleQualite delete(Long id) {
        ControleQualite entity= super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new ControleQualite(entity);
    }

    public ControleQualite traiter(ControleQualite entity) {
        //To change body of generated methods, choose Tools | Templates.
         entity.setState("traite");
        entity = dao.update(entity.getId(), entity);
        //Verifier si tout le contrôles 
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("entree.id", entity.getEntree().getId());
        List<ControleQualite> controles = dao.filter(container.getPredicats(), null, null, 0, -1);
        boolean traiter = true;
        for(ControleQualite controle:controles){
            traiter &=controle.getState().equalsIgnoreCase("traite");
        }//end for(ControleQualite controle:controles){
        if(traiter){//Tout les controles sont effectués
            Entree reception = indao.findByPrimaryKey("id", entity.getEntree().getId());            
            reception.setState("transfere");
            indao.update(reception.getId(), reception);
        }//end if(traiter){
        return entity;
    }
    
    

}
