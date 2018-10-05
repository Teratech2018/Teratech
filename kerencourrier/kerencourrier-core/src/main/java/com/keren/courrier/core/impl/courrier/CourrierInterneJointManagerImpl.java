
package com.keren.courrier.core.impl.courrier;

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
import com.keren.courrier.core.ifaces.courrier.CourrierInterneJointManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierInterneJointManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneJointDAOLocal;
import com.keren.courrier.model.courrier.CourrierAAnnote;
import com.keren.courrier.model.courrier.CourrierInterneJoint;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CourrierInterneJointManager")
public class CourrierInterneJointManagerImpl
    extends AbstractGenericManager<CourrierInterneJoint, Long>
    implements CourrierInterneJointManagerLocal, CourrierInterneJointManagerRemote
{

    @EJB(name = "CourrierInterneJointDAO")
    protected CourrierInterneJointDAOLocal dao;

    public CourrierInterneJointManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierInterneJoint, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<CourrierInterneJoint> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierInterneJoint> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierInterneJoint> results = new ArrayList<CourrierInterneJoint>();        
        for(CourrierInterneJoint courrier:datas){
        	CourrierInterneJoint data = new CourrierInterneJoint(courrier);
            results.add(data);              
        }//end for(CourrierAAnnote courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierInterneJoint> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierInterneJoint> datas = super.findAll(); 
        List<CourrierInterneJoint> results = new ArrayList<CourrierInterneJoint>();        
        for(CourrierInterneJoint data:datas){
            results.add(new CourrierInterneJoint(data));
        }
        
        return results;
    }

    @Override
    public CourrierInterneJoint find(String propertyName, Long entityID) {        
        //initialisaiton
    	CourrierInterneJoint data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
    	CourrierInterneJoint result = new CourrierInterneJoint(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }       
        return result;
    }


}
