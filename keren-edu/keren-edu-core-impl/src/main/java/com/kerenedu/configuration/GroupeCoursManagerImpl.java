
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
@Stateless(mappedName = "GroupeCoursManager")
public class GroupeCoursManagerImpl
    extends AbstractGenericManager<GroupeCours, Long>
    implements GroupeCoursManagerLocal, GroupeCoursManagerRemote
{

    @EJB(name = "GroupeCoursDAO")
    protected GroupeCoursDAOLocal dao;

    public GroupeCoursManagerImpl() {
    }

    @Override
    public GenericDAO<GroupeCours, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
 	public List<GroupeCours> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
 			int firstResult, int maxResult) {
 		// TODO Auto-generated method stub
 		List<GroupeCours> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
 		List<GroupeCours> result = new ArrayList<GroupeCours>();
 		for(GroupeCours elev:datas){
 			result.add(new GroupeCours(elev));
 		}
 		return result;
 	}

 	@Override
 	public GroupeCours find(String propertyName, Long entityID) {
 		// TODO Auto-generated method stub
 		GroupeCours elev = super.find(propertyName, entityID);
 		GroupeCours inscrip = new GroupeCours(elev);
 		for( MatiereDlt matiere :elev.getMatiereList()){
 			inscrip.getMatiereList().add(new MatiereDlt(matiere));
 		}
 		return inscrip;
 	}

 	@Override
 	public List<GroupeCours> findAll() {
 		// TODO Auto-generated method stub
 		List<GroupeCours> datas = super.findAll();
 		List<GroupeCours> result = new ArrayList<GroupeCours>();
 		for(GroupeCours elev:datas){
 			result.add(new GroupeCours(elev));
 		}
 		return result;
 	}
 	
 	

 	@Override
 	public GroupeCours delete(Long id) {
 		// TODO Auto-generated method stub
 		GroupeCours elev = super.delete(id);
 		return new GroupeCours(elev);
 	}

 
 	
}
