
package com.keren.core.impl.structures;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.structures.SocieteManagerLocal;
import com.keren.core.ifaces.structures.SocieteManagerRemote;
import com.keren.dao.ifaces.structures.SocieteDAOLocal;
import com.keren.model.structures.Planification;
import com.keren.model.structures.Societe;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "SocieteManager")
public class SocieteManagerImpl
    extends AbstractGenericManager<Societe, Long>
    implements SocieteManagerLocal, SocieteManagerRemote
{

    @EJB(name = "SocieteDAO")
    protected SocieteDAOLocal dao;

    public SocieteManagerImpl() {
    }

    @Override
    public GenericDAO<Societe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Societe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Societe> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Societe> results = new ArrayList<Societe>();
        for(Societe data:datas){
            results.add(new Societe(data));
        }//end for(Societe data:datas){
        return results;
    }

    @Override
    public List<Societe> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<Societe> datas = super.findAll(); 
        List<Societe> results = new ArrayList<Societe>();
        for(Societe data:datas){
            results.add(new Societe(data));
        }//end for(Societe data:datas){
        return results;
    }

    @Override
    public Societe find(String propertyName, Long entityID) {
        Societe data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Societe result = new Societe(data);
        for(Planification plan:data.getPlanifications()){
            result.getPlanifications().add(new Planification(plan));
        }//end for(Planification plan:data.getPlanifications()){
        return result;
    }

    @Override
    public Societe delete(Long id) {
        return super.delete(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
