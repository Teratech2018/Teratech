
package com.keren.courrier.core.impl.referentiel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.referentiel.LigneDiffusionManagerLocal;
import com.keren.courrier.core.ifaces.referentiel.LigneDiffusionManagerRemote;
import com.keren.courrier.dao.ifaces.referentiel.LigneDiffusionDAOLocal;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "LigneDiffusionManager")
public class LigneDiffusionManagerImpl
    extends AbstractGenericManager<LigneDiffusion, Long>
    implements LigneDiffusionManagerLocal, LigneDiffusionManagerRemote
{

    @EJB(name = "LigneDiffusionDAO")
    protected LigneDiffusionDAOLocal dao;

    public LigneDiffusionManagerImpl() {
    }

    @Override
    public GenericDAO<LigneDiffusion, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<LigneDiffusion> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<LigneDiffusion> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<LigneDiffusion> results = new ArrayList<LigneDiffusion>();
        
        for(LigneDiffusion data:datas){
            results.add(new LigneDiffusion(data));
        }
        
        return results;
    }

    @Override
    public List<LigneDiffusion> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<LigneDiffusion> datas = super.findAll(); 
        List<LigneDiffusion> results = new ArrayList<LigneDiffusion>();   
        
        for(LigneDiffusion data:datas){
            results.add(new LigneDiffusion(data));
        }
        
        return results;
    }

    @Override
    public LigneDiffusion find(String propertyName, Long entityID) {
        LigneDiffusion data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        LigneDiffusion result = new LigneDiffusion(data);  
        
        /*for(WorkflowLigne workflowLigne:data.getLignes()){
            result.getLignes().add(new WorkflowLigne(workflowLigne));
        }*/
        
        return result;
    }
    
    @Override
    public LigneDiffusion delete(Long id) {

        // TODO Auto-generated method stub    	
        LigneDiffusion data= super.delete(id);

        return new LigneDiffusion(data);
    }
}
