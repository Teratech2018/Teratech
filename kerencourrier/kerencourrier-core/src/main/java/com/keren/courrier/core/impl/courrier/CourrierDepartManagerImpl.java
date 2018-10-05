
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
import com.keren.courrier.core.ifaces.courrier.CourrierDepartManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierDepartManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierDepartDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.CompanyDAOLocal;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.CourrierDepart;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.referentiel.Company;
import com.keren.courrier.model.referentiel.Correspondant;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CourrierDepartManager")
public class CourrierDepartManagerImpl extends AbstractGenericManager<CourrierDepart, Long>
		implements CourrierDepartManagerLocal, CourrierDepartManagerRemote {

	@EJB(name = "CourrierDepartDAO")
	protected CourrierDepartDAOLocal dao;

	@EJB(name = "CourrierCloneDAO")
	protected CourrierCloneDAOLocal daoclone;

	@EJB(name = "BorderoCourrierDAO")
	protected BorderoCourrierDAOLocal borderodao;

	@EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;
	
	@EJB(name = "CompanyDAO")
	protected CompanyDAOLocal daocompany;

	public CourrierDepartManagerImpl() {
	}

	@Override
	public GenericDAO<CourrierDepart, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<CourrierDepart> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		List<CourrierDepart> datas = super.filter(predicats, orders, properties, firstResult, maxResult); 
		List<CourrierDepart> results = new ArrayList<CourrierDepart>();
		for (CourrierDepart courrier : datas) {
			results.add(new CourrierDepart(courrier));
		} // end for(CourrierDepart courrier:datas){
		return results;
	}

	@Override
	public List<CourrierDepart> findAll() {

		// To change body of generated methods, choose Tools | Templates.
		List<CourrierDepart> datas = super.findAll();
		List<CourrierDepart> results = new ArrayList<CourrierDepart>();
		for (CourrierDepart data : datas) {
			results.add(new CourrierDepart(data));
		}

		return results;
	}

	@Override
	public CourrierDepart find(String propertyName, Long entityID) {
		CourrierDepart data = super.find(propertyName, entityID); 
		CourrierDepart result = new CourrierDepart(data);
		for (FichierLie aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLie(aas));
		}
		for (Correspondant cores : data.getCorrespondant()) {
			result.getCorrespondant().add(new Correspondant(cores));
		}

		return result;
	}

	@Override
	public void processBeforeSave(CourrierDepart entity) {
		
		if(entity.getDcourrier()==null){
			entity.setDcourrier(new Date());
		}
		
		 RestrictionsContainer container = RestrictionsContainer.newInstance();
		// set expéditeur courrier départ : company 
		Company comp= daocompany.filter(container.getPredicats(), null, null, 0, -1).get(0);
		entity.setExpediteur(new Company(comp));

		/*
		 * On ajoute la catorie du courrier 0 ==> courriers arrivés 1 ==>
		 * courriers departs 2 ==> courriers interne
		 */
		entity.setCategorie("1");
		if (entity.getService() != null) {
			String type = "1";
			if (entity.getPorte() != null && entity.getPorte().trim().equalsIgnoreCase("1")) {
				BorderoCourrier bordero = borderodao.checkBordero(entity.getSource().getService(),
						entity.getCorrespondant(), type);
				entity.setBordero(bordero);
			} // end if(entity.getService()!=null){
		}
		super.processBeforeSave(entity);
	}

	@Override
	public void processAfterSave(CourrierDepart entity) {
		entity = dao.findByPrimaryKey("id", entity.getId());
		entity.setCode("CD/" + entity.getId() + "/" + DateHelper.convertToString(entity.getDcourrier(), "dd/MM/yyyy"));
		// ========== @NTW ENREGISTRER LE TRAITEMENT========;
		TraitementCourrier trtcourrier = new TraitementCourrier(new CourrierClone(entity),
				TypeTraitement.ENREGISTREMENT);
		daotrt.save(trtcourrier);
		dao.update(entity.getId(), entity);
		if (entity.getBordero() != null) {
			LigneBorderoCourrier ligne = new LigneBorderoCourrier();
			ligne.setCourrier(new CourrierClone(entity));
			ligne.setNature("0");
			entity.getBordero().getCourriers().add(ligne);
			entity.getBordero().setCode("BDR/CD/" + entity.getBordero().getId() + "/"
					+ DateHelper.convertToString(entity.getDcourrier(), "dd/MM/yyyy"));
			borderodao.update(entity.getBordero().getId(), entity.getBordero());
		} // end if(entity.getBordero()!=null){
		super.processAfterSave(entity);
	}

	@Override
	public CourrierDepart distribuer(CourrierDepart entity) {

		entity = dao.findByPrimaryKey("id", entity.getId());
		if (entity.getState().equalsIgnoreCase("etabli")) {
			entity.setState("valide");
			TraitementCourrier trtcourrier = new TraitementCourrier(entity, TypeTraitement.TRANSMISSION);
			trtcourrier.setId(-1);
			daotrt.save(trtcourrier);
			entity = dao.update(entity.getId(), entity);
		}

		return new CourrierDepart(entity);
	}

	@Override
	public CourrierDepart delete(Long id) {

		// befor delete ligne bordero
		// delete ligne piece jointe
		CourrierDepart entity = dao.findByPrimaryKey("id", id);
//		daoclone.deleteCourrierRAD(new CourrierClone(entity));
//		entity = new CourrierDepart();
//		System.out.println("CourrierDepartManagerImpl.delete() delet ok ...");
		entity.setState("annulé");
		return new CourrierDepart(entity);
	}

	@Override
	public CourrierDepart confirmer(CourrierDepart entity) {

		if (entity.getState().trim().equalsIgnoreCase("etabli")) {
			entity.setState("valide");
		}

		CourrierDepart data = dao.update(entity.getId(), entity);
		CourrierDepart result = new CourrierDepart(data);

		for (FichierLie aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLie(aas));
		}

		return result;
	}
}
