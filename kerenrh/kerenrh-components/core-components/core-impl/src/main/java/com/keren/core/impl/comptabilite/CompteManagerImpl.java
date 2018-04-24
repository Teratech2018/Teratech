
package com.keren.core.impl.comptabilite;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.comptabilite.CompteManagerLocal;
import com.keren.core.ifaces.comptabilite.CompteManagerRemote;
import com.keren.dao.ifaces.comptabilite.CompteDAOLocal;
import com.keren.model.comptabilite.Compte;
import com.keren.model.comptabilite.SectionAnalytique;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CompteManager")
public class CompteManagerImpl
    extends AbstractGenericManager<Compte, Long>
    implements CompteManagerLocal, CompteManagerRemote
{

    @EJB(name = "CompteDAO")
    protected CompteDAOLocal dao;

    public CompteManagerImpl() {
    }

    @Override
    public GenericDAO<Compte, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<Compte> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<Compte> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Compte> results = new ArrayList<Compte>();
        for(Compte data:datas){
            results.add(new Compte(data));
        }
        return results;
    }

    @Override
    public List<Compte> findAll() {
        List<Compte> datas = super.findAll();
        List<Compte> results = new ArrayList<Compte>();

        for(Compte data:datas){
            results.add(new Compte(data));
        }
        return results;
    }

    @Override
    public Compte find(String propertyName, Long entityID) {
        Compte data = super.find(propertyName, entityID);
        Compte result = new Compte(data);

        for(SectionAnalytique aas:data.getAnalytiques()){
            result.getAnalytiques().add(new SectionAnalytique(aas));
        }

        return result;
    }

    @Override
    public void processAfterUpdate(Compte entity) {
        super.processAfterUpdate(entity);
    }

    @Override
    public void processAfterSave(Compte entity) {
         entity = dao.findByPrimaryKey("code", entity.getCode());

        super.processAfterSave(entity);
    }

}