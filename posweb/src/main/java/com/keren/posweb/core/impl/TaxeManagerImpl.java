
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.TaxeManagerLocal;
import com.keren.posweb.core.ifaces.TaxeManagerRemote;
import com.keren.posweb.dao.ifaces.TaxeDAOLocal;
import com.keren.posweb.model.Compte;
import com.keren.posweb.model.Taxe;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TaxeManager")
public class TaxeManagerImpl
    extends AbstractGenericManager<Taxe, Long>
    implements TaxeManagerLocal, TaxeManagerRemote
{

    @EJB(name = "TaxeDAO")
    protected TaxeDAOLocal dao;

    public TaxeManagerImpl() {
    }

    @Override
    public GenericDAO<Taxe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Taxe> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Taxe> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Taxe> results = new ArrayList<Taxe>();
        for(Taxe data:datas){
            results.add(new Taxe(data));
        }
        return results;
    }

    @Override
    public List<Taxe> findAll() {
        List<Taxe> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Taxe> results = new ArrayList<Taxe>();
        for(Taxe data:datas){
            results.add(new Taxe(data));
        }
        return results;
    }

    @Override
    public Taxe find(String propertyName, Long entityID) {
        Taxe data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Taxe result = new Taxe(data);
        for(Compte compte:data.getComptes()){
            result.getComptes().add(new Compte(compte));
        }
        return  result;
    }

    @Override
    public Taxe delete(Long id) {
        Taxe data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Taxe(data);
    }
    
    

}
