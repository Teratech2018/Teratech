
package com.keren.kerenpaie.dao.impl.comptabilite;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieOpenDAOLocal;
import com.keren.kerenpaie.dao.ifaces.comptabilite.PeriodePaieOpenDAORemote;
import com.keren.kerenpaie.model.comptabilite.PeriodePaieOpen;

@Stateless(mappedName = "PeriodePaieOpenDAO")
public class PeriodePaieOpenDAOImpl
    extends AbstractGenericDAO<PeriodePaieOpen, Long>
    implements PeriodePaieOpenDAOLocal, PeriodePaieOpenDAORemote
{

    @PersistenceContext(unitName = "kerenpaie")
    protected EntityManager em;

    public PeriodePaieOpenDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PeriodePaieOpen> getManagedEntityClass() {
        return (PeriodePaieOpen.class);
    }

}
