
package com.basaccount.core.impl.ventes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.basaccount.core.ifaces.ventes.NoteFraisVenteManagerLocal;
import com.basaccount.core.ifaces.ventes.NoteFraisVenteManagerRemote;
import com.basaccount.dao.ifaces.ventes.NoteFraisVenteDAOLocal;
import com.basaccount.model.ventes.LigneNoteFraisVente;
import com.basaccount.model.ventes.NoteFraisVente;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "NoteFraisVenteManager")
public class NoteFraisVenteManagerImpl
    extends AbstractGenericManager<NoteFraisVente, Long>
    implements NoteFraisVenteManagerLocal, NoteFraisVenteManagerRemote
{

    @EJB(name = "NoteFraisVenteDAO")
    protected NoteFraisVenteDAOLocal dao;

    public NoteFraisVenteManagerImpl() {
    }

    @Override
    public GenericDAO<NoteFraisVente, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<NoteFraisVente> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<NoteFraisVente> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<NoteFraisVente> result = new ArrayList<NoteFraisVente>();
        for(NoteFraisVente data:datas){
            result.add(new NoteFraisVente(data));
        }
        return result;
    }

    @Override
    public NoteFraisVente find(String propertyName, Long entityID) {
        NoteFraisVente data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        NoteFraisVente result = new NoteFraisVente(data);
        for(LigneNoteFraisVente ligne:data.getNotes()){
            result.getNotes().add(new LigneNoteFraisVente(ligne));
        }
        return result;
    }

    @Override
    public NoteFraisVente delete(Long id) {
        NoteFraisVente data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new NoteFraisVente(data);
    }
    
    

}
