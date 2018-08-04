
package com.kerenedu.core.impl.report;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.core.ifaces.report.ViewEmargementManagerLocal;
import com.kerenedu.core.ifaces.report.ViewEmargementManagerRemote;
import com.kerenedu.dao.ifaces.report.ViewEmargementDAOLocal;
import com.kerenedu.inscription.Inscription;
import com.kerenedu.model.report.ViewEmargement;
import com.kerenedu.model.search.EleveSearch;

@TransactionAttribute
@Stateless(mappedName = "ViewEmargementManager")
public class ViewEmargementManagerImpl
    extends AbstractGenericManager<ViewEmargement, Long>
    implements ViewEmargementManagerLocal, ViewEmargementManagerRemote
{

    @EJB(name = "ViewEmargementDAO")
    protected ViewEmargementDAOLocal dao;

    public ViewEmargementManagerImpl() {
    }

    @Override
    public GenericDAO<ViewEmargement, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
    @Override
	public List<ViewEmargement> getCriteres(ViewEmargement critere) {

		RestrictionsContainer container = RestrictionsContainer.newInstance();
		if (critere != null) {

			container.addEq("classe.id", CacheMemory.getClasse().getId());
			container.addEq("anneScolaire", CacheMemory.getCurrentannee());
		}
		List<ViewEmargement> datas = dao.filter(container.getPredicats(), null, new HashSet<String>(), -1, 0);
		return datas;
	}

}
