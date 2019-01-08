
package com.core.securites;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "UserAutorisationManager")
public class UserAutorisationManagerImpl
    extends AbstractGenericManager<UserAutorisation, Long>
    implements UserAutorisationManagerLocal, UserAutorisationManagerRemote
{

    @EJB(name = "UserAutorisationDAO")
    protected UserAutorisationDAOLocal dao;

    public UserAutorisationManagerImpl() {
    }

    @Override
    public GenericDAO<UserAutorisation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<UserAutorisation> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<UserAutorisation> datas =  super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<UserAutorisation> result = new ArrayList<UserAutorisation>();
        for(UserAutorisation data:datas){
            result.add(new UserAutorisation(data));
        }
        return result;
    }

    @Override
    public UserAutorisation find(String propertyName, Long entityID) {
        UserAutorisation data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        UserAutorisation result = new UserAutorisation(data);
        return result;
    }
    
    

}
