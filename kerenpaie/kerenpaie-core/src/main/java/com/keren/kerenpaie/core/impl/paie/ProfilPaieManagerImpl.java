
package com.keren.kerenpaie.core.impl.paie;

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
import com.keren.kerenpaie.core.ifaces.paie.ProfilPaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.ProfilPaieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.paie.ProfilPaieDAOLocal;
import com.keren.kerenpaie.model.paie.ProfilPaie;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ProfilPaieManager")
public class ProfilPaieManagerImpl
    extends AbstractGenericManager<ProfilPaie, Long>
    implements ProfilPaieManagerLocal, ProfilPaieManagerRemote
{

    @EJB(name = "ProfilPaieDAO")
    protected ProfilPaieDAOLocal dao;

    public ProfilPaieManagerImpl() {
    }

    @Override
    public GenericDAO<ProfilPaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public ProfilPaie delete(Long id) {
		// TODO Auto-generated method stub
		ProfilPaie data = super.delete(id);
		return new ProfilPaie(data);
	}

	@Override
	public List<ProfilPaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ProfilPaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ProfilPaie> result = new ArrayList<ProfilPaie>();
		for(ProfilPaie data:datas){
			result.add(new ProfilPaie(data));
		}
		return result;
	}

	@Override
	public ProfilPaie find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ProfilPaie data = super.find(propertyName, entityID);
		ProfilPaie result = new ProfilPaie(data);
		for(Rubrique rebrique:data.getRubriques()){
			result.getRubriques().add(new Rubrique(rebrique));
		}
		return result;
	}

	@Override
	public List<ProfilPaie> findAll() {
		// TODO Auto-generated method stub		
		List<ProfilPaie> datas = super.findAll();
		List<ProfilPaie> result = new ArrayList<ProfilPaie>();
		for(ProfilPaie data:datas){
			result.add(new ProfilPaie(data));
		}
		return result;
	}
    
    

}
