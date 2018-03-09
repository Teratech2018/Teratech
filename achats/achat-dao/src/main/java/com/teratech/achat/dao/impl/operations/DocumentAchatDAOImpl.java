
package com.teratech.achat.dao.impl.operations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.achat.dao.ifaces.operations.DocumentAchatDAOLocal;
import com.teratech.achat.dao.ifaces.operations.DocumentAchatDAORemote;
import com.teratech.achat.model.operations.DocumentAchat;

@Stateless(mappedName = "DocumentAchatDAO")
public class DocumentAchatDAOImpl
    extends AbstractGenericDAO<DocumentAchat, Long>
    implements DocumentAchatDAOLocal, DocumentAchatDAORemote
{

    @PersistenceContext(unitName = "teratechachat")
    protected EntityManager em;

    public DocumentAchatDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<DocumentAchat> getManagedEntityClass() {
        return (DocumentAchat.class);
    }

}
