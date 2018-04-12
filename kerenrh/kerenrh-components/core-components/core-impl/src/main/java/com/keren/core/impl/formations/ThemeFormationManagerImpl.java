
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.ThemeFormationManagerLocal;
import com.keren.core.ifaces.formations.ThemeFormationManagerRemote;
import com.keren.dao.ifaces.formations.ThemeFormationDAOLocal;
import com.keren.model.formations.ThemeFormation;

@TransactionAttribute
@Stateless(mappedName = "ThemeFormationManager")
public class ThemeFormationManagerImpl
    extends AbstractGenericManager<ThemeFormation, Long>
    implements ThemeFormationManagerLocal, ThemeFormationManagerRemote
{

    @EJB(name = "ThemeFormationDAO")
    protected ThemeFormationDAOLocal dao;

    public ThemeFormationManagerImpl() {
    }

    @Override
    public GenericDAO<ThemeFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
