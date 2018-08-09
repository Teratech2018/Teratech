
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierADeclasserManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierADeclasserManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierADeclasserDAOLocal;
import com.keren.courrier.model.courrier.CourrierADeclasser;
import com.keren.courrier.model.courrier.CourrierADeclasser;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierADeclasserManager")
public class CourrierADeclasserManagerImpl
    extends AbstractGenericManager<CourrierADeclasser, Long>
    implements CourrierADeclasserManagerLocal, CourrierADeclasserManagerRemote
{

    @EJB(name = "CourrierADeclasserDAO")
    protected CourrierADeclasserDAOLocal dao;

    public CourrierADeclasserManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierADeclasser, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    
      @Override
    public List<CourrierADeclasser> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierADeclasser> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierADeclasser> results = new ArrayList<CourrierADeclasser>();        
        for(CourrierADeclasser courrier:datas){
            CourrierADeclasser data = new CourrierADeclasser(courrier);
            results.add(data);              
        }//end for(CourrierADeclasser courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierADeclasser> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierADeclasser> datas = super.findAll(); 
        List<CourrierADeclasser> results = new ArrayList<CourrierADeclasser>();        
        for(CourrierADeclasser data:datas){
            results.add(new CourrierADeclasser(data));
        }
        
        return results;
    }

    @Override
    public CourrierADeclasser find(String propertyName, Long entityID) {        
        //initialisaiton
        CourrierADeclasser data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierADeclasser result = new CourrierADeclasser(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }       
        return result;
    }


}
