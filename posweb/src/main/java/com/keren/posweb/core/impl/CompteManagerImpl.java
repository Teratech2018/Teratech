
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.CompteManagerLocal;
import com.keren.posweb.core.ifaces.CompteManagerRemote;
import com.keren.posweb.dao.ifaces.CompteDAOLocal;
import com.keren.posweb.model.Compte;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CompteManager")
public class CompteManagerImpl
    extends AbstractGenericManager<Compte, Long>
    implements CompteManagerLocal, CompteManagerRemote
{

    @EJB(name = "CompteDAO")
    protected CompteDAOLocal dao;

    public CompteManagerImpl() {
    }

    @Override
    public GenericDAO<Compte, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Compte> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Compte> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Compte> results = new ArrayList<Compte>();
        for(Compte data:datas){
            results.add(new Compte(data));
        }
        return results;
    }

    @Override
    public List<Compte> findAll() {
        List<Compte> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Compte> results = new ArrayList<Compte>();
        for(Compte data:datas){
            results.add(new Compte(data));
        }
        return results;
    }

    @Override
    public Compte find(String propertyName, Long entityID) {
        Compte data =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new Compte(data);
    }

    @Override
    public Compte delete(Long id) {
        Compte data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Compte(data);
    }
    
    

}
