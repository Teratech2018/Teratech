
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.PosWebDashboardManagerLocal;
import com.keren.posweb.core.ifaces.PosWebDashboardManagerRemote;
import com.keren.posweb.dao.ifaces.PosWebDashboardDAOLocal;
import com.keren.posweb.model.PosWebDashboard;

@TransactionAttribute
@Stateless(mappedName = "PosWebDashboardManager")
public class PosWebDashboardManagerImpl
    extends AbstractGenericManager<PosWebDashboard, Long>
    implements PosWebDashboardManagerLocal, PosWebDashboardManagerRemote
{

    @EJB(name = "PosWebDashboardDAO")
    protected PosWebDashboardDAOLocal dao;

    public PosWebDashboardManagerImpl() {
    }

    @Override
    public GenericDAO<PosWebDashboard, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
