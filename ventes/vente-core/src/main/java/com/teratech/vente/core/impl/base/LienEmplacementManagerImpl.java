
package com.teratech.vente.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.vente.core.ifaces.base.LienEmplacementManagerLocal;
import com.teratech.vente.core.ifaces.base.LienEmplacementManagerRemote;
import com.teratech.vente.dao.ifaces.base.LienEmplacementDAOLocal;
import com.teratech.vente.model.base.LienEmplacement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "LienEmplacementManager")
public class LienEmplacementManagerImpl
    extends AbstractGenericManager<LienEmplacement, Long>
    implements LienEmplacementManagerLocal, LienEmplacementManagerRemote
{

    @EJB(name = "LienEmplacementDAO")
    protected LienEmplacementDAOLocal dao;

    public LienEmplacementManagerImpl() {
    }

    @Override
    public GenericDAO<LienEmplacement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<LienEmplacement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<LienEmplacement> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<LienEmplacement> result = new ArrayList<LienEmplacement>();
        for(LienEmplacement lien:datas){
            result.add(new LienEmplacement(lien));
        }//end for(LienEmplacement lien:datas){
        return result;
    }

    @Override
    public LienEmplacement find(String propertyName, Long entityID) {
        LienEmplacement entity =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new LienEmplacement(entity);
    }

    @Override
    public LienEmplacement delete(Long id) {
        LienEmplacement entity = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new LienEmplacement(entity);
    }
    
    
}
