
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.LigneBorderoLiasseRDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LigneBorderoLiasseRDAORemote;
import com.keren.courrier.model.archivage.LigneBorderoLiasseR;

@Stateless(mappedName = "LigneBorderoLiasseRDAO")
public class LigneBorderoLiasseRDAOImpl
    extends AbstractGenericDAO<LigneBorderoLiasseR, Long>
    implements LigneBorderoLiasseRDAOLocal, LigneBorderoLiasseRDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LigneBorderoLiasseRDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBorderoLiasseR> getManagedEntityClass() {
        return (LigneBorderoLiasseR.class);
    }

}
