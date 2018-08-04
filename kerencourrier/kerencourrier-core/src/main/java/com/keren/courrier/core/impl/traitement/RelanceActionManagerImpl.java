
package com.keren.courrier.core.impl.traitement;

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
import com.keren.courrier.core.ifaces.traitement.RelanceActionManagerLocal;
import com.keren.courrier.core.ifaces.traitement.RelanceActionManagerRemote;
import com.keren.courrier.dao.ifaces.courrier.BorderoCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierCloneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.CourrierInterneDAOLocal;
import com.keren.courrier.dao.ifaces.courrier.TraitementCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.EventCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.RappelCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.referentiel.UtilisateurCourrierDAOLocal;
import com.keren.courrier.dao.ifaces.traitement.RelanceActionDAOLocal;
import com.keren.courrier.model.courrier.BorderoCourrier;
import com.keren.courrier.model.courrier.CourrierClone;
import com.keren.courrier.model.courrier.CourrierInterne;
import com.keren.courrier.model.courrier.FichierLie;
import com.keren.courrier.model.courrier.LigneBorderoCourrier;
import com.keren.courrier.model.courrier.TraitementCourrier;
import com.keren.courrier.model.courrier.TypeTraitement;
import com.keren.courrier.model.referentiel.EventCourrier;
import com.keren.courrier.model.referentiel.RappelCourrier;
import com.keren.courrier.model.referentiel.UtilisateurCourrier;
import com.keren.courrier.model.traitement.RelanceAction;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RelanceActionManager")
public class RelanceActionManagerImpl extends AbstractGenericManager<RelanceAction, Long>
		implements RelanceActionManagerLocal, RelanceActionManagerRemote {

	@EJB(name = "RelanceActionDAO")
	protected RelanceActionDAOLocal dao;
	@EJB(name = "BorderoCourrierDAO")
	protected BorderoCourrierDAOLocal borderodao;

	@EJB(name = "CourrierInterneDAO")
	protected CourrierInterneDAOLocal daoci;

	@EJB(name = "CourrierCloneDAO")
	protected CourrierCloneDAOLocal daoclone;

	@EJB(name = "EventCourrierDAO")
	protected EventCourrierDAOLocal eventdao;

	@EJB(name = "UtilisateurCourrierDAO")
	protected UtilisateurCourrierDAOLocal userdao;

	@EJB(name = "RappelCourrierEDAO")
	protected RappelCourrierDAOLocal rappeldao;

	@EJB(name = "TraitementCourrierDAO")
	protected TraitementCourrierDAOLocal daotrt;

	public RelanceActionManagerImpl() {
	}

	@Override
	public GenericDAO<RelanceAction, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<RelanceAction> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		List<RelanceAction> datas = super.filter(predicats, orders, properties, firstResult, maxResult); // To
																											// change
																											// body
																											// of
																											// generated
																											// methods,
																											// choose
																											// Tools
																											// |
																											// Templates.
		List<RelanceAction> results = new ArrayList<RelanceAction>();
		for (RelanceAction data : datas) {
			results.add(new RelanceAction(data));
		}
		return results;
	}

	@Override
	public List<RelanceAction> findAll() {
		return super.findAll(); // To change body of generated methods, choose
								// Tools | Templates.
	}

	@Override
	public RelanceAction find(String propertyName, Long entityID) {
		RelanceAction data = super.find(propertyName, entityID); // To change
																	// body of
																	// generated
																	// methods,
																	// choose
																	// Tools |
																	// Templates.
		RelanceAction result = new RelanceAction(data);
		for (FichierLie aas : data.getPiecesjointes()) {
			result.getPiecesjointes().add(new FichierLie(aas));
		}

		return result;
	}

	@Override
	public RelanceAction delete(Long id) {
		// To change body of generated methods, choose Tools | Templates.
		RelanceAction data = super.delete(id);
		RelanceAction entity = new RelanceAction(data);
		return entity;
	}

	@Override
	public void processBeforeSave(RelanceAction entity) {
    	CourrierInterne ciEntity= entity.getCourrierinterne();
    	ciEntity.setCode("RE/CI/"+entity.getCourrier().getId()+"/"+DateHelper.convertToString(ciEntity.getDcourrier(), "dd/MM/yyyy"));
    	daoci.save(ciEntity);
    	ciEntity = daoci.findByPrimaryKey("id", ciEntity.getId());
		BorderoCourrier bordero = borderodao.checkBordero(entity.getCourrierinterne().getSource().getService(), entity.getService(),
				ciEntity.getType());
		ciEntity.setBordero(bordero);
		 if(ciEntity.getBordero()!=null){
	            LigneBorderoCourrier ligne = new LigneBorderoCourrier();
	            ligne.setCourrier(new CourrierClone(ciEntity));
	            ligne.setNature("0");
	            ciEntity.getBordero().getCourriers().add(ligne);
	            ciEntity.getBordero().setCode("BDR/CIR/" + ciEntity.getBordero().getId() + "/" + DateHelper.convertToString(ciEntity.getDcourrier(), "dd/MM/yyyy"));
	            ciEntity.getBordero().setState("transmis");
	            borderodao.update(ciEntity.getBordero().getId(), ciEntity.getBordero());           
	        }//end if(entity.getBordero()!=null){
		ciEntity.setCode("CIR/"+entity.getId()+"/"+DateHelper.convertToString(ciEntity.getDcourrier(), "dd/MM/yyyy"));
		TraitementCourrier trtcourrier = new TraitementCourrier(new CourrierClone(ciEntity),TypeTraitement.TRANSMISSION);
		daotrt.save(trtcourrier);
		daoci.update(ciEntity.getId(), ciEntity);
		
		// update du courrier 
		CourrierClone courrier =daoclone.findByPrimaryKey("id", entity.getCourrier().getId());
		courrier.setLimite(entity.getLimite());
		daoclone.update(courrier.getId(), courrier);
		// create event courrier
		this.createEventRelance(entity);
		super.processBeforeSave(entity);
	}

	@Override
	public RelanceAction save(RelanceAction entity) {
		// TODO Auto-generated method stub
		return super.save(entity);
	}

	public void createEventRelance(RelanceAction entity) {
		EventCourrier evt = new EventCourrier();
		evt.setId(-1);
		evt.setTitle("RELANCE TRAITEMENT COURRIER" + entity.getCourrier().getCode());
		evt.setDescription(entity.getNote());
		evt.setStart(entity.getDoldlimite());
		evt.setEnd(entity.getLimite());
		evt.setDuree("01:00");
		evt.setRecurrent(false);
		evt.setConfidentialite((short) 0);
		evt.setDisponibilite((short) 0);
		evt.setLieu("RAS");
		evt.setAllDay(true);
		UtilisateurCourrier user = entity.getQuote();
		evt.setOwner(user);
		evt.getParticipants().add(user);
		evt.getParticipants().add(entity.getCourrier().getSource());
		evt.setNotify(true);
		RappelCourrier rappel = rappeldao.findByPrimaryKey("id", (long) 1);
		evt.setRappel(rappel);
		eventdao.save(evt);

	}

}
