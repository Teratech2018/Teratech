
package com.keren.dao.impl.formations;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;
import com.keren.dao.ifaces.formations.GenererBesionFormationDAOLocal;
import com.keren.dao.ifaces.formations.GenererBesionFormationDAORemote;
import com.keren.model.formations.GenererBesionFormation;

@Stateless(mappedName = "GenererBesionFormationDAO")
public class GenererBesionFormationDAOImpl
    extends AbstractGenericDAO<GenererBesionFormation, Long>
    implements GenererBesionFormationDAOLocal, GenererBesionFormationDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public GenererBesionFormationDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<GenererBesionFormation> getManagedEntityClass() {
        return (GenererBesionFormation.class);
    }

}
