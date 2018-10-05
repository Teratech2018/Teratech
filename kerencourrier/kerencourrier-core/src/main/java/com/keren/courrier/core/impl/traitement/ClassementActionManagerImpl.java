
package com.keren.courrier.core.impl.traitement;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.courrier.core.ifaces.traitement.ClassementActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.ClassementActionManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.ClassementActionDAOLocal;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.traitement.ClassementAction;

@TransactionAttribute
@Stateless(mappedName = "ClassementActionManager")
public class ClassementActionManagerImpl extends AbstractGenericManager<ClassementAction, Long>
		implements ClassementActionManagerLocal, ClassementActionManagerRemote {

	@EJB(name = "ClassementActionDAO")
	protected ClassementActionDAOLocal dao;

	@EJB(name = "CourrierCloneDAO")
	protected CourrierCloneDAOLocal courrierdao;

	@EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;

	public ClassementActionManagerImpl() {
	}

	@Override
	public GenericDAO<ClassementAction, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public void processAfterSave(ClassementAction entity) {
		// entity = dao.findByPrimaryKey("id", entity.getId());
		// CourrierClone courrier = entity.getCourrier();
		// courrier = daocourrier.findByPrimaryKey("id", courrier.getId());
		// //========== @NTW ENREGISTRER LE TRAITEMENT========;
		// TraitementCourrier trtcourrier = new
		// TraitementCourrier(courrier,TypeTraitement.CLASSEMENT);
		// daotrt.save(trtcourrier);
		// daocourrier.update(courrier.getId(), courrier);
		super.processAfterSave(entity);
	}

	@Override
	public void processBeforeSave(ClassementAction entity) {

		CourrierClone courrier = entity.getCourrier();
		this.declasserAction(courrier, entity);

		super.processBeforeSave(entity); // To change body of generated methods,
											// choose Tools | Templates.
	}
	
	public void declasserAction(CourrierClone courrier,ClassementAction entity){
		if (entity.getNature().equals("0")) {
			// classement dossier sans suite
			CourrierClone result = new CourrierClone();
			courrier = courrierdao.findByPrimaryKey("id", courrier.getId());
			TraitementCourrier traitement = new TraitementCourrier(courrier, TypeTraitement.CLASSEMENT);
			traitement.setAvis(entity.getMotif());
			traitement.setDoperation(entity.getDclassement());
			traitement.setOperateur(entity.getOrdonateur());
			traitement.setClasseur(entity.getClasseur());
			traitement.setCompartiment(entity.getCompartiment());
			courrier.setLastState(courrier.getState());
			courrier.setState("classer");
			courrier.setTypeclassement(entity.getNature());
			daotrt.save(traitement);
			result= courrierdao.update(courrier.getId(), courrier);
		} 
		// classement fond de dossier
		if (entity.getNature().equals("1")) {
			this.classerfonddossier(courrier, entity);
			
		} 
		
	}
	
	public CourrierClone classerfonddossier(CourrierClone interne,ClassementAction entity){
		
		List<CourrierClone> fondsdossier = new ArrayList<CourrierClone>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("courrier.id", interne.getId());
		fondsdossier = courrierdao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		for( CourrierClone c : fondsdossier){
			classerfonddossier(c, entity);
		}//end for( CourrierClone c : fondsdossier){		
		CourrierClone result = new CourrierClone();
		interne = courrierdao.findByPrimaryKey("id", interne.getId());
		TraitementCourrier traitement = new TraitementCourrier(interne, TypeTraitement.CLASSEMENT);
		traitement.setAvis(entity.getMotif());
		traitement.setDoperation(entity.getDclassement());
		traitement.setOperateur(entity.getOrdonateur());
		traitement.setClasseur(entity.getClasseur());
		traitement.setCompartiment(entity.getCompartiment());
		interne.setLastState(interne.getState());
		interne.setState("archivage partiel");
		interne.setTypeclassement(entity.getNature());
		daotrt.save(traitement);
		result= courrierdao.update(interne.getId(), interne);
		return result;		
	}
	


}
