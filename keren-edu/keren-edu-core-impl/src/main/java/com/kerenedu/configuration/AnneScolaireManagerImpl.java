
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
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "AnneScolaireManager")
public class AnneScolaireManagerImpl
    extends AbstractGenericManager<AnneScolaire, Long>
    implements AnneScolaireManagerLocal, AnneScolaireManagerRemote
{

    @EJB(name = "AnneScolaireDAO")
    protected AnneScolaireDAOLocal dao;

    public AnneScolaireManagerImpl() {
    }

    @Override
    public GenericDAO<AnneScolaire, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public List<AnneScolaire> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<AnneScolaire> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<AnneScolaire> result = new ArrayList<AnneScolaire>();
		for(AnneScolaire elev:datas){
			result.add(new AnneScolaire(elev));
		}
	
		return result;
	}

	@Override
	public AnneScolaire find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		AnneScolaire annee = super.find(propertyName, entityID);
		AnneScolaire inscrip = new AnneScolaire(annee);
		for(PeriodeScolaire serv: annee.getPeriodeScoalire()){
			inscrip.getPeriodeScoalire().add(new PeriodeScolaire(serv));
		}
		return inscrip;
	}

	@Override
	public List<AnneScolaire> findAll() {
		// TODO Auto-generated method stub
		List<AnneScolaire> datas = super.findAll();
		List<AnneScolaire> result = new ArrayList<AnneScolaire>();
		for(AnneScolaire elev:datas){
			result.add(new AnneScolaire(elev));
		}
		return result;
	}
	
	
	@Override
	public AnneScolaire delete(Long id) {
		// TODO Auto-generated method stub
		AnneScolaire annee = super.delete(id);
		return new AnneScolaire(annee);
	}

}
