
package com.keren.kerenpaie.core.impl.comptabilite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.CompteManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.CompteManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.CompteDAOLocal;
import com.keren.kerenpaie.model.comptabilite.Compte;
import com.keren.kerenpaie.model.comptabilite.SectionAnalytique;
import com.keren.kerenpaie.model.comptabilite.Taxe;
import com.megatim.common.annotations.OrderType;

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
        List<Compte> datas =  super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<Compte> result = new ArrayList<Compte>();
        for(Compte c:datas){
            result.add(new Compte(c));
        }
        return result;
    }

    @Override
    public List<Compte> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<Compte> datas =  super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Compte> result = new ArrayList<Compte>();
        for(Compte c:datas){
            result.add(new Compte(c));
        }
        return result;
    }

    @Override
    public Compte find(String propertyName, Long entityID) {
        Compte data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Compte result = new Compte(data);
        if(data.getTaxe()!=null){
            result.setTaxe(new Taxe(data.getTaxe()));
        }
        if(data.getAnalytiques()!=null){
            for(SectionAnalytique sec:data.getAnalytiques()){
                result.getAnalytiques().add(new SectionAnalytique(sec));
            }
        }
        return result;
    }

    @Override
    public Compte delete(Long id) {
        Compte data =  super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Compte(data);
    }
    
}
