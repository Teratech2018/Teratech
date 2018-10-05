
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
import com.keren.courrier.core.ifaces.archivage.BoiteArchivageManagerLocal;
import com.keren.courrier.core.ifaces.archivage.BoiteArchivageManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.BoiteArchivageDAOLocal;
import com.keren.courrier.model.archivage.ArchiveDocument;
import com.keren.courrier.model.archivage.BoiteArchivage;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BoiteArchivageManager")
public class BoiteArchivageManagerImpl
    extends AbstractGenericManager<BoiteArchivage, Long>
    implements BoiteArchivageManagerLocal, BoiteArchivageManagerRemote
{

    @EJB(name = "BoiteArchivageDAO")
    protected BoiteArchivageDAOLocal dao;

    public BoiteArchivageManagerImpl() {
    }

    @Override
    public GenericDAO<BoiteArchivage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<BoiteArchivage> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<BoiteArchivage> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<BoiteArchivage> results = new ArrayList<BoiteArchivage>();        
        for(BoiteArchivage courrier:datas){
        	BoiteArchivage data = new BoiteArchivage(courrier);
            results.add(data);              
        }//end for(ArchiveDocument courrier:datas){        
        return results;
    }

    @Override
    public List<BoiteArchivage> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<BoiteArchivage> datas = super.findAll(); 
        List<BoiteArchivage> results = new ArrayList<BoiteArchivage>();        
        for(BoiteArchivage data:datas){
            results.add(new BoiteArchivage(data));
        }
        
        return results;
    }

    @Override
    public BoiteArchivage find(String propertyName, Long entityID) {        
        //initialisaiton
    	BoiteArchivage data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
    	BoiteArchivage result = new BoiteArchivage(data);            
        return result;
    }
    
    

}
