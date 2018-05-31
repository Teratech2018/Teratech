
package com.keren.kerenpaie.core.impl.paie;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ConvensionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.IndiceSoldeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ParametreAvanceDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ProfilPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.RubriqueDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.VariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.presences.LignePointageDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.SocieteDAOLocal;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;
import com.keren.kerenpaie.model.employes.ContratTravail;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.employes.Famille;
import com.keren.kerenpaie.model.paie.BulletinPaie;
import com.keren.kerenpaie.model.paie.Convension;
import com.keren.kerenpaie.model.paie.ElementVariable;
import com.keren.kerenpaie.model.paie.ForfaitCategorie;
import com.keren.kerenpaie.model.paie.ForfaitCategorieProf;
import com.keren.kerenpaie.model.paie.ForfaitSpecialite;
import com.keren.kerenpaie.model.paie.IndiceSolde;
import com.keren.kerenpaie.model.paie.LigneBulletinPaie;
import com.keren.kerenpaie.model.paie.LigneConvension;
import com.keren.kerenpaie.model.paie.LigneElementVariable;
import com.keren.kerenpaie.model.paie.LigneIndiceSolde;
import com.keren.kerenpaie.model.paie.LignePonderationSalaire;
import com.keren.kerenpaie.model.paie.LignePonderationTypeContrat;
import com.keren.kerenpaie.model.paie.ParametreAvance;
import com.keren.kerenpaie.model.paie.PrepaSalaire;
import com.keren.kerenpaie.model.paie.ProfilPaie;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.paie.ValiderSalaire;
import com.keren.kerenpaie.model.paie.Variable;
import com.keren.kerenpaie.model.presences.LignePointage;
import com.keren.kerenpaie.model.prets.Acompte;
import com.keren.kerenpaie.model.prets.LigneRappel;
import com.keren.kerenpaie.model.prets.Rappel;
import com.keren.kerenpaie.model.prets.RemboursementAvance;
import com.keren.kerenpaie.model.prets.RemboursementPret;
import com.keren.kerenpaie.model.structures.Planification;
import com.keren.kerenpaie.model.structures.Societe;
import com.keren.kerenpaie.tools.KerenPaieManagerException;

@TransactionAttribute
@Stateless(mappedName = "BulletinPaieManager")
public class MoteurPaieManagerImpl
    extends AbstractGenericManager<BulletinPaie, Long>
    implements MoteurPaieManagerLocal, MoteurPaieManagerRemote
{

	/**
	 * Nom de la variable devant contenir le acompte
	 */
	private static final String V_ACOMPTE = "MTACOMPTE";
	
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
    
    @EJB(name = "IndiceSoldeDAO")
    protected IndiceSoldeDAOLocal indicesoldedao;    

    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal eltvariabledao;
    
    @EJB(name = "SocieteDAO")
    protected SocieteDAOLocal societedao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    
    @EJB(name = "LignePointageDAO")
    protected LignePointageDAOLocal pointageedao;
    
    /**
     * Cache contenant les ligne element variable deja calcule
     */
    private static Map<String , LigneElementVariable> executorCache = new HashMap<String , LigneElementVariable>();
    
    /**
     * Convension collective en cours
     */
    private Convension convension =null;
    
    private IndiceSolde indice =null;

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
	public PrepaSalaire preparerPaie(PrepaSalaire entity) {
		// TODO Auto-generated method stub
    	/**
    	 * Etape 1 - Generation des bulletion de paie pour la periode
    	 */
    	List<Employe> salaries = creationBulletinPaiePeriode(entity);
    	/**
    	 * Evaluation des bulletin de paie générer
    	 */
    	if(salaries!=null && !salaries.isEmpty()){
    		for(Employe salarie : salaries){
    			RestrictionsContainer container = RestrictionsContainer.newInstance();
    			container.addEq("employe", salarie);
    			container.addEq("periode", entity.getPeriode());
    			List<BulletinPaie> bulletins = dao.filter(container.getPredicats(), null, null, 0, -1);
    			for(BulletinPaie bulletin : bulletins){
    				eval(bulletin);
    			}//end for(BulletinPaie bulletin : bulletins){
    		}//end for(Employe salarie : salaries)
    	}//end if(salaries!=null && !salaries.isEmpty()){
        
		return entity;
	}
	
    @Override
	public ValiderSalaire validerSalaire(ValiderSalaire entity) {
		// TODO Auto-generated method stub
    	/**
    	 * Identifications des bulletions concernés par la validation
    	 */
    	List<BulletinPaie> bulletins = null;
    	if(entity.getPorte().trim().equalsIgnoreCase("0")){
    		PeriodePaie periode = periodedao.findByPrimaryKey("id", entity.getPeriode().getId());
    		bulletins = periode.getSalaires();
    	}else if(entity.getPorte().trim().equalsIgnoreCase("1")){
    		bulletins = entity.getConcernes();
    	}//end if(entity.getPorte().trim().equalsIgnoreCase("0")){
    	//Recalcul des Bulletins concernes
    	for(BulletinPaie bulletin:bulletins){
    		//Mise a jour de l'etat du bulletin
    		bulletin.setState("valide");
    		bulletin.setDpayement(entity.getDate());
    		bulletin = eval(bulletin);
    	}//end for(BulletinPaie bulletin:bulletins){    	
		return entity;
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
            if(salarie.getStructure()!=null && salarie.getStructure().getPlanifications()!=null){
                    salarie.getStructure().getPlanifications().size();
            }//end if(salarie.getStructure()!=null && salarie.getStructure().getPlanifications()!=null){
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
                    Double valeur = eval(ligne.getVariable(),salarie,bulletin.getPeriode(),contrat,salarie.getStructure());
                    ligne.setValeur(valeur+ligne.getValeur());    		
                    executorCache.put(ligne.getVariable().getCode(), ligne);
            }//end for(LigneElementVariable ligne:bulletin.getVariables())
            //Traitement des rubrique de type
    	   for(LigneBulletinPaie ligne:bulletin.getLignes()){
    		rubrique = ligne.getRubrique();
    		if(ligne.getValeur()!=null&&ligne.getValeur().compareTo(0.0)>0){
    			Double valeur = ligne.getValeur();
                        if(ligne.getRubrique().getTauxsal()!=null){
				ligne.setTauxsal(ligne.getValeur()*ligne.getRubrique().getTauxsal()/100);
			}//end if(ligne.getRubrique().getTauxsal()!=null)
			if(ligne.getRubrique().getTauxpat()!=null){
				ligne.setTauxpat(ligne.getValeur()*ligne.getRubrique().getTauxpat()/100);
			}//end if(ligne.getRubrique().getTauxpat()!=null){
    			//Cumul
			if(rubrique.getBasetaxablesal()!=null && rubrique.getBasetaxablesal().equals(Boolean.TRUE)){
				if(rubrique.getTauxtax()!=null){
					salTaxable += ligne.getValeur()*rubrique.getTauxtax()/100;
				}//end if(rubrique.getTauxtax()!=null){
			}//end if(rubrique.getBasetaxablesal().equals(Boolean.TRUE))
			if(rubrique.getBrutsal()!=null && rubrique.getBrutsal().equals(Boolean.TRUE)){
				salbasebrut += ligne.getTauxsal();
			}//end if(rubrique.getBrutsal().equals(Boolean.TRUE)){
			if(rubrique.getCotisablesal()!=null && rubrique.getCotisablesal().equals(Boolean.TRUE)){
				salcot += ligne.getTauxsal();
			}//end if(rubrique.getCotisablesal().equals(Boolean.TRUE))
    			continue;
    		}//end if(ligne.getValeur().compareTo(0.0)>0){  
    		rubrique = rubriquedao.findByPrimaryKey("id", ligne.getRubrique().getId());
			Double valeur = eval(rubrique,salarie,bulletin.getPeriode(),contrat,salarie.getStructure());
			ligne.setValeur(valeur+ligne.getValeur());	
			if(ligne.getRubrique().getTauxsal()!=null){
				ligne.setTauxsal(ligne.getValeur()*ligne.getRubrique().getTauxsal()/100);
			}//end if(ligne.getRubrique().getTauxsal()!=null)
			if(ligne.getRubrique().getTauxpat()!=null){
				ligne.setTauxpat(ligne.getValeur()*ligne.getRubrique().getTauxpat()/100);
			}//end if(ligne.getRubrique().getTauxpat()!=null){
			//Cummul
			//Cumul
			if(rubrique.getBasetaxablesal()!=null && rubrique.getBasetaxablesal().equals(Boolean.TRUE)){
				if(rubrique.getTauxtax()!=null){
					salTaxable += ligne.getValeur()*rubrique.getTauxtax()/100;
				}//end if(rubrique.getTauxtax()!=null){
			}//end if(rubrique.getBasetaxablesal().equals(Boolean.TRUE))
			if(rubrique.getBrutsal()!=null && rubrique.getBrutsal().equals(Boolean.TRUE)){
				salbasebrut += ligne.getTauxsal();
			}//end if(rubrique.getBrutsal().equals(Boolean.TRUE)){
			if(rubrique.getCotisablesal()!=null && rubrique.getCotisablesal().equals(Boolean.TRUE)){
				salcot += ligne.getTauxsal();
			}//end if(rubrique.getCotisablesal().equals(Boolean.TRUE))
		}//end for(LigneBulletinPaie ligne:bulletin.getLignes())
                /**
                 * Mise a jour du SBB SALCO et SALTAX
                 */
                if(executorCache!=null){
                        if(executorCache.get("SBB")!=null){
                                executorCache.get("SBB").setValeur(salbasebrut);
                        }//end if(executorCache.get("SBB")!=null){
                        if(executorCache.get("SALCO")!=null){
                                executorCache.get("SALCO").setValeur(salcot);
                        }//end if(executorCache.get("SALCO")!=null){
                        if(executorCache.get("SALTAX")!=null){
                                executorCache.get("SALTAX").setValeur(salTaxable);
                        }//end if(executorCache.get("SALTAX")!=null){
                }//end if(executorCache!=null){

                //Mise a jour des Variables base sur des variables SBB SALCO SALTAX
                /**
                 * 
                 */
                for(LigneBulletinPaie ligne:bulletin.getLignes()){
                        if(ligne.getValeur()==null||ligne.getValeur().compareTo(0.0)<=0){
                                rubrique = rubriquedao.findByPrimaryKey("id", ligne.getRubrique().getId());
                                Double valeur = eval(rubrique,salarie,bulletin.getPeriode(),contrat,salarie.getStructure());
        //    			System.out.println(MoteurPaieManagerImpl.class.toString()+" =========== "+ligne.getRubrique()+" ==== "+ligne.getRubrique().getFormule()+" ==== "+valeur);
                                ligne.setValeur(valeur);	
                                if(ligne.getRubrique().getTauxsal()!=null){
                                        ligne.setTauxsal(valeur*ligne.getRubrique().getTauxsal()/100);
                                }//end if(ligne.getRubrique().getTauxsal()!=null)
                                if(ligne.getRubrique().getTauxpat()!=null){
                                        ligne.setTauxpat(valeur*ligne.getRubrique().getTauxpat()/100);
                                }//end if(ligne.getRubrique().getTauxpat()!=null){
                        }//end if(ligne.getValeur()==null||ligne.getValeur().compareTo(0.0)<=0){
                }//end for(LigneElementVariable ligne:bulletin.getVariables())
                //Mise a jour du Bulletin
                bulletin = dao.update(bulletin.getId(), bulletin);
                BulletinPaie result = new BulletinPaie(bulletin);
                for(LigneElementVariable ligne:bulletin.getVariables()){
                        result.getVariables().add(new LigneElementVariable(ligne));
                }//end for(LigneElementVariable ligne:bulletin.getVariables()){
                for(LigneBulletinPaie ligne:bulletin.getLignes()){
                        result.getLignes().add(new LigneBulletinPaie(ligne));
                }//end for(LigneBulletinPaie ligne:bulletin.getLignes()){
                return result;
	}
    
        
    
	@Override
	public Double eval(Rubrique rubrique, Employe salarie,PeriodePaie periode,ContratTravail contrat,Societe structure) {
		// TODO Auto-generated method stub
//		System.out.println(MoteurPaieManagerImpl.class.toString()+" ========= contrat : "+contrat+" ==== periode : "+periode+" ===== employe: "+salarie+" === rubrique:"+rubrique);
		if(rubrique.getMode().trim().equalsIgnoreCase("0")){
			return evalCategorieProf(rubrique, salarie);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("1")){
			return evalCategorie(rubrique, salarie,contrat);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("2")){
			return evalSpecialites(rubrique, salarie);
		}else if(rubrique.getMode().trim().equalsIgnoreCase("3")){
			//Pas une variable predefinie		
			if(rubrique.getFormule()==null||rubrique.getFormule().trim().isEmpty()){
				throw new KerenPaieManagerException("La Rubrique "+rubrique.getCode()+" ne contient aucune formule");
			}//end if(rubrique.getFormule()==null||rubrique.getFormule().trim().isEmpty())
			return evalExpressionArithmetique(rubrique.getFormule().trim(),salarie,periode,contrat,structure);
		}//end if(rubrique.getMode().trim().equalsIgnoreCase("0")){
		return null;
	}

	@Override
	public Double eval(Variable variable, Employe salarie,PeriodePaie periode,ContratTravail contrat,Societe structure) {
		// TODO Auto-generated method stub 
		//Verification du contenue du cache
		if(executorCache.containsKey(variable.getCode())
				&& executorCache.get(variable.getCode()).getValeur()>0){
			return executorCache.get(variable.getCode()).getValeur();
		}//end if(executorCache.containsKey(variable.getCode())){
//		System.out.println(MoteurPaieManagerImpl.class.toString()+" ========= contrat : "+contrat+" ==== periode : "+periode+" ===== employe: "+salarie+" === variable:"+variable);
		if(variable.getMethodcal().trim().equalsIgnoreCase("1")){
			if(salarie==null||periode==null||contrat==null){
				return 0.0 ;
			}//end if(salarie==null||periode==null||contrat==null)
			return eval(variable.getCode(), salarie,periode,contrat,structure);
		}//end if(variable.getMethodcal().trim().equalsIgnoreCase("1"))
		//Cas des constante
		if(variable.getMethodcal().trim().equalsIgnoreCase("0")){
			return Double.parseDouble(variable.getFormule());
		}//end if(variable.getMethodcal().trim().equalsIgnoreCase("0"))
		//Cas de formule	
		if(variable.getMethodcal().trim().equalsIgnoreCase("2")){
			if(variable.getTypeformule()!=null){
				if(variable.getTypeformule().equalsIgnoreCase("0")){
					return evalExpressionArithmetique(variable.getFormule(), salarie, periode, contrat,structure);
				}else if(variable.getTypeformule().equalsIgnoreCase("1")){
					return evalSIExpression(variable.getFormule(), salarie, periode, contrat,structure);
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
	private  Double eval(String codeVar,Employe salarie,PeriodePaie periode,ContratTravail contrat,Societe structure){		
		//Cache des variable calcule
		Map<String, Double> map = calculHeures(periode, salarie, structure);		
		Double valeur = 0.0;		
		if(codeVar.trim().equalsIgnoreCase("SALCATEGO")){//Salaire Categorie
			return salaireCategoriel(salarie,contrat);
		}else if(codeVar.trim().equalsIgnoreCase("SALBASE")){//Salarie de Base 			
			return salaireBase(salarie, contrat);
		}else if(codeVar.trim().equalsIgnoreCase("HPAYEES")){//Nombre Heure Payés dans la période
			return map.get("HMOIS") - map.get("NHABS") + map.get("NHABSPAYE");
		}else if(codeVar.trim().equalsIgnoreCase("HTRAV")){//Nombre Heure Travaillées dans la periode
			return map.get("HMOIS")-map.get("NHABS")-map.get("NHABSPAYE");
		}else if(codeVar.trim().equalsIgnoreCase("NHABS")){//Nombre Heure d'Absence dans la période
			return map.get("NHABS");
		}else if(codeVar.trim().equalsIgnoreCase("NHABSPAYE")){//Nombre Heure d'Absence dans la période
			return map.get("NHABSPAYE");
		}else if(codeVar.trim().equalsIgnoreCase("NHCOMP")){//Nombre Heure complementaire 
			
		}else if(codeVar.trim().equalsIgnoreCase("NHSUP120")){//Nombre Heure supplementaire payé a 120% 
			
		}else if(codeVar.trim().equalsIgnoreCase("NHSUP130")){//Nombre Heure supplementaire payé a 130% 
			
		}else if(codeVar.trim().equalsIgnoreCase("NHSUP140")){//Nombre Heure supplementaire payé a 140% 
			
		}else if(codeVar.trim().equalsIgnoreCase("NHSUP150")){//Nombre Heure supplementaire payé a 150% 
			
		}else if(codeVar.trim().equalsIgnoreCase("NJABS")){//Nombres de jours absence dans la periode
			return map.get("NJABS");
		}else if(codeVar.trim().equalsIgnoreCase("NJABSPAYE")){//Nombres de jours absence payé dans la periode
			return map.get("NJABSPAYE");
		}else if(codeVar.trim().equalsIgnoreCase("HMOIS")){//Nombre d'heure de travail par mois
			return map.get("HMOIS");
		}else if(codeVar.trim().equalsIgnoreCase("JTRAV")){//Nombres de jours de travail dans le mois
			return map.get("JTRAV");
		}else if(codeVar.trim().equalsIgnoreCase("JTRAVPAYE")){//Nombres de jours travaillé dans la periode
			return map.get("JTRAV") - map.get("NJABS") + map.get("NJABSPAYE");
		}else if(codeVar.trim().equalsIgnoreCase("TYPECONTRAT")){//Categorie contrat du salarié 0 = CDD 1=CDI 2=Fonctionnaire détaché 3=Temporaire 4=Stagiaires 5=Autres
			return Double.parseDouble(contrat!=null ? contrat.getType().getCategorie():"0.0");
		}else if(codeVar.trim().equalsIgnoreCase("HCONGE")){//Nombre heure congé sur une periode
			
		}else if(codeVar.trim().equalsIgnoreCase("NBENFT21")){	
                        Double value = 0.0;
                        for(Famille fam : salarie.getFamilles()){
                           if(fam.getQualite().trim().equalsIgnoreCase("0")&&fam.getEligible().equals(Boolean.TRUE)){
                                   value  +=1;
                           }//end if(fam.getEligible()==Boolean.TRUE)
                        }//end for(Famille fam : salarie.getFamilles()){
			return value;
		}else if(codeVar.trim().equalsIgnoreCase("NBENFT")){	
                    //Nombre total d'enfant
                        Double value = 0.0;
                        for(Famille fam : salarie.getFamilles()){
                           if(fam.getQualite().trim().equalsIgnoreCase("0")){
                                   value  +=1;
                           }//end if(fam.getEligible()==Boolean.TRUE)
                        }//end for(Famille fam : salarie.getFamilles()){
                        return value;
		}else if(codeVar.trim().equalsIgnoreCase("ANCIENITEGELE")){
			return contrat!=null&&contrat.getGele()==null ? 0.0 : Double.parseDouble(contrat.getGele().toString());
		}else if(codeVar.trim().equalsIgnoreCase("TYPEAGENT")){//0=Agent local et 1 = fonctionnaire
			return Double.parseDouble(salarie.getStatut());
		}else if(codeVar.trim().equalsIgnoreCase("HANDICAPE")){//0 = Agent non handicape 1 - agent handicapé
			return (salarie.getHandicape()==null||salarie.getHandicape().equals(Boolean.FALSE)) ? 0.0:1.0;
		}else if(codeVar.trim().equalsIgnoreCase("SEXE")){//O:Masculin 1:Feminin
			return (salarie.getGenre()!=null ? Double.parseDouble(salarie.getGenre()):0.0);
		}else if(codeVar.trim().equalsIgnoreCase("CATEGORIE")){//Categorie du Salarie
			return Double.parseDouble(contrat!=null ? contrat.getCategorie().getCode().toString():"0.0");
		}else if(codeVar.trim().equalsIgnoreCase("ECHELON")){//Echelon du salarie
			
		}else if(codeVar.trim().equalsIgnoreCase("INDICE")){//Indice de solde du salarie
			return contrat!=null&&contrat.getIndice()==null ?  0.0 : Double.parseDouble(contrat.getIndice().toString());
		}else if(codeVar.equalsIgnoreCase("AFFECTE")){//0 : employé non affecté 1:Employe affecte
			return salarie.getAffecte()==null || salarie.getAffecte().equals(Boolean.FALSE) ? 0.0 : 1.0;
		}else if(codeVar.trim().equalsIgnoreCase("EAU")){//Employé en eau 0 = non 1=Oui
			return salarie.getEau()==null||salarie.getEau().equals(Boolean.FALSE) ? 0.0:1.0;	
		}else if(codeVar.trim().equalsIgnoreCase("ELECTRICITE")){//Employé ayant des avantage en electricite 0 = non 1=Oui
			return salarie.getElectricite()==null||salarie.getElectricite().equals(Boolean.FALSE) ? 0.0:1.0;	
		}else if(codeVar.trim().equalsIgnoreCase("VEHICULE")){//Employé Vehiculé 0 = non 1=Oui
			return salarie.getVehicule()==null||salarie.getVehicule().equals(Boolean.FALSE)? 0.0:1.0;
		}else if(codeVar.trim().equalsIgnoreCase("LOGEMENT")){//Employé Logé 0 = non 1=Oui
			return salarie.getLogement()==null||salarie.getLogement()==Boolean.FALSE ? 0.0 : 1.0;
		}else if(codeVar.trim().equalsIgnoreCase("MANAGERE")){//Employé avantage ménagères 0 = non 1=Oui
			return salarie.getMenagere()==null||salarie.getMenagere()==Boolean.FALSE ? 0.0 : 1.0;
		}else if(codeVar.trim().equalsIgnoreCase("ALIMENTAIRE")){//Employé avantage alimentaire 0 = non 1=Oui
			return salarie.getAlimentaire()==null||salarie.getAlimentaire()==Boolean.FALSE ? 0.0 : 1.0;
		}else if(codeVar.trim().equalsIgnoreCase("COMPSAL")){//Complement salaire employé
			return salarie.getCmplsalaire()==null ? 0.0 :salarie.getCmplsalaire();
		}else if(codeVar.trim().equalsIgnoreCase("SYNDIQUE")){//employe syndique = 1 non syndique = 0
			return salarie.getSyndique()==null||salarie.getSyndique().equals(Boolean.FALSE) ? 0.0:1.0;
		}else if(codeVar.trim().equalsIgnoreCase("TAUXSYNDICAL")){//Taux de retenue syndical
			return salarie.getTauxsyndical()==null ? 0.0 : salarie.getTauxsyndical();
		}else if(codeVar.trim().equalsIgnoreCase("ANCIEN")){
			int months = 0;
                        if(contrat!=null&&contrat.getDrecurtement()!=null){
                            months = DateHelper.numberOfMonth(contrat.getDrecurtement(), periode.getDfin());
                        }//end if(contrat!=null&&contrat.getDrecurtement()!=null){
			return Double.parseDouble(Integer.toString(months));
		}else if(codeVar.trim().equalsIgnoreCase("RETRAITECOMPL")){//Retraite complementaire
			return salarie.getRetraitcomplementaire()==null ? 0.0 : salarie.getRetraitcomplementaire();
		}else if(codeVar.trim().equalsIgnoreCase("INDEMLOGEMENT")){//Indemnité de Logement
			return salarie.getIdemlogement()==null ? 0.0 : salarie.getIdemlogement();
		}else if(codeVar.trim().equalsIgnoreCase("SALBASENEGO")){//Salaire de base négocie
			return salarie.getSalbase()==null ? 0.0 : salarie.getSalbase();
		}else if(codeVar.trim().equalsIgnoreCase("NOEL")){//Arbre de Noel 
			return salarie.getNoel()==null ? 0.0 : salarie.getNoel();
		}else if(codeVar.trim().equalsIgnoreCase("NMOIS")){//Renvoie le nombres de mois de l'exercice
			return Double.parseDouble(""+DateHelper.numberOfMonth(periode.getExercice().getDebut(), periode.getExercice().getFin()));
		}else if(codeVar.trim().equalsIgnoreCase("MEDAILLE")){//Nombres de medailles que l'employe a recu 
			return salarie.getMedailles()==null ? 0.0 : Double.parseDouble(""+salarie.getMedailles().size());
		}//end if(codeVar.trim().equalsIgnoreCase("SALCATEGO")) 	
		return valeur;
	}

	/**
	 * 
	 * @param jour
	 * @param structure
	 */
	private Double getHours(Date jour , Societe structure){
		Double heure = 0.0;
		//Construction du cache devant contenir
		Map<String, Planification> weekDay = new HashMap<String, Planification>();
		for(Planification plan:structure.getPlanifications()){
			weekDay.put(plan.getCode(), plan);
		}//end for(Planification plan:structure.getPlanifications()){
		Calendar c = Calendar.getInstance();
		c.setTime(jour);
		if(c.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY){
			if(weekDay.get("Lundi")!=null&&weekDay.get("Lundi").getOuvert()!=null
                                &&weekDay.get("Lundi").getOuvert().equals(Boolean.TRUE)){
				heure += weekDay.get("Lundi").getHeures();
			}//end if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
		}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY){
			if(weekDay.get("Mardi")!=null&&weekDay.get("Mardi").getOuvert()!=null
                                &&weekDay.get("Mardi").getOuvert().equals(Boolean.TRUE)){
				heure += weekDay.get("Mardi").getHeures();
			}//end if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
		}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY){
			if(weekDay.get("Mercredi")!=null&&weekDay.get("Mercredi").getOuvert()!=null
                                &&weekDay.get("Mercredi").getOuvert().equals(Boolean.TRUE)){
				heure += weekDay.get("Mercredi").getHeures();
			}//end if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
		}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY){
			if(weekDay.get("Jeudi")!=null&&weekDay.get("Jeudi").getOuvert()!=null
                                &&weekDay.get("Jeudi").getOuvert().equals(Boolean.TRUE)){
				heure += weekDay.get("Jeudi").getHeures();
			}//end if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
		}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
			if(weekDay.get("Vendredi")!=null&&weekDay.get("Vendredi").getOuvert()!=null
                                &&weekDay.get("Vendredi").getOuvert().equals(Boolean.TRUE)){
				heure += weekDay.get("Vendredi").getHeures();
			}//end if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
		}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
			if(weekDay.get("Samedi")!=null&&weekDay.get("Samedi").getOuvert()!=null
                                &&weekDay.get("Samedi").getOuvert().equals(Boolean.TRUE)){
				heure += weekDay.get("Samedi").getHeures();
			}//end if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
		}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
			if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
                                &&weekDay.get("Dimanche").getOuvert().equals(Boolean.TRUE)){
				heure += weekDay.get("Dimanche").getHeures();
			}//end if(weekDay.get("Dimanche")!=null&&weekDay.get("Dimanche").getOuvert()!=null
		}//end if(c.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY){
		return heure;
	}
	/**
	 * 
	 * @param periode
	 * @param salarie
	 * @param structure
	 * @return
	 */
	private Map<String, Double> calculHeures(PeriodePaie periode, Employe salarie,Societe structure){
		//Total des jours d'absence
		Double jAbs = 0.0;
		//Total des heures d'absences
		Double hAbs = 0.0;
		//Total des jours d'absence payés
		Double jAbsPaye = 0.0;
		//Total des heures d'absence payes
		Double hAbsPaye = 0.0;
		//Total des retard non justifié
		Double hRet = 0.0 ;
		
		Map<String, Double> map = new HashMap<String, Double>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addGe("datepointage", periode.getDdebut());
		container.addGe("datepointage", periode.getDfin());
		List<LignePointage> pointages = pointageedao.filter(container.getPredicats(),null,null,-1, 0);
		for(LignePointage ligne:pointages){
			if(ligne.getAbsent()){
			    jAbs =jAbs + 1 ;
			    hAbs += getHours(ligne.getDatepointage(), structure);
			    if(ligne.getState().equalsIgnoreCase("justifier")){
			    	jAbsPaye +=1 ;
			    	hAbsPaye += getHours(ligne.getDatepointage(), structure);
			    }//end if(ligne.getState().equalsIgnoreCase("justifier")){
			}else if(ligne.getRetard()){
				if(ligne.getState().equalsIgnoreCase("nonjustifier")){
					Double heuretrav =getHours(ligne.getDatepointage(), structure);
					Double heurepres = DateHelper.numberHours(ligne.getHeurearrive(),ligne.getHeuredepart());
					if(heurepres.compareTo(heuretrav)<=0){
						hRet += (heuretrav-heurepres);
					}//end if(heurepres.compareTo(heuretrav)<=0)
				}//end if(ligne.getState().equalsIgnoreCase("nonjustifier")){
			}//end if(ligne.getAbsent()){
		}//end for(LignePointage ligne:pointages){
		map.put("NHABS", hAbs+hRet);
		map.put("NJABS", jAbs);
		map.put("NJABSPAYE", jAbsPaye);
		map.put("NHABSPAYE", hAbsPaye);
		map.put("JTRAV", salarie.getNbrejours());
		map.put("HMOIS", heuresPeriode(periode, salarie,structure));
		return map;
	}
	
	
	/**
	 * 
	 * @param periode
	 * @param salarie
	 * @return
	 */
	private Double heuresPeriode(PeriodePaie periode , Employe salarie,Societe structure){
		Double heure = 0.0;
		if(salarie.getStructure()==null){
			throw new KerenPaieManagerException("Le Salarié "+salarie.getDesignation()+" n'est affecté à aucune Structure");
		}//end if(salarie.getStructure()==null){
		//Construction du cache devant contenir
		Map<String, Planification> weekDay = new HashMap<String, Planification>();
		for(Planification plan:structure.getPlanifications()){
			weekDay.put(plan.getCode(), plan);
		}//end for(Planification plan:structure.getPlanifications()){
		Date begin = periode.getDdebut();
		do{
			Calendar c = Calendar.getInstance();
			c.setTime(begin);
			if(c.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY){
				if(weekDay.get("Lundi")!=null && weekDay.get("Lundi").getOuvert()!=null                                       
                                        && weekDay.get("Lundi").getOuvert().equals(Boolean.TRUE)){
					heure += weekDay.get("Lundi").getHeures();
				}//end if(weekDay.get("Lundi")!=null && weekDay.get("Lundi").getOuvert()!=null  
			}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.TUESDAY){
				if(weekDay.get("Mardi")!=null && weekDay.get("Mardi").getOuvert()!=null                                       
                                        && weekDay.get("Mardi").getOuvert().equals(Boolean.TRUE)){
					heure += weekDay.get("Mardi").getHeures();
				}//end if(weekDay.get("Mardi")!=null && weekDay.get("Mardi").getOuvert()!=null  
			}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.WEDNESDAY){
				if(weekDay.get("Mercredi")!=null && weekDay.get("Mercredi").getOuvert()!=null                                       
                                        && weekDay.get("Mercredi").getOuvert().equals(Boolean.TRUE)){
					heure += weekDay.get("Mercredi").getHeures();
				}//end if(weekDay.get("Mercredi")!=null && weekDay.get("Mercredi").getOuvert()!=null 
			}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.THURSDAY){
				if(weekDay.get("Jeudi")!=null && weekDay.get("Jeudi").getOuvert()!=null                                       
                                        && weekDay.get("Jeudi").getOuvert().equals(Boolean.TRUE)){
					heure += weekDay.get("Jeudi").getHeures();
				}//end if(weekDay.get("Jeudi")!=null && weekDay.get("Jeudi").getOuvert()!=null 
			}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.FRIDAY){
				if(weekDay.get("Vendredi")!=null && weekDay.get("Vendredi").getOuvert()!=null                                       
                                        && weekDay.get("Vendredi").getOuvert().equals(Boolean.TRUE)){
					heure += weekDay.get("Vendredi").getHeures();
				}//end if(weekDay.get("Vendredi")!=null && weekDay.get("Vendredi").getOuvert()!=null 
			}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SATURDAY){
				if(weekDay.get("Samedi")!=null && weekDay.get("Samedi").getOuvert()!=null                                       
                                        && weekDay.get("Samedi").getOuvert().equals(Boolean.TRUE)){
					heure += weekDay.get("Samedi").getHeures();
				}//end if(weekDay.get("Samedi")!=null && weekDay.get("Samedi").getOuvert()!=null  
			}else if(c.get(Calendar.DAY_OF_WEEK)==Calendar.SUNDAY){
				if(weekDay.get("Dimanche")!=null && weekDay.get("Dimanche").getOuvert()!=null                                       
                                        && weekDay.get("Dimanche").getOuvert().equals(Boolean.TRUE)){
					heure += weekDay.get("Dimanche").getHeures();
				}//end if(weekDay.get("Dimanche")!=null && weekDay.get("Dimanche").getOuvert()!=null
			}//end if(c.get(Calendar.DAY_OF_WEEK)==Calendar.MONDAY){
                        begin = DateHelper.next(begin, 1);
		}while(begin.compareTo(periode.getDfin())<0);
		return heure ;
	}
	/**Calcul du salaire de base
	 * SALBASE = SALCAT + SALaire Pondere + Complement salaire
	 * @param salarie
	 * @param contrat
	 * @return
	 */
	private Double salaireBase(Employe salarie , ContratTravail contrat){		
		Double valeur ;
		Double salcat = salaireCategoriel(salarie, contrat);
		valeur = salcat + complementSalaire(salarie, contrat, salcat) + (salarie.getCmplsalaire()!=null ? salarie.getCmplsalaire() : 0.0);		
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
                if(contrat==null){
                    return valeur;
                }//end if(contrat==null){
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
		if(salarie.getStatut().equalsIgnoreCase("0")){	
			if(convension==null){
				convension = getCurrentConvension();
				//Verification existance convension active
				if(convension==null){
					throw new KerenPaieManagerException("Impossible de trouver une Grille Salariale Valide");
				}//end if(convension==null){
			}//end if(convension==null)
			for(LigneConvension ligne:convension.getLignes()){
				if(ligne.getCategorie().compareTo(salarie.getCategorie())==0
						&& ligne.getEchelon().compareTo(salarie.getEchelon())==0){
					return ligne.getSalbase();
				}//end if(ligne.getCategorie().compareTo(salarie.getCategorie())==0
			}//end for(LigneConvension ligne:convension.getLignes()){
		}else if(salarie.getStatut().equalsIgnoreCase("1")){
			if(indice==null){
				indice = getCurrentIndiceSolde();
				if(indice==null){
					throw new KerenPaieManagerException("Impossible de trouver un Indice de Solde Valide");
				}//end if(indice==null){
			}
			for(LigneIndiceSolde ligne:indice.getIndicessolde()){
				if(ligne.getCategorie().compareTo(salarie.getCategorie())==0
						&& ligne.getEchelon().compareTo(salarie.getEchelon())==0
						&& ligne.getIndice().compareTo(salarie.getIndice())==0){
					    return ligne.getSalbase();
				}//end if(ligne.getCategorie().compareTo(salarie.getCategorie())==0
			}//end for(LigneIndiceSolde ligne:indice.getIndicessolde()){
		}//end if(salarie.getStatut().equalsIgnoreCase("0"))
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
			if(forfait.getCategorie().compareTo(salarie.getCategorie())==0){
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
	private Double evalExpressionArithmetique(String expression ,Employe salarie,PeriodePaie periode,ContratTravail contrat,Societe structure){
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
					  Variable var = null; //
					  if(executorCache.containsKey(terme.toString())){
						  var = executorCache.get(terme.toString()).getVariable();
						  if(executorCache.get(terme.toString()).getValeur()!=null
								  &&executorCache.get(terme.toString()).getValeur().compareTo(0.0)>0){
							  Double value = executorCache.get(terme.toString()).getValeur();
							  operandStack.add(value);
						  }else{
							  Double value = eval(var, salarie, periode, contrat,structure);
							  operandStack.add(value);
							  executorCache.get(terme.toString()).setValeur(value);							 
						  }//end if(executorCache.get(terme.toString()).getValeur()!=null
					  }else{
						  var = variabledao.findByPrimaryKey("code",terme.toString());
						  if(var==null){
							  throw new KerenPaieManagerException("Impossible de trouver la variable : "+terme);
						  }//end if(var==null)
						  Double value = eval(var, salarie, periode, contrat,structure);
						  operandStack.add(value);
					  }//end if(executorCache.containsKey(terme.toString())){					 
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
					  Variable var = null; //
					  if(executorCache.containsKey(terme.toString())){
						  var = executorCache.get(terme.toString()).getVariable();
						  if(executorCache.get(terme.toString()).getValeur()!=null
								  &&executorCache.get(terme.toString()).getValeur().compareTo(0.0)>0){
							  Double value = executorCache.get(terme.toString()).getValeur();
							  operandStack.add(value);
						  }else{
							  Double value = eval(var, salarie, periode, contrat,structure);
							  operandStack.add(value);
							  executorCache.get(terme.toString()).setValeur(value);
						  }//end if(executorCache.get(terme.toString()).getValeur()!=null
					  }else{
						  var = variabledao.findByPrimaryKey("code",terme.toString());
						  if(var==null){
							  throw new KerenPaieManagerException("Impossible de trouver la variable : "+terme);
						  }//end if(var==null)
						  Double value = eval(var, salarie, periode, contrat,structure);
						  operandStack.add(value);
					  }//end if(executorCache.containsKey(terme.toString())){		
//					  if(var==null){
//						  throw new KerenPaieManagerException("Impossible de trouver la variable : "+terme);
//					  }//end if(var==null)
//					  Double value = eval(var, salarie, periode, contrat);
//					  operandStack.add(value);
				  }else if(state==3){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));
				  }else if(state==4){//Traitement du nombre
					  operandStack.add(Double.parseDouble(terme.toString()));
				  }//ed  operatorStack.add(')');
				  operatorStack.add(')');
				  state = matrice[3][state-1];
			  }else if(car==')'){
				  if(state==2){//Traitememnt de la nouvelle variable*
					  Double value = eval(terme.toString(), salarie, periode, contrat,structure);					  
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
					  Variable var = null; //
//					  System.out.println(MoteurPaieManagerImpl.class.toString()+" *********************************  Terme : "+terme+" ==== executor : "+executorCache.containsKey(terme.toString()));							  
					  if(executorCache.containsKey(terme.toString())){
						  var = executorCache.get(terme.toString()).getVariable();
						  if(executorCache.get(terme.toString()).getValeur()!=null
								  &&executorCache.get(terme.toString()).getValeur().compareTo(0.0)>0){
							  Double value = executorCache.get(terme.toString()).getValeur();
							  operandStack.add(value);
						  }else{
							  Double value = eval(var, salarie, periode, contrat,structure);							  
							  operandStack.add(value);
							  executorCache.get(terme.toString()).setValeur(value);
						  }//end if(executorCache.get(terme.toString()).getValeur()!=null
					  }else{
						  var = variabledao.findByPrimaryKey("code",terme.toString());
						  if(var==null){
							  throw new KerenPaieManagerException("Impossible de trouver la variable : "+terme);
						  }//end if(var==null)
						  Double value = eval(var, salarie, periode, contrat,structure);
						  operandStack.add(value);
					  }//end if(executorCache.containsKey(terme.toString())){		
//					  Variable var = variabledao.findByPrimaryKey("code",terme.toString());
//					  if(var==null){
//						  throw new KerenPaieManagerException("Impossible de trouver la variable : "+terme);
//					  }//end if(var==null)
//					  Double value = eval(var, salarie, periode, contrat);				  
//					  operandStack.add(value);	
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
	private Double evalSIExpression(String formule ,Employe salarie,PeriodePaie periode,ContratTravail contrat,Societe structure){
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
//		System.out.println(MoteurPaieManagerImpl.class.toString()+" ============================ FORMULE : "+builder.toString());
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
					Double value = eval(var, salarie, periode, contrat,structure);
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
					Double value = eval(var, salarie, periode, contrat,structure);
					operandStack.add(value);
					oper = new StringBuilder(car);
				}else if(state==5 || state==6){
					operandStack.add(Double.parseDouble(terme.toString()));
					oper = new StringBuilder();
					oper.append(car);
				}else if(state==8||state==7){
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
				if(state==13){
					oper = new StringBuilder();
				}
				state = matrice[10][state-1];
			}else if(car=='h'){
				state = matrice[11][state-1];
			}else if(car=='e'){
				if(state==21){
					if(testResult){
						return evalExpressionArithmetique(expression.toString().trim(), salarie, periode, contrat,structure);
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
				if(state==13){
					oper = new StringBuilder();
				}
				state = matrice[17][state-1];
			}else if(car=='@'){
				if(state==18||state==19||state==20||state==21){
					if(testResult){
//						System.out.println(MoteurPaieManagerImpl.class.toString()+" ============================ EXPRESSION : "+expression.toString().trim());
						return evalExpressionArithmetique(expression.toString().trim(), salarie, periode, contrat,structure);
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
//		System.out.println(MoteurPaieManagerImpl.class.toString()+" ======= oper : "+operateur+" === left : "+left+" === "+rigth);
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


	/**
	 * Responsable de la generation des bulletion de paie
	 * @param entity
	 */
    private List<Employe> creationBulletinPaiePeriode(PrepaSalaire entity){
        
    	
    	//Verification de l'existance d'une variable ACOMPTE    	
		List<Employe> salaries = new ArrayList<Employe>();
		if(entity.getPorte().trim().equalsIgnoreCase("0")){//Tout les employes
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			salaries.addAll(employedao.filter(container.getPredicats(), null, null, 0, -1));
		}else if(entity.getPorte().trim().equalsIgnoreCase("1")){//Employes selectionnés
			salaries.addAll(entity.getConcernes());
		}//end if(entity.getPorte().trim().equalsIgnoreCase("0"))
		//Construction des Bulletin
		for(Employe salarie:salaries){
                        //Cache des lignes du bulletion de paie
                        HashMap<String, LigneBulletinPaie> datacache = new HashMap<String, LigneBulletinPaie>();    	
                        /**
                         * Cache des variables de paie
                         */
                        HashMap<String, LigneElementVariable> variablecache = new HashMap<String, LigneElementVariable>();
			if(salarie.getProfilpaie()==null){
				throw new KerenExecption("Le salarié "+salarie.getDesignation()+" n'a pas de Profil de Paie lié");
			}//end if(salarie.getProfilpaie()==null)
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("employe", salarie);
			container.addEq("periode", entity.getPeriode());
			List<BulletinPaie> bulletins = dao.filter(container.getPredicats(),null,null, 0, -1);
			BulletinPaie bulletin =null;
			if(bulletins!=null&&!bulletins.isEmpty()){
				//Suppressions des anciens bulletins de paie
                            for(BulletinPaie bul:bulletins){
                                dao.delete(bul.getId());
                            }//end for(BulletinPaie bul:bulletins){
			}//end if(bulletins!=null&&!bulletins.isEmpty()){
                        bulletin = new BulletinPaie(salarie.getNom(), salarie, null, entity.getPeriode());
//			if(bulletin!=null){
//				continue;
//			}//end if(bulletin!=null){
			ProfilPaie profil = profildao.findByPrimaryKey("id", salarie.getProfilpaie().getId());
			//Construction de la liste des variables de paie
			container = RestrictionsContainer.newInstance();
			container.addEq("salarie", true);
			List<Variable> variables = variabledao.filter(container.getPredicats(), null, null, 0, -1);
			//Construction des variable du salarie
			for(Variable var:variables){
				LigneElementVariable ligne = new LigneElementVariable();
				ligne.setVariable(var);
				//ligne.setValeur(eval(var,salarie));
				//Mise en cache de la variable
				variablecache.put(var.getCode(), ligne);
                                if(!bulletin.getVariables().contains(ligne)){
                                    bulletin.getVariables().add(ligne);
                                } else{
                                    int index = bulletin.getVariables().indexOf(ligne);
                                    bulletin.getVariables().set(index, ligne);
                                 }//end if(!bulletin.getLignes().contains(ligne))
			}//end for(Variable var:variables){
			for(Rubrique rubrique:profil.getRubriques()){				
				LigneBulletinPaie ligne = null;
				if(datacache.containsKey(rubrique.getCode())){
					ligne = datacache.get(rubrique.getCode());
					//ligne.setValeur(eval(rubrique,salarie) + ligne.getValeur());
				}else{
                                        ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
					//ligne.setValeur(eval(rubrique,salarie));
                                        datacache.put(rubrique.getCode(), ligne);					
				}//end if(datacache.containsKey(rubrique.getCode())){
                                if(!bulletin.getLignes().contains(ligne)){
                                    bulletin.getLignes().add(ligne);
                                }else{
                                    int index = bulletin.getLignes().indexOf(ligne);
                                    bulletin.getLignes().set(index, ligne);
                                 }//end if(!bulletin.getLignes().contains(ligne))
			}//end for(Rubrique rubrique:profil.getRubriques()){
			//Traitement des rubriques complementaires
			salarie = employedao.findByPrimaryKey("id", salarie.getId());
			if(salarie.getRubriques()!=null){
				for(Rubrique rubrique:salarie.getRubriques()){				
					LigneBulletinPaie ligne = null;
					if(datacache.containsKey(rubrique.getCode())){
						ligne = datacache.get(rubrique.getCode());
						//ligne.setValeur(eval(rubrique,salarie) + ligne.getValeur());
					}else{
						ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
						//ligne.setValeur(eval(rubrique,salarie));
                                                datacache.put(rubrique.getCode(), ligne);
					}//end if(datacache.containsKey(rubrique.getCode())){	
                                        if(!bulletin.getLignes().contains(ligne)){
                                            bulletin.getLignes().add(ligne);
                                        }else{
                                           int index = bulletin.getLignes().indexOf(ligne);
                                           bulletin.getLignes().set(index, ligne);
                                        }//end if(!bulletin.getLignes().contains(ligne))
				}//end for(Rubrique rubrique:profil.getRubriques()){
			}//end if(salarie.getRubriques()!=null)
		    //Traitement des Elements variables(Prêt , avances,...)
                    container = RestrictionsContainer.newInstance();
                    container.addEq("salarie0", salarie);
                    container.addEq("peiode", entity.getPeriode());
                    List<ElementVariable> eltsvariables = eltvariabledao.filter(container.getPredicats(), null,null, 0, -1);
		    if(eltsvariables!=null&&!eltsvariables.isEmpty()){
		    	ElementVariable eltvar = eltsvariables.get(0);
                        //Remboursement Avances
		    	for(RemboursementAvance rem:eltvar.getAvances()){
		    		Rubrique rubrique = rem.getAvance().getRubrique();
		    		LigneBulletinPaie ligne = null;
					if(datacache.containsKey(rubrique.getCode())){
						ligne = datacache.get(rubrique.getCode());
						ligne.setValeur(rem.getMontant() + ligne.getValeur());
					}else{
						ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
						ligne.setValeur(rem.getMontant());
                                                datacache.put(rubrique.getCode(), ligne);					
					}//end if(datacache.containsKey(rubrique.getCode())){
                                        if(!bulletin.getLignes().contains(ligne)){
                                            bulletin.getLignes().add(ligne);
                                        }else{
                                           int index = bulletin.getLignes().indexOf(ligne);
                                           bulletin.getLignes().set(index, ligne);
                                        }//end if(!bulletin.getLignes().contains(ligne))
		    	}//end for(RemboursementAvance rem:eltvar.getAvances())
		    	//Remboursement Prêts
		    	for(RemboursementPret rem:eltvar.getPrets()){
                            Rubrique rubrique = rem.getPret().getRubrique();
                            LigneBulletinPaie ligne = null;
                            if(datacache.containsKey(rubrique.getCode())){
                                    ligne = datacache.get(rubrique.getCode());
                                    ligne.setValeur(rem.getMontant() + ligne.getValeur());
                            }else{
                                    ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
                                    ligne.setValeur(rem.getMontant());
                                    datacache.put(rubrique.getCode(), ligne);					
                            }//end if(datacache.containsKey(rubrique.getCode())){	
                            if(!bulletin.getLignes().contains(ligne)){
                                bulletin.getLignes().add(ligne);
                            }else{
                                int index = bulletin.getLignes().indexOf(ligne);
                                bulletin.getLignes().set(index, ligne);
                             }//end if(!bulletin.getLignes().contains(ligne))
		    	}//end for(RemboursementAvance rem:eltvar.getAvances())
		    	//Rappel Salaires
		    	for(Rappel rap:eltvar.getRappels()){
                            for(LigneRappel lign:rap.getLignes()){
                                Rubrique rubrique = lign.getRubrique();
                                LigneBulletinPaie ligne = null;
                                if(datacache.containsKey(rubrique.getCode())){
                                        ligne = datacache.get(rubrique.getCode());
                                        ligne.setValeur(lign.getMontant() + ligne.getValeur());
                                }else{
                                        ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
                                        ligne.setValeur(lign.getMontant());
                                        datacache.put(rubrique.getCode(), ligne);					
                                }//end if(datacache.containsKey(rubrique.getCode())){	
                                if(!bulletin.getLignes().contains(ligne)){
                                    bulletin.getLignes().add(ligne);
                                }else{
                                    int index = bulletin.getLignes().indexOf(ligne);
                                    bulletin.getLignes().set(index, ligne);
                                 }//end if(!bulletin.getLignes().contains(ligne))
                            }//end for(Rubrique rubrique:rap.getLignes()){
		    	}//end for(RemboursementAvance rem:eltvar.getAvances())
		    	//Traitement Acompte en cours
		    	for(Acompte acompte:eltvar.getAcomptes()){
		            LigneElementVariable ligne = null;
		    	    if(variablecache.containsKey(acompte.getVariable().getCode())){
		    	    	ligne = variablecache.get(acompte.getVariable().getCode());
		    	    	ligne.setValeur(acompte.getMontant() + ligne.getValeur());
		    	    }else{
		    	    	ligne = new LigneElementVariable();
		    	    	ligne.setVariable(acompte.getVariable());
		    	    	ligne.setValeur(acompte.getMontant());
		    	    }//end  if(variablecache.containsKey(V_ACOMPTE)){
		    		//Mise a jour de la liste des variable
                            if(!bulletin.getVariables().contains(ligne)){
                                bulletin.getVariables().add(ligne);
                            }else{
                                int index = bulletin.getVariables().indexOf(ligne);
                                bulletin.getVariables().set(index, ligne);
                             }//end if(!bulletin.getLignes().contains(ligne))
		    	}//end for(Acompte acompte:eltvar.getAcomptes())
		    }//end if(eltsvariables!=null&&!eltsvariables.isEmpty())
//                    System.out.println(MoteurPaieManagerImpl.class.toString()+".creationBulletinPaiePeriode(PrepaSalaire entity) ============"+bulletin);                                       
		    if(bulletin.getId()>0){
		    	dao.update(bulletin.getId(), bulletin);
		    }else {
		    	dao.save(bulletin);
//                        System.out.println(MoteurPaieManagerImpl.class.toString()+" ==================================== "+bulletin);
		    }//end if(bulletin.getId()>0){
		}//end for(Employe salarie:salaries)
                return salaries;
    }//end private void creationBulletinPaiePeriode(PrepaSalaire entity){
	
    /**
     * Retourne la convension active
     * @return
     */
    private Convension getCurrentConvension(){
    	RestrictionsContainer container = RestrictionsContainer.newInstance();
    	container.addEq("state", "actif");
    	List<Convension> datas = convensiondao.filter(container.getPredicats(), null, null, 0, -1);
    	return datas.size()>0 ? datas.get(0):null;
    }
    
    /**
     * 
     * @return
     */
    private IndiceSolde getCurrentIndiceSolde(){
    	RestrictionsContainer container = RestrictionsContainer.newInstance();
    	container.addEq("state", "active");
    	List<IndiceSolde> datas = indicesoldedao.filter(container.getPredicats(), null, null, 0, -1);
    	return datas.size()>0 ? datas.get(0):null;
    }

	
}
