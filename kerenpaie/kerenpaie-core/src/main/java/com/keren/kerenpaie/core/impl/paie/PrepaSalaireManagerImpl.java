
package com.keren.kerenpaie.core.impl.paie;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.paie.PrepaSalaireManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.PrepaSalaireManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.EmployeDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.BulletinPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ElementVariableDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.PrepaSalaireDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ProfilPaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.VariableDAOLocal;
import com.keren.kerenpaie.model.employes.Employe;
import com.keren.kerenpaie.model.paie.PrepaSalaire;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.paie.Variable;

@TransactionAttribute
@Stateless(mappedName = "PrepaSalaireManager")
public class PrepaSalaireManagerImpl
    extends AbstractGenericManager<PrepaSalaire, Long>
    implements PrepaSalaireManagerLocal, PrepaSalaireManagerRemote
{

    @EJB(name = "PrepaSalaireDAO")
    protected PrepaSalaireDAOLocal dao;
    
    @EJB(name = "EmployeDAO")
    protected EmployeDAOLocal employedao;
    
    @EJB(name = "ProfilPaieDAO")
    protected ProfilPaieDAOLocal profildao;
    
    @EJB(name = "VaraibleDAO")
    protected VariableDAOLocal variabledao;
    
    @EJB(name = "BulletinPaieDAO")
    protected BulletinPaieDAOLocal bulletindao;
    
    @EJB(name = "ElementVariableDAO")
    protected ElementVariableDAOLocal eltvariabledao;
    
    

    public PrepaSalaireManagerImpl() {
    }

    @Override
    public GenericDAO<PrepaSalaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }	
	
//	public PrepaSalaire save(PrepaSalaire entity) {
//		// TODO Auto-generated method stub
//		HashMap<String, LigneBulletinPaie> datacache = new HashMap<String, LigneBulletinPaie>();
//		//Verification de l'existance d'une variable ACOMPTE    	
//		List<Employe> salaries = new ArrayList<Employe>();
//		if(entity.getPorte().trim().equalsIgnoreCase("0")){//Tout les employes
//			RestrictionsContainer container = RestrictionsContainer.newInstance();
//			salaries.addAll(employedao.filter(container.getPredicats(), null, null, 0, -1));
//		}else if(entity.getPorte().trim().equalsIgnoreCase("1")){//Employes selectionnés
//			salaries.addAll(entity.getConcernes());
//		}//end if(entity.getPorte().trim().equalsIgnoreCase("0"))
//		//Construction des Bulletin
//		for(Employe salarie:salaries){
//			if(salarie.getProfilpaie()==null){
//				throw new KerenExecption("Le salarié "+salarie.getDesignation()+" n'a pas de Profil de Paie lié");
//			}//end if(salarie.getProfilpaie()==null)
//			RestrictionsContainer container = RestrictionsContainer.newInstance();
//			container.addEq("employe", salarie);
//			container.addEq("periode", entity.getPeriode());
//			List<BulletinPaie> bulletins = bulletindao.filter(container.getPredicats(),null,null, 0, -1);
//			BulletinPaie bulletin =null;
//			if(bulletins!=null&&!bulletins.isEmpty()){
//				bulletin = bulletins.get(0);
//			}//end if(bulletins!=null&&!bulletins.isEmpty()){
//			if(bulletin!=null){
//				continue;
//			}//end if(bulletin!=null){
//			bulletin = new BulletinPaie(salarie.getNom(), salarie, null, entity.getPeriode());
//			ProfilPaie profil = profildao.findByPrimaryKey("id", salarie.getProfilpaie().getId());
//			//Construction de la liste des variables de paie
//			container = RestrictionsContainer.newInstance();
//			container.addEq("salarie", true);
//			List<Variable> variables = variabledao.filter(container.getPredicats(), null, null, 0, -1);
//			//Construction des variable du salarie
//			for(Variable var:variables){
//				LigneElementVariable ligne = new LigneElementVariable();
//				ligne.setVariable(var);
//				ligne.setValeur(eval(var,salarie));
//				bulletin.getVariables().add(ligne);
//			}//end for(Variable var:variables){
//			for(Rubrique rubrique:profil.getRubriques()){				
//				LigneBulletinPaie ligne = null;
//				if(datacache.containsKey(rubrique.getCode())){
//					ligne = datacache.get(rubrique.getCode());
//					ligne.setValeur(eval(rubrique,salarie) + ligne.getValeur());
//				}else{
//					ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
//					ligne.setValeur(eval(rubrique,salarie));
//				}//end if(datacache.containsKey(rubrique.getCode())){
//				bulletin.getLignes().add(ligne);
//			}//end for(Rubrique rubrique:profil.getRubriques()){
//			//Traitement des rubriques complementaires
//			salarie = employedao.findByPrimaryKey("id", salarie.getId());
//			if(salarie.getRubriques()!=null){
//				for(Rubrique rubrique:salarie.getRubriques()){				
//					LigneBulletinPaie ligne = null;
//					if(datacache.containsKey(rubrique.getCode())){
//						ligne = datacache.get(rubrique.getCode());
//						ligne.setValeur(eval(rubrique,salarie) + ligne.getValeur());
//					}else{
//						ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
//						ligne.setValeur(eval(rubrique,salarie));
//					}//end if(datacache.containsKey(rubrique.getCode())){		
//					bulletin.getLignes().add(ligne);
//				}//end for(Rubrique rubrique:profil.getRubriques()){
//			}//end if(salarie.getRubriques()!=null)
//		    //Traitement des Elements variables(Prêt , avances,...)
//			container = RestrictionsContainer.newInstance();
//			container.addEq("salarie0", salarie);
//			container.addEq("peiode", entity.getPeriode());
//			List<ElementVariable> eltsvariables = eltvariabledao.filter(container.getPredicats(), null,null, 0, -1);
//		    if(eltsvariables!=null&&!eltsvariables.isEmpty()){
//		    	ElementVariable eltvar = eltsvariables.get(0);
//		    	//Remboursement Avances
//		    	for(RemboursementAvance rem:eltvar.getAvances()){
//		    		Rubrique rubrique = rem.getAvance().getRubrique();
//		    		LigneBulletinPaie ligne = null;
//					if(datacache.containsKey(rubrique.getCode())){
//						ligne = datacache.get(rubrique.getCode());
//						ligne.setValeur(rem.getMontant() + ligne.getValeur());
//					}else{
//						ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
//						ligne.setValeur(rem.getMontant());
//					}//end if(datacache.containsKey(rubrique.getCode())){		
//		    		bulletin.getLignes().add(ligne);
//		    	}//end for(RemboursementAvance rem:eltvar.getAvances())
//		    	//Remboursement Prêts
//		    	for(RemboursementPret rem:eltvar.getPrets()){
//		    		Rubrique rubrique = rem.getPret().getRubrique();
//		    		LigneBulletinPaie ligne = null;
//					if(datacache.containsKey(rubrique.getCode())){
//						ligne = datacache.get(rubrique.getCode());
//						ligne.setValeur(rem.getMontant() + ligne.getValeur());
//					}else{
//						ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
//						ligne.setValeur(rem.getMontant());
//					}//end if(datacache.containsKey(rubrique.getCode())){	
//		    		bulletin.getLignes().add(ligne);
//		    	}//end for(RemboursementAvance rem:eltvar.getAvances())
//		    	//Rappel Salaires
//		    	for(Rappel rap:eltvar.getRappels()){
//		    		for(LigneRappel lign:rap.getLignes()){
//		    			Rubrique rubrique = lign.getRubrique();
//			    		LigneBulletinPaie ligne = null;
//						if(datacache.containsKey(rubrique.getCode())){
//							ligne = datacache.get(rubrique.getCode());
//							ligne.setValeur(lign.getMontant() + ligne.getValeur());
//						}else{
//							ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
//							ligne.setValeur(lign.getMontant());
//						}//end if(datacache.containsKey(rubrique.getCode())){	
//						bulletin.getLignes().add(ligne);
//		    		}//end for(Rubrique rubrique:rap.getLignes()){
//		    	}//end for(RemboursementAvance rem:eltvar.getAvances())
//		    	//Traitement Acompte en cours
//		    	for(Acompte acompte:eltvar.getAcomptes()){
//		    		Rubrique rubrique = acompte.getRubrique();
//		    		LigneBulletinPaie ligne = null;
//					if(datacache.containsKey(rubrique.getCode())){
//						ligne = datacache.get(rubrique.getCode());
//						ligne.setValeur(acompte.getMontant() + ligne.getValeur());
//					}else{
//						ligne = new LigneBulletinPaie(rubrique,0.0,rubrique.getTauxsal(),rubrique.getTauxpat());
//						ligne.setValeur(acompte.getMontant());
//					}//end if(datacache.containsKey(rubrique.getCode())){	
//		    		bulletin.getLignes().add(ligne);
//		    	}//end for(Acompte acompte:eltvar.getAcomptes())
//		    }//end if(eltsvariables!=null&&!eltsvariables.isEmpty())
//		    if(bulletin.getId()>0){
//		    	bulletindao.update("id", bulletin);
//		    }else {
//		    	bulletindao.save(bulletin);
//		    }//end if(bulletin.getId()>0){
//		}//end for(Employe salarie:salaries)
//		return entity;
//	}
    
	/**
	 * 
	 * @param rubrique
	 * @param salarie
	 * @return
	 */
    private Double eval(Rubrique rubrique,Employe salarie){
    	return 0.0;
    }
    
    /**
     * 
     * @param variable
     * @param salarie
     * @return
     */
    private Double eval(Variable variable,Employe salarie){
    	return 0.0;
    }

}
