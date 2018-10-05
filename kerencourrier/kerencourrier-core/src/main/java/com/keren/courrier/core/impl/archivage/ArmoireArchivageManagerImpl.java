
package com.keren.courrier.core.impl.archivage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.archivage.ArmoireArchivageManagerLocal;
import com.keren.courrier.core.ifaces.archivage.ArmoireArchivageManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.ArmoireArchivageDAOLocal;
import com.keren.courrier.model.archivage.ArmoireArchivage;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ArmoireArchivageManager")
public class ArmoireArchivageManagerImpl
    extends AbstractGenericManager<ArmoireArchivage, Long>
    implements ArmoireArchivageManagerLocal, ArmoireArchivageManagerRemote
{

    @EJB(name = "ArmoireArchivageDAO")
    protected ArmoireArchivageDAOLocal dao;

    public ArmoireArchivageManagerImpl() {
    }

    @Override
    public GenericDAO<ArmoireArchivage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<ArmoireArchivage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ArmoireArchivage> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ArmoireArchivage> results = new ArrayList<ArmoireArchivage>();        
        for(ArmoireArchivage courrier:datas){
            ArmoireArchivage data = new ArmoireArchivage(courrier);
            results.add(data);              
        }//end for(ArmoireArchivage courrier:datas){        
        return results;
    }

    @Override
    public List<ArmoireArchivage> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<ArmoireArchivage> datas = super.findAll(); 
        List<ArmoireArchivage> results = new ArrayList<ArmoireArchivage>();        
        for(ArmoireArchivage data:datas){
            results.add(new ArmoireArchivage(data));
        }
        
        return results;
    }

    @Override
    public ArmoireArchivage find(String propertyName, Long entityID) {        
        //initialisaiton
        ArmoireArchivage data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ArmoireArchivage result = new ArmoireArchivage(data);       
//        for(FichierLie aas:data.getPiecesjointes()){
//            result.getPiecesjointes().add(new FichierLie(aas));
//        }       
        return result;
    }


}
