
package com.kerenedu.personnel;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "EnseignantSecondaireDAO")
public class EnseignantSecondaireDAOImpl
    extends AbstractGenericDAO<EnseignantSecondaire, Long>
    implements EnseignantSecondaireDAOLocal, EnseignantSecondaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public EnseignantSecondaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<EnseignantSecondaire> getManagedEntityClass() {
        return (EnseignantSecondaire.class);
    }

}
