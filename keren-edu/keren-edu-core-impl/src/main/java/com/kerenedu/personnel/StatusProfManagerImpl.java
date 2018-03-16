
package com.kerenedu.personnel;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "StatusProfManager")
public class StatusProfManagerImpl
    extends AbstractGenericManager<StatusProf, Long>
    implements StatusProfManagerLocal, StatusProfManagerRemote
{

    @EJB(name = "StatusProfDAO")
    protected StatusProfDAOLocal dao;

    public StatusProfManagerImpl() {
    }

    @Override
    public GenericDAO<StatusProf, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
