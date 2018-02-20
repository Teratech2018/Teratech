
package com.kerenedu.configuration;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "FraisScolaireDAO")
public class FraisScolaireDAOImpl
    extends AbstractGenericDAO<FraisScolaire, Long>
    implements FraisScolaireDAOLocal, FraisScolaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public FraisScolaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<FraisScolaire> getManagedEntityClass() {
        return (FraisScolaire.class);
    }

}
