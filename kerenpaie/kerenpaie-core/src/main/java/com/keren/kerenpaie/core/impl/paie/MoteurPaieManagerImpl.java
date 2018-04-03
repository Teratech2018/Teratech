
package com.keren.kerenpaie.core.impl.paie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.commons.DateHelper;
import com.kerem.core.KerenExecption;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.MoteurPaieManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ConvensionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ParametreAvanceDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ProfilPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.RubriqueDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.VariableDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.ContratTravail;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.employes.Famille;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.Convension;
import com.keren.kerenpaie.model.paie.ForfaitCategorie;
import com.keren.kerenpaie.model.paie.ForfaitCategorieProf;
import com.keren.kerenpaie.model.paie.ForfaitSpecialite;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;
import com.keren.kerenpaie.model.paie.LigneConvension;
import com.keren.kerenpaie.model.paie.LigneElementVariable;
import com.keren.kerenpaie.model.paie.LignePonderationSalaire;
import com.keren.kerenpaie.model.paie.LignePonderationTypeContrat;
import com.keren.kerenpaie.model.paie.ParametreAvance;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.paie.Variable;
import com.keren.kerenpaie.tools.KerenPaieManagerException;

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
    
    @EJB(name = "VariableDAO")
    protected VariableDAOLocal variabledao;
    
    @EJB(name = "ParametreAvanceDAO")
    protected ParametreAvanceDAOLocal parametreavancedao;
    
    /**
     * Cache contenant les ligne element variable deja calcule
     */
    private static Map<String , LigneElementVariable> executorCache = new HashMap<String , LigneElementVariable>();

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
	public BulletinPaie eval(BulletinPaie bulletin) {
		// TODO Auto-generated method stub
    	//Salaire de base brut
    	Double salbasebrut = 0.0;
    	//Salaire de base cotisable
    	Double salcot = 0.0;
    	//Salaire de base taxable
    	Double salTaxable = 0.0;
    	//Initialisation du cache
    	executorCache = new HashMap<String , LigneElementVariable>();
    	
		Employe salarie = employedao.findByPrimaryKey("id", bulletin.getEmploye().getId());
		ContratTravail contrat = null;
		//Traitement du contrat de travail
		for(ContratTravail cont:salarie.getContrats()){
			if(cont.getState().trim().equalsIgnoreCase("confirme")){
				contrat = cont;
			}//end if(cont.getState().trim().equalsIgnoreCase("confirme"))
		}//end for(ContratTravail cont:salarie.getContrats())
    	Rubrique rubrique =null;
    	/**
    	 * Phase 1 Traitement des rubriques qui participe au
    	 * 1- SALCO
    	 * 2 - SBB
    	 * 3-SALTAX
    	 */
    	short index = 0;
    	/**
    	 * Calcul des Elements variables
    	 */
    	for(LigneElementVariable ligne:bulletin.getVariables()){
    		if(ligne.getValeur()!=null&&ligne.getValeur().compareTo(0.0)>0){
    			executorCache.put(ligne.getVariable().getCode(), ligne);
    			continue;
    		}//end if(ligne.getValeur().compareTo(0.0)>0){
    		String codeVar = ligne.getVariable().getCode();
    		Double valeur = eval(ligne.getVariable(),salarie,bulletin.getPeriode(),contrat);
	    	ligne.setValeur(valeur);    		
    		executorCache.put(ligne.getVariable().getCode(), ligne);
    	}//end for(LigneElementVariable ligne:bulletin.getVariables())
    	//Traitement des rubrique de type
    	for(LigneBulletinPaie ligne:bulletin.getLignes()){
    		rubrique = ligne.getRubrique();
    		if(ligne.getValeur()!=null&&ligne.getValeur().compareTo(0.0)>0){
    			Double valeur = ligne.getValeur();
    			if(rubrique.getBasetaxablesal()!=null && rubrique.getBasetaxablesal().equals(Boolean.TRUE)){
    				salTaxable += valeur;
    			}//end if(rubrique.getBasetaxablesal().equals(Boolean.TRUE))
    			if(rubrique.getBrutsal()!=null && rubrique.getBrutsal().equals(Boolean.TRUE)){
    				salbasebrut += valeur;
    			}//end if(rubrique.getBrutsal().equals(Boolean.TRUE)){
    			if(rubrique.getCotisablesal()!=null && rubrique.getCotisablesal().equals(Boolean.TRUE)){
    				salcot += valeur;
    			}//end if(rubrique.getCotisablesal().equals(Boolean.TRUE))
    			continue;
    		}//end if(ligne.getValeur().compareTo(0.0)>0){  
    		rubrique = rubriquedao.findByPrimaryKey("id", ligne.getRubrique().getId());
			Double valeur = eval(rubrique,salarie,bulletin.getPeriode(),contrat);
			ligne.setValeur(valeur);	
			//Cummul
			//Cumul
			if(rubrique.getBasetaxablesal()!=null && rubrique.getBasetaxablesal().equals(Boolean.TRUE)){
				salTaxable += valeur;
			}//end if(rubrique.getBasetaxablesal().equals(Boolean.TRUE))
			if(rubrique.getBrutsal()!=null && rubrique.getBrutsal().equals(Boolean.TRUE)){
				salbasebrut += valeur;
			}//end if(rubrique.getBrutsal().equals(Boolean.TRUE)){
			if(rubrique.getCotisablesal()!=null && rubrique.getCotisablesal().equals(Boolean.TRUE)){
				salcot += valeur;
			}//end if(rubrique.getCotisablesal().equals(Boolean.TRUE))
		}//end for(LigneBulletinPaie ligne:bulletin.getLignes())
    	/**
    	 * Mise a jour du SBB SALCO et SALTAX
    	 */
    	executorCache.get("SBB").setValeur(salbasebrut);
    	executorCache.get("SALCO").setValeur(salcot);
    	executorCache.get("SALTAX").setValeur(salTaxable);
    	
    	//Mise a jour du Bulletin
    	bulletin = dao.update(bulletin.getId(), bulletin);
    	return new BulletinPaie(bulletin);
	}
    
    public BulletinPaie eval2(BulletinPaie bulletin) {
		// TODO Auto-generated method stub
    	//Salaire de base brut
    	Double salbasebrut = 0.0;
    	//Salaire de base cotisable
    	Double salcot = 0.0;
    	//Salaire de base taxable
    	Double salTaxable = 0.0;
    	
    	HashMap<String, LigneElementVariable> mapVar = new HashMap<String, LigneElementVariable>();
		Employe salarie = employedao.findByPrimaryKey("id", bulletin.getEmploye().getId());
		ContratTravail contrat = null;
		//Traitement du contrat de travail
		for(ContratTravail cont:salarie.getContrats()){
			if(cont.getState().trim().equalsIgnoreCase("confirme")){
				contrat = cont;
			}//end if(cont.getState().trim().equalsIgnoreCase("confirme"))
		}//end for(ContratTravail cont:salarie.getContrats())
    	Rubrique rubrique =null;
    	/**
    	 * Phase 1 Traitement des rubriques qui participe au
    	 * 1- SALCO
    	 * 2 - SBB
    	 * 3-SALTAX
    	 */
    	//Index des lignes non traiteés
    	List<Short> indexs = new ArrayList<Short>();
    	short index = 0;
    	//Traitement des rubrique de type
    	for(LigneBulletinPaie ligne:bulletin.getLignes()){
    		if(ligne.getValeur()!=null&&ligne.getValeur().compareTo(0.0)>0){
    			continue;
    		}//end if(ligne.getValeur().compareTo(0.0)>0){    			
			rubrique = rubriquedao.findByPrimaryKey("id", ligne.getRubrique().getId());
			if(rubrique.getBasetaxablesal()==Boolean.TRUE
					|| rubrique.getBrutsal()==Boolean.TRUE
					|| rubrique.getCotisablesal()==Boolean.TRUE){
				Double valeur = eval(rubrique,salarie,bulletin.getPeriode(),contrat);
				ligne.setValeur(valeur);
				//Cumul
				if(rubrique.getBasetaxablesal()!=null && rubrique.getBasetaxablesal().equals(Boolean.TRUE)){
					salTaxable += valeur;
				}//end if(rubrique.getBasetaxablesal().equals(Boolean.TRUE))
				if(rubrique.getBrutsal()!=null && rubrique.getBrutsal().equals(Boolean.TRUE)){
					salbasebrut += valeur;
				}//end if(rubrique.getBrutsal().equals(Boolean.TRUE)){
				if(rubrique.getCotisablesal()!=null && rubrique.getCotisablesal().equals(Boolean.TRUE)){
					salcot += valeur;
				}//end if(rubrique.getCotisablesal().equals(Boolean.TRUE))
			}else if(rubrique.getType().equalsIgnoreCase("0")
					||rubrique.getType().equalsIgnoreCase("1")
					||rubrique.getType().equalsIgnoreCase("2")){
				Double valeur = eval(rubrique,salarie,bulletin.getPeriode(),contrat);
				ligne.setValeur(valeur);
			}else{
				indexs.add(index);
			}//end if(rubrique.getBasetaxablesal()==Boolean.TRUE	
			index++;
		}//end for(LigneBulletinPaie ligne:bulletin.getLignes())
    	//Valorisation des variables
    	for(LigneElementVariable ligne:bulletin.getVariables()){
    		if(ligne.getValeur()!=null&&ligne.getValeur().compareTo(0.0)>0){
    			mapVar.put(ligne.getVariable().getCode(), ligne);
    			continue;
    		}//end if(ligne.getValeur().compareTo(0.0)>0){
    		String codeVar = ligne.getVariable().getCode();
    		if(codeVar.trim().equalsIgnoreCase("SBB")){
    			ligne.setValeur(salbasebrut);
    		}else if(codeVar.trim().equalsIgnoreCase("SALCO")){
    			ligne.setValeur(salcot);
    		}else if(codeVar.trim().equalsIgnoreCase("SALTAX")){
    			ligne.setValeur(salTaxable);
    		}else{
	    		Double valeur = eval(ligne.getVariable(),salarie,bulletin.getPeriode(),contrat);
	    		ligne.setValeur(valeur);
    		}
    		mapVar.put(ligne.getVariable().getCode(), ligne);
    	}//end for(LigneElementVariable ligne:bulletin.getVariables())
    	//Calcul des lignes restantes
    	for(Short i : indexs){
    		String key = bulletin.getLignes().get(i).getRubrique().getFormule().trim();
    		if(mapVar.containsKey(key)){
    			Double valeur = executorCache.get(key).getValeur();
    			bulletin.getLignes().get(i).setValeur(valeur);
    		}else{
    			Double valeur = eval(rubrique,salarie,bulletin.getPeriode(),contrat);
    			bulletin.getLignes().get(i).setValeur(valeur);
    		}//end if(mapVar.containsKey(bulletin.getLignes().get(i).getRubrique().getFormule().trim()))
    	}//end for(Short i : indexs){
    	//Mise a jour du Bulletin
    	bulletin = dao.update(bulletin.getId(), bulletin);
    	return new BulletinPaie(bulletin);
	}
    
    
	@Override
	public Double eval(Rubrique rubrique, Employe salarie,PeriodePaie periode,ContratTravail contrat) {
		// TODO Auto-generated method stub
		if(rubrique.getMode().trim().equalsIgnoreCase("0")){
			return evalCategorieProf(rubrique, salarie);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("1")){
			return evalCategorie(rubrique, salarie,contrat);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("2")){
			return evalSpecialites(rubrique, salarie);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("3")){
			//Pas une variable predefinie
			Variable variable = variabledao.findByPrimaryKey("code", rubrique.getFormule());
			if(variable==null){
				return 0.0;
			}//end if(variable==null)
			return eval(variable,salarie,periode,contrat);
		}//end if(rubrique.getMode().trim().equalsIgnoreCase("0")){
		return null;
	}

	@Override
	public Double eval(Variable variable, Employe salarie,PeriodePaie periode,ContratTravail contrat) {
		// TODO Auto-generated method stub
		if(variable.getMethodcal().trim().equalsIgnoreCase("1")){
			if(salarie==null||periode==null||contrat==null){
				return 0.0 ;
			}//end if(salarie==null||periode==null||contrat==null)
			return eval(variable.getCode(), salarie,periode,contrat);
		}//end if(variable.getMethodcal().trim().equalsIgnoreCase("1"))
		//Cas des constante
		if(variable.getMethodcal().trim().equalsIgnoreCase("0")){
			return Double.parseDouble(variable.getFormule());
		}//end if(variable.getMethodcal().trim().equalsIgnoreCase("0"))
		//Cas de formule	
		if(variable.getMethodcal().trim().equalsIgnoreCase("2")){
			if(variable.getTypeformule()!=null){
				if(variable.getTypeformule().equalsIgnoreCase("0")){
					return evalExpressionArithmetique(variable.getFormule(), salarie, periode, contrat);
				}else if(variable.getTypeformule().equalsIgnoreCase("1")){
					return evalSIExpression(variable.getFormule(), salarie, periode, contrat);
				}//end if(variable.getTypeformule().equalsIgnoreCase("0")){
			}//end if(variable.getTypeformule()!=null)
			return -1.0;
		}//end if(variable.getMethodcal().trim().equalsIgnoreCase("0"))
		return null;
	}
	
	/**
	 * 
	 * @param codeVar:Code de la variable
	 * @param salarie
	 * @return
	 */
	private  Double eval(String codeVar,Employe salarie,PeriodePaie periode,ContratTravail contrat){
		Double valeur = 0.0;		
		if(codeVar.trim().equalsIgnoreCase("SALCATEGO")){
			return salaireCategoriel(salarie,contrat);
		}else if(codeVar.trim().equalsIgnoreCase("ANCIEN")){
			int months = DateHelper.numberOfMonth(contrat.getDrecurtement(), periode.getDfin());
			return Double.parseDouble(Integer.toString(months));
		}else if(codeVar.trim().equalsIgnoreCase("SALBASE")){
			Double salcate = salaireCategoriel(salarie,contrat);
			valeur = salcate;
			valeur+= salarie.getCmplsalaire()==null ? 0.0 : salarie.getCmplsalaire();
			valeur+= complementSalaire(salarie, contrat, salcate);
			return valeur;
		}else if(codeVar.trim().equalsIgnoreCase("ABSENCE")){
			
		}else if(codeVar.trim().equalsIgnoreCase("CONGE")){
			
		}else if(codeVar.trim().equalsIgnoreCase("SALBASEAN")){//Salaire de base annuel
			
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
			return salarie.getCmplsalaire();
		}else if(codeVar.trim().equalsIgnoreCase("SYNDIQUE")){
			if(salarie.getSyndique()==Boolean.TRUE){
				return 1.0;
			}else {
				return 0.0;
			}
		}else if(codeVar.trim().equalsIgnoreCase("TYPAGEN")){
			return Double.parseDouble(salarie.getStatut());
		}//end if(codeVar.trim().equalsIgnoreCase("SALCATEGO")) 		
		return valeur;
	}

	/**
	 * 
	 * @param enEmploye
	 * @param contrat
	 * @return
	 */
	private Double salaireBase(Employe enEmploye , ContratTravail contrat){
		
		Double valeur = 0.0;
		
		return valeur;
	}
	
	/**
	 * COMPSAL : Complement du Salaire
	 * @param enEmploye
	 * @param contrat
	 * @return
	 */
	private Double complementSalaire(Employe salarie , ContratTravail contrat,Double salcate){
		//Traitement des parametrae avanceeés
		//Calcul du salaire categorie
		Double valeur = 0.0;
		RestrictionsContainer  container = RestrictionsContainer.newInstance();
		container.addEq("state", "active");
		List<ParametreAvance> parametres = parametreavancedao.filter(container.getPredicats(), null, null, 0, -1);
		for(ParametreAvance parametre:parametres){
			if(parametre.getType().equals("0")){
				if(salarie.getFonction()!=null){				
					for(LignePonderationSalaire ligne:parametre.getFonctions()){
						if(ligne.getFonction().compareTo(salarie.getFonction())==0){
							valeur += (salcate*ligne.getTaux())/100.0;
							break;
						}//end if(ligne.getFonction().compareTo(salarie.getFonction())==0){
					}//end for(LignePonderationSalaire ligne:parametre.getFonctions()){
				}//end if(parametre.getType().equals("0")){
			}else if(parametre.getType().equalsIgnoreCase("0")){
				for(LignePonderationTypeContrat ligne:parametre.getTypescontrats()){
					if(ligne.getFonction().compareTo(contrat.getType())==0){
						valeur += (salcate*ligne.getTaux())/100.0;
						break;
					}//end if(ligne.getFonction().compareTo(salarie.getFonction())==0){
				}//end for(LignePonderationTypeContrat ligne:parametre.getTypescontrats()){
			}//end if(parametre.getType().equals("0"))
		}//end for(ParametreAvance parametre:parametres)
		return valeur;
	}
	/**
	 * Calcul du salaire catégoriel
	 * @param salarie
	 * @return
	 */
	private Double salaireCategoriel(Employe salarie,ContratTravail contrat){
		Double valeur = 0.0;
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Convension> convensions = convensiondao.filter(container.getPredicats(), null, null, 0, -1);
		Convension convension=null;
		for(Convension conven:convensions){
			if(conven.getState().trim().equalsIgnoreCase("actif")){
				convension = conven;
			}//end if(conven.getState().trim().equalsIgnoreCase("actif"))
		}//end for(Convension conven:convensions){
		if(convension==null){
			return valeur;
		}
		for(LigneConvension ligne:convension.getLignes()){
			if(ligne.getCategorie().compareTo(contrat.getCategorie())==0
					&& ligne.getEchelon().compareTo(contrat.getEchelon())==0){
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
	private Double evalCategorie(Rubrique rubrique, Employe salarie,ContratTravail contrat){
		Double valeur = 0.0;
		if(contrat==null){
			return valeur;
		}
		//Recherche du dernier contrat en cours de l'employé		
		//Traitement des categorie
		for(ForfaitCategorie forfait:rubrique.getForfaitscat()){
			if(forfait.getCategorie().compareTo(contrat.getCategorie())==0){
				valeur = forfait.getValeur();
				return valeur;
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
		if(salarie.getFonction()==null){
			return valeur;
		}//end if(salarie.getFonction()==null)
		for(ForfaitCategorieProf forfait:rubrique.getForfaitscatprof()){
			if(forfait.getCategorie().compareTo(salarie.getFonction())==0){
				valeur = forfait.getValeur();
				return valeur;
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
		if(salarie.getSpecialite()==null){
			return valeur;
		}
		for(ForfaitSpecialite forfait:rubrique.getForfaitsspe()){
			if(forfait.getCategorie().compareTo(salarie.getSpecialite())==0){
				valeur = forfait.getValeur();
				return valeur;
			}
		}//end for(ForfaitCategorie forfait:rubrique.getForfaitscat())
		return valeur;
	}
	
	/**
	 * Evaluation des Expressions Arithmetique et logique
	 * @param expression
	 * @param salarie
	 * @param periode
	 * @param contrat
	 * @return
	 */
	private Double evalExpressionArithmetique(String expression ,Employe salarie,PeriodePaie periode,ContratTravail contrat){
		/**
		 * Matrice etat transition de l'automate
		 */
		int matrice[][]={ {2 , 2 , -1 , -1 , -1},
					      {3 ,-1 ,  3 ,  4 , -1},
					      {-1, 1 ,  1 ,  1 ,  1},
					      { 1, 1 ,  1 ,  1 ,  1},
					      {-1, 5,   5 ,  5 ,  5},
					      {-1, -1 , 4 , -1 , -1},
					      {-1, 6 ,  6 ,  6 ,   6}};
		 
		Double valeur = 0.0;
		
		StringBuilder builder = new StringBuilder(expression.trim());
		builder.append('@');
		
		char[] elements = builder.toString().trim().toCharArray();
		
//		System.out.println(MoteurPaieManagerImpl.class.toString()+"evalExpressionArithmetique(String expression ,Employe salarie,PeriodePaie periode,ContratTravail contrat) ============== "+builder.toString());
		/**
		 * Pile des Operandes
		 */
		List<Double> operandStack = new ArrayList<Double>();
		
		/**
		 * Pile des Operateurs
		 */
		List<Character> operatorStack = new ArrayList<Character>();
		
		/**
		 * Contient le parsing courant
		 */
		StringBuilder terme = new StringBuilder();
		
		int state = 1 ;
		
		for(char car : elements){
//			System.out.println(MoteurPaieManagerImpl.class.toString()+" automate ============== char : "+car+" === state : "+state+" ::::   ==== isLetter : "+isLetter(car)+" === Numeric : "+isNumeric(car)+" === operator : "+isOperator(car)+" === isSpace : "+isSpaceCaracter(car));
			if(isLetter(car)){
				 if(state==1){
					  terme = new StringBuilder();
					  terme.append(car);
				  }else if(state==2){
					  terme.append(car);
				  }//end if(state==1){		
				  state = matrice[0][state-1]; 
			}else if(isNumeric(car)){
				 if(state==1){
					  terme = new StringBuilder();
					  terme.append(car);
				  }else if(state==3 || state==4){
					  terme.append(car);
				  }//end if(state==1){		
				  state = matrice[1][state-1];		
			}else if(isOperator(car)){
				if(state==2){//Traitememnt de la nouvelle variable contenu dans terme
					  if(operandStack.size()>1){
						  if(operatorStack.get(operatorStack.size()-1).equals('-')
								  ||operatorStack.get(operatorStack.size()-1).equals('+')){
							  if(car=='+'||car=='-'){
								  double rigth = operandStack.remove(operandStack.size()-1);								  
								  double left = operandStack.remove(operandStack.size()-1);								  
								  char operator = operatorStack.remove(operandStack.size()-1);
								  operandStack.add(compute(operator, left, rigth));
							  }//end if(car=='+'||car=='-'){
						  }else{//operator * | / |%
							  double rigth = operandStack.remove(operandStack.size()-1);								  
							  double left = operandStack.remove(operandStack.size()-1);								  
							  char operator = operatorStack.remove(operandStack.size()-1);
							  operandStack.add(compute(operator, left, rigth));							  
						  }//end if(operatorStack.get(operatorStack.size()-1).equals('-')
					  }//end if(operandStack.size()>0)
					  Variable var = variabledao.findByPrimaryKey("code",terme.toString());
					  if(var==null){
						  throw new KerenExecption("Impossible de trouver la variable : "+terme);
					  }//end if(var==null)
					  Double value = eval(var, salarie, periode, contrat);
					  operandStack.add(value);
				  }else if(state==3){//Traitement du nombre
					  if(operandStack.size()>1){
						  if(operatorStack.get(operatorStack.size()-1).equals('-')
								  ||operatorStack.get(operatorStack.size()-1).equals('+')){
							  if(car=='+'||car=='-'){
								  double rigth = operandStack.remove(operandStack.size()-1);								  
								  double left = operandStack.remove(operandStack.size()-1);								  
								  char operator = operatorStack.remove(operandStack.size()-1);
								  operandStack.add(compute(operator, left, rigth));
							  }//end if(car=='+'||car=='-'){
						  }else if(!operatorStack.get(operatorStack.size()-1).equals(')')
								  && !operatorStack.get(operatorStack.size()-1).equals('(')){//operator * | / |%
							  double rigth = operandStack.remove(operandStack.size()-1);								  
							  double left = operandStack.remove(operandStack.size()-1);								  
							  char operator = operatorStack.remove(operandStack.size()-1);
							  operandStack.add(compute(operator, left, rigth));							  
						  }//end if(operatorStack.get(operatorStack.size()-1).equals('-')
					  }//end if(operandStack.size()>0)
					  operandStack.add(Double.parseDouble(terme.toString()));
				  }else if(state==4){//Traitement du nombre
					  if(operandStack.size()>1){
						  if(operatorStack.get(operatorStack.size()-1).equals('-')
								  ||operatorStack.get(operatorStack.size()-1).equals('+')){
							  if(car=='+'||car=='-'){
								  double rigth = operandStack.remove(operandStack.size()-1);								  
								  double left = operandStack.remove(operandStack.size()-1);								  
								  char operator = operatorStack.remove(operandStack.size()-1);
								  operandStack.add(compute(operator, left, rigth));
							  }//end if(car=='+'||car=='-'){
						  }else if(!operatorStack.get(operatorStack.size()-1).equals(')')
								  && !operatorStack.get(operatorStack.size()-1).equals('(')){//operator * | / |%
							  double rigth = operandStack.remove(operandStack.size()-1);								  
							  double left = operandStack.remove(operandStack.size()-1);								  
							  char operator = operatorStack.remove(operandStack.size()-1);
							  operandStack.add(compute(operator, left, rigth));							  
						  }//end if(operatorStack.get(operatorStack.size()-1).equals('-')
					  }//end if(operandStack.size()>0)
					  operandStack.add(Double.parseDouble(terme.toString()));					  
				  }else if(state==5){
					  operatorStack.add(car);
				  }//end
				  operatorStack.add(car);				  
				  state = matrice[2][state-1];				  
			  }else if(car=='('){
				  operatorStack.add(car);
				  if(state==2){//Traitememnt de la nouvelle variable
					  Variable var = variabledao.findByPrimaryKey("code",terme.toString());
					  if(var==null){
						  throw new KerenExecption("Impossible de trouver la variable : "+terme);
					  }//end if(var==null)
					  Double value = eval(var, salarie, periode, contrat);
					  operandStack.add(value);
				  }else if(state==3){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));
				  }else if(state==4){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));
				  }//ed  operatorStack.add(')');
				  operatorStack.add(')');
				  state = matrice[3][state-1];
			  }else if(car==')'){
				  if(state==2){//Traitememnt de la nouvelle variable*
					  Double value = eval(terme.toString(), salarie, periode, contrat);					  
					  operandStack.add(value);	
					  boolean stop = false ;
					  while(!stop){
						  if(operatorStack.size()==0){
							  stop = true ;
						  }//end if(operatorStack.size()==0)
						  char operator = operatorStack.remove(operatorStack.size()-1);
						  if(operator=='('){
							  stop = true;
						  }else{//Operation binaire arithmetique
							  if(operandStack.size()>1){
								  double rigth = operandStack.remove(operandStack.size()-1);
								  double left = operandStack.remove(operandStack.size()-1);
								  operandStack.add(compute(operator, left, rigth));
							  }//end if(operandStack.size()>1)
						  }//end if(operator=='(')
					  }//end while(!stop){					  				  
				  }else if(state==3){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));	
					  boolean stop = false ;
					  while(!stop){
						  if(operatorStack.size()==0){
							  stop = true ;
						  }//end if(operatorStack.size()==0)
						  char operator = operatorStack.remove(operatorStack.size()-1);
						  if(operator=='('){
							  stop = true;
						  }else{//Operation binaire arithmetique
							  if(operandStack.size()>1){
								  double rigth = operandStack.remove(operandStack.size()-1);
								  double left = operandStack.remove(operandStack.size()-1);
								  operandStack.add(compute(operator, left, rigth));
							  }//end if(operandStack.size()>1)
						  }//end if(operator=='(')
					  }//end while(!stop){		
				  }else if(state==4){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));	
					  boolean stop = false ;
					  while(!stop){
						  if(operatorStack.size()==0){
							  stop = true ;
						  }//end if(operatorStack.size()==0)
						  char operator = operatorStack.remove(operatorStack.size()-1);
						  if(operator=='('){
							  stop = true;
						  }else{//Operation binaire arithmetique
							  if(operandStack.size()>1){
								  double rigth = operandStack.remove(operandStack.size()-1);
								  double left = operandStack.remove(operandStack.size()-1);
								  operandStack.add(compute(operator, left, rigth));
							  }//end if(operandStack.size()>1)
						  }//end if(operator=='(')
					  }//end while(!stop){		
				  }else if(state==5){
					  boolean stop = false ;
					  while(!stop){
						  if(operatorStack.size()==0){
							  stop = true ;
						  }//end if(operatorStack.size()==0)
						  char operator = operatorStack.remove(operatorStack.size()-1);
						  if(operator=='('){
							  stop = true;
						  }else{//Operation binaire arithmetique
							  if(operandStack.size()>1){
								  double rigth = operandStack.remove(operandStack.size()-1);
								  double left = operandStack.remove(operandStack.size()-1);
								  operandStack.add(compute(operator, left, rigth));
							  }//end if(operandStack.size()>1)
						  }//end if(operator=='(')
					  }//end while(!stop){		
				  }//end
				  state = matrice[4][state-1];
			  }else if(car=='.'){
				  if(state==3){
					  terme.append(car);
				  }//end if(state==1){	
				  state = matrice[5][state-1];
			  }else if(car=='@'){
				  if(state==2){//Traitememnt de la nouvelle variable*
					  Variable var = variabledao.findByPrimaryKey("code",terme.toString());
					  if(var==null){
						  throw new KerenExecption("Impossible de trouver la variable : "+terme);
					  }//end if(var==null)
					  Double value = eval(var, salarie, periode, contrat);				  
					  operandStack.add(value);	
					  if(operatorStack.size()>0){
						  char operator = operatorStack.remove(operatorStack.size()-1);
						  if(operandStack.size()>1){
							  double rigth = operandStack.remove(operandStack.size()-1);
							  double left = operandStack.remove(operandStack.size()-1);
							  operandStack.add(compute(operator, left, rigth));
						  }//end if(operandStack.size()>1)
					  }//end if(operatorStack.size()>0){
				  }else if(state==3){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));	
					  if(operatorStack.size()>0){
						  char operator = operatorStack.remove(operatorStack.size()-1);
						  if(operandStack.size()>1){
							  double rigth = operandStack.remove(operandStack.size()-1);
							  double left = operandStack.remove(operandStack.size()-1);
							  operandStack.add(compute(operator, left, rigth));
						  }//end if(operandStack.size()>1)
					  }//end if(operatorStack.size()>0){					 	
				  }else if(state==4){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));	
					  if(operatorStack.size()>0){
						  char operator = operatorStack.remove(operatorStack.size()-1);
						  if(operandStack.size()>1){
							  double rigth = operandStack.remove(operandStack.size()-1);
							  double left = operandStack.remove(operandStack.size()-1);
							  operandStack.add(compute(operator, left, rigth));
						  }//end if(operandStack.size()>1)
					  }//end if(operatorStack.size()>0){
				  }//end
			  }//end if(isLetter(car))
		}//end for(char car : elements){
		valeur = state >0 ? operandStack.get(0) : -1;
		return valeur ;
	}
	
	/**
	 * 
	 * @param variable
	 * @param salarie
	 * @param periode
	 * @param contrat
	 * @return
	 */
	private Double evalSIExpression(String formule ,Employe salarie,PeriodePaie periode,ContratTravail contrat){
		Double valeur = 0.0 ;
		//                1    2    3     4    5   6    7    8    9   10   11  12   13   14   15   16   17   18   19   20   21   22   23   24   25
		int matrice[][]={
				         { 2, -1 , -1 ,  -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ,  2},
					     {-1 , 3 , -1 ,  -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1,  -1 , -1 , -1 , -1},
					     {-1 , -1 , 3 ,   7 ,  7,  7 ,  7 ,  9 ,  9 , 13 , 13 ,13 , 13 , -1 , -1 , -1 , 17 , 21 , 21 , 21 , 21,  -1 , -1 , -1 ,17},
					     {-1 , -1 , 4 ,   4 , -1, -1 , -1 , -1 , 10 , 10 , -1 ,-1 , -1 , -1 , -1 , -1 , 18 , 18 , -1 , -1 , -1,  -1 , -1 , -1 , -1},
					     {-1 , -1 , 5 ,  -1 , 5,   6 , -1 , -1 , 11 , -1 , 11 ,12 , -1 , -1 , -1 , -1 , 19 , -1 , 19 , 20 , -1,  -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 ,  8 ,  8,  8 ,  8 ,  9 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 ,  9 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , -1 , 17 , 17 , 17 , 17 , -1 , -1 , -1 , -1},
					     {-1 , -1 ,  3 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , 17 , 17 , 17 , 17 , 17 , -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , 13 , -1 , -1 , -1 , -1 , 21 , 21 , 21 , 21 , -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , 14 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , 15 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , 16 , -1 , -1 , -1 , -1 , -1 , 22 , -1 , -1 , 25 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , 17 , -1 , -1 , -1 , -1 , -1,  -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ,-1 ,  23 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ,-1 ,  -1 , 24 , -1 , -1},
					     {-1 , -1 , -1 , -1 ,  6, -1 , -1 , -1 , -1 , -1 , 12 ,-1 , -1 , -1 , -1 , -1 , -1 , -1 , 20 , -1 ,-1 ,  -1 , -1 , -1 , -1},
					     {-1 , -1 , -1 , -1 , -1, -1 , -1 , -1 , -1 , -1 , -1 ,-1 ,  3 , -1 , -1 , -1 , -1 , -1 , -1 , -1 ,-1 , -1 , -1 , -1 , -1}};
		
		StringBuilder builder = new StringBuilder(formule);
		builder.append("@");
		System.out.println(MoteurPaieManagerImpl.class.toString()+" ============================ FORMULE : "+builder.toString());
		char[] elements = builder.toString().trim().toCharArray();
		
		/**
		 * Pile des Operandes
		 */
		List<Double> operandStack = new ArrayList<Double>();
		
		/**
		 * Pile des Operateurs
		 */
		List<String> operatorStack = new ArrayList<String>();
		
		/**
		 * Contient le parsing courant
		 */
		StringBuilder terme = new StringBuilder();
		StringBuilder oper = new StringBuilder();
		StringBuilder expression = new StringBuilder();
		Boolean testResult = null;
		Character connector =null;
		
		int state = 1 ;
		
		for(char car:elements){	
			if(car=='i'){
				state = matrice[0][state-1];
			}else if(car=='f'){
				if(state==2){
					terme = new StringBuilder();	
					connector =null;
				}//end if(state==3)
				state = matrice[1][state-1];
			}else if(isSpaceCaracter(car)){	
				if(state==4||state==10){
					Variable var = variabledao.findByPrimaryKey("code", terme.toString());
					if(var==null){
						throw new KerenPaieManagerException("Impossible de trouver la variable : "+terme);
					}
					Double value = eval(var, salarie, periode, contrat);
					operandStack.add(value);
					if(state==10){//Traitement des Operande
						if(operandStack.size()>1){
						  double rigth = operandStack.remove(operandStack.size()-1);
						  double left = operandStack.remove(operandStack.size()-1);
						  String operator = operatorStack.remove(operatorStack.size()-1);
						  if(connector==null){
							  testResult = compare(operator, left, rigth);
						  }else {
							  if(connector=='&'){
								  testResult &= compare(operator, left, rigth);
							  }else if(connector=='|'){
								  testResult |= compare(operator, left, rigth);
							  }//end if(connector=='&')
							  connector = null;
						  }
						}//end if(operandStack.size()>1){
					}//end 
				}else if(state==5 || state==6|| state==11|| state==12){
					operandStack.add(Double.parseDouble(terme.toString()));
					if(state==11||state==12){//Traitement des Operande
						if(operandStack.size()>1){
						  double rigth = operandStack.remove(operandStack.size()-1);
						  double left = operandStack.remove(operandStack.size()-1);
						  String operator = operatorStack.remove(operatorStack.size()-1);
						  if(connector==null){
							  testResult = compare(operator, left, rigth);
						  }else {
							  if(connector=='&'){
								  testResult &= compare(operator, left, rigth);
							  }else if(connector=='|'){
								  testResult |= compare(operator, left, rigth);
							  }//end if(connector=='&')
							  connector = null;
						  }
						}//end if(operandStack.size()>1){
					}//end 
				}else if(state==7){
					oper = new StringBuilder(car);
				}else if(state==8){
					operatorStack.add(oper.toString());
				}else if(state==25){//Cas du else
					testResult = true;
				}
				state = matrice[2][state-1];
			}else if(isLetter(car)){
				if(state==4||state==10){						
					terme.append(car);
				}else if(state==3||state==9){
					terme = new StringBuilder();
					terme.append(car);
				}else if(state==17||state==18){
					expression.append(car);
				}//end if(state==3){	
				state = matrice[3][state-1];
			}else if(isNumeric(car)){
				if(state==3||state==9){
					terme = new StringBuilder();	
					terme.append(car);
				}else if(state==5||state==6||state==11){
					terme.append(car);
				}else if(state==17||state==19||state==20){
					expression.append(car);
				}//end if(state==3){				
				state = matrice[4][state-1];
			}else if(isLogicOperator1(car)){
				if(state==4){
					Variable var = variabledao.findByPrimaryKey("code", terme.toString());
					if(var==null){
						throw new KerenPaieManagerException("Impossible de trouver la variable : "+terme);
					}
					Double value = eval(var, salarie, periode, contrat);
					operandStack.add(value);
					oper = new StringBuilder(car);
				}else if(state==5 || state==6){
					operandStack.add(Double.parseDouble(terme.toString()));
					oper = new StringBuilder();
					oper.append(car);
				}else if(state==8){
					oper.append(car);
					operatorStack.add(oper.toString());
				}
				state = matrice[5][state-1];
			}else if(isLogicOperator2(car)){
				if(state==8){
					oper.append(car);
					operatorStack.add(oper.toString());
				}
				state = matrice[6][state-1];
			}else if(isOperator(car)){
				if(state==18||state==19||state==20||state==21){
					expression.append(car);
				}
				state = matrice[7][state-1];
			}else if(car=='('){
				if(state==3){
					operatorStack.add("(");
				}else if(state==17||state==18||state==19||state==20){
					expression.append(car);
				}
				state = matrice[8][state-1];
			}else if(car==')'){
				if(state==13){
					operatorStack.remove(operatorStack.size()-1);
				}else if(state==18||state==20||state==19||state==21){
					expression.append(car);
				}
				state = matrice[9][state-1];
			}else if(car=='t'){
				state = matrice[10][state-1];
			}else if(car=='h'){
				state = matrice[11][state-1];
			}else if(car=='e'){
				if(state==21){
					if(testResult){
						return evalExpressionArithmetique(expression.toString().trim(), salarie, periode, contrat);
					}
					expression = new StringBuilder();
				}//end if(state==21){
				state = matrice[12][state-1];
			}else if(car=='n'){
				if(state==16){
					expression = new StringBuilder();
				}
				state = matrice[13][state-1];
			}else if(car=='l'){
				state = matrice[14][state-1];
			}else if(car=='s'){
				state = matrice[15][state-1];
			}else if(car=='.'){
				if(state==5){
					terme.append('.');
				}else if(state==19){
					expression.append(car);
				}
				state = matrice[16][state-1];
			}else if(isConnector(car)){
				state = matrice[17][state-1];
			}else if(car=='@'){
				if(state==18||state==19||state==20||state==21){
					if(testResult){
//						System.out.println(MoteurPaieManagerImpl.class.toString()+" ============================ EXPRESSION : "+expression.toString().trim());
						return evalExpressionArithmetique(expression.toString().trim(), salarie, periode, contrat);
					}
				}
				if(salarie==null||periode==null||contrat==null){
					return 0.0;
				}
				return -1.0;
			}
		}//end for(char car:elements)
		return valeur;
	}//end private Double evalSIExpression(Variable variable ,Employe salarie,PeriodePaie periode,ContratTravail contrat){
	
	private boolean isLogicOperator1(char car){
		return car=='<'||car=='>'||car=='=';
	}
	
	private boolean isLogicOperator2(char car){
		return car=='=';
	}
	
	private Boolean isSpaceCaracter(char car){
		return car==' '||car=='\n'||car=='\t';
	}
	
	private boolean isConnector(char car){
		return car=='|'||car=='&';
	}
	/**
	 * 
	 * @param car
	 * @return
	 */
	private Boolean isLetter(char car){
		return car=='A'||car=='B'||car=='C'||car=='D'||car=='E'||car=='F'||car=='G'||car=='H'||car=='I'||car=='J'||car=='K'||car=='L'||car=='M'||car=='N'||car=='O'||car=='P'||car=='Q'||car=='R'||car=='S'||car=='T'||car=='U'||car=='V'||car=='W'||car=='X'||car=='Y'||car=='Z';
	}
	
	/**
	 * 
	 * @param car
	 * @return
	 */
	private boolean isNumeric(char car){
		return car=='0'||car=='1'||car=='2'||car=='3'||car=='4'||car=='5'||car=='6'||car=='7'||car=='8'||car=='9';
	}
	
	/**
	 * 
	 * @param car
	 * @return
	 */
	private boolean isOperator(char car){
		return car=='+'|| car=='-'||car=='*'||car=='/'||car=='%';
	}
	/**
	 * 
	 * @param car
	 * @param left
	 * @param rigth
	 * @return
	 */
	private Double compute(char car , Double left , Double rigth){
		
		if(car=='+') return left+rigth;
		else if(car=='-') return left - rigth;
		else if(car=='*') return left * rigth;
		else if(car=='/') return left / rigth;
		else if(car=='%') return left % rigth;
		
		return 0.0;
	}
	
	/**
	 * 
	 * @param operateur
	 * @param left
	 * @param rigth
	 * @return
	 */
	private Boolean compare(String operateur, Double left , Double rigth){		
		if(operateur.equalsIgnoreCase(">")){
			return left>rigth;
		}else if(operateur.equalsIgnoreCase("<")){
			return left<rigth;
		}else if(operateur.equalsIgnoreCase(">=")){
			return left>=rigth;
		}else if(operateur.equalsIgnoreCase("<=")){
			return left<=rigth;
		}else if(operateur.equalsIgnoreCase("==")){
			return left==rigth;
		}
		return false;
	}
	
	
}
