
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.CompteurManagerLocal;
import com.teratech.gmao.core.ifaces.base.CompteurManagerRemote;
import com.teratech.gmao.dao.ifaces.base.CompteurDAOLocal;
import com.teratech.gmao.model.base.Compteur;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CompteurManager")
public class CompteurManagerImpl
    extends AbstractGenericManager<Compteur, Long>
    implements CompteurManagerLocal, CompteurManagerRemote
{

    @EJB(name = "CompteurDAO")
    protected CompteurDAOLocal dao;

    public CompteurManagerImpl() {
    }

    @Override
    public GenericDAO<Compteur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Compteur> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Compteur> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Compteur> results = new ArrayList<Compteur>();
        for(Compteur data:datas){
            results.add(new Compteur(data));
        }
        return results;
    }

    @Override
    public List<Compteur> findAll() {
        List<Compteur> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Compteur> results = new ArrayList<Compteur>();
        for(Compteur data:datas){
            results.add(new Compteur(data));
        }
        return results;
    }

    @Override
    public Compteur find(String propertyName, Long entityID) {
        Compteur data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new Compteur(data);
    }

    @Override
    public Compteur delete(Long id) {
        Compteur data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Compteur(data);
    }
    
    

}
