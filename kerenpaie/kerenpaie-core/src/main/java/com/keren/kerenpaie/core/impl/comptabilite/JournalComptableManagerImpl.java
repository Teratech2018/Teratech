
package com.keren.kerenpaie.core.impl.comptabilite;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.Predicat;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.kerenpaie.core.ifaces.comptabilite.JournalComptableManagerLocal;
import com.keren.kerenpaie.core.ifaces.comptabilite.JournalComptableManagerRemote;
import com.keren.kerenpaie.dao.ifaces.comptabilite.JournalComptableDAOLocal;
import com.keren.kerenpaie.model.comptabilite.JournalComptable;
import com.megatim.common.annotations.OrderType;

@TransactionAttribute
@Stateless(mappedName = "JournalComptableManager")
public class JournalComptableManagerImpl
    extends AbstractGenericManager<JournalComptable, Long>
    implements JournalComptableManagerLocal, JournalComptableManagerRemote
{

    @EJB(name = "JournalComptableDAO")
    protected JournalComptableDAOLocal dao;

    public JournalComptableManagerImpl() {
    }

    @Override
    public GenericDAO<JournalComptable, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

	@Override
	public JournalComptable delete(Long id) {
		// TODO Auto-generated method stub
		return super.delete(id);
	}

	@Override
	public List<JournalComptable> filter(List<Predicat> predicats, Map<String, OrderType> orders,
			Set<String> properties, int firstResult, int maxResult) {
		// TODO Auto-generated method stub
		return super.filter(predicats, orders, properties, firstResult, maxResult);
	}

	@Override
	public JournalComptable find(String propertyName, Long entityID) {
		// TODO Auto-generated method stub
		return super.find(propertyName, entityID);
	}

	@Override
	public List<JournalComptable> findAll() {
		// TODO Auto-generated method stub
		return super.findAll();
	}
    
    

}
