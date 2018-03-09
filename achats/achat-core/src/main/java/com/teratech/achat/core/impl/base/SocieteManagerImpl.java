
package com.teratech.achat.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.achat.core.ifaces.base.SocieteManagerLocal;
import com.teratech.achat.core.ifaces.base.SocieteManagerRemote;
import com.teratech.achat.dao.ifaces.base.SocieteDAOLocal;
import com.teratech.achat.model.base.Societe;

@TransactionAttribute
@Stateless(mappedName = "SocieteManager")
public class SocieteManagerImpl
    extends AbstractGenericManager<Societe, Long>
    implements SocieteManagerLocal, SocieteManagerRemote
{

    @EJB(name = "SocieteDAO")
    protected SocieteDAOLocal dao;

    public SocieteManagerImpl() {
    }

    @Override
    public GenericDAO<Societe, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
