
package com.keren.dao.impl.presences;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.presences.PointageJouranlierDAOLocal;
import com.keren.dao.ifaces.presences.PointageJouranlierDAORemote;
import com.keren.model.presences.PointageJouranlier;

@Stateless(mappedName = "PointageJouranlierDAO")
public class PointageJouranlierDAOImpl
    extends AbstractGenericDAO<PointageJouranlier, Long>
    implements PointageJouranlierDAOLocal, PointageJouranlierDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public PointageJouranlierDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<PointageJouranlier> getManagedEntityClass() {
        return (PointageJouranlier.class);
    }

}
