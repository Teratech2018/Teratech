
package com.kerenedu.solde;

import java.util.ArrayList;
import java.util.Date;
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
import com.kerenedu.model.report.EdtMasseSalModal;
import com.kerenedu.model.report.EdtPeriodeModal;
import com.kerenedu.model.report.ViewPeriodeModal;
import com.kerenedu.model.report.ViewRetenueModal;
import com.kerenedu.personnel.ProfesseurChoice;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BulletinPaieManager")
public class BulletinPaieManagerImpl
    extends AbstractGenericManager<BulletinPaie, Long>
    implements BulletinPaieManagerLocal, BulletinPaieManagerRemote
{

    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal dao;
    
    @EJB(name = "AcompteDAO")
    protected AcompteDAOLocal daoacompte;
    
    @EJB(name = "RemboursementPretDAO")
    protected RemboursementPretDAOLocal daoarem;
    
    @EJB(name = "DemandePretDAO")
    protected DemandePretDAOLocal daoapret;

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
//		PeriodePaie periode = CacheMemory.getPeriodepaie();
//		RestrictionsContainer container = RestrictionsContainer.newInstance();
//		if (periode != null) {
//			container.addEq("periode", periode);
//		} // end if(periode!=null)
//		predicats.addAll(container.getPredicats());
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
			//if(ligne.getValeur()!=0){
				result.getLignes().add(new LigneBulletinPaie(ligne));	
			//} // end if(ligne.getValeur()!=0)
		} // end for(LigneBulletinPaie ligne:data.getLignes())
//		for (LigneElementVariable ligne : data.getVariables()) {
//			result.getVariables().add(new LigneElementVariable(ligne));
//		} // end for(LigneElementVariable ligne:data.getVariables())
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
//				for (LigneElementVariable ligne : result.getVariables()) {
//					data.getVariables().add(new LigneElementVariable(ligne));
//				} // end for(LigneElementVariable ligne:data.getVariables())

				records.add(data);
			}

		return records;
	}
	
	@Override
	public List<BulletinPaie> getCriteres(EdtPeriodeModal critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
		List<BulletinPaie> records = new ArrayList<BulletinPaie>();
		
		if(critere.getPorte().equals("0")){// tous les employes
			if (critere != null) {
				container = RestrictionsContainer.newInstance();
				if (critere.getPeriode() != null) {
					container.addEq("periode.id", critere.getPeriode().getId());
				}
				  container.addNotEq("employe.state", "descativer");
			}
			datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
			
		}else if(critere.getPorte().equals("1")){ // employes select
			for(ProfesseurChoice pc : critere.getConcernes()){
				container = RestrictionsContainer.newInstance();
				container.addEq("periode.id", critere.getPeriode().getId());
				container.addEq("employe.id", pc.getId());
				container.addNotEq("employe.state", "descativer");
				records = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
				datas.addAll(records);
			}
			
		}
			for (BulletinPaie b : datas) {
				BulletinPaie result =  super.find("id", b.getId());
				BulletinPaie data = new BulletinPaie(result);
				for (LigneBulletinPaie ligne : result.getLignes()) {
					data.getLignes().add(new LigneBulletinPaie(ligne));
				} // end for(LigneBulletinPaie ligne:data.getLignes())

				records.add(data);
			}

		return records;
	}

	@Override
	public void validerSalaire(TraitSalaire entity) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
		container = RestrictionsContainer.newInstance();
		container.addEq("periode.id", entity.getPeriode().getId());
		container.addNotEq("employe.state", "desactiver");
		datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		
		if(datas!=null&&!datas.isEmpty()&&datas.size()!=0){
			for(BulletinPaie bp : datas){
				BulletinPaie bulletin = dao.findByPrimaryKey("id", bp.getId());
				bulletin.setState("paye");
				bulletin.setDpayement(new Date());;
				dao.update(bulletin.getId(), bulletin);
				// mis a jour des acompte 
				PeriodePaie periode = entity.getPeriode();
				container = RestrictionsContainer.newInstance();
				container.addGe("effet",periode.getDdebut());
				container.addLe("effet",periode.getDfin());
				container.addNotEq("state", "annule");
				container.addEq("employe.id",bulletin.getEmploye().getId() );
				List<Acompte> acomptelist= daoacompte.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				if(acomptelist!=null&&!acomptelist.isEmpty()){
					for(Acompte acompte : acomptelist){
						acompte.setState("paye");
						daoacompte.update(acompte.getId(), acompte);
					}
				}
				
				// mis à jour des remboursements
				container = RestrictionsContainer.newInstance();
				container.addGe("date",periode.getDdebut());
				container.addLe("date",periode.getDfin());
				container.addEq("demande.employe.id",bulletin.getEmploye().getId() );
				container.addNotEq("state", "anulle");	
				List<RemboursementPret> remlist = daoarem.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
				if(remlist!=null&&!remlist.isEmpty()){
					for(RemboursementPret rem : remlist){
						DemandePret ddepret = rem.getDemande();
						rem.setState("paye");
						if(ddepret.getMontantRem()==null){ddepret.setMontantRem((double) 0);}
						double liquide = ddepret.getMontantRem()+rem.getMontant();
						ddepret.setMontantRem(liquide);
						ddepret.setSolde(ddepret.getMontantsol()-liquide);
						if(liquide==ddepret.getMontantsol()){
							ddepret.setState("termine");
						}else{
							ddepret.setState("encours");
						}
						daoarem.update(rem.getId(), rem);
						daoapret.update(ddepret.getId(), ddepret);
					}
				}
			}
		}
		
	}

	@Override
	public List<BulletinPaie> getCriteres(ViewPeriodeModal critere) {
		// To change body of generated methods, choose Tools | Templates.
				RestrictionsContainer container = RestrictionsContainer.newInstance();
				List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
				List<BulletinPaie> records = new ArrayList<BulletinPaie>();
				container = RestrictionsContainer.newInstance();
				  if (critere.getPeriode() != null) {
					container.addEq("periode.id", critere.getPeriode().getId());
					}
				  if(critere.getTypereport()!=null){
					  container.addEq("employe.modePaiement", critere.getTypereport());
				  }
				  container.addNotEq("employe.state", "desactiver");
				  datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
					
				for (BulletinPaie b : datas) {
						BulletinPaie result =  super.find("id", b.getId());
						BulletinPaie data = new BulletinPaie(result);
						for (LigneBulletinPaie ligne : result.getLignes()) {
							data.getLignes().add(new LigneBulletinPaie(ligne));
						} // end for(LigneBulletinPaie ligne:data.getLignes())

						records.add(data);
					}

				return records;
	}
	
	@Override
	public List<BulletinPaie> getCriteres(EdtMasseSalModal critere) {
		// To change body of generated methods, choose Tools | Templates.
				RestrictionsContainer container = RestrictionsContainer.newInstance();
				List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
				List<BulletinPaie> records = new ArrayList<BulletinPaie>();
				container = RestrictionsContainer.newInstance();
				  if (critere.getPeriode() != null) {
					container.addEq("periode.id", critere.getPeriode().getId());
					}
				  container.addNotEq("employe.state", "desactiver");
				  datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
					
//				for (BulletinPaie b : datas) {
//						BulletinPaie result =  super.find("id", b.getId());
//						BulletinPaie data = new BulletinPaie(result);
//						for (LigneBulletinPaie ligne : result.getLignes()) {
//							data.getLignes().add(new LigneBulletinPaie(ligne));
//						} // end for(LigneBulletinPaie ligne:data.getLignes())
//
//						records.add(data);
//					}

				return datas;
	}
	
	@Override
	public List<BulletinPaie> getCriteres(ViewRetenueModal critere, String value) {
		// To change body of generated methods, choose Tools | Templates.
				RestrictionsContainer container = RestrictionsContainer.newInstance();
				List<BulletinPaie> datas = new ArrayList<BulletinPaie>();
				List<BulletinPaie> records = new ArrayList<BulletinPaie>();
				container = RestrictionsContainer.newInstance();
				if (critere != null) {
					container = RestrictionsContainer.newInstance();
					if (critere.getAnnee() != null) {
						container.addEq("anneeScolaire", critere.getAnnee().getId());
					}
				}
				if(value.equals("logement")){
					container.addNotEq("loyer", 0);
				}
				if(value.equals("amicale")){
					container.addNotEq("amical", 0);
				}
				if(value.equals("cnps")){
					container.addNotEq("allocation", 0);
				}
				 datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
				return datas;
	}
}
