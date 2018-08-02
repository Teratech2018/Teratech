
package com.teratech.gmao.core.impl.preventif;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.teratech.gmao.core.ifaces.preventif.MaintenancePreventiveManagerLocal;
import com.teratech.gmao.core.ifaces.preventif.MaintenancePreventiveManagerRemote;
import com.teratech.gmao.dao.ifaces.preventif.MaintenancePreventiveDAOLocal;
import com.teratech.gmao.model.preventif.MaintenancePreventive;

@TransactionAttribute
@Stateless(mappedName = "MaintenancePreventiveManager")
public class MaintenancePreventiveManagerImpl
    extends AbstractGenericManager<MaintenancePreventive, Long>
    implements MaintenancePreventiveManagerLocal, MaintenancePreventiveManagerRemote
{

    @EJB(name = "MaintenancePreventiveDAO")
    protected MaintenancePreventiveDAOLocal dao;

    public MaintenancePreventiveManagerImpl() {
    }

    @Override
    public GenericDAO<MaintenancePreventive, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
