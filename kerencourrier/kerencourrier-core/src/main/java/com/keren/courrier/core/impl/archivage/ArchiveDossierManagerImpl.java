
package com.keren.courrier.core.impl.archivage;

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
import com.keren.courrier.core.ifaces.archivage.ArchiveDossierManagerLocal;
import com.keren.courrier.core.ifaces.archivage.ArchiveDossierManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.ArchiveDossierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierAArchiverDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.model.archivage.ArchiveDossier;
import com.keren.courrier.model.courrier.CourrierAArchiver;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ArchiveDossierManager")
public class ArchiveDossierManagerImpl
    extends AbstractGenericManager<ArchiveDossier, Long>
    implements ArchiveDossierManagerLocal, ArchiveDossierManagerRemote
{

    @EJB(name = "ArchiveDossierDAO")
    protected ArchiveDossierDAOLocal dao;
    
    @EJB(name = "CourrierAArchiverDAO")
    protected CourrierAArchiverDAOLocal courrierdao;
    
	@EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;

    public ArchiveDossierManagerImpl() {
    }

    @Override
    public GenericDAO<ArchiveDossier, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
    public List<ArchiveDossier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties, int firstResult, int maxResult) {
        List<ArchiveDossier> datas = super.filter(predicats, orders, properties, firstResult, maxResult); //To change body of generated methods, choose Tools | Templates.
        List<ArchiveDossier> results = new ArrayList<ArchiveDossier>();        
        for(ArchiveDossier courrier:datas){
            ArchiveDossier data = new ArchiveDossier(courrier);
            results.add(data);              
        }//end for(ArchiveDossier courrier:datas){        
        return results;
    }

    @Override
    public List<ArchiveDossier> findAll() {
        
        //To change body of generated methods, choose Tools | Templates.
        List<ArchiveDossier> datas = super.findAll(); 
        List<ArchiveDossier> results = new ArrayList<ArchiveDossier>();        
        for(ArchiveDossier data:datas){
            results.add(new ArchiveDossier(data));
        }
        
        return results;
    }

    @Override
    public ArchiveDossier find(String propertyName, Long entityID) {        
        //initialisaiton
        ArchiveDossier data = super.find(propertyName, entityID); //To change body of generated methods, choose Tools | Templates.
        ArchiveDossier result = new ArchiveDossier(data);       
        for(FichierLie aas:data.getPiecesjointes()){
            result.getPiecesjointes().add(new FichierLie(aas));
        }       
        return result;
    }
    
    public void classerfonddossier(ArchiveDossier entity){
		//Traitement des enfants
		
		List<CourrierAArchiver> archives = new ArrayList<CourrierAArchiver>() ;//entity.getCourriers();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		for(CourrierAArchiver courrier : archives){
		// créer traitemebnt
			TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.ARCHIVAGE);
			traitement.setAvis(entity.getObservation());
			traitement.setDoperation(entity.getDcreation());
			//traitement.setOperateur(entity.getOrdonateur());
			//traitement.setClasseur(entity.getClasseur());
			traitement.setBoite(entity.getBoite());
			courrier.setState("archiver");
		//	courrier.setTypeclassement(entity.getNature());
			daotrt.save(traitement);
			courrier.setState("archiver");
//			daotrt.save(traitement);
			courrierdao.update(courrier.getId(), courrier);
		}
		
				
	}
	

}
