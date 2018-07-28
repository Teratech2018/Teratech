
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.IntervenantManagerLocal;
import com.teratech.gmao.core.ifaces.base.IntervenantManagerRemote;
import com.teratech.gmao.dao.ifaces.base.IntervenantDAOLocal;
import com.teratech.gmao.model.base.Intervenant;
import com.teratech.gmao.model.base.Qualification;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "IntervenantManager")
public class IntervenantManagerImpl
    extends AbstractGenericManager<Intervenant, Long>
    implements IntervenantManagerLocal, IntervenantManagerRemote
{

    @EJB(name = "IntervenantDAO")
    protected IntervenantDAOLocal dao;

    public IntervenantManagerImpl() {
    }

    @Override
    public GenericDAO<Intervenant, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Intervenant> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Intervenant> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Intervenant> results = new ArrayList<Intervenant>();
        for(Intervenant data : datas){
            results.add(new Intervenant(data));
        }
        return results;
    }

    @Override
    public List<Intervenant> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<Intervenant> datas =  super.findAll(); 
        List<Intervenant> results = new ArrayList<Intervenant>();
        for(Intervenant data : datas){
            results.add(new Intervenant(data));
        }
        return results;
    }

    @Override
    public Intervenant find(String propertyName, Long entityID) {
        Intervenant data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Intervenant result = new Intervenant(data);
        for(Qualification qualif:data.getQualifications()){
            result.getQualifications().add(new Qualification(qualif));
        }
        return result;
    }

    @Override
    public Intervenant delete(Long id) {
        return super.delete(id); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
