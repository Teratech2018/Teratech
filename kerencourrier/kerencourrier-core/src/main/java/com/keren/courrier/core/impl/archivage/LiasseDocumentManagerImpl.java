
package com.keren.courrier.core.impl.archivage;

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
import com.kerem.commons.DateHelper;
import com.keren.courrier.core.ifaces.archivage.LiasseDocumentManagerLocal;
import com.keren.courrier.core.ifaces.archivage.LiasseDocumentManagerRemote;
import com.keren.courrier.dao.ifaces.archivage.BorderoLiasseDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.model.archivage.BorderoLiasse;
import com.keren.courrier.model.archivage.LiasseDocument;
import com.keren.courrier.model.archivage.LigneBorderoLiasse;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "LiasseDocumentManager")
public class LiasseDocumentManagerImpl
    extends AbstractGenericManager<LiasseDocument, Long>
    implements LiasseDocumentManagerLocal, LiasseDocumentManagerRemote
{

    @EJB(name = "LiasseDocumentDAO")
    protected LiasseDocumentDAOLocal dao;
    
    @EJB(name = "BorderoLiasseDAO")
    protected BorderoLiasseDAOLocal daobdr;
    
    @EJB(name = "CourrierCloneDAO")
    protected CourrierCloneDAOLocal courrierdao;
    
    @EJB(name = "TraitementCourrierDAO")
    protected TraitementCourrierDAOLocal trtdao;

    public LiasseDocumentManagerImpl() {
    }

    @Override
    public GenericDAO<LiasseDocument, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
	public List<LiasseDocument> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		List<LiasseDocument> datas = super.filter(predicats, orders, properties, firstResult, maxResult); // To
		List<LiasseDocument> results = new ArrayList<LiasseDocument>();
		for (LiasseDocument LiasseDocument : datas) {
			LiasseDocument data = new LiasseDocument(LiasseDocument);
			results.add(data);
		} // end for(LiasseDocument LiasseDocument:datas){
		return results;
	}

	@Override
	public List<LiasseDocument> findAll() {

		// To change body of generated methods, choose Tools | Templates.
		List<LiasseDocument> datas = super.findAll();
		List<LiasseDocument> results = new ArrayList<LiasseDocument>();
		for (LiasseDocument data : datas) {
			LiasseDocument c = new LiasseDocument(data);
			results.add(c);
		}

		return results;
	}

	@Override
	public LiasseDocument find(String propertyName, Long entityID) {
		// initialisaiton
		LiasseDocument data = super.find(propertyName, entityID); // To change body of
															// generated
															// methods, choose
															// Tools |
															// Templates.
		LiasseDocument result = new LiasseDocument(data);
		for (FichierLie aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLie(aas));
		}
		
		for (CourrierClone aas : data.getCourriers()) {
			result.getCourriers().add(new CourrierClone(aas));
		}

		return result;
	}

	@Override
	public void processBeforeSave(LiasseDocument entity) {
		// if(entity.getPorte()!=null&&entity.getPorte().trim().equalsIgnoreCase("1")){
		BorderoLiasse bordero = daobdr.checkBordero(entity.getSource().getService(), entity.getService());
		entity.setBordero(bordero);
		
		super.processBeforeSave(entity);
	}

	@Override
	public void processAfterSave(LiasseDocument entity) {
		entity = dao.findByPrimaryKey("code", entity.getCode());
		entity = dao.findByPrimaryKey("id", entity.getId());
		entity.setCode("LS/" + entity.getId() + "/" + DateHelper.convertToString(entity.getDliasse(), "dd/MM/yyyy"));
		//========== @NTW ENREGISTRER LE TRAITEMENT========;
		// créer le trrt qui montre que les courrrier on été en liasser
//		entity.getTraitements().add(trtLiasseDocument);
		dao.update(entity.getId(), entity);
		if (entity.getBordero() != null) {
			LigneBorderoLiasse ligne = new LigneBorderoLiasse();
			ligne = new LigneBorderoLiasse(entity);
			entity.getBordero().getLignes().add(ligne);
			entity.getBordero().setCode("BDR/LS/" + entity.getBordero().getId() + "/" + DateHelper.convertToString(entity.getDliasse(), "dd/MM/yyyy"));
			daobdr.update(entity.getBordero().getId(), entity.getBordero());
			
		// update courrier et etat archivage partiel
			for(CourrierClone courrier: entity.getCourriers()){
				this.classerCourrier(courrier, entity);
			}
		
		} // end if(entity.getBordero()!=null){
	
		super.processAfterSave(entity); // To change body of generated methods,
										// choose Tools | Templates.
	}
	
	public CourrierClone classerCourrier(CourrierClone interne,LiasseDocument entity){
		
		List<CourrierClone> fondsdossier = new ArrayList<CourrierClone>();
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		container.addEq("courrier.id", interne.getId());
		fondsdossier = courrierdao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
		for( CourrierClone c : fondsdossier){
			classerCourrier(c, entity);
		}//end for( CourrierClone c : fondsdossier){		
		CourrierClone result = new CourrierClone();
		interne = courrierdao.findByPrimaryKey("id", interne.getId());
		TraitementCourrier traitement = new TraitementCourrier(interne, TypeTraitement.CLASSEMENT);
		traitement.setAvis("Courrier En LIASSER ");
		traitement.setDoperation(entity.getDliasse());
		traitement.setOperateur(entity.getSource());
		interne.setLastState(interne.getState());
		interne.setState("archivage partiel");
		interne.setTypeclassement("2");
		trtdao.save(traitement);
		result= courrierdao.update(interne.getId(), interne);
		return result;		
	}
	

	@Override
	public void processAfterUpdate(LiasseDocument entity) {
		super.processAfterUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public void processBeforeUpdate(LiasseDocument entity) {
		LiasseDocument old = dao.findByPrimaryKey("id", entity.getId());
		if (old.getService() == null && entity.getService() != null) {
			
			BorderoLiasse bordero = daobdr.checkBordero(entity.getSource().getService(), entity.getService());
			entity.setBordero(bordero);
			LigneBorderoLiasse ligne = new LigneBorderoLiasse();
			ligne = new LigneBorderoLiasse(entity);
			ligne = new LigneBorderoLiasse(entity);
			entity.getBordero().getLignes().add(ligne);
			daobdr.update(entity.getBordero().getId(), entity.getBordero());
		} // end if(old.getService()==null&&entity.getService()!=null){
		super.processBeforeUpdate(entity); // To change body of generated
											// methods, choose Tools |
											// Templates.
	}

	@Override
	public LiasseDocument delete(Long id) {
		// befor delete ligne bordero
		// delete ligne piece jointe
//		LiasseDocument entity = dao.findByPrimaryKey("id", id);
//		daoclone.deleteLiasseDocumentRAD(new LiasseDocumentClone(entity));
//		entity = new LiasseDocument();
//		System.out.println("LiasseDocumentDepartManagerImpl.delete() delet ok ...");
		return new LiasseDocument(null);
	}

}
