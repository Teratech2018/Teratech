
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.ArchiveDocumentDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.ArchiveDocumentDAORemote;
import com.keren.courrier.model.archivage.ArchiveDocument;

@Stateless(mappedName = "ArchiveDocumentDAO")
public class ArchiveDocumentDAOImpl
    extends AbstractGenericDAO<ArchiveDocument, Long>
    implements ArchiveDocumentDAOLocal, ArchiveDocumentDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public ArchiveDocumentDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ArchiveDocument> getManagedEntityClass() {
        return (ArchiveDocument.class);
    }

}
