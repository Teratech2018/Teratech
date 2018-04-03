
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
import com.keren.kerenpaie.core.ifaces.paie.ConvensionManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.ConvensionManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.CategorieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.EchelonDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.ConvensionDAOLocal;
import com.keren.kerenpaie.model.employes.Categorie;
import com.keren.kerenpaie.model.employes.Echelon;
import com.keren.kerenpaie.model.paie.Convension;
import com.keren.kerenpaie.model.paie.LigneConvension;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ConvensionManager")
public class ConvensionManagerImpl
    extends AbstractGenericManager<Convension, Long>
    implements ConvensionManagerLocal, ConvensionManagerRemote
{

    @EJB(name = "ConvensionDAO")
    protected ConvensionDAOLocal dao;
    
    @EJB(name = "CategorieDAO")
    protected CategorieDAOLocal categoriedao;
    
    @EJB(name = "EchelonDAO")
    protected EchelonDAOLocal echelondao;
    

    public ConvensionManagerImpl() {
    }

    @Override
    public GenericDAO<Convension, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public Convension delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<Convension> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Convension> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Convension> result = new ArrayList<Convension>();
		for(Convension data:datas){
			result.add(new Convension(data));
		}
		return result;
	}

	@Override
	public Convension find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Convension data = super.find(propertyName, entityID);
		Convension result = new Convension(data);
		for(LigneConvension ligne:data.getLignes()){
			result.getLignes().add(new LigneConvension(ligne));
		}
		return result;
	}

	@Override
	public List<Convension> findAll() {
		// TODO Auto-generated method stub		
		List<Convension> datas = super.findAll();
		List<Convension> result = new ArrayList<Convension>();
		for(Convension data:datas){
			result.add(new Convension(data));
		}
		return result;
	}

	@Override
	public Convension actif(Convension entity) {
		// TODO Auto-generated method stub
		//Chargement de la liste des convension collectives
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Convension> convensions = dao.filter(container.getPredicats(), null, null, 0, -1);
		for(Convension data:convensions){
			data.setState("inactif");
			dao.update(data.getId(), data);
		}
		entity.setState("actif");
		dao.update(entity.getId(), entity);
		return entity;
	}

	@Override
	public Convension inactif(Convension entity) {
		// TODO Auto-generated method stub
		entity.setState("inactif");
		dao.update(entity.getId(), entity);
		return entity;
	}

	@Override
	public Convension genere(Convension entity) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Categorie> categories = categoriedao.filter(container.getPredicats(), null, null, 0,-1);
		for(Categorie categorie:categories){
			for(Echelon echelon:categorie.getEchelons()){
				if(!contains(entity, categorie, echelon)){
					LigneConvension ligne = new LigneConvension(categorie, echelon, 0.0);
					entity.getLignes().add(ligne);
				}
			}//end for(Echelon echelon:categorie.getEchelons())
		}//end for(Categorie categorie:categories)
		dao.update(entity.getId(), entity);
		return entity;
	}
    
	/**
	 * 
	 * @param entity
	 * @param categorie
	 * @param echelon
	 * @return
	 */
    private Boolean contains(Convension entity,Categorie categorie,Echelon echelon){
    	
    	for(LigneConvension ligne:entity.getLignes()){
    		if(ligne.getCategorie().compareTo(categorie)==0 && ligne.getEchelon().compareTo(echelon)==0){
    			return true;
    		}//end if(ligne.getCategorie().compareTo(categorie)==0 && ligne.getEchelon().compareTo(echelon)==0){
    	}//end for(LigneConvension ligne:entity.getLignes()){
    	return false;
    }

}
