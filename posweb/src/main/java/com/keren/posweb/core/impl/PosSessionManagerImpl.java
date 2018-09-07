
package com.keren.posweb.core.impl;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.posweb.core.ifaces.PosSessionManagerLocal;
import com.keren.posweb.core.ifaces.PosSessionManagerRemote;
import com.keren.posweb.dao.ifaces.PosSessionDAOLocal;
import com.keren.posweb.model.PosSession;

@TransactionAttribute
@Stateless(mappedName = "PosSessionManager")
public class PosSessionManagerImpl
    extends AbstractGenericManager<PosSession, Long>
    implements PosSessionManagerLocal, PosSessionManagerRemote
{

    @EJB(name = "PosSessionDAO")
    protected PosSessionDAOLocal dao;

    public PosSessionManagerImpl() {
    }

    @Override
    public GenericDAO<PosSession, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
