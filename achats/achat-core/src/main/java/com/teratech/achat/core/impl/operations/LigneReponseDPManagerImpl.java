
package com.teratech.achat.core.impl.operations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.operations.LigneReponseDPManagerLocal;
import com.teratech.achat.core.ifaces.operations.LigneReponseDPManagerRemote;
import com.teratech.achat.dao.ifaces.operations.LigneReponseDPDAOLocal;
import com.teratech.achat.model.operations.LigneReponseDP;

@TransactionAttribute
@Stateless(mappedName = "LigneReponseDPManager")
public class LigneReponseDPManagerImpl
    extends AbstractGenericManager<LigneReponseDP, Long>
    implements LigneReponseDPManagerLocal, LigneReponseDPManagerRemote
{

    @EJB(name = "LigneReponseDPDAO")
    protected LigneReponseDPDAOLocal dao;

    public LigneReponseDPManagerImpl() {
    }

    @Override
    public GenericDAO<LigneReponseDP, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
