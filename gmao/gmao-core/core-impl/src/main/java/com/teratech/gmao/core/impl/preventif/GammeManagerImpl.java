
package com.teratech.gmao.core.impl.preventif;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.preventif.GammeManagerLocal;
import com.teratech.gmao.core.ifaces.preventif.GammeManagerRemote;
import com.teratech.gmao.dao.ifaces.preventif.GammeDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.preventif.Gamme;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "GammeManager")
public class GammeManagerImpl
    extends AbstractGenericManager<Gamme, Long>
    implements GammeManagerLocal, GammeManagerRemote
{

    @EJB(name = "GammeDAO")
    protected GammeDAOLocal dao;

    public GammeManagerImpl() {
    }

    @Override
    public GenericDAO<Gamme, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<Gamme> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        //To change body of generated methods, choose Tools | Templates.
        List<Gamme> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
        List<Gamme> results =  new ArrayList<Gamme>();
        for(Gamme data:datas){
            results.add(new Gamme(data));
        }
        return results;
    }

    @Override
    public List<Gamme> findAll() {
        List<Gamme> datas = super.findAll(); //To change body of generated methods, choose Tools | Templates.
        List<Gamme> results =  new ArrayList<Gamme>();
        for(Gamme data:datas){
            results.add(new Gamme(data));
        }
        return results;
    }

    @Override
    public Gamme find(String propertyName, Long entityID) {
        Gamme data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        Gamme entity = new Gamme(data);
        for(FichierLie fichier:data.getPiecesjointes()){
            entity.getPiecesjointes().add(fichier);
        }//end for(FichierLie fichier:data.getPiecesjointes()){
        return entity;
    }

    @Override
    public Gamme delete(Long id) {
        Gamme data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new Gamme(data);
    }
    
    

}
