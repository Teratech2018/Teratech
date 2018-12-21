
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierAAnnoteManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierAAnnoteManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierAAnnoteDAOLocal;
import com.keren.courrier.model.courrier.CourrierAAnnote;
import com.keren.courrier.model.courrier.CourrierAQuote;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierAAnnoteManager")
public class CourrierAAnnoteManagerImpl
    extends AbstractGenericManager<CourrierAAnnote, Long>
    implements CourrierAAnnoteManagerLocal, CourrierAAnnoteManagerRemote
{

    @EJB(name = "CourrierAAnnoteDAO")
    protected CourrierAAnnoteDAOLocal dao;

    public CourrierAAnnoteManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierAAnnote, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
      @Override
    public List<CourrierAAnnote> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierAAnnote> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierAAnnote> results = new ArrayList<CourrierAAnnote>();        
        for(CourrierAAnnote courrier:datas){
            CourrierAAnnote data = new CourrierAAnnote(courrier);
            results.add(data);              
        }//end for(CourrierAAnnote courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierAAnnote> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierAAnnote> datas = super.findAll(); 
        List<CourrierAAnnote> results = new ArrayList<CourrierAAnnote>();        
        for(CourrierAAnnote data:datas){
            results.add(new CourrierAAnnote(data));
        }
        
        return results;
    }

    @Override
    public CourrierAAnnote find(String propertyName, Long entityID) {        
        //initialisaiton
        CourrierAAnnote data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierAAnnote result = new CourrierAAnnote(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }       
        return result;
    }


}
