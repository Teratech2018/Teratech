
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.curative.ActiviteHBTManagerLocal;
import com.teratech.gmao.core.ifaces.curative.ActiviteHBTManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.ActiviteHBTDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.curative.ActiviteHBT;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ActiviteHBTManager")
public class ActiviteHBTManagerImpl
    extends AbstractGenericManager<ActiviteHBT, Long>
    implements ActiviteHBTManagerLocal, ActiviteHBTManagerRemote
{

    @EJB(name = "ActiviteHBTDAO")
    protected ActiviteHBTDAOLocal dao;

    public ActiviteHBTManagerImpl() {
    }

    @Override
    public GenericDAO<ActiviteHBT, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<ActiviteHBT> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
         //To change body of generated methods, choose Tools | Templates.
       List<ActiviteHBT> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
       List<ActiviteHBT> results = new ArrayList<ActiviteHBT>();
       for(ActiviteHBT data:datas){
           results.add(new ActiviteHBT(data));
       }
       return results;
    }

    @Override
    public List<ActiviteHBT> findAll() {
        List<ActiviteHBT> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
       List<ActiviteHBT> results = new ArrayList<ActiviteHBT>();
       for(ActiviteHBT data:datas){
           results.add(new ActiviteHBT(data));
       }
       return results;
    }

    @Override
    public ActiviteHBT find(String propertyName, Long entityID) {
        ActiviteHBT data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ActiviteHBT result = new ActiviteHBT(data);
        for(FichierLie fichier:data.getPiecesjointes()){
            result.getPiecesjointes().add(fichier);
        }
        return result;
    }

    @Override
    public ActiviteHBT delete(Long id) {
        ActiviteHBT data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new ActiviteHBT(data);
    }
    
    

}
