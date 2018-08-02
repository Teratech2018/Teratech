
package com.keren.courrier.core.impl.others;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.others.UtilisateurCloneManagerLocal;
import com.keren.courrier.core.ifaces.others.UtilisateurCloneManagerRemote;
import com.keren.courrier.dao.ifaces.others.UtilisateurCloneDAOLocal;
import com.keren.courrier.model.others.UtilisateurClone;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "UtilisateurCloneManager")
public class UtilisateurCloneManagerImpl
    extends AbstractGenericManager<UtilisateurClone, Long>
    implements UtilisateurCloneManagerLocal, UtilisateurCloneManagerRemote
{

    @EJB(name = "UtilisateurCloneDAO")
    protected UtilisateurCloneDAOLocal dao;

    public UtilisateurCloneManagerImpl() {
    }

    @Override
    public GenericDAO<UtilisateurClone, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<UtilisateurClone> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addNotNull("compte", null);
        predicats.addAll(container.getPredicats());
        List<UtilisateurClone> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<UtilisateurClone> results = new ArrayList<UtilisateurClone>();
        for(UtilisateurClone data:datas){
            results.add(new UtilisateurClone(data));
        }
        return results;
    }
    
    

}
