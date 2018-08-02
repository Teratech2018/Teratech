
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "HelpProfClasseManager")
public class HelpProfClasseManagerImpl
    extends AbstractGenericManager<HelpProfClasse, Long>
    implements HelpProfClasseManagerLocal, HelpProfClasseManagerRemote
{

    @EJB(name = "HelpProfClasseDAO")
    protected HelpProfClasseDAOLocal dao;
    
    @EJB(name = "CoefMatiereDetailDAO")
    protected CoefMatiereDetailDAOLocal daocof;

    public HelpProfClasseManagerImpl() {
    }

    @Override
    public GenericDAO<HelpProfClasse, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<HelpProfClasse> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
    	RestrictionsContainer container = RestrictionsContainer.newInstance();
//    	Classe classe = CacheMemory.getClasse();
//    	container.addEq("classe.id", classe.getId());
    	List<CoefMatiereDetail> list = daocof.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
//   		List<HelpProfClasse> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<HelpProfClasse> result = new ArrayList<HelpProfClasse>();
   		for(CoefMatiereDetail coef : list){
   			result.add(new HelpProfClasse(coef));
   		}
   		return result;
   	}

   	@Override
   	public HelpProfClasse find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		HelpProfClasse elev = super.find(propertyName, entityID);
   		HelpProfClasse inscrip = new HelpProfClasse(elev);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<HelpProfClasse> findAll() {
   		// TODO Auto-generated method stub
   		RestrictionsContainer container = RestrictionsContainer.newInstance();
//   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
//    	Classe classe = CacheMemory.getClasse();
//    	container.addEq("classe.id", classe.getId());
    	List<CoefMatiereDetail> list = daocof.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
//   		List<HelpProfClasse> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
   		List<HelpProfClasse> result = new ArrayList<HelpProfClasse>();
   		for(CoefMatiereDetail coef : list){
   			result.add(new HelpProfClasse(coef));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public HelpProfClasse delete(Long id) {
   		// TODO Auto-generated method stub
   		HelpProfClasse elev = super.delete(id);
   		return new HelpProfClasse(elev);
   	}

}
