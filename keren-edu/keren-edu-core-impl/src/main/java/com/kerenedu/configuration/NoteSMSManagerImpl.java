
package com.kerenedu.configuration;

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
import com.kerenedu.inscription.Inscription;
import com.kerenedu.inscription.InscriptionDAOLocal;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "NoteSMSManager")
public class NoteSMSManagerImpl extends AbstractGenericManager<NoteSMS, Long>
		implements NoteSMSManagerLocal, NoteSMSManagerRemote {

	@EJB(name = "NoteSMSDAO")
	protected NoteSMSDAOLocal dao;

	@EJB(name = "InscriptionDAO")
	protected InscriptionDAOLocal daoinscrit;

	public NoteSMSManagerImpl() {
	}

	@Override
	public GenericDAO<NoteSMS, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<NoteSMS> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<NoteSMS> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<NoteSMS> result = new ArrayList<NoteSMS>();
		for (NoteSMS elev : datas) {
			result.add(new NoteSMS(elev));
		}
		return result;
	}

	@Override
	public NoteSMS find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		NoteSMS elev = super.find(propertyName, entityID);
		NoteSMS inscrip = new NoteSMS(elev);
//		for (Inscription serv : CacheMemory.getListdestinataire()) {
//			inscrip.getEleveList().add(new Inscription(serv));
//		}
		return inscrip;
	}

	@Override
	public List<NoteSMS> findAll() {
		// TODO Auto-generated method stub
		List<NoteSMS> datas = super.findAll();
		List<NoteSMS> result = new ArrayList<NoteSMS>();
		for (NoteSMS elev : datas) {
			result.add(new NoteSMS(elev));
		}
		return result;
	}

	@Override
	public NoteSMS delete(Long id) {
		// TODO Auto-generated method stub
		NoteSMS elev = super.delete(id);
		return new NoteSMS(elev);
	}
	
	


	@Override
	public void processBeforeSave(NoteSMS entity) {
		entity.setListDestinataire(CacheMemory.getListdestinataire());
		this.savemessage(entity);
	}
	
	private void savemessage(NoteSMS entity){
		List<NoteSMS> listsms = new ArrayList<NoteSMS>();
		NoteSMS sms = new NoteSMS();
			System.out.println("NoteSMSManagerImpl.processBeforeSave() je suis ici selectionne etudiant");
			List<Inscription> list = entity.getListDestinataire();
			System.out.println("NoteSMSManagerImpl.processBeforeSave() je suis ici selectionne etudiant nombre select"+list.size());
			for (Inscription data : list) {
				sms = new NoteSMS(entity, data.getEleve());
				//listsms.add(sms);
				save(sms);
			}
			System.out.println("NoteSMSManagerImpl.processBeforeSave() nombre sms is "+listsms.size());
			//save(listsms);
	}

	@Override
	public void processBeforeUpdate(NoteSMS entity) {
		// verifier si l'étudiant a déjà été inscit
		/*
		 * NoteSMS inscit = dao.getNoteSMSEtudiantByAnnee(entity.getEleve(),
		 * entity.getAnneScolaire()); if(inscit!=null){ RuntimeException excep =
		 * new RuntimeException("Eléve déjà Inscrit !!!"); throw new
		 * WebApplicationException(excep,Response.Status.NOT_MODIFIED); }
		 */
		super.processBeforeUpdate(entity);
	}

}
