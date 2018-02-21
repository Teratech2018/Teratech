
package com.teratech.stock.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.operations.TransfertManagerLocal;
import com.teratech.stock.core.ifaces.operations.TransfertManagerRemote;
import com.teratech.stock.dao.ifaces.operations.TransfertDAOLocal;
import com.teratech.stock.model.operations.LigneDocumentStock;
import com.teratech.stock.model.operations.Transfert;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "TransfertManager")
public class TransfertManagerImpl
    extends AbstractGenericManager<Transfert, Long>
    implements TransfertManagerLocal, TransfertManagerRemote
{

    @EJB(name = "TransfertDAO")
    protected TransfertDAOLocal dao;

    public TransfertManagerImpl() {
    }

    @Override
    public GenericDAO<Transfert, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Transfert> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Transfert> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Transfert> result = new ArrayList<Transfert>();
        for(Transfert tra:datas){
            result.add(new Transfert(tra));
        }
        return result;
    }

    @Override
    public List<Transfert> findAll() {
        List<Transfert> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Transfert> result = new ArrayList<Transfert>();
        for(Transfert tra:datas){
            result.add(new Transfert(tra));
        }
        return result;
    }

    @Override
    public Transfert find(String propertyName, Long entityID) {
        Transfert data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Transfert result = new Transfert(data);
        for(LigneDocumentStock lign:data.getLignes()){
            result.getLignes().add(new LigneDocumentStock(lign));
        }
        return result;
    }

    @Override
    public Transfert delete(Long id) {
        Transfert data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Transfert(data);
    }
    
    

}
