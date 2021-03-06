
package com.kerenedu.core.impl.report;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.DateHelper;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.core.ifaces.report.ViewBilanServiceEleveManagerLocal;
import com.kerenedu.core.ifaces.report.ViewBilanServiceEleveManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewBilanServiceEleveDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.kerenedu.model.report.ViewBilanServiceEleve;
import com.kerenedu.model.report.ViewBilanServiceModal;
import com.kerenedu.model.report.ViewCouponsInformation;
import com.kerenedu.model.report.ViewRetardPaiement;

@TransactionAttribute
@Stateless(mappedName = "ViewBilanServiceEleveManager")
public class ViewBilanServiceEleveManagerImpl extends AbstractGenericManager<ViewBilanServiceEleve, Long>
		implements ViewBilanServiceEleveManagerLocal, ViewBilanServiceEleveManagerRemote {

	@EJB(name = "ViewBilanServiceEleveDAO")
	protected ViewBilanServiceEleveDAOLocal dao;

	@EJB(name = "AnneScolaireDAO")
	protected AnneScolaireDAOLocal daoanne;

	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal daoins;

	public ViewBilanServiceEleveManagerImpl() {
	}

	@Override
	public GenericDAO<ViewBilanServiceEleve, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<ViewBilanServiceEleve> getCriteres(ViewBilanServiceModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		String annescolaire = "";
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
			if (critere.getAnnee() != null) {
				annescolaire = critere.getAnnee().getCode();
			} else {
				container = RestrictionsContainer.newInstance();
				container.addEq("connected", true);
				List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
				annescolaire = annee.get(0).getCode();
			}
			System.out.println("ViewBilanServiceEleveManagerImpl.getCriteresRetard() annee"+annescolaire);
			container = RestrictionsContainer.newInstance();
			if (critere.getClasse() != null) {
				container.addEq("eleve.classe.id", critere.getClasse().getId());

			}
			if (critere.getService() != null) {
				container.addEq("fiche.service.id", critere.getService().getId());

			}
			container.addEq("eleve.anneScolaire", annescolaire);
			if (critere.getStatut() != null) {
				Boolean value = false;
				if (critere.getStatut().equals("0")) {
					value = true;
					container.addEq("fiche.payer", value);
				} else if (critere.getStatut().equals("1")) {
					value = false;
					container.addEq("fiche.payer", value);
				}

			}

		}
		List<ViewBilanServiceEleve> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewBilanServiceEleve> result = new ArrayList<ViewBilanServiceEleve>();
		if (datas != null) {
			for (ViewBilanServiceEleve aniv : datas) {
				;
				result.add(new ViewBilanServiceEleve(aniv));
			}
		} // fin if(datas!=null)
		return result;
	}

	@Override
	public List<ViewBilanServiceEleve> getCriteres(ViewCouponsInformation critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		String annescolaire = "";
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
			
			container.addEq("connected", true);
			List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
			annescolaire = annee.get(0).getCode();
			container = RestrictionsContainer.newInstance();
			if (critere.getFiliere() != null) {
				container.addEq("eleve.classe.filiere.id", critere.getFiliere().getId());

			}
			if (critere.getService() != null) {
				container.addEq("fiche.service.id", critere.getService().getId());

			}

			container.addLe("fiche.delai", DateHelper.formatDate(new Date()));
			container.addLe("fiche.payer", false);
			container.addEq("eleve.anneScolaire", annescolaire);

		}
		List<ViewBilanServiceEleve> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewBilanServiceEleve> result = new ArrayList<ViewBilanServiceEleve>();
		if (datas != null) {
			for (ViewBilanServiceEleve aniv : datas) {
				;
				result.add(new ViewBilanServiceEleve(aniv));
			}
		} // fin if(datas!=null)
		return result;
	}

	@Override
	public List<ViewBilanServiceEleve> getCriteresRetard(ViewRetardPaiement critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		String annescolaire = "";
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
			if (critere.getAnnee() != null) {
				annescolaire = critere.getAnnee().getCode();
			} else {
				container = RestrictionsContainer.newInstance();
				container.addEq("connected", true);
				List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
				annescolaire = annee.get(0).getCode();
			}
			System.out.println("ViewBilanServiceEleveManagerImpl.getCriteresRetard() annee"+annescolaire);
			container = RestrictionsContainer.newInstance();
			if (critere.getClasse() != null) {
				container.addEq("eleve.classe.id", critere.getClasse().getId());

			}
			if (critere.getService() != null) {
				container.addEq("fiche.service.id", critere.getService().getId());

			}

			Boolean value = false;
			container.addEq("fiche.payer", value);
			container.addLe("fiche.delai", DateHelper.formatDate(new Date()));
			container.addEq("eleve.anneScolaire", annescolaire);

		}
		List<ViewBilanServiceEleve> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<ViewBilanServiceEleve> result = new ArrayList<ViewBilanServiceEleve>();
		if (datas != null) {
			for (ViewBilanServiceEleve aniv : datas) {
				;
				result.add(new ViewBilanServiceEleve(aniv));
			}
		} // fin if(datas!=null)
		return result;
	}

	@Override
	public List<Inscription> getCriteresinscrit(ViewCouponsInformation critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		String annescolaire = "";
		if (critere != null) {
			container = RestrictionsContainer.newInstance();
				
				container.addEq("connected", true);
				List<AnneScolaire> annee = daoanne.filter(container.getPredicats(), null, null, 0, -1);
				annescolaire = annee.get(0).getCode();
				container = RestrictionsContainer.newInstance();

			if (critere.getFiliere() != null) {
				container.addEq("classe.filiere.id", critere.getFiliere().getId());

			}
			container.addEq("anneScolaire",annescolaire);
			/*
			 * if (critere.getService() != null) {
			 * container.addEq("fiche.service.id",
			 * critere.getService().getId());
			 * 
			 * }
			 * 
			 * Boolean value = false; container.addEq("fiche.payer", value);
			 * container.addLe("fiche.delai", DateHelper.formatDate(new
			 * Date()));
			 */

		}
		List<Inscription> datas = daoins.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<Inscription> result = new ArrayList<Inscription>();

		return datas;
	}

}
