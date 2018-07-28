
package com.teratech.gmao.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.base.EquipementManagerLocal;
import com.teratech.gmao.core.ifaces.base.EquipementManagerRemote;
import com.teratech.gmao.dao.ifaces.base.EquipementDAOLocal;
import com.teratech.gmao.model.base.Compteur;
import com.teratech.gmao.model.base.Equipement;
import com.teratech.gmao.model.base.Organe;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "EquipementManager")
public class EquipementManagerImpl
    extends AbstractGenericManager<Equipement, Long>
    implements EquipementManagerLocal, EquipementManagerRemote
{

    @EJB(name = "EquipementDAO")
    protected EquipementDAOLocal dao;

    public EquipementManagerImpl() {
    }

    @Override
    public GenericDAO<Equipement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Equipement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Equipement> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Equipement> results = new ArrayList<Equipement>();
        for(Equipement data:datas){
            results.add(new Equipement(data));
        }
        return results;
    }

    @Override
    public List<Equipement> findAll() {
        List<Equipement> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Equipement> results = new ArrayList<Equipement>();
        for(Equipement data:datas){
            results.add(new Equipement(data));
        }
        return results;
    }

    @Override
    public Equipement find(String propertyName, Long entityID) {
        Equipement data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Equipement result = new Equipement(data);
        for(Organe org:data.getOrganes()){
            result.getOrganes().add(new Organe(org));
        }//end for(Organe org:data.getOrganes()){
        for(Compteur com:data.getCompteurs()){
            result.getCompteurs().add(new Compteur(com));
        }
        return result;
    }

    @Override
    public Equipement delete(Long id) {
        Equipement data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Equipement(data);
    }
    
    

}
