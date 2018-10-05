
package com.keren.courrier.dao.impl.archivage;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentTriDAOLocal;
import com.keren.courrier.dao.ifaces.archivage.LiasseDocumentTriDAORemote;
import com.keren.courrier.model.archivage.LiasseDocumentTri;

@Stateless(mappedName = "LiasseDocumentTriDAO")
public class LiasseDocumentTriDAOImpl
    extends AbstractGenericDAO<LiasseDocumentTri, Long>
    implements LiasseDocumentTriDAOLocal, LiasseDocumentTriDAORemote
{

    @PersistenceContext(unitName = "kerencourrier")
    protected EntityManager em;

    public LiasseDocumentTriDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LiasseDocumentTri> getManagedEntityClass() {
        return (LiasseDocumentTri.class);
    }

}
