
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.LignePlanningFormationManagerLocal;
import com.keren.core.ifaces.formations.LignePlanningFormationManagerRemote;
import com.keren.dao.ifaces.formations.LignePlanningFormationDAOLocal;
import com.keren.model.formations.LignePlanningFormation;

@TransactionAttribute
@Stateless(mappedName = "LignePlanningFormationManager")
public class LignePlanningFormationManagerImpl
    extends AbstractGenericManager<LignePlanningFormation, Long>
    implements LignePlanningFormationManagerLocal, LignePlanningFormationManagerRemote
{

    @EJB(name = "LignePlanningFormationDAO")
    protected LignePlanningFormationDAOLocal dao;

    public LignePlanningFormationManagerImpl() {
    }

    @Override
    public GenericDAO<LignePlanningFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
