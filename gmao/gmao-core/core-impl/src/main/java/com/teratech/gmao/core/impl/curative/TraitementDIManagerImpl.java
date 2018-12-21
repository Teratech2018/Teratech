
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.curative.TraitementDIManagerLocal;
import com.teratech.gmao.core.ifaces.curative.TraitementDIManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.TraitementDIDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.curative.TraitementDI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TraitementDIManager")
public class TraitementDIManagerImpl
    extends AbstractGenericManager<TraitementDI, Long>
    implements TraitementDIManagerLocal, TraitementDIManagerRemote
{

    @EJB(name = "TraitementDIDAO")
    protected TraitementDIDAOLocal dao;

    public TraitementDIManagerImpl() {
    }

    @Override
    public GenericDAO<TraitementDI, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "etabli");
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TraitementDI> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("state", "etabli");
        predicats.addAll(container.getPredicats());
        List<TraitementDI> datas = dao.filter(predicats, orders, properties, firstResult, maxResult);
        List<TraitementDI> resultats  = new ArrayList<TraitementDI>();
        for(TraitementDI data : datas){
            resultats.add(new TraitementDI(data));
        }//end for(TraitementDI data : datas){
        return resultats; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<TraitementDI> findAll() {
        List<TraitementDI> datas = super.findAll();
        List<TraitementDI> resultats  = new ArrayList<TraitementDI>();
        for(TraitementDI data : datas){
            resultats.add(new TraitementDI(data));
        }//end for(TraitementDI data : datas){
        return resultats; //To change body of generated methods, cho
    }

    @Override
    public TraitementDI find(String propertyName, Long entityID) {
        TraitementDI data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        TraitementDI entity = new TraitementDI(data);
        for(FichierLie fichier : data.getPiecesjointes()){
            entity.getPiecesjointes().add(fichier);
        }//end for(FichierLie fichier : data.getPiecesjointes()){
        return entity ;
    }

    @Override
    public TraitementDI delete(Long id) {
        TraitementDI data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new TraitementDI(data);
    }

    @Override
    public void processBeforeUpdate(TraitementDI entity) {
        entity.setState("prisencharge");
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
