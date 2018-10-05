
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.ArchiveLiasseDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.ArchiveLiasseDAORemote;
import com.keren.courrier.model.archivage.ArchiveLiasse;

@Stateless(mappedName = "ArchiveLiasseDAO")
public class ArchiveLiasseDAOImpl
    extends AbstractGenericDAO<ArchiveLiasse, Long>
    implements ArchiveLiasseDAOLocal, ArchiveLiasseDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ArchiveLiasseDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ArchiveLiasse> getManagedEntityClass() {
        return (ArchiveLiasse.class);
    }

}
