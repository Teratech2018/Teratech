
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.UtilisateurCourrierManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.UtilisateurCourrierDAOLocal;
import com.keren.courrier.model.referentiel.User;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "UtilisateurCourrierManager")
public class UtilisateurCourrierManagerImpl
    extends AbstractGenericManager<UtilisateurCourrier, Long>
    implements UtilisateurCourrierManagerLocal, UtilisateurCourrierManagerRemote
{

    @EJB(name = "UtilisateurCourrierDAO")
    protected UtilisateurCourrierDAOLocal dao;

    public UtilisateurCourrierManagerImpl() {
    }

    @Override
    public GenericDAO<UtilisateurCourrier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<UtilisateurCourrier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("compte", null);container.addNotNull("service", null);
        predicats.addAll(container.getPredicats());
        List<UtilisateurCourrier> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
       //To change body of generated methods, choose Tools | Templates.
        List<UtilisateurCourrier> results = new ArrayList<UtilisateurCourrier>();
        for(UtilisateurCourrier data:datas){
            User user = new User(data.getCompte());
            data.setCompte(user);
            results.add(new UtilisateurCourrier(data));
        }
        return results;
    }

    @Override
    public List<UtilisateurCourrier> findAll() {
        List<UtilisateurCourrier> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<UtilisateurCourrier> results = new ArrayList<UtilisateurCourrier>();
        for(UtilisateurCourrier data:datas){
        	System.out.println("UtilisateurCourrierManagerImpl.findAll() utilisateur"+data.getId());
        	UtilisateurCourrier userc= dao.findByPrimaryKey("id", data.getId());
        	User user = new User(userc.getCompte());
        	data.setCompte(user);
            results.add(new UtilisateurCourrier(data));
        }
        return results;
    }

    @Override
    public UtilisateurCourrier find(String propertyName, Long entityID) {
        UtilisateurCourrier data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        UtilisateurCourrier entity = new UtilisateurCourrier(data);
        User user = new User(data.getCompte());
        entity.setCompte(user);
        return entity;
    }

    @Override
    public UtilisateurCourrier delete(Long id) {
        UtilisateurCourrier data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new UtilisateurCourrier(data);
    }

    @Override
    public void processBeforeSave(UtilisateurCourrier entity) {
        entity.setNature("3");
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Long count(List<Predicat> predicats) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("compte", null);container.addNotNull("service", null);
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public UtilisateurCourrier getUserByAcompte(Long userid) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("compte.id", userid);
        List<UtilisateurCourrier> users = filter(container.getPredicats(), null, null, 0, -1);
        return users.get(0);
        
    }
    
    
    

}
