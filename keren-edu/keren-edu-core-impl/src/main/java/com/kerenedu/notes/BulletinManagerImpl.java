
package com.kerenedu.notes;

import java.util.ArrayList;
import java.util.HashSet;
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
import com.kerenedu.configuration.Appreciation;
import com.kerenedu.configuration.AppreciationDAOLocal;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.Classe;
import com.kerenedu.configuration.Filiere;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "BulletinManager")
public class BulletinManagerImpl extends AbstractGenericManager<Bulletin, Long>
		implements BulletinManagerLocal, BulletinManagerRemote {

	@EJB(name = "BulletinDAO")
	protected BulletinDAOLocal dao;
	
	@EJB(name = "AppreciationDAO")
    protected AppreciationDAOLocal daoapp;

	public BulletinManagerImpl() {
	}

	@Override
	public GenericDAO<Bulletin, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<Bulletin> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		ModelBulletin mdl = CacheMemory.getModelBulletin();
		Filiere filiere = CacheMemory.getFiliere();
		Classe classe = CacheMemory.getClasse();

		if (classe != null) {
			container.addEq("classe.id", classe.getId());
		} // end if(classe!=null)

		if (filiere != null) {
			container.addEq("classe.filiere.id", filiere.getId());
		} // end if(mdl!=null)

		if (mdl != null) {
			container.addEq("model.id", mdl.getId());
		} // end if(mdl!=null){

		predicats.addAll(container.getPredicats());

		List<Bulletin> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Bulletin> result = new ArrayList<Bulletin>();
		for (Bulletin elev : datas) {
			result.add(new Bulletin(elev));
		}
		return result;
	}

	@Override
	public Bulletin find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Bulletin elev = super.find(propertyName, entityID);
		Bulletin data = new Bulletin(elev);
		for (LigneBulletinClasse ligne : elev.getLignes()) {
			data.getLignes().add(new LigneBulletinClasse(ligne));
		}
		return data;
	}

	@Override
	public List<Bulletin> findAll() {
		// TODO Auto-generated method stub
		List<Bulletin> datas = super.findAll();

		return datas;
	}

	@Override
	public Bulletin delete(Long id) {
		// TODO Auto-generated method stub
		Bulletin elev = super.delete(id);
		return new Bulletin(elev);
	}

	@Override
	public List<Bulletin> getCriteres(Bulletin critere) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {

			if (critere.getEleve() != null) {
				container.addEq("eleve.matricule", critere.getEleve().getMatricule());
			}

			if (critere.getModel() != null) {
				container.addEq("model.id", critere.getModel().getId());
			}

			if (critere.getClasse() != null) {
				container.addEq("classe.id", critere.getClasse().getId());
			}

		}
		List<Bulletin> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		List<Bulletin> result = new ArrayList<Bulletin>();
		if (datas != null) {
			for (Bulletin bull : datas) {
				Bulletin newBull = find("id", bull.getId());
				result.add(newBull);
			}
		} // fin if(datas!=null)
		return result;
	}
	
	@Override
	public void processBeforeSave(Bulletin entity) {
		System.out.println("BulletinManagerImpl.processBeforeSave() get long value moyenne"+entity.getMoyenne().longValue());
		Appreciation value = daoapp.getAppreciation(entity.getMoyenne().longValue());
		if(value!=null){
		entity.setAppre(value.getLibelle());
		entity.setSanction(value.getSanction());
		}else{
			entity.setAppre("default");
			entity.setSanction("default");
		}
		super.processBeforeSave(entity);
	}
	
	
	
	
	@Override
	public void processBeforeUpdate(Bulletin entity) {
		// modifier les note
		// modifier la conduite
		super.processBeforeUpdate(entity);
	}

	private String getAppreciation(long note){
		String app= " default";
		Appreciation value = daoapp.getAppreciation(note);
		if(value!=null){
			app = value.getLibelle();
		}else{
			app= "Default";
		}
		return app;
	}

}
