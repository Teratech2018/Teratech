
package com.keren.core.impl.formations;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import com.bekosoftware.genericdaolayer.dao.ifaces.GenericDAO;
import com.bekosoftware.genericmanagerlayer.core.impl.AbstractGenericManager;
import com.keren.core.ifaces.formations.ModuleFormationManagerLocal;
import com.keren.core.ifaces.formations.ModuleFormationManagerRemote;
import com.keren.dao.ifaces.formations.ModuleFormationDAOLocal;
import com.keren.model.formations.ModuleFormation;

@TransactionAttribute
@Stateless(mappedName = "ModuleFormationManager")
public class ModuleFormationManagerImpl
    extends AbstractGenericManager<ModuleFormation, Long>
    implements ModuleFormationManagerLocal, ModuleFormationManagerRemote
{

    @EJB(name = "ModuleFormationDAO")
    protected ModuleFormationDAOLocal dao;

    public ModuleFormationManagerImpl() {
    }

    @Override
    public GenericDAO<ModuleFormation, Long> getDao() {
        return dao;
    }

    @Override
    public String getEntityIdName() {
        return "id";
    }

}
