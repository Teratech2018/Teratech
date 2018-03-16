
package com.kerenedu.inscription;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.ClasseDAOLocal;
import com.kerenedu.model.search.EleveSearch;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "InscriptionManager")
public class InscriptionManagerImpl
    extends AbstractGenericManager<Inscription, Long>
    implements InscriptionManagerLocal, InscriptionManagerRemote
{

    @EJB(name = "InscriptionDAO")
    protected InscriptionDAOLocal dao;
    
    
    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal annedao;  
    
    @EJB(name = "ClasseDAO")
    protected ClasseDAOLocal classedao;  
    

    public InscriptionManagerImpl() {
    }

    @Override
    public GenericDAO<Inscription, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public List<Inscription> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Inscription> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Inscription> result = new ArrayList<Inscription>();
		for(Inscription elev:datas){
			result.add(new Inscription(elev));
		}
		return result;
	}

	@Override
	public Inscription find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Inscription elev = super.find(propertyName, entityID);
		Inscription inscrip = new Inscription(elev);
//		for(Service serv: elev.getServiceList()){
//			inscrip.getServiceList().add(new Service(serv));
//		}
		return inscrip;
	}

	@Override
	public List<Inscription> findAll() {
		// TODO Auto-generated method stub
		List<Inscription> datas = super.findAll();
		List<Inscription> result = new ArrayList<Inscription>();
		for(Inscription elev:datas){
			result.add(new Inscription(elev));
		}
		return result;
	}
	
	

	@Override
	public Inscription delete(Long id) {
		// TODO Auto-generated method stub
		Inscription elev = super.delete(id);
		return new Inscription(elev);
	}

	@Override
	public void processBeforeSave(Inscription entity) {
		// set annescolaire courante
		  //Creation des journaux de saisie
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		 container.addEq("connected", true);
		List<AnneScolaire> annee = annedao.filter(container.getPredicats(), null, null, 0 , -1);
        if(annee==null||annee.size()==0){
            RuntimeException excep = new RuntimeException("Aucune Année Scolaire disponible !!!");
            throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
        }
        entity.setAnneScolaire(annee.get(0));
        // verifier si l'étudiant a déjà été inscit 
        container = RestrictionsContainer.newInstance();
        	container.addEq("eleve.matricule", entity.getEleve().getMatricule());
        	container.addEq("anneScolaire.code", entity.getAnneScolaire().getCode());
        	List<Inscription> inscit = dao.filter(container.getPredicats(), null, null, 0 , -1);
        if((inscit!=null&&inscit.size()!=0)){
            RuntimeException excep = new RuntimeException("Eléve déjà Inscrit !!!");
            throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
        }
       // System.out.println("InscriptionManagerImpl.processBeforeSave()"+inscit.get(0).getEleve().getMatricule());
        
		// montant total à payer 
	//		BigDecimal total = BigDecimal.ZERO;
	//		if(entity.getServiceList()!=null){
	//			for(Service service : entity.getServiceList()){
	//				total= total.add(service.getzMnt());
	//			}
		//	entity.setzMnt(entity.getServiceList().getzMnt());
		//}
    
		super.processBeforeSave(entity);
	}
	
	

	
	@Override
	public void processAfterSave(Inscription entity) {
		// mettre a jour le nbre d'elève de la classe concerné 
		Classe cls = entity.getClasse();
		Long effectifactuel= cls.getEffectif();
		Long effectif = effectifactuel+new Long(1);
		cls.setEffectif(effectif);
		classedao.update(cls.getId(), cls);
		super.processAfterSave(entity);
	}

	@Override
	public void processBeforeUpdate(Inscription entity) {
	    // verifier si l'étudiant a déjà été inscit 
      /*  Inscription inscit = dao.getInscriptionEtudiantByAnnee(entity.getEleve(), entity.getAnneScolaire());
        if(inscit!=null){
            RuntimeException excep = new RuntimeException("Eléve déjà Inscrit !!!");
            throw new WebApplicationException(excep,Response.Status.NOT_MODIFIED);
        }*/
		super.processBeforeUpdate(entity);
	}

	@Override
	public List<Inscription> getCriteres(EleveSearch critere) {
		
        RestrictionsContainer container = RestrictionsContainer.newInstance();
        if(critere!=null){
            if(critere.getMatricule()!=null){
                container.addEq("eleve.matricule", critere.getMatricule());
            }
          
        }
        List<Inscription> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
        List<Inscription>  result = new ArrayList<Inscription>();
        for(Inscription ins:datas){            
        	Inscription inscription = new Inscription(ins);
            result.add(inscription);
        }
        return result;
	}
	
	

}
