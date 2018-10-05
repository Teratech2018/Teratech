
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
import com.keren.courrier.core.ifaces.courrier.CourrierAArchiverManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierAArchiverManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierAArchiverDAOLocal;
import com.keren.courrier.model.courrier.CourrierAArchiver;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CourrierAArchiverManager")
public class CourrierAArchiverManagerImpl
    extends AbstractGenericManager<CourrierAArchiver, Long>
    implements CourrierAArchiverManagerLocal, CourrierAArchiverManagerRemote
{

    @EJB(name = "CourrierAArchiverDAO")
    protected CourrierAArchiverDAOLocal dao;

    public CourrierAArchiverManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierAArchiver, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    

    @Override
  public List<CourrierAArchiver> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
      List<CourrierAArchiver> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
      List<CourrierAArchiver> results = new ArrayList<CourrierAArchiver>();        
      for(CourrierAArchiver courrier:datas){
          CourrierAArchiver data = new CourrierAArchiver(courrier);
          results.add(data);              
      }//end for(CourrierAArchiver courrier:datas){        
      return results;
  }

  @Override
  public List<CourrierAArchiver> findAll() {
      
      //To change body of generated methods, choose Tools | Templates.
      List<CourrierAArchiver> datas = super.findAll(); 
      List<CourrierAArchiver> results = new ArrayList<CourrierAArchiver>();        
      for(CourrierAArchiver data:datas){
          results.add(new CourrierAArchiver(data));
      }
      
      return results;
  }

  @Override
  public CourrierAArchiver find(String propertyName, Long entityID) {        
      //initialisaiton
      CourrierAArchiver data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
      CourrierAArchiver result = new CourrierAArchiver(data);       
      for(FichierLie aas:data.getPiecesjointes()){
          result.getPiecesjointes().add(new FichierLie(aas));
      }       
      return result;
  }

}
