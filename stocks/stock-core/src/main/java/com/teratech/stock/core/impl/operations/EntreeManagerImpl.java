
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.EntreeManagerLocal;
import com.teratech.stock.core.ifaces.operations.EntreeManagerRemote;
import com.teratech.stock.dao.ifaces.operations.EntreeDAOLocal;
import com.teratech.stock.model.operations.Entree;
import com.teratech.stock.model.operations.LigneDocumentStock;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "EntreeManager")
public class EntreeManagerImpl
    extends AbstractGenericManager<Entree, Long>
    implements EntreeManagerLocal, EntreeManagerRemote
{

    @EJB(name = "EntreeDAO")
    protected EntreeDAOLocal dao;

    public EntreeManagerImpl() {
    }

    @Override
    public GenericDAO<Entree, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Entree> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Entree> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Entree> result = new ArrayList<Entree>();
        for(Entree en:datas){
            result.add(new Entree(en));
        }
        return result ;
    }

    @Override
    public List<Entree> findAll() {        
        List<Entree> datas = super.findAll();//To change body of generated methods, choose Tools | Templates.
        List<Entree> result = new ArrayList<Entree>();
        for(Entree en:datas){
            result.add(new Entree(en));
        }
        return result ;
    }

    @Override
    public Entree find(String propertyName, Long entityID) {
        Entree data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Entree result = new Entree(data);
        for(LigneDocumentStock lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentStock(lign));
        }
        return result;
    }

    @Override
    public Entree delete(Long id) {
        Entree data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Entree(data);
    }
    
    

}
