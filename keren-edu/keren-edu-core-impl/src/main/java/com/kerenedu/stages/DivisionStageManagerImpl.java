
package com.kerenedu.stages;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;

import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;

@TransactionAttribute
@Stateless(mappedName = "DivisionStageManager")
public class DivisionStageManagerImpl
    extends AbstractGenericManager<DivisionStage, Long>
    implements DivisionStageManagerLocal, DivisionStageManagerRemote
{

    @EJB(name = "DivisionStageDAO")
    protected DivisionStageDAOLocal dao;

    public DivisionStageManagerImpl() {
    }

    @Override
    public GenericDAO<DivisionStage, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
