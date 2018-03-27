
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
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.BulletinPaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.BulletinPaieManagerRemote;
import com.keren.kerenpaie.core.ifaces.paie.CacheMemory;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;
import com.keren.kerenpaie.model.paie.LigneElementVariable;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BulletinPaieManager")
public class BulletinPaieManagerImpl
    extends AbstractGenericManager<BulletinPaie, Long>
    implements BulletinPaieManagerLocal, BulletinPaieManagerRemote
{

    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal dao;

    public BulletinPaieManagerImpl() {
    }

    @Override
    public GenericDAO<BulletinPaie, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public BulletinPaie delete(Long id) {
		// TODO Auto-generated method stub
		BulletinPaie bulletin = super.delete(id);
		return new BulletinPaie(bulletin);
	}

	@Override
	public List<BulletinPaie> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		PeriodePaie periode = CacheMemory.getPeriode();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("periode", periode);
		predicats.addAll(container.getPredicats());
		List<BulletinPaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<BulletinPaie> result = new ArrayList<BulletinPaie>();
		for(BulletinPaie data:datas){
			result.add(new BulletinPaie(data));
		}
		return result;
	}

	@Override
	public BulletinPaie find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		BulletinPaie data = super.find(propertyName, entityID);
		BulletinPaie result = new BulletinPaie(data);
		for(LigneBulletinPaie ligne:data.getLignes()){
			result.getLignes().add(new LigneBulletinPaie(ligne));
		}//end for(LigneBulletinPaie ligne:data.getLignes())
		for(LigneElementVariable ligne:data.getVariables()){
			result.getVariables().add(new LigneElementVariable(ligne));
		}//end for(LigneElementVariable ligne:data.getVariables())
		return result;
	}

	@Override
	public List<BulletinPaie> findAll() {
		// TODO Auto-generated method stub		
		List<BulletinPaie> datas = super.findAll();
		List<BulletinPaie> result = new ArrayList<BulletinPaie>();
		for(BulletinPaie data:datas){
			result.add(new BulletinPaie(data));
		}
		return result;
	}
    
    

}
