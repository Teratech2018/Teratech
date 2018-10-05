
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
import com.keren.courrier.core.ifaces.archivage.LocalArchivageManagerLocal;
import com.keren.courrier.core.ifaces.archivage.LocalArchivageManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.LocalArchivageDAOLocal;
import com.keren.courrier.model.archivage.LocalArchivage;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "LocalArchivageManager")
public class LocalArchivageManagerImpl
    extends AbstractGenericManager<LocalArchivage, Long>
    implements LocalArchivageManagerLocal, LocalArchivageManagerRemote
{

    @EJB(name = "LocalArchivageDAO")
    protected LocalArchivageDAOLocal dao;

    public LocalArchivageManagerImpl() {
    }

    @Override
    public GenericDAO<LocalArchivage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
    public List<LocalArchivage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<LocalArchivage> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<LocalArchivage> results = new ArrayList<LocalArchivage>();        
        for(LocalArchivage courrier:datas){
            LocalArchivage data = new LocalArchivage(courrier);
            results.add(data);              
        }//end for(LocalArchivage courrier:datas){        
        return results;
    }

    @Override
    public List<LocalArchivage> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<LocalArchivage> datas = super.findAll(); 
        List<LocalArchivage> results = new ArrayList<LocalArchivage>();        
        for(LocalArchivage data:datas){
            results.add(new LocalArchivage(data));
        }
        
        return results;
    }

    @Override
    public LocalArchivage find(String propertyName, Long entityID) {        
        //initialisaiton
        LocalArchivage data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        LocalArchivage result = new LocalArchivage(data);       
//        for(FichierLie aas:data.getPiecesjointes()){
//            result.getPiecesjointes().add(new FichierLie(aas));
//        }       
        return result;
    }


}
