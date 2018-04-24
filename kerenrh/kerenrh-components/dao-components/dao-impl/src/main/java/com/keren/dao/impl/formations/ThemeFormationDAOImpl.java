
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.ThemeFormationDAOLocal;
import com.keren.dao.ifaces.formations.ThemeFormationDAORemote;
import com.keren.model.formations.ThemeFormation;

@Stateless(mappedName = "ThemeFormationDAO")
public class ThemeFormationDAOImpl
    extends AbstractGenericDAO<ThemeFormation, Long>
    implements ThemeFormationDAOLocal, ThemeFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ThemeFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ThemeFormation> getManagedEntityClass() {
        return (ThemeFormation.class);
    }

}
