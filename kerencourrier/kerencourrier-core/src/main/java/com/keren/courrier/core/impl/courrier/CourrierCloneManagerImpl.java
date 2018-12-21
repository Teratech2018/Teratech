
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierCloneManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierCloneManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.ServiceDiffusion;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierCloneManager")
public class CourrierCloneManagerImpl
    extends AbstractGenericManager<CourrierClone, Long>
    implements CourrierCloneManagerLocal, CourrierCloneManagerRemote
{

    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal dao;

    public CourrierCloneManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierClone, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
     @Override
    public List<CourrierClone> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierClone> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierClone> results = new ArrayList<CourrierClone>();        
        for(CourrierClone courrier:datas){
            CourrierClone data = new CourrierClone(courrier);
            results.add(data);              
        }//end for(Courrier courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierClone> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierClone> datas = super.findAll(); 
        List<CourrierClone> results = new ArrayList<CourrierClone>();        
        for(CourrierClone data:datas){
            results.add(new CourrierClone(data));
        }
        
        return results;
    }

    @Override
    public CourrierClone find(String propertyName, Long entityID) {        
        //initialisaiton
        CourrierClone data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierClone result = new CourrierClone(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }
        return result;
    }

}
