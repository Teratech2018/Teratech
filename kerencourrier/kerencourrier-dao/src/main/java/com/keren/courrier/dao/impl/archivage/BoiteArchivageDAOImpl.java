
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.BoiteArchivageDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.BoiteArchivageDAORemote;
import com.keren.courrier.model.archivage.BoiteArchivage;

@Stateless(mappedName = "BoiteArchivageDAO")
public class BoiteArchivageDAOImpl
    extends AbstractGenericDAO<BoiteArchivage, Long>
    implements BoiteArchivageDAOLocal, BoiteArchivageDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public BoiteArchivageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<BoiteArchivage> getManagedEntityClass() {
        return (BoiteArchivage.class);
    }

}
