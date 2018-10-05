
package com.keren.courrier.core.impl.courrier;

import java.util.ArrayList;
import java.util.Date;
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
import com.kerem.commons.DateHelper;
import com.keren.courrier.core.ifaces.courrier.CourrierInterneManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierInterneManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.CompanyDAOLocal;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.CourrierDepart;
import com.keren.courrier.model.courrier.CourrierInterne;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.referentiel.Company;
import com.keren.courrier.model.referentiel.LigneDiffusion;
import com.keren.courrier.model.referentiel.User;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CourrierInterneManager")
public class CourrierInterneManagerImpl extends AbstractGenericManager<CourrierInterne, Long>
		implements CourrierInterneManagerLocal, CourrierInterneManagerRemote {

	@EJB(name = "CourrierInterneDAO")
	protected CourrierInterneDAOLocal dao;

	@EJB(name = "CourrierCloneDAO")
	protected CourrierCloneDAOLocal daoclone;

	@EJB(name = "BorderoCourrierDAO")
	protected BorderoCourrierDAOLocal borderodao;

	@EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;
	
	@EJB(name = "CompanyDAO")
	protected CompanyDAOLocal daocompany;

	public CourrierInterneManagerImpl() {
	}

	@Override
	public GenericDAO<CourrierInterne, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<CourrierInterne> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		List<CourrierInterne> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
		List<CourrierInterne> results = new ArrayList<CourrierInterne>();
		for (CourrierInterne courrier : datas) {
		//	User compte = new User(courrier.getExpediteur().getCompte());
			//courrier.getExpediteur().setCompte(compte);
			CourrierInterne data = new CourrierInterne(courrier);
			results.add(data);
		} // end for(CourrierInterne courrier:datas){
		return results;
	}

	@Override
	public List<CourrierInterne> findAll() {
		// To change body of generated methods, choose Tools | Templates.
		List<CourrierInterne> datas = super.findAll();
		List<CourrierInterne> results = new ArrayList<CourrierInterne>();
		for (CourrierInterne data : datas) {
			results.add(new CourrierInterne(data));
		}

		return results;
	}

	@Override
	public CourrierInterne find(String propertyName, Long entityID) {

		// initialisaiton
		CourrierInterne data = super.find(propertyName, entityID);
		// To change body of generated methods, choose Tools | Templates.
		CourrierInterne result = new CourrierInterne(data);

		result.setCourrier(data.getCourrier());

		for (FichierLie aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLie(aas));
		} // end for(FichierLie aas:data.getPiecesjointes()){
		
		
		for (UtilisateurCourrier corres : data.getCorrespondant()) {
			result.getCorrespondant().add(new UtilisateurCourrier(corres));
		} // end for(FichierLie aas:data.getPiecesjointes()){

		return result;
	}

	@Override
	public void processBeforeSave(CourrierInterne entity) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		Company comp = daocompany.filter(container.getPredicats(), null, null, 0, -1).get(0);
		/*
		 * On ajoute la catorie du courrier 0 ==> courriers arrivés 1 ==>
		 * courriers departs 2 ==> courriers interne
		 */
		// set service expediteur
		if(entity.getExpediteur()!=null){
			entity.setSexp(entity.getExpediteur().getService());
		}
		if (entity.getDcourrier() == null) {
			entity.setDcourrier(new Date());
		}
		if (entity.getService() == null) {
			entity.setService(comp.getServiceTraitantdefaut());
		}

		if (entity.getPorte() == null) {
			entity.setPorte(comp.getPorte());
		}

		if (entity.getPriorite() == null) {
			entity.setPriorite(comp.getPriorite());
		}
		entity.setCategorie("2");
		if (entity.getService() != null) {
			String type = "2";
			if (entity.getPorte() != null && entity.getPorte().trim().equalsIgnoreCase("1")) {
				type = "2";
			} // end
				// if(entity.getPorte()!=null&&entity.getPorte().trim().equalsIgnoreCase("1")){
			BorderoCourrier bordero = borderodao.checkBordero(entity.getSource().getService(), entity.getService(),
					type);
			entity.setBordero(bordero);

		} // end if(entity.getService()!=null){
		super.processBeforeSave(entity);
	}

	@Override
	public void processAfterSave(CourrierInterne entity) {
		entity = dao.findByPrimaryKey("id", entity.getId());
		entity.setCode("CI/" + entity.getId() + "/" + DateHelper.convertToString(entity.getDcourrier(), "dd/MM/yyyy"));
		// gerre le tratement;
		TraitementCourrier trtcourrier = new TraitementCourrier(new CourrierClone(entity),
				TypeTraitement.ENREGISTREMENT);
		daotrt.save(trtcourrier);
		dao.update(entity.getId(), entity);
		if (entity.getBordero() != null) {
			LigneBorderoCourrier ligne = new LigneBorderoCourrier();
			ligne.setCourrier(new CourrierClone(entity));
			ligne.setNature("0");
			entity.getBordero().getCourriers().add(ligne);
			entity.getBordero().setCode("BDR/CI/" + entity.getBordero().getId() + "/"
					+ DateHelper.convertToString(entity.getDcourrier(), "dd/MM/yyyy"));
			borderodao.update(entity.getBordero().getId(), entity.getBordero());
		} // end if(entity.getBordero()!=null){
		super.processAfterSave(entity);
	}

	@Override
	public CourrierInterne delete(Long id) {

		// befor delete ligne bordero
		// delete ligne piece jointe
		CourrierInterne entity = dao.findByPrimaryKey("id", id);
		// daoclone.deleteCourrierRAD(new CourrierClone(entity));
		// entity= new CourrierInterne();*
		entity.setState("annulé");
		return new CourrierInterne(entity);
	}

	@Override
	public CourrierInterne confirmer(CourrierInterne entity) {

		if (entity.getState().trim().equalsIgnoreCase("etabli")) {
			entity.setState("valide");
		}
		CourrierInterne data = dao.update(entity.getId(), entity);
		CourrierInterne result = new CourrierInterne(data);

		for (FichierLie aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLie(aas));
		}
		return result;
	}
}
