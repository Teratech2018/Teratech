
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.menus.MenuAction;
import com.core.menus.MenuModule;
import com.core.securites.Groupe;
import com.core.securites.GroupeDetail;
import com.keren.courrier.core.ifaces.referentiel.UserManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.UserManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.UserDAOLocal;
import com.keren.courrier.model.referentiel.User;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "UserManager")
public class UserManagerImpl
    extends AbstractGenericManager<User, Long>
    implements UserManagerLocal, UserManagerRemote
{

    @EJB(name = "UserDAO")
    protected UserDAOLocal dao;

    public UserManagerImpl() {
    }

    @Override
    public GenericDAO<User, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<User> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<User> datas =  super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<User> results = new ArrayList<User>();
        for(User data:datas){
            results.add(new User(data));
        }
        return results;
    }

    @Override
    public List<User> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<User> datas = super.findAll(); 
        List<User> results = new ArrayList<User>();
        for(User data:datas){
            results.add(new User(data));
        }
        return results;
    }

    @Override
    public User find(String propertyName, Long entityID) {
        User data =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        User result = new User(data);
        for(Groupe groupe : data.getAutorisations()){
            Groupe grp = new Groupe(groupe);
            grp.setModule(new MenuModule(groupe.getModule()));
            for(GroupeDetail detail : groupe.getDroits()){
                GroupeDetail gdt = new GroupeDetail(detail);
                gdt.setMenuAction(new MenuAction(detail.getMenuAction()));
                grp.getDroits().add(gdt);
            }//end for(GroupeDetail detail : groupe.getDroits()){
            result.getAutorisations().add(grp);
        }//end for(Groupe groupe : data.getAutorisations()){
        return result;
    }

    @Override
    public User delete(Long id) {
        User data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new User(data);
    }
    
    

}
