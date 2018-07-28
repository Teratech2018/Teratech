
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.curative.SymptomeManagerLocal;
import com.teratech.gmao.core.ifaces.curative.SymptomeManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.SymptomeDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.curative.Symptome;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "SymptomeManager")
public class SymptomeManagerImpl
    extends AbstractGenericManager<Symptome, Long>
    implements SymptomeManagerLocal, SymptomeManagerRemote
{

    @EJB(name = "SymptomeDAO")
    protected SymptomeDAOLocal dao;

    public SymptomeManagerImpl() {
    }

    @Override
    public GenericDAO<Symptome, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Symptome> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
         List<Symptome> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
        List<Symptome> results = new ArrayList<Symptome>();
        for(Symptome data:datas){
            results.add(new Symptome(data));
        }
        return results;
    }

    @Override
    public List<Symptome> findAll() {
        List<Symptome> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Symptome> results = new ArrayList<Symptome>();
        for(Symptome data:datas){
            results.add(new Symptome(data));
        }
        return results;
    }

    @Override
    public Symptome find(String propertyName, Long entityID) {
        Symptome data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Symptome entity = new Symptome(data);
        for(FichierLie fichier:data.getPiecesjointes()){
            entity.getPiecesjointes().add(fichier);
        }
        return entity;
     }

    @Override
    public Symptome delete(Long id) {
        Symptome data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Symptome(data);
    }
    
    

}
