
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.operations.DocumentAchatManagerLocal;
import com.teratech.achat.core.ifaces.operations.DocumentAchatManagerRemote;
import com.teratech.achat.dao.ifaces.operations.DocumentAchatDAOLocal;
import com.teratech.achat.model.operations.DocumentAchat;

@TransactionAttribute
@Stateless(mappedName = "DocumentAchatManager")
public class DocumentAchatManagerImpl
    extends AbstractGenericManager<DocumentAchat, Long>
    implements DocumentAchatManagerLocal, DocumentAchatManagerRemote
{

    @EJB(name = "DocumentAchatDAO")
    protected DocumentAchatDAOLocal dao;

    public DocumentAchatManagerImpl() {
    }

    @Override
    public GenericDAO<DocumentAchat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
