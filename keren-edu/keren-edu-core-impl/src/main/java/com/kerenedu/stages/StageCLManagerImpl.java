
package com.kerenedu.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "StageCLManager")
public class StageCLManagerImpl
    extends AbstractGenericManager<StageCL, Long>
    implements StageCLManagerLocal, StageCLManagerRemote
{

    @EJB(name = "StageCLDAO")
    protected StageCLDAOLocal dao;

    public StageCLManagerImpl() {
    }

    @Override
    public GenericDAO<StageCL, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
