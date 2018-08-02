
package com.keren.courrier.core.impl.workflow;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.workflow.WorkflowActionManagerLocal;
import com.keren.courrier.core.ifaces.workflow.WorkflowActionManagerRemote;
import com.keren.courrier.dao.ifaces.workflow.WorkflowActionDAOLocal;
import com.keren.courrier.model.workflow.WorkflowAction;
import com.keren.courrier.model.workflow.WorkflowLigne;
import com.megatim.common.annotations.OrderType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@TransactionAttribute
@Stateless(mappedName = "WorkflowActionManager")
public class WorkflowActionManagerImpl
    extends AbstractGenericManager<WorkflowAction, Long>
    implements WorkflowActionManagerLocal, WorkflowActionManagerRemote
{

    @EJB(name = "WorkflowActionDAO")
    protected WorkflowActionDAOLocal dao;

    public WorkflowActionManagerImpl() {
    }

    @Override
    public GenericDAO<WorkflowAction, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<WorkflowAction> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<WorkflowAction> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<WorkflowAction> results = new ArrayList<WorkflowAction>();
        
        for(WorkflowAction data:datas){
            results.add(new WorkflowAction(data));
        }
        
        return results;
    }

    @Override
    public List<WorkflowAction> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<WorkflowAction> datas = super.findAll(); 
        List<WorkflowAction> results = new ArrayList<WorkflowAction>();   
        
        for(WorkflowAction data:datas){
            results.add(new WorkflowAction(data));
        }
        
        return results;
    }

    @Override
    public WorkflowAction find(String propertyName, Long entityID) {
        WorkflowAction data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        WorkflowAction result = new WorkflowAction(data);  
        
        for(WorkflowLigne workflowLigne:data.getLignes()){
            result.getLignes().add(new WorkflowLigne(workflowLigne));
        }
        
        return result;
    }
    
    @Override
    public WorkflowAction delete(Long id) {

        // TODO Auto-generated method stub    	
        WorkflowAction data= super.delete(id);

        return new WorkflowAction(data);
    }
    
    @Override
    public void processBeforeSave(WorkflowAction entity) {
        
        //Traitement des LigneDiffusion
        if(entity.getLignes()!= null){
            
            //On parcourt la liste des donnees
            List<WorkflowLigne> datas =new ArrayList<WorkflowLigne>();
            int index =1 ;
            
            //On parcourt la liste
            for(WorkflowLigne workflowLigne : entity.getLignes()){
              
              //Initialisation
              workflowLigne.setId(-index);
              datas.add(workflowLigne);
              index ++;
            }
            
            //On ajoute la liste
            entity.getLignes().addAll(datas);
            
        }
        
        super.processBeforeSave(entity);
    }
}
