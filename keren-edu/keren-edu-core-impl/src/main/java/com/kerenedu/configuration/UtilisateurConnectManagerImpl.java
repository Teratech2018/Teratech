
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
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "UtilisateurConnectManager")
public class UtilisateurConnectManagerImpl
    extends AbstractGenericManager<UtilisateurConnect, Long>
    implements UtilisateurConnectManagerLocal, UtilisateurConnectManagerRemote
{

	@EJB(name="UtilisateurConnectDAO")
	  protected UtilisateurConnectDAOLocal dao;
	  
	  public UtilisateurConnectManagerImpl() {}
	  
	  public GenericDAO<UtilisateurConnect, Long> getDao()
	  {
	    return dao;
	  }
	  
	  public String getEntityIdName()
	  {
	    return "id";
	  }
	  


	  public List<UtilisateurConnect> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult)
	  {
	    List<UtilisateurConnect> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
	    List<UtilisateurConnect> result = new ArrayList();
	    for (UtilisateurConnect elev : datas) {
	      UserEducation user = new UserEducation(elev.getCompte());
	      elev.setCompte(user);
	      result.add(new UtilisateurConnect(elev));
	    }
	    return result;
	  }
	  

	  public UtilisateurConnect find(String propertyName, Long entityID)
	  {
	    UtilisateurConnect annee = (UtilisateurConnect)super.find(propertyName, entityID);
	    UtilisateurConnect inscrip = new UtilisateurConnect(annee);
	    UserEducation user = new UserEducation(annee.getCompte());
	    inscrip.setCompte(user);
	    for (Responsabilite serv : annee.getResponsable()) {
	      inscrip.getResponsable().add(new Responsabilite(serv));
	    }
	    
	    return inscrip;
	  }
	  

	  public List<UtilisateurConnect> findAll()
	  {
	    List<UtilisateurConnect> datas = super.findAll();
	    List<UtilisateurConnect> result = new ArrayList<UtilisateurConnect>();
	    for (UtilisateurConnect elev : datas) {
	      UserEducation user = new UserEducation(elev.getCompte());
	      elev.setCompte(user);
	      result.add(new UtilisateurConnect(elev));
	    }
	    return result;
	  }
	  


	  public UtilisateurConnect delete(Long id)
	  {
	    UtilisateurConnect annee = (UtilisateurConnect)super.delete(id);
	    return new UtilisateurConnect(annee);
	  }
	  
	  public UtilisateurConnect getUserByAcompte(Long userid)
	  {
	    RestrictionsContainer container = RestrictionsContainer.newInstance();
	    container.addEq("compte.id", userid);
	    List<UtilisateurConnect> users = filter(container.getPredicats(), null, null, 0, -1);
	    if ((users == null) || (users.isEmpty()))
	      return null;
	    return (UtilisateurConnect)users.get(0);
	  }
}
