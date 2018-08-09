
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
@Stateless(mappedName = "InscriptioncloneManager")
public class InscriptioncloneManagerImpl
    extends AbstractGenericManager<Inscriptionclone, Long>
    implements InscriptioncloneManagerLocal, InscriptioncloneManagerRemote
{

    @EJB(name = "InscriptioncloneDAO")
    protected InscriptioncloneDAOLocal dao;

    public InscriptioncloneManagerImpl() {
    }

    @Override
    public GenericDAO<Inscriptionclone, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
	@Override
	public List<Inscriptionclone> filter(List<Predicat> predicats, Map<String, OrderType> orders, Set<String> properties,
			int firstResult, int maxResult) {
		
		List<Inscriptionclone> datas = super.filter(predicats, orders, properties, firstResult, maxResult);
		List<Inscriptionclone> result = new ArrayList<Inscriptionclone>();
		for (Inscriptionclone elev : datas) {
			result.add(new Inscriptionclone(elev));
		}
		return result;
	}

	@Override
	public Inscriptionclone find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		Inscriptionclone elev = super.find(propertyName, entityID);
		Inscriptionclone inscrip = new Inscriptionclone(elev);
		for (FichePaiement serv : elev.getService()) {
			inscrip.getService().add(new FichePaiement(serv));
		}
		return inscrip;
	}

	@Override
	public List<Inscriptionclone> findAll() {
		// TODO Auto-generated method stub
		RestrictionsContainer container = RestrictionsContainer.newInstance();
   		container.getPredicats().addAll(CacheMemory.defaultPredicatsCycleAnnee());
   		if (CacheMemory.getClasse() != null) {
   			container.addEq("classe.id",  CacheMemory.getClasse().getId());
   		}
   		List<Inscriptionclone> datas = super.filter(container.getPredicats(), null, null, 0, -1);
		List<Inscriptionclone> result = new ArrayList<Inscriptionclone>();
		for (Inscriptionclone elev : datas) {
			result.add(new Inscriptionclone(elev));
		}
		return result;
	}

	@Override
	public Inscriptionclone delete(Long id) {
		// TODO Auto-generated method stub
		Inscriptionclone elev = super.delete(id);
		return new Inscriptionclone(elev);
	}

}
