
package com.teratech.stock.core.impl.invetaire;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.stock.core.ifaces.invetaire.FicheInventaireManagerLocal;
import com.teratech.stock.core.ifaces.invetaire.FicheInventaireManagerRemote;
import com.teratech.stock.dao.ifaces.invetaire.FicheInventaireDAOLocal;
import com.teratech.stock.model.invetaire.FicheInventaire;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "FicheInventaireManager")
public class FicheInventaireManagerImpl
    extends AbstractGenericManager<FicheInventaire, Long>
    implements FicheInventaireManagerLocal, FicheInventaireManagerRemote
{

    @EJB(name = "FicheInventaireDAO")
    protected FicheInventaireDAOLocal dao;

    public FicheInventaireManagerImpl() {
    }

    @Override
    public GenericDAO<FicheInventaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<FicheInventaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<FicheInventaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<FicheInventaire> result = new ArrayList<FicheInventaire>();
        for(FicheInventaire fich:datas){
            result.add(new FicheInventaire(fich));
        }
        return result;
    }

    @Override
    public List<FicheInventaire> findAll() {        
         List<FicheInventaire> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<FicheInventaire> result = new ArrayList<FicheInventaire>();
        for(FicheInventaire fich:datas){
            result.add(new FicheInventaire(fich));
        }
        return result;
    }

    @Override
    public FicheInventaire find(String propertyName, Long entityID) {
        FicheInventaire data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        FicheInventaire result = new FicheInventaire(data);        
        return result;
    }

    @Override
    public FicheInventaire delete(Long id) {
        FicheInventaire data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new FicheInventaire(data);
    }
    
    

}
