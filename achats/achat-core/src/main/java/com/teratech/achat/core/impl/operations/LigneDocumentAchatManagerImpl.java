
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.operations.LigneDocumentAchatManagerLocal;
import com.teratech.achat.core.ifaces.operations.LigneDocumentAchatManagerRemote;
import com.teratech.achat.dao.ifaces.operations.LigneDocumentAchatDAOLocal;
import com.teratech.achat.model.operations.LigneDocumentAchat;

@TransactionAttribute
@Stateless(mappedName = "LigneDocumentAchatManager")
public class LigneDocumentAchatManagerImpl
    extends AbstractGenericManager<LigneDocumentAchat, Long>
    implements LigneDocumentAchatManagerLocal, LigneDocumentAchatManagerRemote
{

    @EJB(name = "LigneDocumentAchatDAO")
    protected LigneDocumentAchatDAOLocal dao;

    public LigneDocumentAchatManagerImpl() {
    }

    @Override
    public GenericDAO<LigneDocumentAchat, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
