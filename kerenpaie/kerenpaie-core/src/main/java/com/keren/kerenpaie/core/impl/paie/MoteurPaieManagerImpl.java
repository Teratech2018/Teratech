
package com.keren.kerenpaie.core.impl.paie;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.commons.DateHelper;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ConvensionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ProfilPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.RubriqueDAOLocal;
import com.keren.kerenpaie.model.employes.ContratTravail;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.employes.Famille;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.Convension;
import com.keren.kerenpaie.model.paie.ForfaitCategorie;
import com.keren.kerenpaie.model.paie.ForfaitCategorieProf;
import com.keren.kerenpaie.model.paie.ForfaitSpecialite;
import com.keren.kerenpaie.model.paie.LigneConvension;
import com.keren.kerenpaie.model.paie.ProfilPaie;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.paie.Variable;

@TransactionAttribute
@Stateless(mappedName = "BulletinPaieManager")
public class MoteurPaieManagerImpl
    extends AbstractGenericManager<BulletinPaie, Long>
    implements MoteurPaieManagerLocal, MoteurPaieManagerRemote
{

    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal dao;
    
    @EJB(name = "RubriqueDAO")
    protected RubriqueDAOLocal rubriquedao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;
    
    @EJB(name = "ProfilPaieDAO")
    protected ProfilPaieDAOLocal profildao;
    
    @EJB(name = "ConvensionDAO")
    protected ConvensionDAOLocal convensiondao;
    
    

    public MoteurPaieManagerImpl() {
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
	public Double eval(Rubrique rubrique, Employe salarie) {
		// TODO Auto-generated method stub
		if(rubrique.getMode().trim().equalsIgnoreCase("0")){
			return evalCategorieProf(rubrique, salarie);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("1")){
			return evalCategorie(rubrique, salarie);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("2")){
			return evalSpecialites(rubrique, salarie);
		}
		return null;
	}

	@Override
	public Double eval(Variable variable, Employe salarie) {
		// TODO Auto-generated method stub
		if(variable.getMethodcal().trim().equalsIgnoreCase("1")){
			return eval(variable.getCode(), salarie);
		}//end if(variable.getMethodcal().trim().equalsIgnoreCase("1"))
		//Cas des constante
		if(variable.getMethodcal().trim().equalsIgnoreCase("0")){
			return Double.parseDouble(variable.getFormule());
		}//end if(variable.getMethodcal().trim().equalsIgnoreCase("0"))
		//Cas de formule		
		return null;
	}
	
	/**
	 * 
	 * @param codeVar:Code de la variable
	 * @param salarie
	 * @return
	 */
	private  Double eval(String codeVar,Employe salarie){
		Double valeur = 0.0;
		
		if(codeVar.trim().equalsIgnoreCase("SALCATEGO")){
			return salaireCategoriel(salarie);
		}else if(codeVar.trim().equalsIgnoreCase("ANCIEN")){
			
		}else if(codeVar.trim().equalsIgnoreCase("SALBASE")){
			
		}else if(codeVar.trim().equalsIgnoreCase("SBB")){
			
		}else if(codeVar.trim().equalsIgnoreCase("SALCO")){
			
		}else if(codeVar.trim().equalsIgnoreCase("SALTAX")){
			
		}else if(codeVar.trim().equalsIgnoreCase("ABSENCE")){
			
		}else if(codeVar.trim().equalsIgnoreCase("CONGE")){
			
		}else if(codeVar.trim().equalsIgnoreCase("SALBA")){
			
		}else if(codeVar.trim().equalsIgnoreCase("NBENFT21")){
			Double value = 0.0;
			for(Famille fam : salarie.getFamilles()){
			   if(fam.getEligible()==Boolean.TRUE){
				   value  +=1;
			   }//end if(fam.getEligible()==Boolean.TRUE)
			}//end for(Famille fam : salarie.getFamilles()){
			return value;
		}else if(codeVar.trim().equalsIgnoreCase("VEHICULE")){
			if(salarie.getVehicule()==Boolean.TRUE){
				return 1.0;
			}else {
				return 0.0;
			}//end if(salarie.getVehicule()==Boolean.TRUE)
		}else if(codeVar.trim().equalsIgnoreCase("LOGE")){
			return salarie.getLogement()==Boolean.FALSE ? 0.0 : 1.0;
		}else if(codeVar.trim().equalsIgnoreCase("ANCGELE")){
			return salarie.getAnciennitegele();
		}else if(codeVar.trim().equalsIgnoreCase("COMPSAL")){
			
		}else if(codeVar.trim().equalsIgnoreCase("SYNDIQUE")){
			if(salarie.getSyndique()==Boolean.TRUE){
				return 1.0;
			}else {
				return 0.0;
			}
		}else if(codeVar.trim().equalsIgnoreCase("TYPAGEN")){
			return Double.parseDouble(salarie.getStatut());
		}
		return valeur;
	}

	/**
	 * Calcul du salaire catégoriel
	 * @param salarie
	 * @return
	 */
	private Double salaireCategoriel(Employe salarie){
		Double valeur = 0.0;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Convension> convensions = convensiondao.filter(container.getPredicats(), null, null, 0, -1);
		Convension convension=null;
		for(Convension conven:convensions){
			if(conven.getState().trim().equalsIgnoreCase("actif")){
				convension = conven;
			}//end if(conven.getState().trim().equalsIgnoreCase("actif"))
		}//end for(Convension conven:convensions){
		for(LigneConvension ligne:convension.getLignes()){
			if(ligne.getCategorie().compareTo(salarie.getCategorie())==0
					&& ligne.getEchelon().compareTo(salarie.getEchelon())==0){
				return ligne.getSalbase();
			}//end if(ligne.getCategorie().compareTo(salarie.getCategorie())==0
		}//end for(LigneConvension ligne:convension.getLignes()){
		return valeur;
	}
	/**
	 * Evaluation sur la base de la categorie 
	 * @param rubrique
	 * @param salarie
	 * @return
	 */
	private Double evalCategorie(Rubrique rubrique, Employe salarie){
		Double valeur = 0.0;
		//Recherche du dernier contrat en cours de l'employé
		salarie = employedao.findByPrimaryKey("id", salarie.getId());
		ContratTravail contrat = null;
		for(ContratTravail c:salarie.getContrats()){
			if(c.getState().equalsIgnoreCase("confirme")){
				contrat = c;
			}
		}//end for(ContratTravail c:salarie.getContrats()){
		//Traitement des categorie
		rubrique = rubriquedao.findByPrimaryKey("id", rubrique.getId());
		for(ForfaitCategorie forfait:rubrique.getForfaitscat()){
			if(forfait.getCategorie().compareTo(contrat.getCategorie())==0){
				valeur = forfait.getValeur();
			}
		}//end for(ForfaitCategorie forfait:rubrique.getForfaitscat())
		return valeur;
	}
	
	/**
	 * Evaluation sur la base de la categorie Professionnel
	 * @param rubrique
	 * @param salarie
	 * @return
	 */
	private Double evalCategorieProf(Rubrique rubrique, Employe salarie){
		Double valeur = 0.0;
		rubrique = rubriquedao.findByPrimaryKey("id", rubrique.getId());
		for(ForfaitCategorieProf forfait:rubrique.getForfaitscatprof()){
			if(forfait.getCategorie().compareTo(salarie.getFonction())==0){
				valeur = forfait.getValeur();
			}
		}//end for(ForfaitCategorie forfait:rubrique.getForfaitscat())
		return valeur;
	}

	/**
	 * 
	 * @param rubrique
	 * @param salarie
	 * @return
	 */
	private Double evalSpecialites(Rubrique rubrique, Employe salarie){
		Double valeur = 0.0;
		rubrique = rubriquedao.findByPrimaryKey("id", rubrique.getId());
		for(ForfaitSpecialite forfait:rubrique.getForfaitsspe()){
			if(forfait.getCategorie().compareTo(salarie.getSpecialite())==0){
				valeur = forfait.getValeur();
			}
		}//end for(ForfaitCategorie forfait:rubrique.getForfaitscat())
		return valeur;
	}
}
