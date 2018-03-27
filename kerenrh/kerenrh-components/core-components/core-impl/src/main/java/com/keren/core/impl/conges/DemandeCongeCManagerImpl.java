
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
import com.keren.core.ifaces.conges.DemandeCongeCManagerLocal;
import com.keren.core.ifaces.conges.DemandeCongeCManagerRemote;
import com.keren.dao.ifaces.conges.DemandeCongeCDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeRDAOLocal;
import com.keren.dao.ifaces.conges.DemandeCongeVDAOLocal;
import com.keren.model.conges.DemandeConge;
import com.keren.model.conges.DemandeCongeC;
import com.keren.model.conges.DemandeCongeR;
import com.keren.model.conges.DemandeCongeV;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "DemandeCongeCManager")
public class DemandeCongeCManagerImpl
    extends AbstractGenericManager<DemandeCongeC, Long>
    implements DemandeCongeCManagerLocal, DemandeCongeCManagerRemote
{

    @EJB(name = "DemandeCongeCDAO")
    protected DemandeCongeCDAOLocal dao;
    
    @EJB(name = "DemandeCongeVDAO")
    protected DemandeCongeVDAOLocal daodcv;
    
    
    @EJB(name = "DemandeCongeRDAO")
    protected DemandeCongeRDAOLocal daodcr;
    
    @EJB(name = "DemandeCongeDAO")
    protected DemandeCongeDAOLocal daodc;

    public DemandeCongeCManagerImpl() {
    }

    @Override
    public GenericDAO<DemandeCongeC, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public DemandeCongeC delete(Long id) {
		// TODO Auto-generated method stub
		DemandeCongeC data= super.delete(id);
		return new DemandeCongeC(data);
	}

	@Override
	public List<DemandeCongeC> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<DemandeCongeC> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<DemandeCongeC> result = new ArrayList<DemandeCongeC>();
		for(DemandeCongeC data:datas){
			result.add(new DemandeCongeC(data));
		}
		return result;
	}
	

	@Override
	public void processAfterSave(DemandeCongeC entity) {
		// determine la date de din de congé  en prenant en copte les jours ouvré
		super.processAfterSave(entity);
	}

	@Override
	public void processAfterUpdate(DemandeCongeC entity) {
		// TODO Auto-generated method stub
		super.processAfterUpdate(entity);
	}

	@Override
	public DemandeCongeC find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		DemandeCongeC data = super.find(propertyName, entityID);
		DemandeCongeC result = new DemandeCongeC(data);		
		return result;
	}

	@Override
	public List<DemandeCongeC> findAll() {
		// TODO Auto-generated method stub
		List<DemandeCongeC> datas = super.findAll();
		List<DemandeCongeC> result = new ArrayList<DemandeCongeC>();
		for(DemandeCongeC data:datas){
			result.add(new DemandeCongeC(data));
		}
		return result;
	}

	@Override
	public DemandeCongeV approuver(DemandeCongeC dmde) {
		DemandeCongeV dcv = new DemandeCongeV(dmde);
		dcv.setId(-1);
		dao.delete(dmde.getId());
		daodcv.save(dcv);
		return dcv;
	}

	@Override
	public DemandeCongeR rejeter(DemandeCongeC dmde) {
		DemandeCongeR dcr = new DemandeCongeR(dmde);
		dcr.setId(-1);
		dao.delete(dmde.getId());
		daodcr.save(dcr);
		return dcr;
	}

	@Override
	public DemandeConge annuler(DemandeCongeC dmde) {
		DemandeConge dc = new DemandeConge(dmde);
		dc.setId(-1);
		dao.delete(dmde.getId());
		daodc.save(dc);
		return dc;
	}
    
    

}
