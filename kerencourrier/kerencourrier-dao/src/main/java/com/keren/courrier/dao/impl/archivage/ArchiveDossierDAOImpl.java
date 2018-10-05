
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.ArchiveDossierDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.ArchiveDossierDAORemote;
import com.keren.courrier.model.archivage.ArchiveDossier;

@Stateless(mappedName = "ArchiveDossierDAO")
public class ArchiveDossierDAOImpl
    extends AbstractGenericDAO<ArchiveDossier, Long>
    implements ArchiveDossierDAOLocal, ArchiveDossierDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ArchiveDossierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ArchiveDossier> getManagedEntityClass() {
        return (ArchiveDossier.class);
    }

}
