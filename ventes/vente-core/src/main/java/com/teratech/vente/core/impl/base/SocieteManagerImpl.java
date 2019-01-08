
package com.teratech.vente.core.impl.base;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.vente.core.ifaces.base.SocieteManagerLocal;
import com.teratech.vente.core.ifaces.base.SocieteManagerRemote;
import com.teratech.vente.dao.ifaces.base.SocieteDAOLocal;
import com.teratech.vente.model.base.Societe;

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
