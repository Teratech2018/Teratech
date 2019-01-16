
package com.basaccount.core.impl.ventes;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.basaccount.core.ifaces.ventes.FactureVenteManagerLocal;
import com.basaccount.core.ifaces.ventes.FactureVenteManagerRemote;
import com.basaccount.dao.ifaces.ventes.FactureVenteDAOLocal;
import com.basaccount.model.achats.Acompte;
import com.basaccount.model.achats.DocumentAchatState;
import com.basaccount.model.achats.EcheanceReglement;
import com.basaccount.model.achats.LigneFacture;
import com.basaccount.model.ventes.FactureVente;
import com.basaccount.model.ventes.LigneFactureVente;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "FactureVenteManager")
public class FactureVenteManagerImpl
    extends AbstractGenericManager<FactureVente, Long>
    implements FactureVenteManagerLocal, FactureVenteManagerRemote
{

    
    @EJB(name = "FactureVenteDAO")
    protected FactureVenteDAOLocal dao;

    public FactureVenteManagerImpl() {
    }

    @Override
    public GenericDAO<FactureVente, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public Long count(List<Predicat> predicats) {
        return super.count(predicats); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<FactureVente> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        container.addEq("typedocument", DocumentAchatState.COMPTABILITE);
        predicats.addAll(container.getPredicats());
        List<FactureVente> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<FactureVente> result = new ArrayList<FactureVente>();
        for(FactureVente data:datas){
            result.add(new FactureVente(data));
        }
        return result;
    }

    @Override
    public List<FactureVente> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public FactureVente find(String propertyName, Long entityID) {
        FactureVente data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        FactureVente result = new FactureVente(data);
        for(LigneFactureVente ligne:data.getLignes()){
            result.getLignes().add(new LigneFactureVente(ligne));
        }
        for(Acompte acom:data.getAcomptes()){
            result.getAcomptes().add(new Acompte(acom));
        }
        for(EcheanceReglement ech:data.getEcheances()){
            result.getEcheances().add(ech);
        }
       return result;
    }

    @Override
    public FactureVente delete(Long id) {
        FactureVente data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new FactureVente(data);
    }
    
    

}
