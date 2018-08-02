
package com.teratech.gmao.core.impl.projet;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.projet.ProjetManagerLocal;
import com.teratech.gmao.core.ifaces.projet.ProjetManagerRemote;
import com.teratech.gmao.dao.ifaces.projet.ProjetDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.projet.BudgetProjet;
import com.teratech.gmao.model.projet.Projet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ProjetManager")
public class ProjetManagerImpl
    extends AbstractGenericManager<Projet, Long>
    implements ProjetManagerLocal, ProjetManagerRemote
{

    @EJB(name = "ProjetDAO")
    protected ProjetDAOLocal dao;

    public ProjetManagerImpl() {
    }

    @Override
    public GenericDAO<Projet, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Projet> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Projet> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Projet> results = new ArrayList<Projet>();
        for(Projet data:datas){
            results.add(new Projet(data));
        }
        return results;
    }

    @Override
    public List<Projet> findAll() {
        List<Projet> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Projet> results = new ArrayList<Projet>();
        for(Projet data:datas){
            results.add(new Projet(data));
        }
        return results;
    }

    @Override
    public Projet find(String propertyName, Long entityID) {
        Projet data= super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Projet result = new Projet(data);
        for(BudgetProjet bud : data.getBudgets()){
            result.getBudgets().add(new BudgetProjet(bud));
        }
        for(FichierLie fich:data.getPiecesjointes()){
            result.getPiecesjointes().add(fich);
        }
        return result;
    }

    @Override
    public Projet delete(Long id) {
        Projet data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Projet();
    }
    
    

}
