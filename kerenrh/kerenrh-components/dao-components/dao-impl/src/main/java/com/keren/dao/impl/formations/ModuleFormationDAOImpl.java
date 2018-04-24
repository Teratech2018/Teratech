
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.ModuleFormationDAOLocal;
import com.keren.dao.ifaces.formations.ModuleFormationDAORemote;
import com.keren.model.formations.ModuleFormation;

@Stateless(mappedName = "ModuleFormationDAO")
public class ModuleFormationDAOImpl
    extends AbstractGenericDAO<ModuleFormation, Long>
    implements ModuleFormationDAOLocal, ModuleFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ModuleFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ModuleFormation> getManagedEntityClass() {
        return (ModuleFormation.class);
    }

}
