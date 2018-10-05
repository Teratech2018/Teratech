
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.LigneBorderoLiasseDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LigneBorderoLiasseDAORemote;
import com.keren.courrier.model.archivage.LigneBorderoLiasse;

@Stateless(mappedName = "LigneBorderoLiasseDAO")
public class LigneBorderoLiasseDAOImpl
    extends AbstractGenericDAO<LigneBorderoLiasse, Long>
    implements LigneBorderoLiasseDAOLocal, LigneBorderoLiasseDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LigneBorderoLiasseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBorderoLiasse> getManagedEntityClass() {
        return (LigneBorderoLiasse.class);
    }

}
