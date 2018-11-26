
package com.kerenedu.inscription;

import java.util.ArrayList;
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
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.reglement.FichePaiement;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "InscriptionChoiceManager")
public class InscriptionChoiceManagerImpl
    extends AbstractGenericManager<InscriptionChoice, Long>
    implements InscriptionChoiceManagerLocal, InscriptionChoiceManagerRemote
{

    @EJB(name = "InscriptionChoiceDAO")
    protected InscriptionChoiceDAOLocal dao;

    public InscriptionChoiceManagerImpl() {
    }

    @Override
    public GenericDAO<InscriptionChoice, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    @Override
	public List<InscriptionChoice> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		
		List<InscriptionChoice> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<InscriptionChoice> result = new ArrayList<InscriptionChoice>();
		for (InscriptionChoice elev : datas) {
			result.add(new InscriptionChoice(elev));
		}
		return result;
	}

	@Override
	public InscriptionChoice find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		InscriptionChoice elev = super.find(propertyName, entityID);
	//	CacheMemory.setIncription(elev);
		InscriptionChoice inscrip = new InscriptionChoice(elev);
		for (FichePaiement serv : elev.getService()) {
			inscrip.getService().add(new FichePaiement(serv));
		}
//		for (FichePaiementOptionel serv : elev.getServiceOpt()) {
//			inscrip.getServiceOpt().add(new FichePaiementOptionel(serv));
//		}
		return inscrip;
	}

	@Override
	public List<InscriptionChoice> findAll() {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycleAnnee());
   		if (CacheMemory.getClasse() != null) {
   			container.addEq("classe.id",  CacheMemory.getClasse().getId());
   		}
   		List<InscriptionChoice> datas = super.filter(container.getPredicats(), null, null, 0, -1);
		List<InscriptionChoice> result = new ArrayList<InscriptionChoice>();
		for (InscriptionChoice elev : datas) {
			result.add(new InscriptionChoice(elev));
		}
		return result;
	}

	@Override
	public InscriptionChoice delete(Long id) {
		// TODO Auto-generated method stub
		InscriptionChoice elev = super.delete(id);
		return new InscriptionChoice(elev);
	}

}
