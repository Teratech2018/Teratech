
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
@Stateless(mappedName = "EtablissementManager")
public class EtablissementManagerImpl
    extends AbstractGenericManager<Etablissement, Long>
    implements EtablissementManagerLocal, EtablissementManagerRemote
{

    @EJB(name = "EtablissementDAO")
    protected EtablissementDAOLocal dao;

    public EtablissementManagerImpl() {
    }

    @Override
    public GenericDAO<Etablissement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
	public List<Etablissement> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		List<Etablissement> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Etablissement> result = new ArrayList<Etablissement>();
		for(Etablissement elev:datas){
			result.add(new Etablissement(elev));
		}
		return result;
	}

	@Override
	public Etablissement find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Etablissement data = super.find(propertyName, entityID);
		Etablissement result = new Etablissement(data);
		for(Cycle cycle:data.getCyles()){
			result.getCyles().add(cycle);
		}
		return result;
	}

	@Override
	public List<Etablissement> findAll() {
		// TODO Auto-generated method stub
		List<Etablissement> datas = super.findAll();
		List<Etablissement> result = new ArrayList<Etablissement>();
		for(Etablissement etbl : datas){
			result.add(new Etablissement(etbl));
		}
		return result;
	}

}
