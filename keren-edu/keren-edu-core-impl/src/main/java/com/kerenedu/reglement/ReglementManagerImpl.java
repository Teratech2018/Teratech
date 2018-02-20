
package com.kerenedu.reglement;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.AnneScolaire;
import com.kerenedu.configuration.AnneScolaireDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ReglementManager")
public class ReglementManagerImpl
    extends AbstractGenericManager<Reglement, Long>
    implements ReglementManagerLocal, ReglementManagerRemote
{

    @EJB(name = "ReglementDAO")
    protected ReglementDAOLocal dao;
    
   
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;    
    
   
    
    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal inscriptionDao;    
    
    @EJB(name = "CaisseDAO")
    protected CaisseDAOLocal caissedao;

    

    public ReglementManagerImpl() {
    }

    @Override
    public GenericDAO<Reglement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
   
    @Override
 	public List<Reglement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
 			int firstResult, int maxResult) {
 		// TODO Auto-generated method stub
 		List<Reglement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
 		List<Reglement> result = new ArrayList<Reglement>();
 		for(Reglement elev:datas){
 			result.add(new Reglement(elev));
 		}
 		return result;
 	}

 	@Override
 	public Reglement find(String propertyName, Long entityID) {
 		// TODO Auto-generated method stub
 		Reglement elev = super.find(propertyName, entityID);
 		return new Reglement(elev);
 	}
 	
 	

 	@Override
	public Reglement delete(Long id) {
 		Reglement elev = super.delete(id);
		return new Reglement(elev);
	}

	@Override
 	public List<Reglement> findAll() {
 		// TODO Auto-generated method stub
 		List<Reglement> datas = super.findAll();
 		List<Reglement> result = new ArrayList<Reglement>();
 		for(Reglement elev:datas){
 			result.add(new Reglement(elev));
 		}
 		return result;
 	}
    @Override
	public void processBeforeSave(Reglement entity) {
		// set annescolaire courante
    	 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("connected", true);
		 //container.addEq("anneScolaire.code", entities.getAnneScolaire().getCode());
		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
		System.out.println("InscriptionManagerImpl.processBeforeSave() année trouvé is "+annee.get(0));
        if((annee==null||annee.size()==0)){
            RuntimeException excep = new RuntimeException("Aucune Année Scoalire disponible !!!");
            throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
        }
        entity.setAnneScolaire(annee.get(0));
             
		entity.setzMntTmp(entity.getzMnt());
		super.processBeforeSave(entity);
	}
    
    

	@Override
	public void processAfterSave(Reglement entities) {
		//update montant payer inscription 
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("eleve.matricule", entities.eleve.getMatricule());
		 //container.addEq("anneScolaire.code", entities.getAnneScolaire().getCode());
		List<Inscription> listins = inscriptionDao.filter(container.getPredicats(), null, null, 0 , -1);
		Inscription v$entytyInsc= new Inscription() ;
		if(listins!=null){
			 v$entytyInsc = listins.get(0);
			BigDecimal totalPayer= v$entytyInsc.getzMntPaye().add(entities.getzMnt());
			v$entytyInsc.setzMntPaye(totalPayer);
			v$entytyInsc.setzSolde(v$entytyInsc.getzMnt().subtract(v$entytyInsc.getzMntPaye()));
		}
		inscriptionDao.update(v$entytyInsc.getId(), v$entytyInsc);
		
		// mouvement caisse en credit
		Caisse caisse = new Caisse(entities);
		caissedao.save(caisse);
		
		super.processAfterSave(entities);
	}
	
	

	@Override
	public void processAfterUpdate(Reglement entity) {
		//update montant payer inscription 
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("eleve.matricule", entity.eleve.getMatricule());
		 //container.addEq("anneScolaire.code", entities.getAnneScolaire().getCode());
		List<Inscription> listins = inscriptionDao.filter(container.getPredicats(), null, null, 0 , -1);
		Inscription v$entytyInsc= new Inscription() ;
		if(listins!=null){
			 v$entytyInsc = listins.get(0);
			BigDecimal oldPayer = entity.getzMntTmp();
			BigDecimal totalPayer= v$entytyInsc.getzMntPaye().add(entity.getzMnt()).subtract(oldPayer);
			v$entytyInsc.setzMntPaye(totalPayer);
			v$entytyInsc.setzSolde(v$entytyInsc.getzMnt().subtract(v$entytyInsc.getzMntPaye()));
		}
		inscriptionDao.update(v$entytyInsc.getId(), v$entytyInsc);
		super.processAfterUpdate(entity);
	}

	@Override
	public void processBeforeDelete(Reglement entity) {
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("eleve.matricule", entity.eleve.getMatricule());
		 //container.addEq("anneScolaire.code", entities.getAnneScolaire().getCode());
		List<Inscription> listins = inscriptionDao.filter(container.getPredicats(), null, null, 0 , -1);
		Inscription v$entytyInsc= new Inscription() ;
		if(listins!=null){
			 v$entytyInsc = listins.get(0);
			BigDecimal totalPayer= v$entytyInsc.getzMntPaye().subtract(entity.getzMnt());
			v$entytyInsc.setzMntPaye(totalPayer);
			v$entytyInsc.setzSolde(v$entytyInsc.getzMnt().subtract(v$entytyInsc.getzMntPaye()));
		}
		inscriptionDao.update(v$entytyInsc.getId(), v$entytyInsc);
		super.processBeforeDelete(entity);
	}

	@Override
	public void processBeforeUpdate(Reglement entity) {
	    // verifier si l'étudiant a déjà été inscit 
      /*  Inscription inscit = dao.getInscriptionEtudiantByAnnee(entity.getEleve(), entity.getAnneScolaire());
        if(inscit!=null){
            RuntimeException excep = new RuntimeException("Eléve déjà Inscrit !!!");
            throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
        }*/
		super.processBeforeUpdate(entity);
	}

}
