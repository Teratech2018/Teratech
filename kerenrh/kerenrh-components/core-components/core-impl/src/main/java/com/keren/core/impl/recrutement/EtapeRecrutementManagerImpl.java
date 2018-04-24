
package com.keren.core.impl.recrutement;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.recrutement.EtapeRecrutementManagerLocal;
import com.keren.core.ifaces.recrutement.EtapeRecrutementManagerRemote;
import com.keren.dao.ifaces.recrutement.EtapeRecrutementDAOLocal;
import com.keren.model.recrutement.EtapeRecrutement;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "EtapeRecrutementManager")
public class EtapeRecrutementManagerImpl
    extends AbstractGenericManager<EtapeRecrutement, Long>
    implements EtapeRecrutementManagerLocal, EtapeRecrutementManagerRemote
{

    @EJB(name = "EtapeRecrutementDAO")
    protected EtapeRecrutementDAOLocal dao;

    public EtapeRecrutementManagerImpl() {
    }

    @Override
    public GenericDAO<EtapeRecrutement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<EtapeRecrutement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<EtapeRecrutement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<EtapeRecrutement> results = new ArrayList<EtapeRecrutement>();
        for(EtapeRecrutement data:datas){
            results.add(new EtapeRecrutement(data));
        }
        return results;
    }

    @Override
    public List<EtapeRecrutement> findAll() {
        List<EtapeRecrutement> datas = super.findAll();
        List<EtapeRecrutement> results = new ArrayList<EtapeRecrutement>();

        for(EtapeRecrutement data:datas){
            results.add(new EtapeRecrutement(data));
        }
        return results;
    }

    @Override
    public EtapeRecrutement find(String propertyName, Long entityID) {
        EtapeRecrutement data = super.find(propertyName, entityID);
        EtapeRecrutement result = new EtapeRecrutement(data);

        return result;
    }

    @Override
    public void processBeforeSave(EtapeRecrutement entity) {
        super.processBeforeSave(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}