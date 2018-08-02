
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierRecuManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierRecuManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierRecuDAOLocal;
import com.keren.courrier.model.courrier.CourrierRecu;
import com.keren.courrier.model.courrier.CourrierRecu;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierRecuManager")
public class CourrierRecuManagerImpl
    extends AbstractGenericManager<CourrierRecu, Long>
    implements CourrierRecuManagerLocal, CourrierRecuManagerRemote
{

    @EJB(name = "CourrierRecuDAO")
    protected CourrierRecuDAOLocal dao;

    public CourrierRecuManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierRecu, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
      @Override
    public List<CourrierRecu> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierRecu> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierRecu> results = new ArrayList<CourrierRecu>();        
        for(CourrierRecu courrier:datas){
            CourrierRecu data = new CourrierRecu(courrier);
            results.add(data);              
        }//end for(CourrierRecu courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierRecu> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierRecu> datas = super.findAll(); 
        List<CourrierRecu> results = new ArrayList<CourrierRecu>();        
        for(CourrierRecu data:datas){
            results.add(new CourrierRecu(data));
        }
        
        return results;
    }

    @Override
    public CourrierRecu find(String propertyName, Long entityID) {        
        //initialisaiton
        CourrierRecu data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierRecu result = new CourrierRecu(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }       
        return result;
    }


}
