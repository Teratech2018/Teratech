
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
import com.keren.courrier.core.ifaces.others.ConfigSequenceManagerLocal;
import com.keren.courrier.core.ifaces.others.ConfigSequenceManagerRemote;
import com.keren.courrier.dao.ifaces.others.ConfigSequenceDAOLocal;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.others.ConfigSequence;
import com.keren.courrier.model.others.PortionSequence;
import com.keren.courrier.model.others.ConfigSequence;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ConfigSequenceManager")
public class ConfigSequenceManagerImpl
    extends AbstractGenericManager<ConfigSequence, Long>
    implements ConfigSequenceManagerLocal, ConfigSequenceManagerRemote
{

    @EJB(name = "ConfigSequenceDAO")
    protected ConfigSequenceDAOLocal dao;

    public ConfigSequenceManagerImpl() {
    }

    @Override
    public GenericDAO<ConfigSequence, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<ConfigSequence> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ConfigSequence> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ConfigSequence> results = new ArrayList<ConfigSequence>();        
        for(ConfigSequence courrier:datas){
        	ConfigSequence data = new ConfigSequence(courrier);
            results.add(data);              
        }//end for(ArchiveDocument courrier:datas){        
        return results;
    }

    @Override
    public List<ConfigSequence> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<ConfigSequence> datas = super.findAll(); 
        List<ConfigSequence> results = new ArrayList<ConfigSequence>();        
        for(ConfigSequence data:datas){
            results.add(new ConfigSequence(data));
        }
        
        return results;
    }

    @Override
    public ConfigSequence find(String propertyName, Long entityID) {        
        //initialisaiton
    	ConfigSequence data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
    	ConfigSequence result = new ConfigSequence(data);   
    	for (PortionSequence aas : data.getPortions()) {
			result.getPortions().add(new PortionSequence(aas));
		}
        return result;
    }
    

}
