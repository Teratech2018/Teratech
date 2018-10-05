
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
import com.keren.courrier.core.ifaces.archivage.CadreClassementManagerLocal;
import com.keren.courrier.core.ifaces.archivage.CadreClassementManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.CadreClassementDAOLocal;
import com.keren.courrier.model.archivage.CadreClassement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CadreClassementManager")
public class CadreClassementManagerImpl
    extends AbstractGenericManager<CadreClassement, Long>
    implements CadreClassementManagerLocal, CadreClassementManagerRemote
{

    @EJB(name = "CadreClassementDAO")
    protected CadreClassementDAOLocal dao;

    public CadreClassementManagerImpl() {
    }

    @Override
    public GenericDAO<CadreClassement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
    public List<CadreClassement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CadreClassement> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CadreClassement> results = new ArrayList<CadreClassement>();        
        for(CadreClassement courrier:datas){
            CadreClassement data = new CadreClassement(courrier);
            results.add(data);              
        }//end for(CadreClassement courrier:datas){        
        return results;
    }

    @Override
    public List<CadreClassement> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CadreClassement> datas = super.findAll(); 
        List<CadreClassement> results = new ArrayList<CadreClassement>();        
        for(CadreClassement data:datas){
            results.add(new CadreClassement(data));
        }
        
        return results;
    }

    @Override
    public CadreClassement find(String propertyName, Long entityID) {        
        //initialisaiton
        CadreClassement data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CadreClassement result = new CadreClassement(data);       
//        for(FichierLie aas:data.getPiecesjointes()){
//            result.getPiecesjointes().add(new FichierLie(aas));
//        }       
        return result;
    }


}
