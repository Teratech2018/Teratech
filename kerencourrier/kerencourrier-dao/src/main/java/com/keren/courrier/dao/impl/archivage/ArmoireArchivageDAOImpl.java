
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.ArmoireArchivageDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.ArmoireArchivageDAORemote;
import com.keren.courrier.model.archivage.ArmoireArchivage;

@Stateless(mappedName = "ArmoireArchivageDAO")
public class ArmoireArchivageDAOImpl
    extends AbstractGenericDAO<ArmoireArchivage, Long>
    implements ArmoireArchivageDAOLocal, ArmoireArchivageDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ArmoireArchivageDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ArmoireArchivage> getManagedEntityClass() {
        return (ArmoireArchivage.class);
    }

}
