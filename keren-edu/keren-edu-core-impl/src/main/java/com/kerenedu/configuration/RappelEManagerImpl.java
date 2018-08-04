
package com.kerenedu.configuration;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "RappelEManager")
public class RappelEManagerImpl
    extends AbstractGenericManager<RappelE, Long>
    implements RappelEManagerLocal, RappelEManagerRemote
{

    @EJB(name = "RappelEDAO")
    protected RappelEDAOLocal dao;

    public RappelEManagerImpl() {
    }

    @Override
    public GenericDAO<RappelE, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
