
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierARelancerManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierARelancerManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierARelancerDAOLocal;
import com.keren.courrier.model.courrier.CourrierARelancer;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierARelancerManager")
public class CourrierARelancerManagerImpl
    extends AbstractGenericManager<CourrierARelancer, Long>
    implements CourrierARelancerManagerLocal, CourrierARelancerManagerRemote
{

    @EJB(name = "CourrierARelancerDAO")
    protected CourrierARelancerDAOLocal dao;

    public CourrierARelancerManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierARelancer, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
      @Override
    public List<CourrierARelancer> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierARelancer> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierARelancer> results = new ArrayList<CourrierARelancer>();        
        
        
        for(CourrierARelancer courrier:datas){
            CourrierARelancer data = new CourrierARelancer(courrier);
            results.add(data);              
        }//end for(CourrierARelancer courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierARelancer> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierARelancer> datas = super.findAll(); 
        List<CourrierARelancer> results = new ArrayList<CourrierARelancer>();        
        for(CourrierARelancer data:datas){
            results.add(new CourrierARelancer(data));
        }
        
        return results;
    }

    @Override
    public CourrierARelancer find(String propertyName, Long entityID) {        
        //initialisaiton
        CourrierARelancer data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierARelancer result = new CourrierARelancer(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }      
        for (UtilisateurCourrier dest : data.getDestinataire()) {
			result.getDestinataire().add(new UtilisateurCourrier(dest));
		}

        return result;
    }


}
