
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.curative.DemandeInterventionManagerLocal;
import com.teratech.gmao.core.ifaces.curative.DemandeInterventionManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.DemandeInterventionDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.curative.DemandeIntervention;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "DemandeInterventionManager")
public class DemandeInterventionManagerImpl
    extends AbstractGenericManager<DemandeIntervention, Long>
    implements DemandeInterventionManagerLocal, DemandeInterventionManagerRemote
{

    @EJB(name = "DemandeInterventionDAO")
    protected DemandeInterventionDAOLocal dao;

    public DemandeInterventionManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeIntervention, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<DemandeIntervention> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<DemandeIntervention> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<DemandeIntervention> results = new ArrayList<DemandeIntervention>();
        for(DemandeIntervention data:datas){
            results.add(new DemandeIntervention(data));
        }//end for(DemandeIntervention data:datas){
        return results;
    }

    @Override
    public List<DemandeIntervention> findAll() {
        List<DemandeIntervention> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<DemandeIntervention> results = new ArrayList<DemandeIntervention>();
        for(DemandeIntervention data:datas){
            results.add(new DemandeIntervention(data));
        }//end for(DemandeIntervention data:datas){
        return results;
    }

    @Override
    public DemandeIntervention find(String propertyName, Long entityID) {
        //To change body of generated methods, choose Tools | Templates.
        DemandeIntervention data = super.find(propertyName, entityID); 
        DemandeIntervention entity =new DemandeIntervention(data);
        for(FichierLie fichier : data.getPiecesjointes()){
            entity.getPiecesjointes().add(fichier);
        }//end for(FichierLie fichier : data.getPiecesjointes()){
       return entity;
    }

    @Override
    public DemandeIntervention delete(Long id) {
        DemandeIntervention data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        DemandeIntervention entity =new DemandeIntervention(data);
        return entity;
    }

    @Override
    public void processBeforeSave(DemandeIntervention entity) {
        entity.setState("etabli");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
