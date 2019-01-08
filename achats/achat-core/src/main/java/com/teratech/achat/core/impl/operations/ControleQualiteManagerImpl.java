
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;
import com.teratech.achat.core.ifaces.operations.ControleQualiteManagerLocal;
import com.teratech.achat.core.ifaces.operations.ControleQualiteManagerRemote;
import com.teratech.achat.dao.ifaces.operations.ControleQualiteDAOLocal;
import com.teratech.achat.model.operations.ControleQualite;
import com.teratech.achat.model.operations.LigneControleQualite;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "ControleQualiteManager")
public class ControleQualiteManagerImpl
    extends AbstractGenericManager<ControleQualite, Long>
    implements ControleQualiteManagerLocal, ControleQualiteManagerRemote
{

    @EJB(name = "ControleQualiteDAO")
    protected ControleQualiteDAOLocal dao;

    public ControleQualiteManagerImpl() {
    }

    @Override
    public GenericDAO<ControleQualite, Long> getDao() {
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
    public List<ControleQualite> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ControleQualite> datas =  super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ControleQualite> result = new ArrayList<ControleQualite>();
        for(ControleQualite data:datas){
            result.add(new ControleQualite(data));
        }
        return result;
    }

    @Override
    public List<ControleQualite> findAll() {
        return super.findAll(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ControleQualite find(String propertyName, Long entityID) {
        ControleQualite  data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ControleQualite result = new ControleQualite(data);
        for(LigneControleQualite ligne:data.getLignes()){
            result.getLignes().add(new LigneControleQualite(ligne));
        }
        return result;
    }

    @Override
    public ControleQualite delete(Long id) {
        ControleQualite data= super.delete(id); //To change body of generated methods, choose Tools | Templates.
        return new ControleQualite(data);
    }

    @Override
    public void processBeforeUpdate(ControleQualite entity) {
        if(entity.getRebus().compareTo(0.0)>0){            
            if(entity.getRecu().compareTo(entity.getRebus())<0){
                entity.setColor("#FFFF00");
            }else{
                 entity.setColor("#FF0000");
            }//end if(entity.getRecu().compareTo(entity.getRebus())<0){
        }else{
           entity.setColor("#2EFE2E");
        }//end  if(entity.getRebus().compareTo(0.0)>0){        
        super.processBeforeUpdate(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
