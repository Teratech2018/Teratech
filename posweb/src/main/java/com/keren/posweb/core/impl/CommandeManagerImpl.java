
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.CommandeManagerLocal;
import com.keren.posweb.core.ifaces.CommandeManagerRemote;
import com.keren.posweb.dao.ifaces.CommandeDAOLocal;
import com.keren.posweb.model.Commande;
import com.keren.posweb.model.LigneCommande;
import com.keren.posweb.model.Taxe;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "CommandeManager")
public class CommandeManagerImpl
    extends AbstractGenericManager<Commande, Long>
    implements CommandeManagerLocal, CommandeManagerRemote
{

    @EJB(name = "CommandeDAO")
    protected CommandeDAOLocal dao;

    public CommandeManagerImpl() {
    }

    @Override
    public GenericDAO<Commande, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Commande> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Commande> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Commande> results = new ArrayList<Commande>();
        for(Commande data:datas){
            results.add(new Commande(data));
        }
        return results;
    }

    @Override
    public List<Commande> findAll() {
        List<Commande> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Commande> results = new ArrayList<Commande>();
        for(Commande data:datas){
            results.add(new Commande(data));
        }
        return results;
    }

    @Override
    public Commande find(String propertyName, Long entityID) {
        Commande data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Commande entity = new Commande(data);
        for(LigneCommande ligne:data.getLignes()){
            LigneCommande li = new LigneCommande(ligne);
            for(Taxe taxe:ligne.getTaxes()){
                li.getTaxes().add(new Taxe(taxe));
            }//end vfor(Taxe taxe:ligne.getTaxes()){
            entity.getLignes().add(li);
        }
        return entity;
    }

    @Override
    public Commande delete(Long id) {
        Commande data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Commande(data);
    }
    
    

}
