
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentDAORemote;
import com.keren.courrier.model.archivage.LiasseDocument;

@Stateless(mappedName = "LiasseDocumentDAO")
public class LiasseDocumentDAOImpl
    extends AbstractGenericDAO<LiasseDocument, Long>
    implements LiasseDocumentDAOLocal, LiasseDocumentDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LiasseDocumentDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LiasseDocument> getManagedEntityClass() {
        return (LiasseDocument.class);
    }

}
