
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.LigneBesionFormationDAOLocal;
import com.keren.dao.ifaces.formations.LigneBesionFormationDAORemote;
import com.keren.model.formations.LigneBesionFormation;

@Stateless(mappedName = "LigneBesionFormationDAO")
public class LigneBesionFormationDAOImpl
    extends AbstractGenericDAO<LigneBesionFormation, Long>
    implements LigneBesionFormationDAOLocal, LigneBesionFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public LigneBesionFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<LigneBesionFormation> getManagedEntityClass() {
        return (LigneBesionFormation.class);
    }

}
