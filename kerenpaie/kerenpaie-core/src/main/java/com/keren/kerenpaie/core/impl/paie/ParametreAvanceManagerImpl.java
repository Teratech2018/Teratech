
package com.keren.kerenpaie.core.impl.paie;

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
import com.keren.kerenpaie.core.ifaces.paie.ParametreAvanceManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.ParametreAvanceManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.FonctionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.TypeContratDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ParametreAvanceDAOLocal;
import com.keren.kerenpaie.model.employes.Fonction;
import com.keren.kerenpaie.model.employes.TypeContrat;
import com.keren.kerenpaie.model.paie.LignePonderationSalaire;
import com.keren.kerenpaie.model.paie.LignePonderationTypeContrat;
import com.keren.kerenpaie.model.paie.ParametreAvance;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ParametreAvanceManager")
public class ParametreAvanceManagerImpl
    extends AbstractGenericManager<ParametreAvance, Long>
    implements ParametreAvanceManagerLocal, ParametreAvanceManagerRemote
{

    @EJB(name = "ParametreAvanceDAO")
    protected ParametreAvanceDAOLocal dao;
    
    @EJB(name = "TypeContratDAO")
    protected TypeContratDAOLocal typecontratdao;
    
    @EJB(name = "FonctionDAO")
    protected FonctionDAOLocal fonctiondao;
    

    public ParametreAvanceManagerImpl() {
    }

    @Override
    public GenericDAO<ParametreAvance, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public ParametreAvance delete(Long id) {
		// TODO Auto-generated method stub
		ParametreAvance data = super.delete(id);
		return new ParametreAvance(data);
	}

	@Override
	public List<ParametreAvance> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<ParametreAvance> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<ParametreAvance> result = new ArrayList<ParametreAvance>();
		for(ParametreAvance data:datas){
			result.add(new ParametreAvance(data));
		}
		return result;
	}

	@Override
	public ParametreAvance find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		ParametreAvance data = super.find(propertyName, entityID);
		ParametreAvance result = new ParametreAvance(data);
		if(data.getType().equalsIgnoreCase("0")){
			for(LignePonderationSalaire pond:data.getFonctions()){
				result.getFonctions().add(new LignePonderationSalaire(pond));
			}//end for(LignePonderationSalaire pond:data.getFonctions()){
		}else if(data.getType().equalsIgnoreCase("1")){
			for(LignePonderationTypeContrat pond:data.getTypescontrats()){
				result.getTypescontrats().add(new LignePonderationTypeContrat(pond));
			}//end for(LignePonderationTypeContrat pond:data.getTypescontrats())
		}//end if(data.getType().equalsIgnoreCase("0"))
		return result;
	}

	@Override
	public List<ParametreAvance> findAll() {
		// TODO Auto-generated method stub		
		List<ParametreAvance> datas =  super.findAll();
		List<ParametreAvance> result = new ArrayList<ParametreAvance>();
		for(ParametreAvance data:datas){
			result.add(new ParametreAvance(data));
		}
		return result;
	}

	@Override
	public ParametreAvance actif(ParametreAvance entity) {
		// TODO Auto-generated method stub
		entity.setState("active");
		dao.update(entity.getId(), entity);
		return entity;
	}

	@Override
	public ParametreAvance inactif(ParametreAvance entity) {
		// TODO Auto-generated method stub
		entity.setState("inactive");
		dao.update(entity.getId(), entity);
		return entity;
	}

	@Override
	public ParametreAvance genere(ParametreAvance entity) {
		// TODO Auto-generated method stub
		if(entity.getType().equalsIgnoreCase("0")){
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("actif", Boolean.TRUE);
			List<Fonction> fonctions = fonctiondao.filter(container.getPredicats(), null, null, 0, -1);
			for(Fonction fonction:fonctions){
				if(!contains(entity.getFonctions(), fonction)){
					LignePonderationSalaire ligne = new LignePonderationSalaire(fonction,0.0);
					entity.getFonctions().add(ligne);
				}//end if(!contains(entity.getFonctions(), fonction))
			}//end for(Fonction fonction:fonctions){
		}else if(entity.getType().equalsIgnoreCase("1")){
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			List<TypeContrat> typescontrats = typecontratdao.filter(container.getPredicats(),null,null, 0, -1);
			for(TypeContrat typecontrat:typescontrats){
				LignePonderationTypeContrat ligne = new LignePonderationTypeContrat(typecontrat, 0.0);
				entity.getTypescontrats().add(ligne);
			}//end for(TypeContrat typecontrat:typescontrats)
		}//end if(entity.getType().equalsIgnoreCase("0"))
		if(entity.getId()>0){
			dao.update(entity.getId(), entity);
		}else{
			dao.save(entity);
		}//end if(entity.getId()>0)
		return entity;
	}
    
	/**
	 * 
	 * @param lignes
	 * @param fonction
	 * @return
	 */
    private Boolean contains(List<LignePonderationSalaire> lignes , Fonction fonction){    	
    	for(LignePonderationSalaire pon:lignes){
    		if(pon.getFonction().compareTo(fonction)==0){
    			return true;
    		}
    	}
    	return false ;
    }

    /**
     * 
     * @param lignes
     * @param fonction
     * @return
     */
    private Boolean contains(List<LignePonderationTypeContrat> lignes , TypeContrat fonction){    	
    	for(LignePonderationTypeContrat pon:lignes){
    		if(pon.getFonction().compareTo(fonction)==0){
    			return true;
    		}
    	}
    	return false ;
    }
}
