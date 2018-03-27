
package com.keren.kerenpaie.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieDAORemote;
import com.keren.kerenpaie.model.comptabilite.PeriodePaie;

@Stateless(mappedName = "PeriodePaieDAO")
public class PeriodePaieDAOImpl
    extends AbstractGenericDAO<PeriodePaie, Long>
    implements PeriodePaieDAOLocal, PeriodePaieDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

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

}
