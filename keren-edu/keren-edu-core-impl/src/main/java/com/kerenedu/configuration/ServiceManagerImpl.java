
package com.kerenedu.configuration;

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
import com.kerenedu.reglement.FichePaiement;
import com.kerenedu.reglement.FichePaiementOptionel;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "ServiceManager")
public class ServiceManagerImpl extends AbstractGenericManager<Service, Long>
		implements ServiceManagerLocal, ServiceManagerRemote {

	@EJB(name = "ServiceDAO")
	protected ServiceDAOLocal dao;
	
	@EJB(name = "ClasseDAO")
	protected ClasseDAOLocal daoclasse;

	public ServiceManagerImpl() {
	}

	@Override
	public GenericDAO<Service, Long> getDao() {
		return dao;
	}

	@Override
	public String getEntityIdName() {
		return "id";
	}

	@Override
	public List<Service> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Service> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Service> result = new ArrayList<Service>();
		for (Service elev : datas) {
			result.add(new Service(elev));
		}
		return result;
	}

	@Override
	public Service find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Service elev = super.find(propertyName, entityID);
		Service inscrip = new Service(elev);
		for (ServiceFilliere frais : elev.getFiliere()) {
			inscrip.getFiliere().add(new ServiceFilliere(frais));
		}
		return inscrip;
	}

	@Override
	public List<Service> findAll() {
		// TODO Auto-generated method stub
		List<Service> datas = super.findAll();
		List<Service> result = new ArrayList<Service>();
		for (Service elev : datas) {
			result.add(new Service(elev));
		}
		return result;
	}

	@Override
	public void processBeforeSave(Service entity) {
		long montant = 0;
		List<ServiceFilliere> datas = new ArrayList<ServiceFilliere>();
		for(ServiceFilliere sf : entity.getFiliere()){
			montant= montant+sf.getzMnt();
			sf.setId(-1);
//			datas.add(sf);
		}
		entity.setzMnt(new Double(montant));
		super.processBeforeSave(entity);
	}
	
	

	@Override
	public void processBeforeUpdate(Service entity) {
		long montant = 0;
		List<ServiceFilliere> datas = new ArrayList<ServiceFilliere>();
		for(ServiceFilliere sf : entity.getFiliere()){
			montant= montant+sf.getzMnt();
			sf.setId(-1);
//			datas.add(sf);
		}
		entity.setzMnt(new Double(montant));
		super.processBeforeUpdate(entity);
	}

	@Override
	public List<FichePaiement> findmatierclasse(long id) {
		RestrictionsContainer container = RestrictionsContainer.newInstance();
		List<Service> result = new ArrayList<Service>();
		List<FichePaiement>datas = new ArrayList<FichePaiement>();
		if (id > 0) {
			container = RestrictionsContainer.newInstance();
			container.addEq("id",id);
			Classe classe = daoclasse.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1).get(0);
			
			container = RestrictionsContainer.newInstance();
			//container.addEq("filiere.id",classe.getFiliere().getId());
			 result = dao.filter(container.getPredicats(), null, new HashSet<String>(), 0, -1);
			 
		if(result!=null&!result.isEmpty()){
			for(Service serice : result){
				for(ServiceFilliere filliere : serice.getFiliere()){
					if(filliere.getFiliere().getId()==classe.getFiliere().getId()&&serice.getExige()==true){
						FichePaiement fiche = new FichePaiement(serice,filliere);
						fiche.setId(-1);
						datas.add(fiche);
					}
				}
				
			}
		}
		}
		return datas;
	}
	


}
