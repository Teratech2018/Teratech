
package com.keren.courrier.dao.impl.courrier;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAORemote;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.referentiel.Correspondant;
import com.keren.courrier.model.referentiel.StructureCompany;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Stateless(mappedName = "BorderoCourrierDAO")
public class BorderoCourrierDAOImpl extends AbstractGenericDAO<BorderoCourrier, Long>
		implements BorderoCourrierDAOLocal, BorderoCourrierDAORemote {

	@PersistenceContext(unitName = "kerencourrier")
	protected EntityManager em;

	public BorderoCourrierDAOImpl() {
	}

	@Override
	public EntityManager getEntityManager() {
		return em;
	}

	@Override
	public Class<BorderoCourrier> getManagedEntityClass() {
		return (BorderoCourrier.class);
	}

	@Override
	public BorderoCourrier checkBordero(StructureCompany source, StructureCompany cible, String type) {
		// To change body of generated methods, choose Tools | Templates.
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("source", source);
		container.addEq("cible", cible);
		container.addEq("type", type);
		container.addEq("state", "etabli");
		List<BorderoCourrier> borderos = filter(container.getPredicats(), null, null, 0, -1);
		if (borderos != null && !borderos.isEmpty()) {
			return borderos.get(0);
		} // end if(borderos!=null&&!borderos.isEmpty()){
		BorderoCourrier bordero = new BorderoCourrier();
		bordero.setCode("BDR/" + new Date() + source.getId() + cible.getId() + type);
		bordero.setSource(source);
		bordero.setCible(cible);
		bordero.setType(type);
		bordero.setCreation(new Date());
		bordero.setState("etabli");
		
		save(bordero);
		borderos = filter(container.getPredicats(), null, null, 0, -1);
		return borderos.get(0);// end if(borderos!=null&&!borderos.isEmpty()){
	}

	@Override
	public BorderoCourrier checkBordero(StructureCompany source, List<Correspondant> cible, String type) {
		// To change body of generated methods, choose Tools | Templates.
		List<BorderoCourrier> borderos = new ArrayList<BorderoCourrier>();
		for (Correspondant corres : cible) {
			RestrictionsContainer container = RestrictionsContainer.newInstance();
			container.addEq("source", source);
			container.addEq("excible", corres);
			container.addEq("type", type);
			container.addEq("state", "etabli");
			borderos = filter(container.getPredicats(), null, null, 0, -1);
			if (borderos != null && !borderos.isEmpty()) {
				return borderos.get(0);
			} // end if(borderos!=null&&!borderos.isEmpty()){
			BorderoCourrier bordero = new BorderoCourrier();
			bordero.setCode("BDR/" + new Date() + source.getId() + corres.getId() + type);
			bordero.setSource(source);
			bordero.setExcible(corres);
			bordero.setType(type);
			bordero.setCreation(new Date());
			bordero.setState("etabli");
			save(bordero);
			borderos = filter(container.getPredicats(), null, null, 0, -1);
		}

		return borderos.get(0);// end if(borderos!=null&&!borderos.isEmpty()){
	}

	@Override
	public void setManager(EntityManager manager) {
		super.setManager(manager); // To change body of generated methods,
									// choose Tools | Templates.
	}

	@Override
	public void processAfterDelete(BorderoCourrier entity) {
		for (LigneBorderoCourrier ligne : entity.getCourriers()) {
			CourrierClone courrier = ligne.getCourrier();
			if (ligne.getNature().trim().equalsIgnoreCase("0")) {
				courrier = getEntityManager().find(CourrierClone.class, courrier.getId());
				courrier.setBordero(null);
				courrier.setService(null);
				getEntityManager().merge(courrier);
			} // end if(ligne.getNature().trim().equalsIgnoreCase("0")){
		} // end for(LigneBorderoCourrier ligne:entity.getCourriers()){
		super.processAfterDelete(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public void processBeforeDelete(BorderoCourrier entity) {
		super.processBeforeDelete(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public void processAfterUpdate(BorderoCourrier entity) {
		BorderoCourrier old = getEntityManager().find(BorderoCourrier.class, entity.getId());
		// Map
		Map<Long, LigneBorderoCourrier> map = new HashMap<Long, LigneBorderoCourrier>();
		for (LigneBorderoCourrier ligne : old.getCourriers()) {
			map.put(ligne.getId(), ligne);
		} // end for(LigneBorderoCourrier ligne:old.getCourriers()){
		for (LigneBorderoCourrier ligne : entity.getCourriers()) {
			CourrierClone courrier = ligne.getCourrier();
			if (ligne.getNature().trim().equalsIgnoreCase("0")) {
				courrier = getEntityManager().find(CourrierClone.class, courrier.getId());
				courrier.setBordero(entity);
				courrier.setService(entity.getCible());
				getEntityManager().merge(courrier);
			} // end if(ligne.getNature().trim().equalsIgnoreCase("0")){
			if (map.containsKey(ligne.getId())) {
				map.remove(ligne.getId());
			} // end if(map.containsKey(ligne.getId())){
		} // end for(LigneBorderoCourrier ligne:entity.getCourriers()){
			// Traitement des lignes supprimer
		for (Long key : map.keySet()) {
			CourrierClone courrier = map.get(key).getCourrier();
			if (map.get(key).getNature().trim().equalsIgnoreCase("0")) {
				courrier = getEntityManager().find(CourrierClone.class, courrier.getId());
				courrier.setBordero(null);
				courrier.setService(null);
				getEntityManager().merge(courrier);
			} // end if(ligne.getNature().trim().equalsIgnoreCase("0")){
		} // end for(Long key:map.keySet()){
		super.processAfterUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public void processBeforeUpdate(BorderoCourrier entity) {
		super.processBeforeUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public void processAfterSave(BorderoCourrier entity) {
		for (LigneBorderoCourrier ligne : entity.getCourriers()) {
			CourrierClone courrier = ligne.getCourrier();
			if (ligne.getNature().trim().equalsIgnoreCase("0")) {
				courrier = getEntityManager().find(CourrierClone.class, courrier.getId());
				courrier.setBordero(entity);
				courrier.setService(entity.getCible());
				getEntityManager().merge(courrier);
			} // end if(ligne.getNature().trim().equalsIgnoreCase("0")){
		} // end for(LigneBorderoCourrier ligne:entity.getCourriers()){
		super.processAfterSave(entity); // To change body of generated methods,
										// choose Tools | Templates.
	}

	@Override
	public void processBeforeSave(BorderoCourrier entity) {
		super.processBeforeSave(entity); // To change body of generated methods,
											// choose Tools | Templates.
	}

}
