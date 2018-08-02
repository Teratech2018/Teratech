
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.SecteurManagerLocal;
import com.teratech.gmao.core.ifaces.base.SecteurManagerRemote;
import com.teratech.gmao.dao.ifaces.base.SecteurDAOLocal;
import com.teratech.gmao.model.base.Secteur;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "SecteurManager")
public class SecteurManagerImpl
    extends AbstractGenericManager<Secteur, Long>
    implements SecteurManagerLocal, SecteurManagerRemote
{

    @EJB(name = "SecteurDAO")
    protected SecteurDAOLocal dao;

    public SecteurManagerImpl() {
    }

    @Override
    public GenericDAO<Secteur, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Secteur> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Secteur> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Secteur> results = new ArrayList<Secteur>();
        for(Secteur data:datas){
            results.add(new Secteur(data));
        }
        return results;
    }

    @Override
    public List<Secteur> findAll() {
        List<Secteur> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Secteur> results = new ArrayList<Secteur>();
        for(Secteur data:datas){
            results.add(new Secteur(data));
        }
        return results;
    }

    @Override
    public Secteur find(String propertyName, Long entityID) {
        Secteur data =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new Secteur(data);
    }

    @Override
    public Secteur delete(Long id) {
        Secteur data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Secteur(data);
    }
    
    

}
