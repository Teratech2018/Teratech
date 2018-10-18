
package com.kerenedu.solde;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.bekosoftware.genericdaolayer.dao.impl.AbstractGenericDAO;

@Stateless(mappedName = "ValiderSalaireDAO")
public class ValiderSalaireDAOImpl
    extends AbstractGenericDAO<ValiderSalaire, Long>
    implements ValiderSalaireDAOLocal, ValiderSalaireDAORemote
{

    @PersistenceContext(unitName = "keren")
    protected EntityManager em;

    public ValiderSalaireDAOImpl() {
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    @Override
    public Class<ValiderSalaire> getManagedEntityClass() {
        return (ValiderSalaire.class);
    }

}
