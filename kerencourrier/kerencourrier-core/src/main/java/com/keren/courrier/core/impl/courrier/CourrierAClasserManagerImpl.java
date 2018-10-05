
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierAClasserManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierAClasserManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierAClasserDAOLocal;
import com.keren.courrier.model.courrier.CourrierAClasser;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierAClasserManager")
public class CourrierAClasserManagerImpl
    extends AbstractGenericManager<CourrierAClasser, Long>
    implements CourrierAClasserManagerLocal, CourrierAClasserManagerRemote
{

    @EJB(name = "CourrierAClasserDAO")
    protected CourrierAClasserDAOLocal dao;

    public CourrierAClasserManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierAClasser, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
      @Override
    public List<CourrierAClasser> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<CourrierAClasser> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<CourrierAClasser> results = new ArrayList<CourrierAClasser>();        
        for(CourrierAClasser courrier:datas){
            CourrierAClasser data = new CourrierAClasser(courrier);
            results.add(data);              
        }//end for(CourrierAClasser courrier:datas){        
        return results;
    }

    @Override
    public List<CourrierAClasser> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<CourrierAClasser> datas = super.findAll(); 
        List<CourrierAClasser> results = new ArrayList<CourrierAClasser>();        
        for(CourrierAClasser data:datas){
            results.add(new CourrierAClasser(data));
        }
        
        return results;
    }

    @Override
    public CourrierAClasser find(String propertyName, Long entityID) {        
        //initialisaiton
        CourrierAClasser data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierAClasser result = new CourrierAClasser(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }       
        for (UtilisateurCourrier dest : data.getDestinataire()) {
			result.getDestinataire().add(new UtilisateurCourrier(dest));
		}
        return result;
    }


}
