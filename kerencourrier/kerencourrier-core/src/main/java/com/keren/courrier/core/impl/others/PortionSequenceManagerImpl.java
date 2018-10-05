
package com.keren.courrier.core.impl.others;

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
import com.keren.courrier.core.ifaces.others.PortionSequenceManagerLocal;
import com.keren.courrier.core.ifaces.others.PortionSequenceManagerRemote;
import com.keren.courrier.dao.ifaces.others.PortionSequenceDAOLocal;
import com.keren.courrier.model.others.PortionSequence;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "PortionSequenceManager")
public class PortionSequenceManagerImpl
    extends AbstractGenericManager<PortionSequence, Long>
    implements PortionSequenceManagerLocal, PortionSequenceManagerRemote
{

    @EJB(name = "PortionSequenceDAO")
    protected PortionSequenceDAOLocal dao;

    public PortionSequenceManagerImpl() {
    }

    @Override
    public GenericDAO<PortionSequence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

    @Override
    public List<PortionSequence> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<PortionSequence> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<PortionSequence> results = new ArrayList<PortionSequence>();        
        for(PortionSequence courrier:datas){
        	PortionSequence data = new PortionSequence(courrier);
            results.add(data);              
        }//end for(ArchiveDocument courrier:datas){        
        return results;
    }

    @Override
    public List<PortionSequence> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<PortionSequence> datas = super.findAll(); 
        List<PortionSequence> results = new ArrayList<PortionSequence>();        
        for(PortionSequence data:datas){
            results.add(new PortionSequence(data));
        }
        
        return results;
    }

    @Override
    public PortionSequence find(String propertyName, Long entityID) {        
        //initialisaiton
    	PortionSequence data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
    	PortionSequence result = new PortionSequence(data);            
        return result;
    }
    
}
