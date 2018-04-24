
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.LigneThemeFormationDAOLocal;
import com.keren.dao.ifaces.formations.LigneThemeFormationDAORemote;
import com.keren.model.formations.LigneThemeFormation;

@Stateless(mappedName = "LigneThemeFormationDAO")
public class LigneThemeFormationDAOImpl
    extends AbstractGenericDAO<LigneThemeFormation, Long>
    implements LigneThemeFormationDAOLocal, LigneThemeFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneThemeFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneThemeFormation> getManagedEntityClass() {
        return (LigneThemeFormation.class);
    }

}
