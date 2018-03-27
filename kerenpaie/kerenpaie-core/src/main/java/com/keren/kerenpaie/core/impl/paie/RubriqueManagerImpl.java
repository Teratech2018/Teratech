
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
import com.keren.kerenpaie.core.ifaces.paie.RubriqueManagerLocal;
import com.keren.kerenpaie.core.ifaces.paie.RubriqueManagerRemote;
import com.keren.kerenpaie.dao.ifaces.employes.CategorieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.employes.FonctionDAOLocal;
import com.keren.kerenpaie.dao.ifaces.paie.RubriqueDAOLocal;
import com.keren.kerenpaie.dao.ifaces.structures.SpecialiteDAOLocal;
import com.keren.kerenpaie.model.employes.Categorie;
import com.keren.kerenpaie.model.employes.Fonction;
import com.keren.kerenpaie.model.paie.ForfaitCategorie;
import com.keren.kerenpaie.model.paie.ForfaitCategorieProf;
import com.keren.kerenpaie.model.paie.ForfaitSpecialite;
import com.keren.kerenpaie.model.paie.Rubrique;
import com.keren.kerenpaie.model.structures.Specialite;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RubriqueManager")
public class RubriqueManagerImpl
    extends AbstractGenericManager<Rubrique, Long>
    implements RubriqueManagerLocal, RubriqueManagerRemote
{

    @EJB(name = "RubriqueDAO")
    protected RubriqueDAOLocal dao;
    
    @EJB(name = "FonctionDAO")
    protected FonctionDAOLocal fonctiondao;
    
    @EJB(name = "CategorieDAO")
    protected CategorieDAOLocal categoriedao;
    
    @EJB(name = "SpecialiteDAO")
    protected SpecialiteDAOLocal specialitedao;
    

    public RubriqueManagerImpl() {
    }

    @Override
    public GenericDAO<Rubrique, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public Rubrique delete(Long id) {
		// TODO Auto-generated method stub
		Rubrique data =super.delete(id);
		return new Rubrique(data);
	}

	@Override
	public List<Rubrique> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Rubrique>  datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Rubrique>  result = new ArrayList<Rubrique>();
		for(Rubrique data:datas){
			result.add(new Rubrique(data));
		}
		return result;
	}

	@Override
	public Rubrique find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Rubrique data= super.find(propertyName, entityID);
		Rubrique result = new Rubrique(data);
		for(ForfaitCategorieProf forfait:data.getForfaitscatprof()){
			result.getForfaitscatprof().add(new ForfaitCategorieProf(forfait));
		}
		for(ForfaitCategorie forfait:data.getForfaitscat()){
			result.getForfaitscat().add(new ForfaitCategorie(forfait));
		}
		for(ForfaitSpecialite forfait:data.getForfaitsspe()){
			result.getForfaitsspe().add(new ForfaitSpecialite(forfait));
		}
		return result;
		
	}

	@Override
	public List<Rubrique> findAll() {
		// TODO Auto-generated method stub
		List<Rubrique>  datas = super.findAll();
		List<Rubrique>  result = new ArrayList<Rubrique>();
		for(Rubrique data:datas){
			result.add(new Rubrique(data));
		}
		return result;
	}

	@Override
	public Rubrique genereforfait(Rubrique entity) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if(entity.getType().equalsIgnoreCase("0")){
			List<Fonction> fonctions = fonctiondao.filter(container.getPredicats(), null, null, 0, -1);
			for(Fonction fonc:fonctions){
				ForfaitCategorieProf cat = new ForfaitCategorieProf();
				cat.setCategorie(fonc);cat.setMesure("0");cat.setValeur(0.0);
				entity.getForfaitscatprof().add(cat);
			}//end for(Fonction fonc:fonctions){
		}else if(entity.getType().equalsIgnoreCase("1")){
			List<Categorie> categories = categoriedao.filter(container.getPredicats(), null, null, 0, -1);
			for(Categorie fonc:categories){
				ForfaitCategorie cat = new ForfaitCategorie();
				cat.setCategorie(fonc);cat.setMesure("0");cat.setValeur(0.0);
				entity.getForfaitscat().add(cat);
			}//end for(Fonction fonc:fonctions){
		}else if(entity.getType().equalsIgnoreCase("2")){
			List<Specialite> specialites = specialitedao.filter(container.getPredicats(), null, null, 0, -1);
			for(Specialite fonc:specialites){
				ForfaitSpecialite cat = new ForfaitSpecialite();
				cat.setCategorie(fonc);cat.setMesure("0");cat.setValeur(0.0);
				entity.getForfaitsspe().add(cat);
			}//end for(Fonction fonc:fonctions){
		}//end if(entity.getType().equalsIgnoreCase("0"))
		if(entity.getId()>0){
			dao.update(entity.getId(),entity);
		}else {
			dao.save(entity);
		}//end if(entity.getId()>0){
		return entity;
	}
    
    

}
