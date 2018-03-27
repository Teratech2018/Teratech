
package com.keren.core.impl.conges;

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
import com.keren.core.ifaces.conges.RepriseServiceManagerLocal;
import com.keren.core.ifaces.conges.RepriseServiceManagerRemote;
import com.keren.dao.ifaces.conges.DemandeCongeVDAOLocal;
import com.keren.dao.ifaces.conges.RepriseServiceDAOLocal;
import com.keren.model.conges.RepriseService;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "RepriseServiceManager")
public class RepriseServiceManagerImpl
    extends AbstractGenericManager<RepriseService, Long>
    implements RepriseServiceManagerLocal, RepriseServiceManagerRemote
{

    @EJB(name = "RepriseServiceDAO")
    protected RepriseServiceDAOLocal dao;
    
    @EJB(name = "DemandeCongeVDAO")
    protected DemandeCongeVDAOLocal daodcv;

    public RepriseServiceManagerImpl() {
    }

    @Override
    public GenericDAO<RepriseService, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public RepriseService delete(Long id) {
		// TODO Auto-generated method stub
		RepriseService data= super.delete(id);
		return new RepriseService(data);
	}

	@Override
	public List<RepriseService> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<RepriseService> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<RepriseService> result = new ArrayList<RepriseService>();
		for(RepriseService data:datas){
			result.add(new RepriseService(data));
		}
		return result;
	}
	

	@Override
	public void processAfterSave(RepriseService entity) {
		// determine la date de din de congé  en prenant en copte les jours ouvré
		daodcv.update(entity.getConge().getId(), entity.getConge());
		super.processAfterSave(entity);
	}

	@Override
	public void processAfterUpdate(RepriseService entity) {
		// TODO Auto-generated method stub
		super.processAfterUpdate(entity);
	}

	@Override
	public RepriseService find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		RepriseService data = super.find(propertyName, entityID);
		RepriseService result = new RepriseService(data);		
		return result;
	}

	@Override
	public List<RepriseService> findAll() {
		// TODO Auto-generated method stub
		List<RepriseService> datas = super.findAll();
		List<RepriseService> result = new ArrayList<RepriseService>();
		for(RepriseService data:datas){
			result.add(new RepriseService(data));
		}
		return result;
	}

	@Override
	public RepriseService confirmer(RepriseService dmde) {
		dmde.setState("Validé");
		dao.update(dmde.getId(), dmde);
		return dmde;
	}

}
