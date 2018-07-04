
package com.kerenedu.configuration;

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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ConfigMailManager")
public class ConfigMailManagerImpl
    extends AbstractGenericManager<ConfigMail, Long>
    implements ConfigMailManagerLocal, ConfigMailManagerRemote
{

    @EJB(name = "ConfigMailDAO")
    protected ConfigMailDAOLocal dao;

    public ConfigMailManagerImpl() {
    }

    @Override
    public GenericDAO<ConfigMail, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ConfigMail> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
   		List<ConfigMail> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<ConfigMail> result = new ArrayList<ConfigMail>();
   		for(ConfigMail elev:datas){
   			result.add(new ConfigMail(elev));
   		}
   		return result;
   	}

   	@Override
   	public ConfigMail find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ConfigMail elev = super.find(propertyName, entityID);
   		ConfigMail inscrip = new ConfigMail(elev);
//   		for(Eleve serv: elev.getEleveList()){
//   			inscrip.getEleveList().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<ConfigMail> findAll() {
   		// TODO Auto-generated method stub
   		List<ConfigMail> datas = super.findAll();
   		List<ConfigMail> result = new ArrayList<ConfigMail>();
   		for(ConfigMail elev:datas){
   			result.add(new ConfigMail(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public ConfigMail delete(Long id) {
   		// TODO Auto-generated method stub
   		ConfigMail elev = super.delete(id);
   		return new ConfigMail(elev);
   	}

   	@Override
   	public void processBeforeSave(ConfigMail entity) {
   		
       
   		super.processBeforeSave(entity);
   	}

   	@Override
   	public void processBeforeUpdate(ConfigMail entity) {
   	    // verifier si l'étudiant a déjà été inscit 
         /*  ConfigMail inscit = dao.getConfigMailEtudiantByAnnee(entity.getEleve(), entity.getAnneScolaire());
           if(inscit!=null){
               RuntimeException excep = new RuntimeException("Eléve déjà Inscrit !!!");
               throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
           }*/
   		super.processBeforeUpdate(entity);
   	}

}
