
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.CorrespondantManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.CorrespondantManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.CorrespondantDAOLocal;
import com.keren.courrier.model.referentiel.Correspondant;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CorrespondantManager")
public class CorrespondantManagerImpl
    extends AbstractGenericManager<Correspondant, Long>
    implements CorrespondantManagerLocal, CorrespondantManagerRemote
{

    @EJB(name = "CorrespondantDAO")
    protected CorrespondantDAOLocal dao;

    public CorrespondantManagerImpl() {
    }

    @Override
    public GenericDAO<Correspondant, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
         RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addIsNull("compte", null);
        container.addIsNull("service", null);
        predicats.addAll(container.getPredicats());
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Correspondant> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addIsNull("compte", null);
        container.addIsNull("service", null);
        predicats.addAll(container.getPredicats());
        List<Correspondant> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Correspondant> results = new ArrayList<Correspondant>();
        for(Correspondant data:datas){
            results.add(new Correspondant(data));
        }
        return results;
    }

    @Override
    public List<Correspondant> findAll() {
        List<Correspondant> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Correspondant> results = new ArrayList<Correspondant>();
        for(Correspondant data:datas){
            results.add(new Correspondant(data));
        }
        return results;
    }

    @Override
    public Correspondant find(String propertyName, Long entityID) {
        Correspondant data =  super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        return new Correspondant(data);
    }

    @Override
    public Correspondant delete(Long id) {
        Correspondant data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Correspondant(data);
    }
    
    

}
