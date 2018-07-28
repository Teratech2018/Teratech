
package com.teratech.gmao.core.impl.curative;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.gmao.core.ifaces.curative.ActiviteBTManagerLocal;
import com.teratech.gmao.core.ifaces.curative.ActiviteBTManagerRemote;
import com.teratech.gmao.dao.ifaces.curative.ActiviteBTDAOLocal;
import com.teratech.gmao.model.base.FichierLie;
import com.teratech.gmao.model.curative.ActiviteBT;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ActiviteBTManager")
public class ActiviteBTManagerImpl
    extends AbstractGenericManager<ActiviteBT, Long>
    implements ActiviteBTManagerLocal, ActiviteBTManagerRemote
{

    @EJB(name = "ActiviteBTDAO")
    protected ActiviteBTDAOLocal dao;

    public ActiviteBTManagerImpl() {
    }

    @Override
    public GenericDAO<ActiviteBT, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<ActiviteBT> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ActiviteBT> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ActiviteBT> results = new ArrayList<ActiviteBT>();
        for(ActiviteBT data:datas){
            results.add(new ActiviteBT(data));
        }//end for(ActiviteBT data:datas){
        return results;
    }

    @Override
    public List<ActiviteBT> findAll() {
        //To change body of generated methods, choose Tools | Templates.
        List<ActiviteBT> datas = super.findAll(); 
        List<ActiviteBT> results = new ArrayList<ActiviteBT>();
        for(ActiviteBT data:datas){
            results.add(new ActiviteBT(data));
        }//end for(ActiviteBT data:datas){
        return results;
    }
    
    

    @Override
    public ActiviteBT find(String propertyName, Long entityID) {
        ActiviteBT data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ActiviteBT entity = new ActiviteBT(data);
        for(FichierLie fichier:data.getPiecesjointes()){
            entity.getPiecesjointes().add(fichier);
        }//end for(FichierLie fichier:data.getPiecesjointes()){
        return entity;
    }

    @Override
    public ActiviteBT delete(Long id) {
        ActiviteBT data = super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new ActiviteBT(data);
    }
    
    

}
