
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
import com.keren.courrier.core.ifaces.archivage.ArchiveLiasseManagerLocal;
import com.keren.courrier.core.ifaces.archivage.ArchiveLiasseManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.ArchiveLiasseDAOLocal;
import com.keren.courrier.model.archivage.ArchiveLiasse;
import com.keren.courrier.model.archivage.LiasseDocumentTri;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ArchiveLiasseManager")
public class ArchiveLiasseManagerImpl
    extends AbstractGenericManager<ArchiveLiasse, Long>
    implements ArchiveLiasseManagerLocal, ArchiveLiasseManagerRemote
{

    @EJB(name = "ArchiveLiasseDAO")
    protected ArchiveLiasseDAOLocal dao;

    public ArchiveLiasseManagerImpl() {
    }

    @Override
    public GenericDAO<ArchiveLiasse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<ArchiveLiasse> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ArchiveLiasse> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ArchiveLiasse> results = new ArrayList<ArchiveLiasse>();        
        for(ArchiveLiasse courrier:datas){
            ArchiveLiasse data = new ArchiveLiasse(courrier);
            results.add(data);              
        }//end for(ArchiveLiasse courrier:datas){        
        return results;
    }

    @Override
    public List<ArchiveLiasse> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<ArchiveLiasse> datas = super.findAll(); 
        List<ArchiveLiasse> results = new ArrayList<ArchiveLiasse>();        
        for(ArchiveLiasse data:datas){
            results.add(new ArchiveLiasse(data));
        }
        
        return results;
    }

    @Override
    public ArchiveLiasse find(String propertyName, Long entityID) {        
        //initialisaiton
        ArchiveLiasse data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ArchiveLiasse result = new ArchiveLiasse(data);       
        for(LiasseDocumentTri aas:data.getLiassedocuments()){
            result.getLiassedocuments().add(new LiasseDocumentTri(aas));
        }       
        return result;
    }
    
    
}
