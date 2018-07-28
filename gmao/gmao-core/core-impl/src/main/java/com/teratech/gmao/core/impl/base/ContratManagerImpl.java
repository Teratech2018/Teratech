
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.ContratManagerLocal;
import com.teratech.gmao.core.ifaces.base.ContratManagerRemote;
import com.teratech.gmao.dao.ifaces.base.ContratDAOLocal;
import com.teratech.gmao.model.base.Contrat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ContratManager")
public class ContratManagerImpl
    extends AbstractGenericManager<Contrat, Long>
    implements ContratManagerLocal, ContratManagerRemote
{

    @EJB(name = "ContratDAO")
    protected ContratDAOLocal dao;

    public ContratManagerImpl() {
    }

    @Override
    public GenericDAO<Contrat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Contrat> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Contrat> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Contrat> results = new ArrayList<Contrat>();
        for(Contrat data:datas){
            results.add(new Contrat(data));
        }
        return results;
    }

    @Override
    public List<Contrat> findAll() {
        List<Contrat> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Contrat> results = new ArrayList<Contrat>();
        for(Contrat data:datas){
            results.add(new Contrat(data));
        }
        return results;
    }

    @Override
    public Contrat find(String propertyName, Long entityID) {
        Contrat data =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Contrat result = new Contrat(data);
        return result;
    }

    @Override
    public Contrat delete(Long id) {
        Contrat data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Contrat(data);
    }

    
}
