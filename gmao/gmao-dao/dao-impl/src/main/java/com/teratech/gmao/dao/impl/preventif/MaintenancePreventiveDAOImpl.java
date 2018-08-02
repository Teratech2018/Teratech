
package com.teratech.gmao.dao.impl.preventif;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.teratech.gmao.dao.ifaces.preventif.MaintenancePreventiveDAOLocal;
import com.teratech.gmao.dao.ifaces.preventif.MaintenancePreventiveDAORemote;
import com.teratech.gmao.model.preventif.MaintenancePreventive;

@Stateless(mappedName = "MaintenancePreventiveDAO")
public class MaintenancePreventiveDAOImpl
    extends AbstractGenericDAO<MaintenancePreventive, Long>
    implements MaintenancePreventiveDAOLocal, MaintenancePreventiveDAORemote
{

    @PersistenceContext(unitName = "teratechgmao")
    protected EntityManager em;

    public MaintenancePreventiveDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<MaintenancePreventive> getManagedEntityClass() {
        return (MaintenancePreventive.class);
    }

}
