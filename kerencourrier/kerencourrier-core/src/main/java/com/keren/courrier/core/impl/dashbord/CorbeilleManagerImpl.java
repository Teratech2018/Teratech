
package com.keren.courrier.core.impl.dashbord;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.dashbord.CorbeilleManagerLocal;
import com.keren.courrier.core.ifaces.dashbord.CorbeilleManagerRemote;
import com.keren.courrier.dao.ifaces.dashbord.CorbeilleDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.UserDAOLocal;
import com.keren.courrier.model.dashbord.Corbeille;
import com.keren.courrier.model.dashbord.RegleCorbeille;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CorbeilleManager")
public class CorbeilleManagerImpl
    extends AbstractGenericManager<Corbeille, Long>
    implements CorbeilleManagerLocal, CorbeilleManagerRemote
{

    @EJB(name = "CorbeilleDAO")
    protected CorbeilleDAOLocal dao;
    
    @EJB(name = "UserDAO")
    protected UserDAOLocal userdao;

    public CorbeilleManagerImpl() {
    }

    @Override
    public GenericDAO<Corbeille, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Corbeille> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Corbeille> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Corbeille> results = new ArrayList<Corbeille>();
        for(Corbeille data:datas){
            results.add(new Corbeille(data));
        }
        return results;
    }

    @Override
    public List<Corbeille> findAll() {
        List<Corbeille> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Corbeille> results = new ArrayList<Corbeille>();
        for(Corbeille data:datas){
            results.add(new Corbeille(data));
        }
        return results;
    }

    @Override
    public Corbeille find(String propertyName, Long entityID) {
         //To change body of generated methods, choose Tools | Templates.
        Corbeille data =  super.find(propertyName, entityID);
        Corbeille result = new Corbeille(data);
        for(RegleCorbeille rule:data.getRules()){
            result.getRules().add(rule);
        }
        return result;
    }

    @Override
    public Corbeille delete(Long id) {
        Corbeille data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Corbeille(data);
    }   
    

}
