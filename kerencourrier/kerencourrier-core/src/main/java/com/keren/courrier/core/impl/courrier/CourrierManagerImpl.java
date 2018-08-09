
package com.keren.courrier.core.impl.courrier;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerem.commons.DateHelper;
import com.keren.courrier.core.ifaces.courrier.CourrierManagerLocal;
import com.keren.courrier.core.ifaces.courrier.CourrierManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.Courrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "CourrierManager")
public class CourrierManagerImpl extends AbstractGenericManager<Courrier, Long>
		implements CourrierManagerLocal, CourrierManagerRemote {

	@EJB(name = "CourrierDAO")
	protected CourrierDAOLocal dao;

	@EJB(name = "BorderoCourrierDAO")
	protected BorderoCourrierDAOLocal borderodao;
	
	@EJB(name = "CourrierCloneDAO")
	protected CourrierCloneDAOLocal daoclone;
	
	@EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;

	public CourrierManagerImpl() {
	}

	@Override
	public GenericDAO<Courrier, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<Courrier> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		List<Courrier> datas = super.filter(predicats, orders, properties, firstResult, maxResult); // To
                // change
                // body
                // of
                // generated
                // methods,
                // choose
                // Tools
                // |
                // Templates.
		List<Courrier> results = new ArrayList<Courrier>();
		for (Courrier courrier : datas) {
			Courrier data = new Courrier(courrier);
			results.add(data);
		} // end for(Courrier courrier:datas){
		return results;
	}

	@Override
	public List<Courrier> findAll() {

		// To change body of generated methods, choose Tools | Templates.
		List<Courrier> datas = super.findAll();
		List<Courrier> results = new ArrayList<Courrier>();
		for (Courrier data : datas) {
			results.add(new Courrier(data));
		}

		return results;
	}

	@Override
	public Courrier find(String propertyName, Long entityID) {
		// initialisaiton
		Courrier data = super.find(propertyName, entityID); // To change body of
															// generated
															// methods, choose
															// Tools |
															// Templates.
		Courrier result = new Courrier(data);
		for (FichierLie aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLie(aas));
		}
//		for (TraitementCourrier trt : data.getTraitements()) {
//			TraitementCourrier trtcour = new TraitementCourrier(trt);
//			UtilisateurCourrier user = new UtilisateurCourrier(trt.getOperateur(),"");
//			UtilisateurCourrier dest= new UtilisateurCourrier(trt.getDestinataire(),"");
//			trtcour.setOperateur(user);
//			trtcour.setDestinataire(dest);
//			result.getTraitements().add(trtcour);
//		}

		return result;
	}

	@Override
	public void processBeforeSave(Courrier entity) {
		/*
		 * On ajoute la catorie du courrier 
		 * 0 ==> courriers arrivés
		 *  1 ==> courriers departs 
		 *  2 ==> courriers interne
		 */
		entity.setCategorie("0");
		if (entity.getService() != null) {
			String type = "0";
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
	public void processAfterSave(Courrier entity) {
		entity = dao.findByPrimaryKey("code", entity.getCode());
		entity = dao.findByPrimaryKey("id", entity.getId());
		entity.setCode("CA/" + entity.getId() + "/" + DateHelper.convertToString(entity.getDcourrier(), "dd/MM/yyyy"));
		//========== @NTW ENREGISTRER LE TRAITEMENT========;
		TraitementCourrier trtcourrier = new TraitementCourrier(new CourrierClone(entity),TypeTraitement.ENREGISTREMENT);
		daotrt.save(trtcourrier);
//		entity.getTraitements().add(trtcourrier);
		dao.update(entity.getId(), entity);
		if (entity.getBordero() != null) {
			LigneBorderoCourrier ligne = new LigneBorderoCourrier();
			ligne.setCourrier(new CourrierClone(entity));
			ligne.setNature("0");
			entity.getBordero().getCourriers().add(ligne);
			entity.getBordero().setCode("BDR/CA/" + entity.getBordero().getId() + "/" + DateHelper.convertToString(entity.getDcourrier(), "dd/MM/yyyy"));
			borderodao.update(entity.getBordero().getId(), entity.getBordero());
		} // end if(entity.getBordero()!=null){
	
		super.processAfterSave(entity); // To change body of generated methods,
										// choose Tools | Templates.
	}

	@Override
	public void processAfterUpdate(Courrier entity) {
		super.processAfterUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public void processBeforeUpdate(Courrier entity) {
		Courrier old = dao.findByPrimaryKey("id", entity.getId());
		if (old.getService() == null && entity.getService() != null) {
			String type = "0";
			if (entity.getPorte() != null && entity.getPorte().trim().equalsIgnoreCase("1")) {
				type = "2";
			} // end
				// if(entity.getPorte()!=null&&entity.getPorte().trim().equalsIgnoreCase("1")){
			BorderoCourrier bordero = borderodao.checkBordero(entity.getSource().getService(), entity.getService(),
					type);
			entity.setBordero(bordero);
			LigneBorderoCourrier ligne = new LigneBorderoCourrier();
			ligne.setCourrier(new CourrierClone(entity));
			ligne.setNature("0");
			entity.getBordero().getCourriers().add(ligne);
			borderodao.update(entity.getBordero().getId(), entity.getBordero());
		} // end if(old.getService()==null&&entity.getService()!=null){
		super.processBeforeUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public Courrier delete(Long id) {
		// befor delete ligne bordero
		// delete ligne piece jointe
		Courrier entity = dao.findByPrimaryKey("id", id);
		daoclone.deleteCourrierRAD(new CourrierClone(entity));
		entity = new Courrier();
		System.out.println("CourrierDepartManagerImpl.delete() delet ok ...");
		return new Courrier(entity);
	}

}