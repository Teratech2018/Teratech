
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
import com.keren.courrier.core.ifaces.archivage.TiroirArchivageManagerLocal;
import com.keren.courrier.core.ifaces.archivage.TiroirArchivageManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.TiroirArchivageDAOLocal;
import com.keren.courrier.model.archivage.TiroirArchivage;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "TiroirArchivageManager")
public class TiroirArchivageManagerImpl
    extends AbstractGenericManager<TiroirArchivage, Long>
    implements TiroirArchivageManagerLocal, TiroirArchivageManagerRemote
{

    @EJB(name = "TiroirArchivageDAO")
    protected TiroirArchivageDAOLocal dao;

    public TiroirArchivageManagerImpl() {
    }

    @Override
    public GenericDAO<TiroirArchivage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
    public List<TiroirArchivage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<TiroirArchivage> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<TiroirArchivage> results = new ArrayList<TiroirArchivage>();        
        for(TiroirArchivage courrier:datas){
            TiroirArchivage data = new TiroirArchivage(courrier);
            results.add(data);              
        }//end for(TiroirArchivage courrier:datas){        
        return results;
    }

    @Override
    public List<TiroirArchivage> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<TiroirArchivage> datas = super.findAll(); 
        List<TiroirArchivage> results = new ArrayList<TiroirArchivage>();        
        for(TiroirArchivage data:datas){
            results.add(new TiroirArchivage(data));
        }
        
        return results;
    }

    @Override
    public TiroirArchivage find(String propertyName, Long entityID) {        
        //initialisaiton
        TiroirArchivage data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        TiroirArchivage result = new TiroirArchivage(data);       
//        for(FichierLie aas:data.getPiecesjointes()){
//            result.getPiecesjointes().add(new FichierLie(aas));
//        }       
        return result;
    }


}
