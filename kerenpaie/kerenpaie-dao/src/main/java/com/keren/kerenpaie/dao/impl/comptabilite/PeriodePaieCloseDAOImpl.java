
package com.keren.kerenpaie.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieCloseDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieCloseDAORemote;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieClose;

@Stateless(mappedName = "PeriodePaieCloseDAO")
public class PeriodePaieCloseDAOImpl
    extends AbstractGenericDAO<PeriodePaieClose, Long>
    implements PeriodePaieCloseDAOLocal, PeriodePaieCloseDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public PeriodePaieCloseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PeriodePaieClose> getManagedEntityClass() {
        return (PeriodePaieClose.class);
    }

}
