
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.CentreFraisManagerLocal;
import com.teratech.gmao.core.ifaces.base.CentreFraisManagerRemote;
import com.teratech.gmao.dao.ifaces.base.CentreFraisDAOLocal;
import com.teratech.gmao.model.base.CentreFrais;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CentreFraisManager")
public class CentreFraisManagerImpl
    extends AbstractGenericManager<CentreFrais, Long>
    implements CentreFraisManagerLocal, CentreFraisManagerRemote
{

    @EJB(name = "CentreFraisDAO")
    protected CentreFraisDAOLocal dao;

    public CentreFraisManagerImpl() {
    }

    @Override
    public GenericDAO<CentreFrais, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<CentreFrais> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<CentreFrais> datas =  super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<CentreFrais> results = new ArrayList<CentreFrais>();
        for(CentreFrais data:datas){
            results.add(new CentreFrais(data));
        }
        return results;
    }

    @Override
    public List<CentreFrais> findAll() {
        List<CentreFrais> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<CentreFrais> results = new ArrayList<CentreFrais>();
        for(CentreFrais data:datas){
            results.add(new CentreFrais(data));
        }
        return results;
    }

    @Override
    public CentreFrais find(String propertyName, Long entityID) {
        CentreFrais data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new CentreFrais(data);
    }

    @Override
    public CentreFrais delete(Long id) {
        CentreFrais data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new CentreFrais(data);
    }
    
    

}
