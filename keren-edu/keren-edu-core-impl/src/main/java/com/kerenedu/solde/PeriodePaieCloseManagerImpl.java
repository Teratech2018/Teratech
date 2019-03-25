
package com.kerenedu.solde;

import java.util.Date;
import java.util.HashSet;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericdaolayer.dao.tools.RestrictionsContainer;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.core.tools.DateHelper;
import com.google.gson.Gson;
import com.kerenedu.configuration.CacheMemory;
import com.kerenedu.configuration.TypeCacheMemory;

@TransactionAttribute
@Stateless(mappedName = "PeriodePaieCloseManager")
public class PeriodePaieCloseManagerImpl
    extends AbstractGenericManager<PeriodePaieClose, Long>
    implements PeriodePaieCloseManagerLocal, PeriodePaieCloseManagerRemote
{

    @EJB(name = "PeriodePaieCloseDAO")
    protected PeriodePaieCloseDAOLocal dao;
    
    @EJB(name = "PeriodePaieDAO")
    protected PeriodePaieDAOLocal periodedao;
    

    @EJB(name = "AcompteDAO")
    protected AcompteDAOLocal daoacompte;
    
    @EJB(name = "RemboursementPretDAO")
    protected RemboursementPretDAOLocal daoarem;
    
    @EJB(name = "DemandePretDAO")
    protected DemandePretDAOLocal daoapret;

    public PeriodePaieCloseManagerImpl() {
    }

    @Override
    public GenericDAO<PeriodePaieClose, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }
    
	@Override
	public void closeperiode(PeriodePaieClose entity) {
		entity.getPeriode().setState("ferme");		;
		periodedao.update(entity.getPeriode().getId(), entity.getPeriode());
		
	}

    
}
