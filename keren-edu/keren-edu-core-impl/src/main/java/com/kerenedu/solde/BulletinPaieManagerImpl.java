
package com.kerenedu.solde;

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
		PeriodePaie periode = CacheMemory.getPeriodepaie();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (periode != null) {
			container.addEq("periode", periode);
		} // end if(periode!=null)
		predicats.addAll(container.getPredicats());
		List<BulletinPaie> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<BulletinPaie> result = new ArrayList<BulletinPaie>();
		for (BulletinPaie data : datas) {
			result.add(new BulletinPaie(data));
		}
		return result;
	}

	@Override
	public BulletinPaie find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		BulletinPaie data = super.find(propertyName, entityID);
		BulletinPaie result = new BulletinPaie(data);
		for (LigneBulletinPaie ligne : data.getLignes()) {
			if(ligne.getValeur()!=0){
				result.getLignes().add(new LigneBulletinPaie(ligne));	
			} // end if(ligne.getValeur()!=0)
		} // end for(LigneBulletinPaie ligne:data.getLignes())
		for (LigneElementVariable ligne : data.getVariables()) {
			result.getVariables().add(new LigneElementVariable(ligne));
		} // end for(LigneElementVariable ligne:data.getVariables())
		return result;
	}

	@Override
	public List<BulletinPaie> findAll() {
		// TODO Auto-generated method stub
		List<BulletinPaie> datas = super.findAll();
		List<BulletinPaie> result = new ArrayList<BulletinPaie>();
		for (BulletinPaie data : datas) {
			result.add(new BulletinPaie(data));
		}
		return result;
	}

//	@Override
//	public List<BulletinPaie> getCriteres(BPaie critere) {
//		// To change body of generated methods, choose Tools | Templates.
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
//		List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
//		List<BulletinPaie> records = new ArrayList<>();
//		if (critere != null) {
//
//			critere.setPeriode(CacheMemory.getPeriode());
//			if (critere.getPeriode() != null) {
//				container.addEq("periode.id", critere.getPeriode().getId());
//			}
//			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
//
//			for (BulletinPaie b : datas) {
//				BulletinPaie result =  super.find("id", b.getId());
//				BulletinPaie data = new BulletinPaie(result);
//				for (LigneBulletinPaie ligne : result.getLignes()) {
//					data.getLignes().add(new LigneBulletinPaie(ligne));
//				} // end for(LigneBulletinPaie ligne:data.getLignes())
//				for (LigneElementVariable ligne : result.getVariables()) {
//					data.getVariables().add(new LigneElementVariable(ligne));
//				} // end for(LigneElementVariable ligne:data.getVariables())
//
//				records.add(data);
//			}
//		}
//
//		return records;
//	}
	
	@Override
	public List<BulletinPaie> getCriteres(BulletinPaie critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
		List<BulletinPaie> records = new ArrayList<BulletinPaie>();
		if (critere != null) {

			critere.setPeriode(CacheMemory.getPeriodepaie());
			if (critere.getPeriode() != null) {
				container.addEq("periode.id", critere.getPeriode().getId());
			}
		}
			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);

			for (BulletinPaie b : datas) {
				BulletinPaie result =  super.find("id", b.getId());
				BulletinPaie data = new BulletinPaie(result);
				for (LigneBulletinPaie ligne : result.getLignes()) {
					data.getLignes().add(new LigneBulletinPaie(ligne));
				} // end for(LigneBulletinPaie ligne:data.getLignes())
				for (LigneElementVariable ligne : result.getVariables()) {
					data.getVariables().add(new LigneElementVariable(ligne));
				} // end for(LigneElementVariable ligne:data.getVariables())

				records.add(data);
			}

		return records;
	}
}
