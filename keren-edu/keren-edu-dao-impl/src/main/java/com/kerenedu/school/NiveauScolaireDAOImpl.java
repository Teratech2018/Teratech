
package com.kerenedu.school;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "NiveauScolaireDAO")
public class NiveauScolaireDAOImpl
    extends AbstractGenericDAO<NiveauScolaire, Long>
    implements NiveauScolaireDAOLocal, NiveauScolaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public NiveauScolaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<NiveauScolaire> getManagedEntityClass() {
        return (NiveauScolaire.class);
    }

}
