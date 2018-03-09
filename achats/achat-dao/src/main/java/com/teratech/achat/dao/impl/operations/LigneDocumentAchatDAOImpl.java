
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentAchatDAOLocal;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentAchatDAORemote;
import com.teratech.achat.model.operations.LigneDocumentAchat;

@Stateless(mappedName = "LigneDocumentAchatDAO")
public class LigneDocumentAchatDAOImpl
    extends AbstractGenericDAO<LigneDocumentAchat, Long>
    implements LigneDocumentAchatDAOLocal, LigneDocumentAchatDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public LigneDocumentAchatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneDocumentAchat> getManagedEntityClass() {
        return (LigneDocumentAchat.class);
    }

}
