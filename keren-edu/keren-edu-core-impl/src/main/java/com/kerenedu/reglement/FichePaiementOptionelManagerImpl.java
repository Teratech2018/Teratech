
package com.kerenedu.reglement;

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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "FichePaiementOptionelManager")
public class FichePaiementOptionelManagerImpl extends AbstractGenericManager<FichePaiementOptionel, Long>
		implements FichePaiementOptionelManagerLocal, FichePaiementOptionelManagerRemote {

	@EJB(name = "FichePaiementOptionelDAO")
	protected FichePaiementOptionelDAOLocal dao;

	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal daoins;

	@EJB(name = "FichePaiementDAO")
	protected FichePaiementDAOLocal daofiche;

	public FichePaiementOptionelManagerImpl() {
	}

	@Override
	public GenericDAO<FichePaiementOptionel, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<FichePaiementOptionel> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		// predicats.addAll(CacheMemory.defaultPredicatsCycle());
		List<FichePaiementOptionel> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<FichePaiementOptionel> result = new ArrayList<FichePaiementOptionel>();
		for (FichePaiementOptionel elev : datas) {
			result.add(new FichePaiementOptionel(elev));
		}
		return result;
	}

	@Override
	public FichePaiementOptionel save(FichePaiementOptionel entity) {
		Inscription insc = daoins.findByPrimaryKey("id", entity.getEleve().getId());
		entity.setAnneScolaire(insc.getAnneScolaire());
		return super.save(entity);
	}

	@Override
	public void processAfterSave(FichePaiementOptionel entity) {
		Inscription insc = daoins.findByPrimaryKey("id", entity.getEleve().getId());
		FichePaiementOptionel fpopt = dao.findByPrimaryKey("id", entity.getId());

		// recherche fiche paiements
		FichePaiement fp = new FichePaiement();
		List<FichePaiement> datas = insc.getService();
		for (FichePaiement fiche : datas) {
			if (fiche.getService().getId() == entity.getService().getId()) {
				fp = fiche;
				break;
			}
		}

		if (fp != null && fp.getId() > 0) {
			fp.addMontantopt(entity.getMntpayer());
			fp.addTotalopt(entity.getZtotal());
			fp.addQteopt(entity.getzQte());
			fp.addMontanthtopt(entity.getzMntHt());
		} else {
			fp = new FichePaiement(fpopt);

		}
		fp.setAnneScolaire(insc.getAnneScolaire());
		insc.getService().add(fp);
		daoins.update(insc.getId(), insc);

		super.processAfterSave(entity);
	}

	@Override
	public void processAfterUpdate(FichePaiementOptionel entity) {
		Inscription insc = daoins.findByPrimaryKey("id", entity.getEleve().getId());
		FichePaiementOptionel fpopt = dao.findByPrimaryKey("id", entity.getId());
		FichePaiement fp = new FichePaiement(fpopt);
		System.out.println(
				"FichePaiementOptionelManagerImpl.processAfterUpdate() size before " + insc.getService().size());
		insc.getService().add(fp);
		daoins.update(insc.getId(), insc);
		System.out.println(
				"FichePaiementOptionelManagerImpl.processAfterUpdate() size after " + insc.getService().size());
		super.processAfterUpdate(entity);
	}

	@Override
	public FichePaiementOptionel update(Long id, FichePaiementOptionel entity) {
		Inscription insc = daoins.findByPrimaryKey("id", entity.getEleve().getId());
		FichePaiement fp = new FichePaiement(entity);
		insc.getService().add(fp);
		daoins.update(insc.getId(), insc);
		return super.update(id, entity);

	}

	@Override
	public void processBeforeDelete(FichePaiementOptionel entity) {
		Inscription insc = daoins.findByPrimaryKey("id", entity.getEleve().getId());
		FichePaiementOptionel fpopt = dao.findByPrimaryKey("id", entity.getId());

		// recherche fiche paiements
		FichePaiement fp = new FichePaiement();
		List<FichePaiement> datas = insc.getService();
		for (FichePaiement fiche : datas) {
			if (fiche.getService().getId() == entity.getService().getId()) {
				fp = fiche;
				break;
			}
		}

		if (fp != null && fp.getId() > 0) {
			fp.subMontantopt(entity.getMntpayer());
			fp.subTotalopt(entity.getZtotal());
			fp.subQteopt(entity.getzQte());
			fp.subMontanthtopt(entity.getzMntHt());
			insc.getService().add(fp);
			daoins.update(insc.getId(), insc);
		}
		super.processBeforeDelete(entity);
	}

	@Override
	public void processBeforeSave(FichePaiementOptionel entity) {

		super.processBeforeSave(entity);
	}

	@Override
	public FichePaiementOptionel find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		FichePaiementOptionel elev = super.find(propertyName, entityID);
		FichePaiementOptionel inscrip = new FichePaiementOptionel(elev);
		// for(Eleve serv: elev.getElevelist()){
		// inscrip.getElevelist().add(new Eleve(serv));
		// }
		return inscrip;
	}

	@Override
	public List<FichePaiementOptionel> findAll() {
		// TODO Auto-generated method stub
		// RestrictionsContainer container =
		// RestrictionsContainer.newInstance();
		// container.getPredicats().addAll(CacheMemory.defaultPredicatsCycle());
		List<FichePaiementOptionel> datas = super.findAll();
		List<FichePaiementOptionel> result = new ArrayList<FichePaiementOptionel>();
		for (FichePaiementOptionel elev : datas) {
			result.add(new FichePaiementOptionel(elev));
		}
		return result;
	}

	@Override
	public FichePaiementOptionel delete(Long id) {
		// TODO Auto-generated method stub
		FichePaiementOptionel elev = super.delete(id);
		return new FichePaiementOptionel(elev);
	}

}
