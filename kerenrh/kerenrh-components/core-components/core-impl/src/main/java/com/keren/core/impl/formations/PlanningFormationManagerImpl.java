
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.PlanningFormationManagerLocal;
import com.keren.core.ifaces.formations.PlanningFormationManagerRemote;
import com.keren.dao.ifaces.formations.PlanningFormationDAOLocal;
import com.keren.model.formations.PlanningFormation;

@TransactionAttribute
@Stateless(mappedName = "PlanningFormationManager")
public class PlanningFormationManagerImpl
    extends AbstractGenericManager<PlanningFormation, Long>
    implements PlanningFormationManagerLocal, PlanningFormationManagerRemote
{

    @EJB(name = "PlanningFormationDAO")
    protected PlanningFormationDAOLocal dao;

    public PlanningFormationManagerImpl() {
    }

    @Override
    public GenericDAO<PlanningFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
