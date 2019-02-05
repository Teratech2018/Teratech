
package com.kerenedu.solde;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "PeriodePaieDAO")
public class PeriodePaieDAOImpl
    extends AbstractGenericDAO<PeriodePaie, Long>
    implements PeriodePaieDAOLocal, PeriodePaieDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;
    
	@EJB(name = "PeriodePaieDAO")
	protected PeriodePaieDAOLocal dao;

    public PeriodePaieDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PeriodePaie> getManagedEntityClass() {
        return (PeriodePaie.class);
    }

	@Override
	public PeriodePaie getPeriodeFromDate(Date date) {
		return dao.getPeriodeFromDate(date);
	}

}
