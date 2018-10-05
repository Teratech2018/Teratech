
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
import com.keren.courrier.core.ifaces.archivage.ArchiveDocumentManagerLocal;
import com.keren.courrier.core.ifaces.archivage.ArchiveDocumentManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.ArchiveDocumentDAOLocal;
import com.keren.courrier.model.archivage.ArchiveDocument;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ArchiveDocumentManager")
public class ArchiveDocumentManagerImpl
    extends AbstractGenericManager<ArchiveDocument, Long>
    implements ArchiveDocumentManagerLocal, ArchiveDocumentManagerRemote
{

    @EJB(name = "ArchiveDocumentDAO")
    protected ArchiveDocumentDAOLocal dao;

    public ArchiveDocumentManagerImpl() {
    }

    @Override
    public GenericDAO<ArchiveDocument, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<ArchiveDocument> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ArchiveDocument> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ArchiveDocument> results = new ArrayList<ArchiveDocument>();        
        for(ArchiveDocument courrier:datas){
            ArchiveDocument data = new ArchiveDocument(courrier);
            results.add(data);              
        }//end for(ArchiveDocument courrier:datas){        
        return results;
    }

    @Override
    public List<ArchiveDocument> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<ArchiveDocument> datas = super.findAll(); 
        List<ArchiveDocument> results = new ArrayList<ArchiveDocument>();        
        for(ArchiveDocument data:datas){
            results.add(new ArchiveDocument(data));
        }
        
        return results;
    }

    @Override
    public ArchiveDocument find(String propertyName, Long entityID) {        
        //initialisaiton
        ArchiveDocument data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ArchiveDocument result = new ArchiveDocument(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }       
        return result;
    }
    
    

}
