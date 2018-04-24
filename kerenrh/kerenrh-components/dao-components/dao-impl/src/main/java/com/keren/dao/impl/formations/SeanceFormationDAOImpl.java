
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.SeanceFormationDAOLocal;
import com.keren.dao.ifaces.formations.SeanceFormationDAORemote;
import com.keren.model.formations.SeanceFormation;

@Stateless(mappedName = "SeanceFormationDAO")
public class SeanceFormationDAOImpl
    extends AbstractGenericDAO<SeanceFormation, Long>
    implements SeanceFormationDAOLocal, SeanceFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public SeanceFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<SeanceFormation> getManagedEntityClass() {
        return (SeanceFormation.class);
    }

}
