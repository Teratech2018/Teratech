
package com.keren.courrier.core.impl.courrier;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.courrier.CourrierTousManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierTousManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierTousDAOLocal;
import com.keren.courrier.model.courrier.CourrierTous;
import com.keren.courrier.model.courrier.FichierLie;
import com.megatim.common.annotations.OrderType;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CourrierTousManager")
public class CourrierTousManagerImpl
    extends AbstractGenericManager<CourrierTous, Long>
    implements CourrierTousManagerLocal, CourrierTousManagerRemote
{

    @EJB(name = "CourrierTousDAO")
    protected CourrierTousDAOLocal dao;

    public CourrierTousManagerImpl() {
    }

    @Override
    public GenericDAO<CourrierTous, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<CourrierTous> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        return super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<CourrierTous> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CourrierTous find(String propertyName, Long entityID) {
        CourrierTous data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        CourrierTous entity = new CourrierTous(data);
        for(FichierLie fichier:data.getPiecesjointes()){
            entity.getPiecesjointes().add(fichier);
        }
        return entity;
    }
    
    

}
