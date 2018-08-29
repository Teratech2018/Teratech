
package com.kerenedu.core.impl.report;

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
import com.kerenedu.core.ifaces.report.ViewListeEleveManagerLocal;
import com.kerenedu.core.ifaces.report.ViewListeEleveManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewListeEleveDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.kerenedu.model.report.ViewAnniversaire;
import com.kerenedu.model.report.ViewListeEleve;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ViewListeEleveManager")
public class ViewListeEleveManagerImpl
    extends AbstractGenericManager<ViewListeEleve, Long>
    implements ViewListeEleveManagerLocal, ViewListeEleveManagerRemote
{

    @EJB(name = "ViewListeEleveDAO")
    protected ViewListeEleveDAOLocal dao;
    
    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal daoIns;


    public ViewListeEleveManagerImpl() {
    }

    @Override
    public GenericDAO<ViewListeEleve, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
   	public List<ViewListeEleve> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
   			int firstResult, int maxResult) {
   		// TODO Auto-generated method stub
    	predicats.addAll(CacheMemory.defaultPredicatsCycleAnnee());
    	List<ViewListeEleve> listIns = dao.filter(predicats, orders, properties, firstResult, maxResult);
    	List<ViewListeEleve> result = new ArrayList<ViewListeEleve>();
    	for(ViewListeEleve i :listIns){
    		result.add(new ViewListeEleve(i));
    	}
   		return result;
   	}

   	@Override
   	public ViewListeEleve find(String propertyName, Long entityID) {
   		// TODO Auto-generated method stub
   		ViewListeEleve ins= dao.findByPrimaryKey("id", entityID);
   		//ViewListeEleve elev = super.find(propertyName, entityID);
   		ViewListeEleve inscrip = new ViewListeEleve(ins);
//   		for(Eleve serv: elev.getElevelist()){
//   			inscrip.getElevelist().add(new Eleve(serv));
//   		}
   		return inscrip;
   	}

   	@Override
   	public List<ViewListeEleve> findAll() {
   		// TODO Auto-generated method stub
   
   		List<ViewListeEleve> datas = super.findAll();
   		List<ViewListeEleve> result = new ArrayList<ViewListeEleve>();
   		for(ViewListeEleve elev:datas){
   			result.add(new ViewListeEleve(elev));
   		}
   		return result;
   	}
   	
   	

   	@Override
   	public ViewListeEleve delete(Long id) {
   		// TODO Auto-generated method stub
   		ViewListeEleve elev = super.delete(id);
   		return new ViewListeEleve(elev);
   	}
   	@Override
	public List<ViewListeEleve> getCriteres(ViewListeEleve critere) {
		// To change body of generated methods, choose Tools | Templates.
				RestrictionsContainer container = RestrictionsContainer.newInstance();
				if (critere != null) {
					container = RestrictionsContainer.newInstance();
//					if (critere.getDatInsfin() != null) {
//						container.addGe("eleve.dateNais", critere.getDatInsfin());
//					}
//					
					

					if (critere.getClasse() != null) {
						container.addEq("classe.id", critere.getClasse().getId());
						
					}

				}
				List<ViewListeEleve> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
				List<ViewListeEleve> result = new ArrayList<ViewListeEleve>();
				if (datas != null) {
					for (ViewListeEleve aniv : datas) {;
						result.add(new ViewListeEleve(aniv));
					}
				} // fin if(datas!=null)
				return result;
	}


}
